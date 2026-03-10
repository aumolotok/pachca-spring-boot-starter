package com.pachcaBotComponents.interfaces;

import com.pachcaBotComponents.polling.models.data.EventItem;

import java.util.List;

public interface EventProvider<T extends EventItem> {

    List<T> getEventsToReactOn(List<T> allEvents);

    void passEventToConsumer(List<T> eventToCunsumer);
}
