package com.khu.r3turn.rollthedev;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    ViewGroup vg;
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
        vg = (ViewGroup)devScreen;
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
                        updateDeveloperState();
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
/*
        assistList.add(new Assistant("Newbie",5, 100));
        assistList.add(new Assistant("Intermediate",15, 1000));
        assistList.add(new Assistant("Experienced",50, 5000));
        assistList.add(new Assistant("Advanced",100, 10000));
        assistList.add(new Assistant("Senior",200, 20000));
        assistList.add(new Assistant("Expert",500, 50000));

        equipList.add(new Equipment("Keyboard", 5, 1 , 1000));
        equipList.add(new Equipment("Keyboard2",10, 2  , 50000));
        equipList.add(new Equipment("Keyboard3",20, 5 , 25000));
        equipList.add(new Equipment("Monitor", 40,10 , 100000));
        equipList.add(new Equipment("Monitor2",80, 20 , 1000000));
        equipList.add(new Equipment("Monitor3", 160,40 , 6543210));

        consumList.add(new Consumable("Hot-Six", 1, 1 ,100000));
        consumList.add(new Consumable("RedBull", 2, 2 , 200000));
        consumList.add(new Consumable("Monster", 4, 3 , 500000));
        consumList.add(new Consumable("Nightwork", 8, 4 ,1000000));
        consumList.add(new Consumable("Overwork", 16 , 5 ,2000000 ));
        consumList.add(new Consumable("Zombie", 32 , 10 , 5000000 ));*/

        assistList.add(new Assistant("Newbie",0.1, 10));
        assistList.add(new Assistant("Intermediate",2, 100));
        assistList.add(new Assistant("Experienced",25, 1000));
        assistList.add(new Assistant("Advanced",300, 10000));
        assistList.add(new Assistant("Senior",3333, 100000));
        assistList.add(new Assistant("Expert",44444, 1000000));

        equipList.add(new Equipment("Keyboard", 2, 5000));
        equipList.add(new Equipment("Keyboard2",3, 10000));
        equipList.add(new Equipment("Keyboard3",5, 30000));

        consumList.add(new Consumable("Hot-Six", 2, 10000));
        consumList.add(new Consumable("RedBull", 3, 30000 ));
        consumList.add(new Consumable("Monster", 5, 50000));
        consumList.add(new Consumable("Nightwork", 10, 100000));
        consumList.add(new Consumable("Overwork", 20 , 200000 ));
        consumList.add(new Consumable("Zombie", 100 , 1000000 ));

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
                if(developer.getCodeLine()>=t.getPrice()) {
                    developer.setCodeLine(developer.getCodeLine()-t.getPrice());
                    t.setCount(t.getCount()+1);
                }
            }
        });
        e[1].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Equipment t = equipList.get(1);
                if(developer.getCodeLine()>=t.getPrice()) {
                    developer.setCodeLine(developer.getCodeLine()-t.getPrice());
                    t.setCount(t.getCount()+1);
                }
            }
        });
        e[2].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Equipment t = equipList.get(2);
                if(developer.getCodeLine()>=t.getPrice()) {
                    developer.setCodeLine(developer.getCodeLine()-t.getPrice());
                    t.setCount(t.getCount()+1);
                }
            }
        });
        c[0].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Consumable t = consumList.get(0);
                if(developer.getFever()==Boolean.FALSE) {
                    if (developer.getCodeLine() >= t.getPrice()) {
                        developer.setCodeLine(developer.getCodeLine() - t.getPrice());
                        t.setCount(t.getCount() + 1);
                        developer.setFever(Boolean.TRUE);
                        developer.setFeverMulti(2);
                        Toast.makeText(thisActivity, "FEVER MODE START", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            developer.setFever(Boolean.FALSE);
                            Toast.makeText(thisActivity, "FEVER MODE END", Toast.LENGTH_SHORT).show();
                        }
                    },10000);
                }
            }
        });
        c[1].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Consumable t = consumList.get(1);
                if(developer.getFever()==Boolean.FALSE) {
                    if (developer.getCodeLine() >= t.getPrice()) {
                        developer.setCodeLine(developer.getCodeLine() - t.getPrice());
                        t.setCount(t.getCount() + 1);
                        developer.setFever(Boolean.TRUE);
                        developer.setFeverMulti(3);
                    }
                }else {
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            developer.setFever(Boolean.FALSE);
                        }
                    },10000);
                }
            }
        });

        c[2].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Consumable t = consumList.get(2);
                if(developer.getFever()==Boolean.FALSE) {
                    if (developer.getCodeLine() >= t.getPrice()) {
                        developer.setCodeLine(developer.getCodeLine() - t.getPrice());
                        t.setCount(t.getCount() + 1);
                        developer.setFever(Boolean.TRUE);
                        developer.setFeverMulti(5);
                    }
                } else {
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            developer.setFever(Boolean.FALSE);

                        }
                    },10000);
                }
            }
        });

        c[3].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Consumable t = consumList.get(3);
                if(developer.getCodeLine()>=t.getPrice()) {
                    developer.setCodeLine(developer.getCodeLine()-t.getPrice());
                    t.setCount(t.getCount()+1);
                }
            }
        });

        c[4].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Consumable t = consumList.get(4);
                if(developer.getCodeLine()>=t.getPrice()) {
                    developer.setCodeLine(developer.getCodeLine()-t.getPrice());
                    t.setCount(t.getCount()+1);
                }
            }
        });

        c[5].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Consumable t = consumList.get(5);
                if(developer.getCodeLine()>=t.getPrice()) {
                    developer.setCodeLine(developer.getCodeLine()-t.getPrice());
                    t.setCount(t.getCount()+1);
                }
            }
        });

    }
    public void showFloatingText(int floatType, int x, int y, String text) {
        System.gc();
        PixelTextView floatTextView = new PixelTextView(vg.getContext(), null);
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
        for(int i=0; i<6;i++) {
            Assistant temp = assistList.get(i);
            lps+=temp.getCount()*temp.getLinePerSecond();
        }
        double lpt = 1;
        for (int i =0; i<3; i++) {
            Equipment temp = equipList.get(i);
            lpt += temp.getLineMultiplier()*temp.getCount();
        }
        developer.setLinePerOneTenthSeconds(lps);
        developer.setClickMultiplier(lpt);
    }

}