package com.xlj.events;

import org.springframework.context.ApplicationEvent;

public class TestEvent extends ApplicationEvent {

    private String msg;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public TestEvent(Object source) {
        super(source);
    }


    public TestEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public void Print()
    {
        System.out.println(this.msg);
    }
}
