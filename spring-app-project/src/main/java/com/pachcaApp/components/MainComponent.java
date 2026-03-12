package com.pachcaApp.components;

import com.pachcaBotComponents.polling.PachcaPollingClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan
@Component
public class MainComponent {

    private PachcaPollingClient pachcaPollingClient;
}
