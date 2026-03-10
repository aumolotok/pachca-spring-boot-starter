package com.pachcaBotComponents.interfaces;

import com.pachcaBotComponents.polling.models.data.EventItem;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public interface LongPollingEventConsumer {
    Executor updatesProcessorExecutor = Executors.newSingleThreadExecutor();

    default void consume(List<EventItem> eventItems) {
        eventItems.forEach((update) -> updatesProcessorExecutor.execute(() -> this.consume(update)));
    }

    void consume(EventItem eventItem);
}
