package com.xlj.rmi;

import com.xlj.rmi.serviceinterfaces.IProducter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigClient.class})
public class TestClient {

    @Autowired
    IProducter producter;

    @Test
    public void testClientt()
    {

        //error
//        try {
//            ((IProducter)Naming.lookup("rmi://localhost/producter")).getAllUser();
//
//            System.out.println(Naming.lookup("rmi://localhost/producter"));
//
//            for (Class<?> interfaces:Naming.lookup("rmi://localhost/producter").getClass().getInterfaces()) {
//                System.out.println(interfaces);
//            }
//
//        } catch (NotBoundException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }

        System.out.println(producter.getAllUser());
    }

}
