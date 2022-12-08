package com.ecommerce.EcommerceApp.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiResponse {

    private final boolean success;
    private final String message;

    public String getTimestamp() {
        return LocalDateTime.now().toString();
    }
}
