package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Controller
public class ProcessStatusController {

    @RequestMapping("/events")
    public SseEmitter handle() {
        SseEmitter emitter = new SseEmitter();

        BlockingQueue<String> messageQueue = new LinkedBlockingQueue<>();
        Process process = new SimulateProcess(messageQueue);

        new Thread(new MessageConsumer(messageQueue, emitter)).start();
        new Thread(process::process).start();

        return emitter;
    }
}
