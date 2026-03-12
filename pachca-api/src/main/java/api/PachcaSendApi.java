package api;

import api.models.message.MessageModel;
import lombok.RequiredArgsConstructor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
@RequiredArgsConstructor
public class PachcaSendApi extends PachcaApiBase {

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public PachcaSendApi(String token) {
        super(token);
    }

    public static String BASE_PACHCA_URL = "https://api.pachca.com/api/shared/v1";

    public static String MESSAGES = "/messages";

    public Object sendToChat(MessageModel messageModel) {

        String json = objectMapper.writeValueAsString(messageModel);
        var body = RequestBody.create(json, JSON);

        Request request =
                new Request
                        .Builder()
                        .post(body)
                        .url(BASE_PACHCA_URL + MESSAGES)
                        .build();
        try(Response response = okHttpClient.newCall(request).execute()) {

            String jsonString = response.body().string();
            return objectMapper.readValue(jsonString, Object.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
