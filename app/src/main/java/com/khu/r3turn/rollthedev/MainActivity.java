package com.khu.r3turn.rollthedev;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {
    Button menuEqu, menuDev, menuCon;
    GameHandler gameHandler = null;

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
    }

    //initialize properties
    public void init() {
        gameHandler = new GameHandler(this);
    }

}
