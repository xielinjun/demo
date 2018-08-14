package com.xlj.jaxws;


import com.xlj.jaxws.webserviceinterfaces.IProductWS;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        Config.class
        , ConfigServer.class
        , Scanner.class
})
public class TestServer {

    @Autowired
    IProductWS productWS;

    @Test
    public void testServerStart() {

        System.out.println(productWS.getAllUsers());

        while (true) {
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
