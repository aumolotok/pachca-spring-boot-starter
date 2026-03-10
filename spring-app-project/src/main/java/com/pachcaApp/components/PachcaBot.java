package com.pachcaApp.components;

import api.models.data.EventItem;
import com.pachcaApp.configs.AppConfigs;
import com.pachcaBotComponents.interfaces.LongPollingEventConsumer;
import com.pachcaBotComponents.interfaces.PachcaLongPollingBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class  PachcaBot implements PachcaLongPollingBot {

    @Autowired
    private AppConfigs appConfigs;

    @Override
    public String getBotName() {
        return "Тестовый бот";
    }

    @Override
    public String getBotToken() {
        return appConfigs.getPachca().getBots().get("example_bot").getToken();
    }

    @Override
    public LongPollingEventConsumer getUpdatesConsumer() {
        return this;
    }

    @Override
    public void consume(EventItem eventItem) {
        System.out.println(eventItem.getPayload());
    }
}
