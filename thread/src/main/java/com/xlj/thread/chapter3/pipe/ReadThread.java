package com.xlj.thread.chapter3.pipe;

import java.io.PipedInputStream;

public class ReadThread extends Thread {

    private ReadData readData;
    private PipedInputStream inputStream;

    public ReadThread(ReadData readData, PipedInputStream inputStream)
    {
        this.readData = readData;
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        this.readData.readMethod(inputStream);
    }
}
