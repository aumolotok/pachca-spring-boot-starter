package com.pachcaBotComponents.interfaces;

public interface PachcaLongPollingBot extends LongPollingEventConsumer {

    String getBotName();
    String getBotToken();
    LongPollingEventConsumer getUpdatesConsumer();
}
