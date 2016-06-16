package com.khu.r3turn.rollthedev;

/**
 * Created by yb on 2016-06-15.
 */
public class Consumable {
    int count;
    String name;
    double price;
    int lpsMutliplier;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Consumable(String name, int lm, double price) {
        this.count=0;
        this.lpsMutliplier=lm;
        this.name=name;
        this.price = price;
    }
}
