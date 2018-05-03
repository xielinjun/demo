package com.xlj;

import com.alibaba.dubbo.container.Main;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(App.class.getResource("/").getPath());

        Main.main(args);
    }
}
