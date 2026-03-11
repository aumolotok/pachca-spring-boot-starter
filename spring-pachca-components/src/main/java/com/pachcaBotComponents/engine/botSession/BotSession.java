package com.pachcaBotComponents.engine.botSession;

import com.pachcaBotComponents.interfaces.PachcaLongPollingBot;
import com.pachcaBotComponents.polling.PachcaPollingClient;

public class BotSession implements AutoCloseable {

    private final PachcaLongPollingBot pachcaLongPollingBot;
    private final PachcaPollingClient pachcaPollingClient;

    public BotSession(PachcaLongPollingBot pachcaLongPollingBot) {
        this.pachcaLongPollingBot = pachcaLongPollingBot;
        this.pachcaPollingClient = new PachcaPollingClient(pachcaLongPollingBot);
    }

    public void start() {
        pachcaPollingClient.startPolling();
    }

    @Override
    public void close() {
        pachcaPollingClient.stopPolling();
    }
}
