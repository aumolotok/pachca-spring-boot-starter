package com.pachcaApp.components;

import com.pachcaBotComponents.components.BotComponent;
import com.pachcaBotComponents.polling.PachcaPollingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan
@Component
public class MainComponent {
    private PachcaPollingClient pachcaPollingClient;


}
