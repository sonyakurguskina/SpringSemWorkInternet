package ru.itis.kurguskina.springsemworkinternet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionController {

    @GetMapping(value = "/runtimeException")
    public void throwException() {
        throw new RuntimeException();
    }
}
