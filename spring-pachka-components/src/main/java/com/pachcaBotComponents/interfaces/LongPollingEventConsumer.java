package com.pachcaBotComponents.interfaces;

import api.models.data.EventItem;
import api.models.data.payloads.BasePayload;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public interface LongPollingEventConsumer {
    Executor updatesProcessorExecutor = Executors.newSingleThreadExecutor();

    default void consume(List<EventItem> eventItems) {
        eventItems.forEach((update) -> updatesProcessorExecutor.execute(() -> this.consume(update)));
    }

    void consume(EventItem<? extends BasePayload> eventItem);
}
