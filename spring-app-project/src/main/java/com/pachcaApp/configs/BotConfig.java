package com.pachcaApp.configs;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BotConfig {
    private String name;

    @NotBlank(message = "Bot token is required")
    private String token;
}