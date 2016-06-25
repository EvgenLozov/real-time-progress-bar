package com.example.controller;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class MessageConsumer implements Runnable{

    private BlockingQueue<String> messageQueue;
    private SseEmitter sseEmitter;

    public MessageConsumer(BlockingQueue<String> messageQueue, SseEmitter sseEmitter) {
        this.messageQueue = messageQueue;
        this.sseEmitter = sseEmitter;
    }

    @Override
    public void run() {
        try {
            while (true){
                String message = messageQueue.take();
                sseEmitter.send(message);
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
