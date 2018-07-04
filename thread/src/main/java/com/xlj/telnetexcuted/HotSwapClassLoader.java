package com.xlj.telnetexcuted;

public class HotSwapClassLoader extends ClassLoader {

    public HotSwapClassLoader()
    {
//        super(HotSwapClassLoader.class.getClassLoader());
    }

    public Class loadByte(byte[] classByte)
    {
        try {
            Class<?> cl = Class.forName("com.xlj.App");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return this.defineClass(null, classByte, 0, classByte.length);
    }

}
