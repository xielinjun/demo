package com.xlj.hibernate;

import com.xlj.hibernate.model.User;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class TestJavaConfig {

    @Autowired
    SessionFactory sessionFactory;

    @SuppressWarnings({"unchecked", "unexpected"})
    @Transactional
    @Test
    public void test()
    {
        for(int i=0; i <10; i++)
        {
            //new
            System.out.println(this.sessionFactory.openSession().hashCode());
        }

        for(int i=0; i <10; i++)
        {
            //one
            System.out.println(this.sessionFactory.getCurrentSession().hashCode());
        }

        System.out.println(this.sessionFactory);

        User user = new User();
        user.setName("dddddd");
        user.setAge(213124);
        user.setSex("ewiruouou");

//        Serializable id =
//                this.sessionFactory.openSession().save(user);
//        System.out.println(id);

        this.sessionFactory.getCurrentSession().getTransaction().begin();

        Serializable id =
                this.sessionFactory.getCurrentSession().save(user);
        System.out.println(id);

        this.sessionFactory.getCurrentSession().getTransaction().commit();

        java.util.List<User> list = this.sessionFactory.getCurrentSession().createQuery(
                "from com.xlj.hibernate.model.User").list();

        for (User user1:list) {
            System.out.println(user1);
        }
    }
}
