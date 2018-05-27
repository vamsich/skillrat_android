package com.skillrat.myapp.utils;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class LatoRegularTextView extends AppCompatTextView {

    public LatoRegularTextView(Context context) {
        super(context);
        init();
    }

    public LatoRegularTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LatoRegularTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        if (!isInEditMode()) {
            Typeface typeface = Typeface.createFromAsset(getContext()
                    .getAssets(), "fonts/Lato-Regular.ttf");
            setTypeface(typeface);
            setPaintFlags(getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);

        }
    }
}
