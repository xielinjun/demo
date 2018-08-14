package com.xlj.jaxws;

import com.xlj.jaxws.webservice.test.ProductWS;
import com.xlj.jaxws.webserviceinterfaces.IProductWS;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = ConfigClient.class)
public class TestClient {

    @Autowired
    ProductWS productWS;

    @Test
    public void testClient()
    {

        System.out.println(this.productWS);

        System.out.println(this.productWS.getAllUsers());
    }

}
