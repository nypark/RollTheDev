package com.khu.r3turn.rollthedev;

import android.app.Activity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by PNY on 2016-06-15.
 */
public class GameHandler {
    public static int TEXT_FLOAT_UP = 1;
    public static int TEXT_FLOAT_DOWN = 2;

    Activity thisActivity = null;

    RelativeLayout devScreen = null;
    TextView codeLineTextView = null;
    ImageView devImg = null;
    Developer developer = null;


    public GameHandler(Activity ctx) {
        thisActivity = ctx;

        devScreen = (RelativeLayout) ctx.findViewById(R.id.DevScreen);
        developer = new Developer( (RelativeLayout) ctx.findViewById(R.id.DevScreen));
        codeLineTextView = (TextView) ctx.findViewById(R.id.codeLineText);
        devImg = (ImageView) ctx.findViewById(R.id.DevImg);

        init();

        developer.draw();
    }

    public void init() {
        //add onClickListener to increase code line number
        devImg.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, final MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN ) {
                    new Thread() {
                        public void run() {
                            try {
                                final float x, y;
                                x = (event.getX() + event.getRawX())/2.0f;
                                y = (event.getY() + event.getRawY())/2.0f;
                                Log.d("coord", x + ", " + y);
                                developer.addCodeLine();
                                codeLineTextView.setText("" + developer.getCodeLine());
                                showFloatingText(TEXT_FLOAT_UP, (int) x, (int) y, "+1");
                            } catch (Exception e) {e.printStackTrace();}
                        }
                    }.run();
                }
                return false;
            }
        });
    }


    public void showFloatingText(int floatType, int x, int y, String text) {
        final PixelTextView floatTextView = new PixelTextView(thisActivity, null);
        floatTextView.setText(text);
        floatTextView.setX(x);
        floatTextView.setY(y);
        devScreen.addView(floatTextView);
        floatTextView.setVisibility(View.VISIBLE);
        Animation floatUpAnim = AnimationUtils.loadAnimation(thisActivity, R.anim.floatup);
        floatTextView.startAnimation(floatUpAnim);
        floatUpAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                floatTextView.setVisibility(View.GONE);
                devScreen.removeView(floatTextView);
            }

            @Override
            public void onAnimationStart(Animation animation) { }
            @Override
            public void onAnimationRepeat(Animation animation) { }
        });
    }
}
