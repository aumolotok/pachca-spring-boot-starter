package com.pachcaApp.components;

import com.pachcaBotComponents.interfaces.LongPollingEventConsumer;
import com.pachcaBotComponents.interfaces.PachcaLongPollingBot;
import com.pachcaBotComponents.polling.models.data.EventItem;
import org.springframework.stereotype.Component;

@Component
public class  PachcaBot implements PachcaLongPollingBot {
    @Override
    public String getBotName() {
        return "Тестовый бот";
    }

    @Override
    public String getBotToken() {
        return "";
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
