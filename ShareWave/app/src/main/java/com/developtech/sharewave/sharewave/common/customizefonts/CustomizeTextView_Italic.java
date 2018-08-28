package com.developtech.sharewave.sharewave.common.customizefonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Attinder on 29/04/16.
 */
public class CustomizeTextView_Italic extends TextView {



    public CustomizeTextView_Italic(Context context) {
        super(context);
        setFont();
    }
    public CustomizeTextView_Italic(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont();
    }
    public CustomizeTextView_Italic(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFont();
    }

    private void setFont() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/open-sans.italic.ttf");
        setTypeface(font, Typeface.BOLD);
    }
}
