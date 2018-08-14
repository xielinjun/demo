package com.xlj.rmi.serviceinterfaces;

import com.xlj.rmi.model.User;
import org.springframework.stereotype.Component;

@Component
public interface IProducter {

    java.util.List<User> getAllUser();

}
