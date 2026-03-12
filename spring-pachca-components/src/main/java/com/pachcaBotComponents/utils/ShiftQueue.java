package com.pachcaBotComponents.utils;

import java.util.*;

public class ShiftQueue<T> {

    private int size;

    private Deque<T> deque;

    public ShiftQueue(int size) {
        deque = new ArrayDeque<T>(size);
    }

    public void putOnTop(T value) {
        if(deque.size() >= size) {
            deque.removeLast();
        }
        deque.addFirst(value);
    }
}
