package com.pachcaBotComponents;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "my.starter")
public class PachcaProperties {
    private String value;

    // геттеры и сеттеры
}