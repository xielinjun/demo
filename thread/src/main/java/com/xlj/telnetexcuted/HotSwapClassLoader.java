package com.xlj.telnetexcuted;

public class HotSwapClassLoader extends ClassLoader {

    public HotSwapClassLoader()
    {
        super(HotSwapClassLoader.class.getClassLoader());
    }

    public Class loadByte(byte[] classByte)
    {
        return this.defineClass(null, classByte, 0, classByte.length);
    }

}
