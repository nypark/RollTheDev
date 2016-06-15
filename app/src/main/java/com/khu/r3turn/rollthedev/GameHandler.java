package com.khu.r3turn.rollthedev;

import android.app.Activity;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by PNY on 2016-06-15.
 */
public class GameHandler {
    public static int TEXT_FLOAT_UP = 1;
    public static int TEXT_FLOAT_DOWN = 2;

    public int codeLine = 0;

    Activity thisActivity = null;
    TextView codeLineTextView = null;
    ImageView devImg = null;
    Developer developer = null;


    public GameHandler(Activity ctx) {
        thisActivity = ctx;

        developer = new Developer( (RelativeLayout) ctx.findViewById(R.id.DevScreen));

        codeLineTextView = (TextView) ctx.findViewById(R.id.codeLineText);
        devImg = (ImageView) ctx.findViewById(R.id.DevImg);

        init();

        developer.draw();
    }

    public void init() {
        //add onClickListener to increase code line number
        devImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] coordinates = new int[2];
                v.getLocationOnScreen(coordinates);
                addCodeLine(coordinates[0], coordinates[1]);
                showFloatingText(TEXT_FLOAT_UP, coordinates[0], coordinates[1], "+1");
            }
        });
    }

    public void addCodeLine(int x, int y) {
        codeLine++;
        codeLineTextView.setText("" + codeLine);
        developer.changeImgType();
        developer.draw();
    }

    public void showFloatingText(int floatType, int x, int y, String text) {
        PixelTextView floatTextView = new PixelTextView(thisActivity, null);
        floatTextView.setText(text);
        floatTextView.setX(x);
        floatTextView.setY(y);
        floatTextView.setVisibility(View.VISIBLE);
        SystemClock.sleep(1000);
        floatTextView.setVisibility(View.GONE);
    }
}
