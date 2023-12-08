package com.example.demo.dtos;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@NoArgsConstructor
public class ApiResponse {

    private Map<String, Object> response = new HashMap<>();
    private Map<String, Object> error = new HashMap<>();

    public ApiResponse(String key, Object value) {
        response.put(key, value);
    }

    public ApiResponse addError(String key, Object value) {
        error.put(key, value);
        return this;
    }

    public ApiResponse addSuccess(String key, Object value) {
        response.put(key, value);
        return this;
    }

}