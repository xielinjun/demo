package com.xlj.web.controllers;

import com.xlj.ContextLoaderListenerConfig;
import com.xlj.DispatcherServletConfig;
import com.xlj.web.domain.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;
import java.net.URI;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes ={
        ContextLoaderListenerConfig.class,
        DispatcherServletConfig.class})
public class IndexControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    @InjectMocks
//    @Autowired
    IndexController indexController;

    private MockMvc mockMvcWebApplication;
    private MockMvc mockMvcController;

    @Before
    public void init()
    {
        //controller
        MockitoAnnotations.initMocks(this);
        this.mockMvcController = MockMvcBuilders.standaloneSetup(this.indexController).build();

        //webapp
        this.mockMvcWebApplication = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void testFindAllUsers()
    {
        MvcResult mvcResult = null;

        try {
            mvcResult =
                    this.mockMvcWebApplication.perform(
                            MockMvcRequestBuilders.get("/findAllUsers.xml", new Object[]{}))
                            .andExpect(MockMvcResultMatchers.status().isOk())
                            .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(mvcResult);

        try {
            System.out.println(mvcResult.getResponse().getContentAsString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAllUsers1()
    {
        MvcResult mvcResult = null;

        try {
            mvcResult =
                    this.mockMvcWebApplication.perform(
                            MockMvcRequestBuilders.get("/findAllUsers.json", new Object[]{}))
                            .andExpect(MockMvcResultMatchers.status().isOk())
                            .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(mvcResult);

        System.out.println(mvcResult.getModelAndView());
        System.out.println(1);
        System.out.println(mvcResult.getModelAndView().getStatus());
        System.out.println(2);
        System.out.println(mvcResult.getModelAndView().getViewName());
        System.out.println(3);
        System.out.println(mvcResult.getModelAndView().getView());
        System.out.println(4);
        System.out.println(mvcResult.getModelAndView().getModel());
        System.out.println(5);

        try {
            System.out.println(mvcResult.getResponse().getContentAsString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
