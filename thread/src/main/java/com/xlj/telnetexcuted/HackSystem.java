package com.xlj.telnetexcuted;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class HackSystem {

    private static ByteArrayOutputStream buffer = new ByteArrayOutputStream();

//    public final static PrintStream out = new PrintStream(buffer);
    public final static PrintStream out = new HackPrintStream(buffer);

//    public final static PrintStream err = out;

    public final static InputStream in = System.in;

//    public final static InputStream in = new InputStream() {
//        @Override
//        public int read() throws IOException {
//
//            return 0;
//        }
//    };

    public static String getBufferString()
    {
        return buffer.toString();
    }

    public static void clearBuffer()
    {
        buffer.reset();
    }

    public static void setSecurityManager(final SecurityManager s)
    {
        System.setSecurityManager(s);
    }

    public static SecurityManager getSecurityManager()
    {
        return System.getSecurityManager();
    }

    public static long currentTimeMillis()
    {
        return System.currentTimeMillis();
    }

    public static void arraycopy(Object src, int srcPos,
                                 Object dest, int destPos,
                                 int length)
    {
        System.arraycopy(src, srcPos, dest, destPos, length);
    }

    public static int identityHashCode(Object x)
    {
        return System.identityHashCode(x);
    }

}
