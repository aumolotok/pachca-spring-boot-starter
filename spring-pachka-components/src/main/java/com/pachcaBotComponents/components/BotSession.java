package com.pachcaBotComponents.components;

import tools.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;

import java.util.concurrent.ScheduledExecutorService;


public class BotSession implements AutoCloseable {


    private ObjectMapper objectMapper;
    private  OkHttpClient okHttpClient;
    private  ScheduledExecutorService executor;
    private  String botToken;

    @Override
    public void close() throws Exception {

    }
}
