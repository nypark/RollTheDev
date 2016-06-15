package com.khu.r3turn.rollthedev;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.ViewGroup;
import android.view.View.OnClickListener;

/**
 * Created by yb on 2016-06-15.
 */
public class MenuHandler {
    Activity ctx;
    View mainPanelLayout = null;
    View scrollPanelLayout = null;
    Button menuEquButton, menuDevButton, menuConButton;
    ImageButton menuBackToMainButton;
    View.OnClickListener panelListener = new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            mainPanelLayout.setVisibility(View.GONE);
            scrollPanelLayout.setVisibility(View.VISIBLE);
        }
    };
    MenuHandler (Activity ctx) {
        this.ctx = ctx;
        mainPanelLayout = ctx.findViewById(R.id.mainPanel);
        scrollPanelLayout = ctx.findViewById(R.id.scrollPanel);
        //panel layout
        menuEquButton = (Button) ctx.findViewById(R.id.button);
        menuDevButton = (Button) ctx.findViewById(R.id.button2);
        menuConButton = (Button) ctx.findViewById(R.id.button3);

        menuBackToMainButton = (ImageButton) ctx.findViewById(R.id.backToMainButton);

        menuEquButton.setOnClickListener(panelListener);
        menuDevButton.setOnClickListener(panelListener);
        menuConButton.setOnClickListener(panelListener);
        menuBackToMainButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollPanelLayout.setVisibility(View.GONE);
                mainPanelLayout.setVisibility(View.VISIBLE);
            }
        });
    }

}
