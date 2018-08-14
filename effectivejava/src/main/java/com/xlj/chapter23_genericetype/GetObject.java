package com.xlj.chapter23_genericetype;

public class GetObject<T> {

    T object;

    public void setObject(T object)
    {
        this.object = object;
    }

    public T getObject()
    {
        return this.object;
    }

}
