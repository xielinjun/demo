package com.xlj.rmi;

import com.xlj.rmi.interfaces.IUserDao;
import com.xlj.rmi.serviceinterfaces.IProducter;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {
                Config.class
                ,Scaner.class
        })
public class Test {

    @Autowired
    @Qualifier("rmiProxyFactoryBean")
    IProducter producter;

    @Autowired
    IUserDao userDao;

    @org.junit.Test
    public void test()
    {
        System.out.println(userDao);
        System.out.println(producter);

        System.out.println(this.producter.getAllUser());

        while (true)
        {
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @org.junit.Test
    public void publishTest()
    {
        String serURL = "rmi://localhost:1099/producter";
        IProducter producter1 = null;
        try {
            producter1 = (IProducter) Naming.lookup(serURL);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        while (true)
        {
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }

            producter1.getAllUser();
        }
    }

}
