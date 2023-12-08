package com.example.demo.controllers;

import com.example.demo.dtos.ApiResponse;
import com.example.demo.exceptions.IncorrectArgumentException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ExceptionHandler(IncorrectArgumentException.class)
    public ApiResponse handleIncorrectArgumentException(IncorrectArgumentException e) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.addError("incorrectArgument", e.getDescription());
        return apiResponse;
    }

}