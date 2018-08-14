package com.xlj.web.controllers;


import com.xlj.web.domain.entity.User;
import com.xlj.web.domain.repository.UserRepository;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.activemq.jms.pool.PooledConnectionFactory;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class IndexRestController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ActiveMQConnectionFactory activeMQConnectionFactory;

    @Autowired
    Connection connection;

    @Autowired
    PooledConnectionFactory pooledConnectionFactory;

    String activeMQQueue = "xlj.tset";

    @RequestMapping("findAllUsers_RestController")
    public List<User> findAllUsers_RestController()
    {

        try {
//            Connection connection = activeMQConnectionFactory.createConnection();
            Connection connection = pooledConnectionFactory.createConnection();

            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = new ActiveMQQueue(this.activeMQQueue);
            MessageProducer messageProducer = session.createProducer(destination);

            ObjectMessage objectMessage = new ActiveMQObjectMessage();
            objectMessage.setObject(this.userRepository.findAll().get(0));
            messageProducer.send(objectMessage);

            TextMessage textMessage = new ActiveMQTextMessage();
            textMessage.setText("test text message");
            messageProducer.send(textMessage);

            session.close();
//            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return this.userRepository.findAll();
    }

    @RequestMapping("findUsersByName_RestController")
    public List<Message> findUsersByName_RestController(String name)
    {
        List<Message> messageList = new ArrayList<>();

        try {
//            Connection connection = this.activeMQConnectionFactory.createConnection();
            Connection connection = pooledConnectionFactory.createConnection();

            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = new ActiveMQQueue(this.activeMQQueue);
            MessageConsumer messageConsumer = session.createConsumer(destination);
            Message message = messageConsumer.receive(10);
            while (message != null)
            {
                messageList.add(message);
                System.out.println(message);
                message = messageConsumer.receive(10);
            }

            session.close();
//            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

//        return this.userRepository.findUsersByName(name);
        return messageList;
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Error> catchRuntimeException(RuntimeException excption)
    {
        Error error = new Error();

        error.setCode(100);
        error.setMessage(error.getMessage());

        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND) ;
    }

}
