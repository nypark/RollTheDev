package com.khu.r3turn.rollthedev;

import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by PNY on 2016-06-15.
 */
public class Developer {

    private static int DEVELOPER_IMG_SRC = 0;

    private CodeLineThread codeLineThread = new CodeLineThread();
    private int imgFrame = 1;
    private ImageView devImg = null;

    public int codeLine = 0;

    public Developer(ViewGroup vg) {
        devImg = (ImageView) vg.findViewById(R.id.DevImg);
        DEVELOPER_IMG_SRC = R.drawable.developer1;
    }

    public void changeImgType () {
        if(imgFrame == 1) imgFrame = 2;
        else imgFrame = 1;
        //imgFrame = (imgFrame==1)? 2:1;
    }

    public void draw() {
        //frame 1
        if(imgFrame == 1)
            DEVELOPER_IMG_SRC = R.drawable.developer1;
        //frame 2
        else
            DEVELOPER_IMG_SRC = R.drawable.developer2;

        devImg.setImageResource(DEVELOPER_IMG_SRC);
    }

    public void addCodeLine() {
        codeLine++;
        changeImgType();
        draw();
    }

    public int getCodeLine() {
        return codeLine;
    }
}
