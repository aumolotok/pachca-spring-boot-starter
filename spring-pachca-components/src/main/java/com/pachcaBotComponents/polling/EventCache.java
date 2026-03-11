package com.pachcaBotComponents.polling;

import api.models.data.EventItem;
import com.pachcaBotComponents.utils.BoundedMap;

import java.util.Collections;
import java.util.List;

public class EventCache {

    private final BoundedMap<String, EventItem> cache;

    public void putEventIfNo(EventItem eventItem) {

        var id = eventItem.getId();

        cache.putIfAbsent(id, eventItem);
    }

    public void putAllByOne(List<EventItem> events) {
        Collections.reverse(events);
        events.forEach( event -> cache.putIfAbsent(event.getId(), event));
    }

    public boolean hasInCache(String id) {
        return cache.containsKey(id);
    }

    public EventCache(int size) {
        cache = new BoundedMap<>(size);
    }

    public EventCache() {
        cache = new BoundedMap<>(10);
    }
}
