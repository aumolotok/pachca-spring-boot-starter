package com.pachcaBotComponents.polling;

import com.pachcaBotComponents.api.PachcaEventApi;
import com.pachcaBotComponents.interfaces.EventProvider;
import com.pachcaBotComponents.interfaces.LongPollingEventConsumer;
import com.pachcaBotComponents.interfaces.PachcaLongPollingBot;
import com.pachcaBotComponents.polling.models.ApiResponse;
import com.pachcaBotComponents.polling.models.data.EventItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Component
@Slf4j
public class PachcaPollingClient implements EventProvider<EventItem> {

    @Autowired
    private PachcaEventApi pachcaEventApi;
    private ScheduledExecutorService scheduledExecutorService;
    private LongPollingEventConsumer consumer;

    private final int cacheAndPullLimit = 50;

    private final EventCache cache = new EventCache(cacheAndPullLimit);

    public PachcaPollingClient(PachcaLongPollingBot pachcaLongPollingBot) {
        pachcaEventApi = new PachcaEventApi(pachcaLongPollingBot.getBotToken());
        this.scheduledExecutorService = Executors.newScheduledThreadPool(1);
        this.consumer = pachcaLongPollingBot.getUpdatesConsumer();
    }

    public void startPolling() {
        var all = pachcaEventApi.getLast50EventsResponse().getData();
        cache.putAllByOne(all);
        scheduledExecutorService.scheduleAtFixedRate(this::pollingProcess,3, 3, TimeUnit.SECONDS);
    }

    public void stopPolling() {
        scheduledExecutorService.shutdown();
    }

    private void pollingProcess() {
        var allResponse = pachcaEventApi.getLast50EventsResponse();
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
