package com.pachcaBotComponents.api;

import com.pachcaBotComponents.api.interceptor.AuthInterceptor;
import okhttp3.OkHttpClient;
import tools.jackson.databind.ObjectMapper;

import java.util.concurrent.TimeUnit;

public class PachcaApiBase {
    protected OkHttpClient okHttpClient;
    protected ObjectMapper objectMapper;
    protected String bearerToken;

    public PachcaApiBase(String token) {
        this.bearerToken = token;
        this.okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new AuthInterceptor(token))
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        this.objectMapper = new ObjectMapper();
    }
}
