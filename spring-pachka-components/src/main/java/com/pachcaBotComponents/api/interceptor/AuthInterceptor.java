package com.pachcaBotComponents.api.interceptor;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class AuthInterceptor implements Interceptor {
    private String authToken;

    public AuthInterceptor(String token) {
        this.authToken = token;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request authenticatedRequest = originalRequest.newBuilder()
                .header("Authorization", "Bearer " + authToken)
                .build();
        return chain.proceed(authenticatedRequest);
    }
}
