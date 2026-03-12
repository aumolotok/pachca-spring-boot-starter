package com.pachcaApp.components;

import api.PachcaSendApi;
import api.cast.EventPayloadUtils;
import api.enums.EventType;
import api.models.data.EventItem;
import api.models.data.payloads.BasePayload;
import api.models.data.payloads.MessagePayload;
import api.models.message.Message;
import api.models.message.MessageModel;
import api.models.message.buttons.DataButton;
import api.models.message.buttons.UrlButton;
import com.pachcaApp.configs.AppConfigs;
import com.pachcaBotComponents.interfaces.LongPollingEventConsumer;
import com.pachcaBotComponents.interfaces.PachcaLongPollingBot;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PachcaBot implements PachcaLongPollingBot {

    private final AppConfigs appConfigs;

    private PachcaSendApi pachcaSendApi;

    public PachcaBot(AppConfigs appConfigs) {
        pachcaSendApi = new PachcaSendApi(appConfigs.getPachca().getApi().getToken());
        this.appConfigs = appConfigs;
    }

    @Override
    public String getBotName() {
        return "Тестовый бот";
    }

    @Override
    public String getBotToken() {
        return appConfigs.getPachca().getBots().get("example_bot").getToken();
    }

    @Override
    public LongPollingEventConsumer getUpdatesConsumer() {
        return this;
    }

    @Override
    public void consume(EventItem<? extends BasePayload> eventItem) {
        mirrorMessage(eventItem);
    }


    private void mirrorMessage(EventItem<? extends BasePayload> eventItem) {
        if (eventItem.getEventType().equals(EventType.MESSAGE_NEW) ){
            var castEvent = EventPayloadUtils.toEventType(eventItem, MessagePayload.class);
            if (castEvent.getPayload().getEntityId() == 34902114){
                var message = Message
                        .builder()
                        .entity_type(castEvent.getPayload().getEntityType())
                        .entity_id(castEvent.getPayload().getEntityId())
                        .content("Получено сообщение: " + castEvent.getPayload().getContent())
                        .buttons(

                                List.of(List.of(
                                UrlButton
                                        .builder()
                                        .url("https://github.com/aumolotok/pachca-spring-boot-starter")
                                        .text("А еще посмотри в Гит Лаб")
                                        .build(),
                                DataButton.builder()
                                        .data("Нажали на кнопку")
                                        .text("Нажимай")
                                        .build())
                        ))
                        .build();

                var messageModel = MessageModel
                        .builder()
                        .message(message)
                        .build();
                pachcaSendApi.sendToChat(messageModel);
            }
        }
    }
}
