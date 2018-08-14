package com.xlj.web.controllers;

import com.xlj.web.domain.entity.User;
import com.xlj.web.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
public class IndexResponeseBodyAndRequestBodyController {

    @Autowired
    UserRepository repository;

    @RequestMapping(value = "findAllUsers_ResponseBody"
            ,method = GET
            ,produces = {"application/xml", "application/json", "application/html"})
    public @ResponseBody List<User> findAllUsers_ResponseBody()
    {
        return this.repository.findAll();
    }

    @RequestMapping(value = "returnUser_ResponseBody"
    ,method = POST
    ,produces = {"application/json", "application/xml"}
    ,consumes = {"application/xml", "application/json"}
    )
    public @ResponseBody User returnUser_ResponseBody(@RequestBody User user)
    {
        return user;
    }

    @RequestMapping(value = "updateImage_ResponseBody"
    ,method = POST
//    ,produces = {"application/octet-stream"}
//    ,consumes = {"text/html"}
    )
    public @ResponseBody String updateImage_ResponseBody(@RequestBody byte[] bytes)
    {
        System.out.println(bytes.length);

        return "ok";
    }

    @RequestMapping(value = "returnImage_RepsonseBody"
    ,method = RequestMethod.POST
    ,produces = {"application/octet-stream"}
    )
    public @ResponseBody byte[] returnImage_RepsonseBody(@RequestBody byte[] bytes)
    {
        return bytes;
    }

}