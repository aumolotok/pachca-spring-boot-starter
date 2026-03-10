package com.pachcaApp.configs;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Map;
import java.util.HashMap;

@Component
@ConfigurationProperties(prefix = "app")
@Data
@NoArgsConstructor
@Validated
public class AppConfigs {

    private PachcaConfig pachca = new PachcaConfig();

    @Data
    @NoArgsConstructor
    public static class PachcaConfig {
        private ApiConfig api = new ApiConfig();
        private Map<String, BotConfig> bots = new HashMap<>();
    }
}