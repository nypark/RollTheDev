package com.khu.r3turn.rollthedev;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    GameHandler gameHandler = null;
    MenuHandler menuHandler = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize
        init();
    }

    //initialize properties
    public void init() {
        gameHandler = new GameHandler(this);
        menuHandler = new MenuHandler(this);
    }

}
