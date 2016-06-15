package com.khu.r3turn.rollthedev;

import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by PNY on 2016-06-15.
 */
public class Developer {

    private static int DEVELOPER_IMG_SRC = 0;

    private int imgFrame = 1;
    private ImageView devImg = null;

    private double codeLine = 0;
    private double linePerOneTenthSeconds = 1.f;
    private double clickMultiplier = 1.f;
    private double assistMultiplier =1.f;

    public double getAssistMultiplier() {
        return assistMultiplier;
    }

    public void setAssistMultiplier(double assistMultiplier) {
        this.assistMultiplier = assistMultiplier;
    }

    public double getLinePerOneTenthSeconds() {
        return linePerOneTenthSeconds;
    }

    public void setLinePerOneTenthSeconds(double linePerOneTenthSeconds) {
        this.linePerOneTenthSeconds = linePerOneTenthSeconds;
    }

    public void setClickMultiplier(double clickMultiplier) {
        this.clickMultiplier = clickMultiplier;
    }

    public void setCodeLine(double codeLine) {
        this.codeLine = codeLine;
    }

    public Developer(ViewGroup vg) {
        devImg = (ImageView) vg.findViewById(R.id.DevImg);
        DEVELOPER_IMG_SRC = R.drawable.developer1_1;
    }

    public void changeImgType () {
        if(imgFrame == 1) imgFrame = 2;
        else imgFrame = 1;
        //imgFrame = (imgFrame==1)? 2:1;
    }

    public void draw() {
        //frame 1
        if(imgFrame == 1)
            DEVELOPER_IMG_SRC = R.drawable.developer1_1;
        //frame 2
        else
            DEVELOPER_IMG_SRC = R.drawable.developer1_2;

        devImg.setImageResource(DEVELOPER_IMG_SRC);
    }

    public void addCodeLine() {
        this.codeLine +=this.clickMultiplier;
        changeImgType();
        draw();
    }
    public void addLpts() {
       this.codeLine+=this.linePerOneTenthSeconds;
    }
    public double getCodeLine() {
        return this.codeLine;
    }
    public double getClickMultiplier() {
        return this.clickMultiplier;
    }

}
