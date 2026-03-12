package api;
import api.interceptor.AuthInterceptor;
import lombok.NoArgsConstructor;
import okhttp3.OkHttpClient;
import tools.jackson.databind.ObjectMapper;

import java.util.concurrent.TimeUnit;

@NoArgsConstructor
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
