package com.xlj.interfaces.model;

import java.io.Serializable;
import java.util.List;

public class OrderDetial  implements Serializable {

    String articName = "";
    float count = 0F;
    float amount = 0F;

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

    public OrderDetial() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public String toString() {
        return "OrderDetial{" +
                "articName='" + articName + '\'' +
                ", count=" + count +
                ", amount=" + amount +
                ", price=" + price +
                '}';
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
