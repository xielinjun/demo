package com.xlj.jpa;

import com.xlj.jpa.model.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = Config.class)

@Transactional
//@Repository
public class Test {

    @PersistenceUnit(unitName = "localEntityManagerFactoryBean")
//    @Qualifier("localEntityManagerFactoryBean")
    EntityManagerFactory localEntityManagerFactoryBean;

    @PersistenceUnit(unitName = "localContainerEntityManagerFactoryBean")
//    @Qualifier("localContainerEntityManagerFactoryBean")
    EntityManagerFactory localContainerEntityManagerFactoryBean;

    @org.junit.Test
    public void test ()
    {
        System.out.println(this.localEntityManagerFactoryBean);

//        System.out.println(this.localContainerEntityManagerFactoryBean);



        System.out.println(
                this.localEntityManagerFactoryBean.createEntityManager()
                        .find(User.class, 80)
        );

        System.out.println(
                this.localEntityManagerFactoryBean.createEntityManager()
                        .createQuery(" from User").getResultList()
        );



//        System.out.println(
//                this.localContainerEntityManagerFactoryBean.createEntityManager()
//                        .find(User.class, 80)
//        );
//
//        System.out.println(
//                this.localContainerEntityManagerFactoryBean.createEntityManager()
//                        .createQuery(" from User").getResultList()
//        );
    }

}
