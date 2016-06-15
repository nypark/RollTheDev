package com.khu.r3turn.rollthedev;

/**
 * Created by yb on 2016-06-16.
 */
public class CodeLineThread extends Thread {
    private double codeLine = 0;
    private double linePerOneTenthSeconds = 1.f;
    private double lineMultiplier = 1.f;
    public CodeLineThread(){

    }
    @Override
    public void run () {
        super.run();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        codeLine += linePerOneTenthSeconds * lineMultiplier;
    }
}
