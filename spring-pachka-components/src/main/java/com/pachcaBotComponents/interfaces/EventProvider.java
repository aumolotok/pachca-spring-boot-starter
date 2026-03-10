package com.pachcaBotComponents.interfaces;

import api.models.data.EventItem;

import java.util.List;

public interface EventProvider<T extends EventItem> {

    List<T> getEventsToReactOn(List<T> allEvents);

    void passEventToConsumer(List<T> eventToConsumer);
}
