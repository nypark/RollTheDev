package com.khu.r3turn.rollthedev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ViewSwitcher;
import android.widget.RelativeLayout;



public class MainActivity extends AppCompatActivity {
    Button menuEqu, menuDev, menuCon;
    GameHandler gameHandler = null;
    RelativeLayout devScreen = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*menuEqu = (Button) findViewById(R.id.button);
        menuDev = (Button) findViewById(R.id.button2);
        menuCon = (Button) findViewById(R.id.button3);

        menuEqu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
            }
        });
        menuDev.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
            }
        });
        menuCon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
            }
        });
*/
        //initialize
        init();

        //add onClickListener to increase code line number
        /*devScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameHandler.addCodeLine();
            }
        });*/
    }

    //initialize properties
    public void init() {
        //devScreen = (RelativeLayout) findViewById(R.id.DevScreen);
        //gameHandler = new GameHandler(devScreen);
    }

}
