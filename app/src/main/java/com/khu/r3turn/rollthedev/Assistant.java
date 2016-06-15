package com.khu.r3turn.rollthedev;

/**
 * Created by yb on 2016-06-15.
 */
public class Assistant {
    int count;
    String name;
    double linePerSecond;
    double price;

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

    public double getLinePerSecond() {
        return linePerSecond;
    }

    public void setLinePerSecond(double linePerSecond) {
        this.linePerSecond = linePerSecond;
    }

    public Assistant(String name, double linePerSecond, double price) {
        this.count = 0;
        this.name = name;
        this.linePerSecond = linePerSecond;
        this.price = price;
    }
}
