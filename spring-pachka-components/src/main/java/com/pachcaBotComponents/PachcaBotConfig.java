package com.pachcaBotComponents;

import com.pachcaBotComponents.implementations.PachcaEngine;
import com.pachcaBotComponents.interfaces.PachcaLongPollingBot;
import com.pachcaBotComponents.interfaces.BotEngine;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.List;

@AutoConfiguration
@ConditionalOnClass(PachcaBotInitializer.class)
@EnableConfigurationProperties(PachcaProperties.class)
public class PachcaBotConfig {
    @Bean
    @ConditionalOnMissingBean
    public PachcaBotInitializer myService(
            BotEngine botEngine,
            ObjectProvider<List<PachcaLongPollingBot>> longPollingBots,
            PachcaProperties properties) {

        return new PachcaBotInitializer(
                botEngine,
                longPollingBots.getIfAvailable(Collections::emptyList),
                properties);
    }

    @Bean
    @ConditionalOnMissingBean
    public BotEngine botEngine() {
        return new PachcaEngine();
    }


}
