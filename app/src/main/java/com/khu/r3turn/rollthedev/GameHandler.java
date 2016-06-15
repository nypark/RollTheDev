package com.khu.r3turn.rollthedev;

import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by PNY on 2016-06-15.
 */
public class GameHandler {
    public int codeLine = 0;

    TextView codeLineTextView = null;

    public GameHandler(ViewGroup vg) {
        codeLineTextView = (TextView) vg.findViewById(R.id.codeLineText);
    }

    public void addCodeLine() {
        codeLine++;
        codeLineTextView.setText("" + codeLine);
    }
}
