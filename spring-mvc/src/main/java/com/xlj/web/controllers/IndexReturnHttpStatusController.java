package com.xlj.web.controllers;

import com.xlj.web.domain.entity.User;
import com.xlj.web.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class IndexReturnHttpStatusController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/findUsersByName_ResponseEntity/{name}"
            ,method = RequestMethod.GET)
    public ResponseEntity<List<User>> findUsersByName(
            @PathVariable("name") String name
            , UriComponentsBuilder uriComponentsBuilder)
    {
        List<User> userList = this.userRepository.findUsersByName(name);

        userList =
                (userList == null || userList.size() == 0)?
                        null : userList;

        HttpStatus status =
                (userList == null || userList.size() == 0)?
                        HttpStatus.NOT_FOUND:HttpStatus.OK;

        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setLocation(
                uriComponentsBuilder
                        .path("/findUsersByName_Error")
                        .path("/template").build().toUri());

        ResponseEntity<List<User>> responseEntity =
                new ResponseEntity<List<User>>(userList, httpHeaders, status);

        return responseEntity;
    }

    @RequestMapping(value = "/findUsersByName_Error/{name}"
            ,method = RequestMethod.GET)
    public ResponseEntity<?> findUsersByName_Error(@PathVariable("name") String name)
    {
        List<User> userList = this.userRepository.findUsersByName(name);

        userList = (userList == null || userList.size() == 0)?
                null:userList;

        HttpStatus status = (userList == null || userList.size() == 0)?
                HttpStatus.NOT_FOUND:HttpStatus.OK;

        if(status == HttpStatus.OK)
        {
            return new ResponseEntity<List<User>>(userList, status);
        }
        else {
            Error error = new Error();
            error.setCode(100);
            error.setMessage("haha not found");
            return new ResponseEntity<Error>(error, status);
        }
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Error> notFoundException(NotFoundException exception)
    {
        Error error = new Error();
        error.setCode(100);
        error.setMessage(exception.getTarget() + "");

        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/findUsersByName_Error_ExceptionHandler/{name}"
            ,method = RequestMethod.GET)
    public List<User> findUsersByName_Error_ExceptionHandler(@PathVariable("name") String name)
    {
        List<User> userList = this.userRepository.findUsersByName(name);

        if(userList == null || userList.size() == 0 )
        {
            NotFoundException notFoundException =
                    new NotFoundException();

            notFoundException.<String>setTarget(name);

            throw notFoundException;
        }

        return userList;
    }

    @RequestMapping("/returnString")
    public String returnString()
    {
        return "ddd";
    }

    public static class NotFoundException extends RuntimeException
    {
        Object target;

        public <T> T getTarget() {
            return (T)target;
        }

        public <T> void setTarget(T target) {
            this.target = target;
        }
    }

}
