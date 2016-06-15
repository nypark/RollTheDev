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

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/**
 * Created by PNY on 2016-06-15.
 */
public class GameHandler {
    public static int TEXT_FLOAT_UP = 1;
    public static int TEXT_FLOAT_DOWN = 2;
    Activity thisActivity = null;
    RelativeLayout devScreen = null;
    TextView codeLineTextView = null;
    TextView codeLineTextView2 = null;
    ImageView devImg = null;
    Developer developer = null;
    Timer timer;

    List<Assistant> assistList;
    List<Equipment> equipList;
    List<Consumable> consumList;
    RelativeLayout a[];
    RelativeLayout c[];
    RelativeLayout e[];

    public GameHandler(Activity ctx) {
        thisActivity = ctx;
        devScreen = (RelativeLayout) ctx.findViewById(R.id.DevScreen);
        developer = new Developer( (RelativeLayout)devScreen);
        assistList = new ArrayList<Assistant>();
        equipList = new ArrayList<Equipment>();
        consumList = new ArrayList<Consumable>();

        codeLineTextView = (TextView) ctx.findViewById(R.id.codeLineText);
        codeLineTextView2 = (TextView) ctx.findViewById(R.id.codeLineText2);
        devImg = (ImageView) ctx.findViewById(R.id.DevImg);
        init();
        developer.draw();
    }
    public void init() {

        a = new RelativeLayout[6];
        e = new RelativeLayout[6];
        c = new RelativeLayout[6];
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                developer.addLpts();
                thisActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        codeLineTextView.setText("" + developer.getCodeLine());
                        codeLineTextView2.setText("" + developer.getLinePerOneTenthSeconds()*10+"lines per second");
                    }
                });
            }
        },100,100);
        //add onClickListener to increase code line number
        devImg.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, final MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN ) {

                    final float x, y;
                    x = (event.getX() + event.getRawX()) / 2.0f;
                    y = (event.getY() + event.getRawY()) / 2.0f;
                    Log.d("coord", x + ", " + y);
                    developer.addCodeLine();
                    showFloatingText(TEXT_FLOAT_UP, (int) x, (int) y, "+"+developer.getClickMultiplier());

                }
                return false;
            }
        });

        assistList.add(new Assistant("Newbie",1.2, 100));
        assistList.add(new Assistant("Intermediate",2.4, 100));
        assistList.add(new Assistant("Experienced",1.2, 100));
        assistList.add(new Assistant("Advanced",1.2, 100));
        assistList.add(new Assistant("Senior",1.2, 100));
        assistList.add(new Assistant("Expert",1.2, 100));

        equipList.add(new Equipment("Keyboard", 1 , 1));
        equipList.add(new Equipment("Keyboard2", 4 , 1));
        equipList.add(new Equipment("Keyboard3", 10 , 1));
        equipList.add(new Equipment("Monitor", 1 , 1));
        equipList.add(new Equipment("Monitor2", 4 , 1));
        equipList.add(new Equipment("Monitor3", 10 , 1));

        consumList.add(new Consumable("Hot-Six", 2, 1 ));
        consumList.add(new Consumable("RedBull", 4, 1 ));
        consumList.add(new Consumable("Monster", 8, 1 ));
        consumList.add(new Consumable("Nightwork", 2, 2 ));
        consumList.add(new Consumable("Overwork", 4 , 4 ));
        consumList.add(new Consumable("Zombie", 8 , 8 ));

        a[0]=(RelativeLayout)thisActivity.findViewById(R.id.a1);
        a[1]=(RelativeLayout)thisActivity.findViewById(R.id.a2);
        a[2]=(RelativeLayout)thisActivity.findViewById(R.id.a3);
        a[3]=(RelativeLayout)thisActivity.findViewById(R.id.a4);
        a[4]=(RelativeLayout)thisActivity.findViewById(R.id.a5);
        a[5]=(RelativeLayout)thisActivity.findViewById(R.id.a6);

        c[0]=(RelativeLayout)thisActivity.findViewById(R.id.c1);
        c[1]=(RelativeLayout)thisActivity.findViewById(R.id.c2);
        c[2]=(RelativeLayout)thisActivity.findViewById(R.id.c3);
        c[3]=(RelativeLayout)thisActivity.findViewById(R.id.c4);
        c[4]=(RelativeLayout)thisActivity.findViewById(R.id.c5);
        c[5]=(RelativeLayout)thisActivity.findViewById(R.id.c6);
        e[0]=(RelativeLayout)thisActivity.findViewById(R.id.e1);
        e[1]=(RelativeLayout)thisActivity.findViewById(R.id.e2);
        e[2]=(RelativeLayout)thisActivity.findViewById(R.id.e3);
        e[3]=(RelativeLayout)thisActivity.findViewById(R.id.e4);
        e[4]=(RelativeLayout)thisActivity.findViewById(R.id.e5);
        e[5]=(RelativeLayout)thisActivity.findViewById(R.id.e6);

        a[0].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Assistant t = assistList.get(0);
                if(developer.getCodeLine()>=t.getPrice()) {
                    developer.setCodeLine(developer.getCodeLine()-t.getPrice());
                    t.setCount(t.getCount()+1);
                    Log.d("clistenr",0+"");
                }
            }
        });
        a[1].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Assistant t = assistList.get(1);
                if(developer.getCodeLine()>=t.getPrice()) {
                    developer.setCodeLine(developer.getCodeLine()-t.getPrice());
                    t.setCount(t.getCount()+1);
                    Log.d("clistenr",1+"");
                }
            }
        });
        a[2].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Assistant t = assistList.get(2);
                if(developer.getCodeLine()>=t.getPrice()) {
                    developer.setCodeLine(developer.getCodeLine()-t.getPrice());
                    t.setCount(t.getCount()+1);
                    Log.d("clistenr",2+"");
                }
            }
        });
        a[3].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Assistant t = assistList.get(3);
                if(developer.getCodeLine()>=t.getPrice()) {
                    developer.setCodeLine(developer.getCodeLine()-t.getPrice());
                    t.setCount(t.getCount()+1);
                    Log.d("clistenr",3+"");
                }
            }
        });
        a[4].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Assistant t = assistList.get(4);
                if(developer.getCodeLine()>=t.getPrice()) {
                    developer.setCodeLine(developer.getCodeLine()-t.getPrice());
                    t.setCount(t.getCount()+1);
                    Log.d("clistenr",4+"");
                }
            }
        });
        a[5].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Assistant t = assistList.get(5);
                if(developer.getCodeLine()>=t.getPrice()) {
                    developer.setCodeLine(developer.getCodeLine()-t.getPrice());
                    t.setCount(t.getCount()+1);
                    Log.d("clistenr",5+"");
                }
            }
        });
        e[0].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Equipment t = equipList.get(0);
                if(developer.getCodeLine()>=t.getCount()) {
                    developer.setCodeLine(developer.getCodeLine()-t.getPrice());
                    t.setCount(t.getCount()+1);
                }
            }
        });
        e[1].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Equipment t = equipList.get(1);
                if(developer.getCodeLine()>=t.getCount()) {
                    developer.setCodeLine(developer.getCodeLine()-t.getPrice());
                    t.setCount(t.getCount()+1);
                }
            }
        });
        e[2].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Equipment t = equipList.get(2);
                if(developer.getCodeLine()>=t.getCount()) {
                    developer.setCodeLine(developer.getCodeLine()-t.getPrice());
                    t.setCount(t.getCount()+1);
                }
            }
        });
        e[3].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Equipment t = equipList.get(3);
                if(developer.getCodeLine()>=t.getCount()) {
                    developer.setCodeLine(developer.getCodeLine()-t.getPrice());
                    t.setCount(t.getCount()+1);
                }
            }
        });
        e[4].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Equipment t = equipList.get(4);
                if(developer.getCodeLine()>=t.getCount()) {
                    developer.setCodeLine(developer.getCodeLine()-t.getPrice());
                    t.setCount(t.getCount()+1);
                }
            }
        });
        e[5].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Equipment t = equipList.get(5);
                if(developer.getCodeLine()>=t.getCount()) {
                    developer.setCodeLine(developer.getCodeLine()-t.getPrice());
                    t.setCount(t.getCount()+1);
                }
            }
        });

        c[0].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Consumable t = consumList.get(0);
                if(developer.getCodeLine()>=t.getCount()) {
                    developer.setCodeLine(developer.getCodeLine()-t.getPrice());
                    t.setCount(t.getCount()+1);
                }
            }
        });
        c[1].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Consumable t = consumList.get(1);
                if(developer.getCodeLine()>=t.getCount()) {
                    developer.setCodeLine(developer.getCodeLine()-t.getPrice());
                    t.setCount(t.getCount()+1);
                }
            }
        });

        c[2].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Consumable t = consumList.get(2);
                if(developer.getCodeLine()>=t.getCount()) {
                    developer.setCodeLine(developer.getCodeLine()-t.getPrice());
                    t.setCount(t.getCount()+1);
                }
            }
        });

        c[3].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Consumable t = consumList.get(3);
                if(developer.getCodeLine()>=t.getCount()) {
                    developer.setCodeLine(developer.getCodeLine()-t.getPrice());
                    t.setCount(t.getCount()+1);
                }
            }
        });

        c[4].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Consumable t = consumList.get(4);
                if(developer.getCodeLine()>=t.getCount()) {
                    developer.setCodeLine(developer.getCodeLine()-t.getPrice());
                    t.setCount(t.getCount()+1);
                }
            }
        });

        c[5].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Consumable t = consumList.get(5);
                if(developer.getCodeLine()>=t.getCount()) {
                    developer.setCodeLine(developer.getCodeLine()-t.getPrice());
                    t.setCount(t.getCount()+1);
                }
            }
        });

    }
    public void showFloatingText(int floatType, int x, int y, String text) {
        PixelTextView floatTextView = new PixelTextView(thisActivity, null);
        floatTextView.setText(text);
        floatTextView.setX(x);
        floatTextView.setY(y);
        devScreen.addView(floatTextView);
        floatTextView.setVisibility(View.VISIBLE);
        Animation floatUpAnim;
        floatUpAnim = AnimationUtils.loadAnimation(thisActivity, R.anim.floatup);
        floatTextView.startAnimation(floatUpAnim);
        floatUpAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
            }
            @Override
            public void onAnimationStart(Animation animation) {

            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        floatTextView.startAnimation(floatUpAnim);
    }
    public void updateDeveloperState() {
        double lps = 0;
        for(int i=0; i<assistList.size();i++) {
          //  Assistant temp = assistList.get(i);
           // lps+=temp.getCount()*temp.getLinePerSecond();
        }
        developer.setLinePerOneTenthSeconds(lps);
        double lmp = 1;
        for(int i=0; i<equipList.size(); i++) {
           // lmp+=equipList.get(i).getLineMultiplier();
        }
        developer.setClickMultiplier(lmp);
        for(int i=0; i<consumList.size(); i++) {

        }
    }

}