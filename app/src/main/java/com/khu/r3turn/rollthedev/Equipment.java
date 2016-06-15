package com.khu.r3turn.rollthedev;

/**
 * Created by yb on 2016-06-15.
 */
public class Equipment {
    int count;
    String name;
    double lineAdder;
    double lineMultiplier;
    public Equipment(String name, double lineAdder, double lineMultiplier) {
        this.count = 0;
        this.name = name;
        this.lineAdder = lineAdder;
        this.lineMultiplier = lineMultiplier;
    }
}
