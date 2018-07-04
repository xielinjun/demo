package com.xlj.thread.chapter3.pipe;

import java.io.PipedOutputStream;

public class WriteThread extends Thread {

    private WriteData writeData;
    private PipedOutputStream outputStream;

    public WriteThread(WriteData writeData, PipedOutputStream outputStream)
    {
        this.writeData = writeData;
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        writeData.writeMethod(this.outputStream);
    }
}
