package com.pachcaApp;

import com.pachcaApp.components.MainComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringPachcaApp {

    @Autowired
    private MainComponent mainComponent;

    public static void main(String[] args) {
        SpringApplication.run(SpringPachcaApp.class, args);
    }
}
