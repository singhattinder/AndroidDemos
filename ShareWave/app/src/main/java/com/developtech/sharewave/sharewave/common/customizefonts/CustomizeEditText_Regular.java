package com.developtech.sharewave.sharewave.common.customizefonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Attinder on 28/04/16.
 */
public class CustomizeEditText_Regular extends EditText {

    public CustomizeEditText_Regular(Context context) {
        super(context);
        setFont();
    }
    public CustomizeEditText_Regular(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont();
    }
    public CustomizeEditText_Regular(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFont();
    }

    private void setFont() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/open-sans.regular.ttf");
        setTypeface(font, Typeface.NORMAL);
    }
}

