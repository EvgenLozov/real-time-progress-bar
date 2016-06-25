package com.example.controller;

import java.util.concurrent.BlockingQueue;

public abstract class AbstractProcess implements Process {

    protected BlockingQueue<String> messageQueue;

    public AbstractProcess(BlockingQueue<String> messageQueue) {
        this.messageQueue = messageQueue;
    }
}
