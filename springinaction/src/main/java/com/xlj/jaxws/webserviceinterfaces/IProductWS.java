package com.xlj.jaxws.webserviceinterfaces;

import com.xlj.jaxws.model.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "productws")
public interface IProductWS {

    @WebMethod
    List<User> getAllUsers();

}
