package com.pachcaBotComponents.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BotComponent {

    @Autowired
    private HelloComponent helloComponent;

    public void message() {
        helloComponent.hello();
    }
}
