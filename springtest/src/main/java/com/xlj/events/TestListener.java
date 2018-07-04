package com.xlj.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class TestListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof TestEvent)
        {
            TestEvent testEvent = (TestEvent) event;
            testEvent.Print();
        }else
        {
            System.out.println(event);
        }
    }
}
