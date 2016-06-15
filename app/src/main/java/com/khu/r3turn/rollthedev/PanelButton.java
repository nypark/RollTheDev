package com.khu.r3turn.rollthedev;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by yb on 2016-06-15.
 */
public class PanelButton extends RelativeLayout {
    public PanelButton(Context context) {
        super(context);
    }
    public PanelButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.PanelButton, 0, 0);
        try {

        } finally {
            a.recycle();
        }
    }

}
