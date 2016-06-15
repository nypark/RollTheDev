package com.khu.r3turn.rollthedev;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

/**
 * Created by yb on 2016-06-15.
 */
public class MenuHandler {
    Activity ctx;
    View mainPanelLayout = null;
    View scrollPanelLayout1, scrollPanelLayout2, scrollPanelLayout3;
    Button menuEquButton, menuAssButton, menuConButton;
    ImageButton menuBackToMainButton,menuBackToMainButton2,menuBackToMainButton3;

    MenuHandler (Activity ctx) {
        this.ctx = ctx;
        mainPanelLayout = ctx.findViewById(R.id.mainPanel);
        scrollPanelLayout1 = (RelativeLayout)ctx.findViewById(R.id.scrollPanelAssist);
        scrollPanelLayout2 = (RelativeLayout)ctx.findViewById(R.id.scrollPanelEquip);
        scrollPanelLayout3 = (RelativeLayout)ctx.findViewById(R.id.scrollPanelConsum);
        //panel layout
        menuAssButton = (Button) ctx.findViewById(R.id.button);
        menuEquButton = (Button) ctx.findViewById(R.id.button2);
        menuConButton = (Button) ctx.findViewById(R.id.button3);
        menuBackToMainButton = (ImageButton) ctx.findViewById(R.id.backToMainButton);
        menuBackToMainButton2 = (ImageButton) ctx.findViewById(R.id.backToMainButton2);
        menuBackToMainButton3 = (ImageButton) ctx.findViewById(R.id.backToMainButton3);
        menuAssButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View arg0) {
                mainPanelLayout.setVisibility(View.GONE);
                scrollPanelLayout1.setVisibility(View.VISIBLE);
            }
        });
        menuEquButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View arg0) {
                mainPanelLayout.setVisibility(View.GONE);
                scrollPanelLayout2.setVisibility(View.VISIBLE);
            }
        });
        menuConButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View arg0) {
                mainPanelLayout.setVisibility(View.GONE);
                scrollPanelLayout3.setVisibility(View.VISIBLE);
            }
        });
        menuBackToMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                scrollPanelLayout1.setVisibility(View.GONE);
                mainPanelLayout.setVisibility(View.VISIBLE);
            }
        });
        menuBackToMainButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View  arg0) {
             scrollPanelLayout2.setVisibility(View.GONE);
                mainPanelLayout.setVisibility(View.VISIBLE);
            }
        });
        menuBackToMainButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                scrollPanelLayout3.setVisibility(View.GONE);
                mainPanelLayout.setVisibility(View.VISIBLE);
            }
        });

    }

}
