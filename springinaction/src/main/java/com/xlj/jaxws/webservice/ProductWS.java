package com.xlj.jaxws.webservice;

import com.xlj.jaxws.daointerfaces.IUserDao;
import com.xlj.jaxws.model.User;
import com.xlj.jaxws.webserviceinterfaces.IProductWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@Component
@WebService(serviceName = "productws")
public class ProductWS implements IProductWS {

    @Autowired
    IUserDao userDao;

    @Override
    @WebMethod
    public List<User> getAllUsers() {
        return this.userDao.findAll();
    }
}