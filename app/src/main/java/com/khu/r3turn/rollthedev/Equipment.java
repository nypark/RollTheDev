package com.khu.r3turn.rollthedev;

/**
 * Created by yb on 2016-06-15.
 */
public class Equipment {
    int count;
    String name;
    double lineAdder;
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

    public double getLineAdder() {
        return lineAdder;
    }

    public void setLineAdder(double lineAdder) {
        this.lineAdder = lineAdder;
    }

    public double getLineMultiplier() {
        return lineMultiplier;
    }

    public void setLineMultiplier(double lineMultiplier) {
        this.lineMultiplier = lineMultiplier;
    }

    public Equipment(String name, double lineAdder, double lineMultiplier) {
        this.count = 0;

        this.name = name;
        this.lineAdder = lineAdder;
        this.lineMultiplier = lineMultiplier;
    }
}
