package com.xlj.interfaces.model;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {

    User user = new User();
    String address = "";

    float amount = 0F;
    float count = 0F;

    public User getUser() {
        return user;
    }


    List<OrderDetial> detials = null;

    public List<OrderDetial> getDetials() {
        return detials;
    }

    public void setDetials(List<OrderDetial> detials) {
        this.detials = detials;
    }

    @Override
    public String toString() {
        return "Order{" +
                "user=" + user +
                ", address='" + address + '\'' +
                ", amount=" + amount +
                ", count=" + count +
                '}';
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getCount() {
        return count;
    }

    public void setCount(float count) {
        this.count = count;
    }
}