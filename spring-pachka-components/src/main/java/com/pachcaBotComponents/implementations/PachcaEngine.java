package com.pachcaBotComponents.implementations;

import com.pachcaBotComponents.engine.botSession.BotSession;
import com.pachcaBotComponents.interfaces.BotEngine;
import com.pachcaBotComponents.interfaces.PachcaLongPollingBot;

import java.util.concurrent.ConcurrentHashMap;

public class PachcaEngine implements BotEngine {

    private final ConcurrentHashMap<String, BotSession> botSessions = new ConcurrentHashMap<>();

    @Override
    public void registerBot(PachcaLongPollingBot botToInit) {

        var botSession = new BotSession(botToInit);
        botSession.start();
        botSessions.put(botToInit.getBotName(), botSession);

    }
}
