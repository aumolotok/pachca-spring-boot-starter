package com.pachcaApp.configs;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@Validated
public class ApiConfig {
    @NotBlank(message = "Pachca API token is required")
    private String token;
}