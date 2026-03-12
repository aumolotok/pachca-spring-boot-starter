package api.cast;

import api.models.data.EventItem;
import api.models.data.payloads.BasePayload;

public class EventPayloadUtils {
    public static  <T extends BasePayload> EventItem<T> toEventType(EventItem<? extends BasePayload> eventItem, Class<T> clazz) {
        return (EventItem<T>) eventItem;
    }
}
