package com.xlj.telnetexcuted;

import java.io.OutputStream;
import java.io.PrintStream;

public class HackPrintStream extends PrintStream {
    public HackPrintStream(OutputStream out) {
        super(out);

    }

    public void println(String str) {
        super.println("HackPrintStream: " + str);
    }
}
