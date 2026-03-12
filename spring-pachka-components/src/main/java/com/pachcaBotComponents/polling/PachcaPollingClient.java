package com.pachcaBotComponents.polling;

import api.PachcaBotApi;
import api.models.data.EventItem;
import api.models.data.payloads.BasePayload;
import com.pachcaBotComponents.interfaces.EventProvider;
import com.pachcaBotComponents.interfaces.LongPollingEventConsumer;
import com.pachcaBotComponents.interfaces.PachcaLongPollingBot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class PachcaPollingClient implements EventProvider<EventItem> {

    @Autowired
    private PachcaBotApi pachcaBotApi;
    private final ScheduledExecutorService scheduledExecutorService;
    private final LongPollingEventConsumer consumer;

    private final int cacheAndPullLimit = 50;

    private final EventCache cache = new EventCache(cacheAndPullLimit);

    public PachcaPollingClient(PachcaLongPollingBot pachcaLongPollingBot) {
        pachcaBotApi = new PachcaBotApi(pachcaLongPollingBot.getBotToken());
        this.scheduledExecutorService = Executors.newScheduledThreadPool(1);
        this.consumer = pachcaLongPollingBot.getUpdatesConsumer();
    }

    public void startPolling() {
        var all = pachcaBotApi.getLast50EventsResponse().getData();
        cache.putAllByOne(all);
        scheduledExecutorService.scheduleAtFixedRate(this::pollingProcess,3, 3, TimeUnit.SECONDS);
    }

    public void stopPolling() {
        scheduledExecutorService.shutdown();
    }

    private void pollingProcess() {
        var allResponse = pachcaBotApi.getLast50EventsResponse();
        var eventsToPass = getEventsToReactOn(allResponse.getData());
        passEventToConsumer(eventsToPass);
        log.trace(allResponse.getData().stream().findFirst().get().toString());
    }

    @Override
    public List<EventItem> getEventsToReactOn(List<EventItem> allEvents) {
        return allEvents
                .stream()
                .limit(cacheAndPullLimit)
                .filter(event -> !cache.hasInCache(event.getId()))
                .toList();
    }

    @Override
    public void passEventToConsumer(List<EventItem> eventToConsumer) {
        eventToConsumer.forEach(event -> {
            consumer.consume(event);
            cache.putEventIfNo(event);
        });
    }
}
