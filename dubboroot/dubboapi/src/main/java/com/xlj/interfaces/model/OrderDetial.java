package com.xlj.interfaces.model;

import java.util.List;

public class OrderDetial {

    String articName = "";
    float count = 0F;
    float amount = 0F;
    List<OrderDetial> detials = null;

    public List<OrderDetial> getDetials() {
        return detials;
    }

    public void setDetials(List<OrderDetial> detials) {
        this.detials = detials;
    }

    public float getCount() {
        return count;
    }

    public void setCount(float count) {
        this.count = count;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    float price = 0F;

    public String getArticName() {
        return articName;
    }

    public void setArticName(String articName) {
        this.articName = articName;
    }
}
