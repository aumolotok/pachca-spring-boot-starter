package com.pachcaBotComponents;

import com.pachcaBotComponents.interfaces.BotEngine;
import com.pachcaBotComponents.interfaces.PachcaLongPollingBot;
import jakarta.annotation.Nonnull;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PachcaBotInitializer{

    private static final Logger log = LoggerFactory.getLogger(PachcaBotInitializer.class);

    private final BotEngine botEngine;
    private final List<PachcaLongPollingBot> longPollingBots;
    private final PachcaProperties properties;

    public PachcaBotInitializer(@Nonnull BotEngine botEngine,
                                @Nonnull List<PachcaLongPollingBot> bootList,
                                PachcaProperties properties) {
        this.botEngine = botEngine;
        this.longPollingBots = bootList;
        this.properties = properties;
    }


    @PostConstruct
    public void init()  {
        if (longPollingBots.isEmpty()) {
            log.warn("Нет доступных для регистрации ботов");
        }
        longPollingBots.forEach(this::registerBot);
    }

    private void registerBot(PachcaLongPollingBot longPollingBot) {
        try {
            botEngine.registerBot(longPollingBot);
            log.trace("Бот '{}' успешно зарегистрирован в движке.", longPollingBot.getClass().getSimpleName());
        } catch (Exception e) {
            log.error("Ошибка при регистрации бота ", e);
        }
    };
}
