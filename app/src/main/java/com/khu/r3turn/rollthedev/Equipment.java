package com.khu.r3turn.rollthedev;

/**
 * Created by yb on 2016-06-15.
 */
public class Equipment {
    int count;
    double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    String name;
    double lineMultiplier;

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

    public double getLineMultiplier() {
        return lineMultiplier;
    }

    public void setLineMultiplier(double lineMultiplier) {
        this.lineMultiplier = lineMultiplier;
    }

    public Equipment(String name, double lineMultiplier, double price) {
        this.count = 0;
        this.price = price;
        this.name = name;
        this.lineMultiplier = lineMultiplier;
    }
}
