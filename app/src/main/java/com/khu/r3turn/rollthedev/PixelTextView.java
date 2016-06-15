package com.khu.r3turn.rollthedev;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by PNY on 2016-06-15.
 */
public class PixelTextView extends TextView{

    public PixelTextView(Context context) {
        super(context);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/victor-pixel.ttf"));
    }

    public PixelTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/victor-pixel.ttf"));
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.PixelTextView, 0, 0);
        a.recycle();
    }
}
