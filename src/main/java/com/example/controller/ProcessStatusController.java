package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Controller
public class ProcessStatusController {

    @RequestMapping("/events")
    public SseEmitter handle() {
        SseEmitter emitter = new SseEmitter();

        new Thread(new DummyProcess(emitter)).start();

        return emitter;
    }
}
