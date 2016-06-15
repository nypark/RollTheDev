package com.khu.r3turn.rollthedev;

import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by PNY on 2016-06-15.
 */
public class Developer {

    private static int DEVELOPER_LEVEL_1 = 1;
    private static int DEVELOPER_LEVEL_2 = 3;
    private static int DEVELOPER_LEVEL_3 = 5;

    private static int DEVELOPER_IMG_SRC = 0;

    private int imgFrame = 1;
    private ImageView devImg = null;

    boolean feverMode = false;

    private int devLevel = DEVELOPER_LEVEL_1;

    private double codeLine = 0;
    private double totalCodeLine= 0;
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
        feverMode = false;
    }

    public void changeImgType () {
        if(!feverMode) {
            if (imgFrame%2 == 0)
                imgFrame -= 1;
            else
                imgFrame += 1;
        } else {

        }
        //imgFrame = (imgFrame==1)? 2:1;
    }

    public void draw() {
        //frame 1
        switch(imgFrame) {
            case 1:
                DEVELOPER_IMG_SRC = R.drawable.developer1_1;
                break;
            case 2:
                DEVELOPER_IMG_SRC = R.drawable.developer1_2;
                break;
            case 3:
                DEVELOPER_IMG_SRC = R.drawable.developer2_1;
                break;
            case 4:
                DEVELOPER_IMG_SRC = R.drawable.developer2_2;
                break;
            case 5:
                DEVELOPER_IMG_SRC = R.drawable.developer3_1;
                break;
            case 6:
                DEVELOPER_IMG_SRC = R.drawable.developer3_2;
                break;
            case 7:
                DEVELOPER_IMG_SRC = R.drawable.developer1_fever1;
                break;
            case 8:
                DEVELOPER_IMG_SRC = R.drawable.developer1_fever2;
                break;
            case 9:
                DEVELOPER_IMG_SRC = R.drawable.developer2_fever1;
                break;
            case 10:
                DEVELOPER_IMG_SRC = R.drawable.developer2_fever2;
                break;
            case 11:
                DEVELOPER_IMG_SRC = R.drawable.developer3_fever1;
                break;
            case 12:
                DEVELOPER_IMG_SRC = R.drawable.developer3_fever2;
                break;
        }

        devImg.setImageResource(DEVELOPER_IMG_SRC);
    }

    public void changeFeverMode() {
        feverMode = feverMode? false:true;
    }

    public void addCodeLine() {
        this.codeLine +=this.clickMultiplier;
        this.totalCodeLine +=this.clickMultiplier;
        changeImgType();
        draw();
    }
    public void addLpts() {
        this.codeLine+=this.linePerOneTenthSeconds;
        this.totalCodeLine+=this.linePerOneTenthSeconds;
        if(totalCodeLine > 1000.0f) {
            levelUp(DEVELOPER_LEVEL_2);
        } else if(totalCodeLine > 10000.0f) {
            levelUp(DEVELOPER_LEVEL_3);
        }
    }

    public void levelUp(int level) {
        imgFrame = level;
    }

    public double getTotalCodeLine() { return  this.totalCodeLine; }
    public double getCodeLine() {
        return this.codeLine;
    }
    public double getClickMultiplier() {
        return this.clickMultiplier;
    }

}
