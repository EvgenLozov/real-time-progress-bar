package com.example.controller;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

public class DummyProcess implements Runnable{

    private SseEmitter sseEmitter;

    public DummyProcess(SseEmitter sseEmitter) {
        this.sseEmitter = sseEmitter;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            try {
                sseEmitter.send(i);
            } catch (IOException e) {
                e.printStackTrace();
                sseEmitter.completeWithError(e);
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
                sseEmitter.completeWithError(e);
            }
        }
        sseEmitter.complete();
    }
}
