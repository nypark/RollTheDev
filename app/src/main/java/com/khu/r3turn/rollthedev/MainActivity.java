package com.khu.r3turn.rollthedev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;



public class MainActivity extends AppCompatActivity {
    GameHandler gameHandler = null;
    RelativeLayout devScreen = null;
    MenuHandler menuHandler = null;
        @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize
        init();

        //add onClickListener to increase code line number
        devScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameHandler.addCodeLine();
            }
        });
    }

    //initialize properties
    public void init() {
        devScreen = (RelativeLayout) findViewById(R.id.DevScreen);
        gameHandler = new GameHandler(devScreen);
        
        menuHandler = new MenuHandler(this);
    }

}
