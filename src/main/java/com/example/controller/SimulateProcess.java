package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class SimulateProcess extends AbstractProcess {

    private List<String> messages = new ArrayList<String>(){{
        add("Start");
        add("Get connection to service");
        add("Check operation");
        add("File downloading");
        add("Analysis data");
        add("Save file to the disk");
        add("Finish");
    }};

    public SimulateProcess(BlockingQueue<String> messageQueue) {
        super(messageQueue);
    }


    public void process() {
        try {
            for (String message : messages) {
                messageQueue.put(message);
                Thread.sleep(1000);//simulate delay
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
