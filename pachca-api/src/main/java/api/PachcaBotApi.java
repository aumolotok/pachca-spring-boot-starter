package api;

import api.models.ApiResponse;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class PachcaBotApi extends PachcaApiBase {

    private final String events = "https://api.pachca.com/api/shared/v1/webhooks/events";

    public PachcaBotApi(String botToken) {
        super(botToken);
    }

    public ApiResponse getLast50EventsResponse() {
        Request request =
                new Request
                        .Builder()
                        .addHeader("Authorization", "Bearer " + bearerToken)
                        .url(this.events)
                        .build();
        try(Response response = okHttpClient.newCall(request).execute()) {

            String jsonString = response.body().string();
            return objectMapper.readValue(jsonString, ApiResponse.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
