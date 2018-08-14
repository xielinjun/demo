package com.xlj.web.controllers;

import com.xlj.web.domain.entity.User;
import com.xlj.web.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/jsp", method = RequestMethod.GET)
    public String jsp(HttpSession httpSession)
    {
        System.out.println(httpSession.getId() + " jsp " +httpSession.isNew());
        System.out.println(this);

        return "jsp";
    }

    @RequestMapping(value = "/html", method = RequestMethod.GET)
    public String html(HttpSession httpSession)
    {
        System.out.println(httpSession.getId() + " html " +httpSession.isNew());
        System.out.println(this);

        return "html";
    }

    @RequestMapping(value = "/findAllUsers", method = RequestMethod.GET)
    public List<User> findAllUsers(HttpSession httpSession)
    {
        return this.userRepository.findAll();
    }

    @RequestMapping(value = "/findAllUsers_Model")
    public String findAllUsers(Model model)
    {
        model.addAttribute(this.userRepository.findAll());

        return "findAllUsers_Model";
    }

    @RequestMapping(value = "/findUserByName/{name}")
    public List<User> findUsersByName(@PathVariable("name") String name)
    {
        return this.userRepository.findUsersByName(name);
    }

    @RequestMapping(value = "/findUsersByAgeBetween/{start}/{end}")
    public List<User> findUsersByAgeBetween(
            @PathVariable("start") int start,
            @PathVariable("end")int end)
    {
        return this.userRepository.findUsersByAgeBetween(start, end);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpSession httpSession)
    {
        System.out.println(httpSession.getId() + " / " +httpSession.isNew());
        System.out.println(this);

        System.out.println(this.userRepository);
        return "index";
    }
}