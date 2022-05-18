package ru.itis.kurguskina.internet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExceptionController {

    @GetMapping(value = "/runtimeException")
    public void throwException() {
        throw new RuntimeException();
    }
}
