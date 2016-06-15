package com.khu.r3turn.rollthedev;

/**
 * Created by yb on 2016-06-15.
 */
public class Consumable {
    int count;
    String name;
    double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    int assistMultiplier;
    int developerMutliplier;
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

    public int getAssistMultiplier() {
        return assistMultiplier;
    }

    public void setAssistMultiplier(int assistMultiplier) {
        this.assistMultiplier = assistMultiplier;
    }

    public int getDeveloperMutliplier() {
        return developerMutliplier;
    }

    public void setDeveloperMutliplier(int developerMutliplier) {
        this.developerMutliplier = developerMutliplier;
    }

    public Consumable(String name, int dm, int am) {
        this.name=name;
        this.developerMutliplier = dm;
        this.assistMultiplier=am;
    }
}
