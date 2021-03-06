package com.weexcel.guestexpress.util.applyfont;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Pair;

import com.weexcel.guestexpress.R;


public class EditText extends android.widget.EditText{
    private String quickfont;

    public EditText(Context context) {
        super(context);
        init(null, 0);
    }

    public EditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public EditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.TextView, defStyle, 0);
        try {
            quickfont = a.getString(R.styleable.TextView_quickfont);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            a.recycle();
        }
        if(quickfont!=null&!isInEditMode())
        {
            Pair<Typeface,Boolean> pair= QuickFontManager.getTypeface(getContext(), quickfont);
            Typeface typeface=pair.first;
            boolean fromCache=pair.second;

            if(typeface!=null)
            {
                setTypeface(typeface);
            }

                if(!fromCache)setTextColor(Color.RED);
        }

        // Note: This flag is required for proper typeface rendering
        setPaintFlags(getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);

    }
}