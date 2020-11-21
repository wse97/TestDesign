package com.mrwaseem.testdesign.ui;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class FontManager {

    private static final String ROOT = "fonts/",
            FONTAWESOME = ROOT + "DINNextLTArabic.ttf";


    public static Typeface getTypeface(Context context) {
        return Typeface.createFromAsset(context.getAssets(), FONTAWESOME);

    }

    public static Typeface getTypefaceTextInputRegular(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/DINNextLTArabic.ttf");
    }

    public static Typeface getTypefaceTextInputBold(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/DINNextLTArabic.ttf");
    }


    public static void strikeThroughText(TextView price) {
        price.setPaintFlags(price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    public static void applyFont(final Context context, final View v) {
        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/DINNextLTArabic.ttf");
        try {
            if (v instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) v;
                for (int i = 0; i < vg.getChildCount(); i++) {
                    View child = vg.getChildAt(i);
                    applyFont(context, child);
                }
            } else if (v instanceof TextView) {
                ((TextView) v).setTypeface(font);
            } else if (v instanceof EditText) {
                ((EditText) v).setTypeface(font);
            } else if (v instanceof Button) {
                ((Button) v).setTypeface(font);
            } else if (v instanceof RadioButton) {
                ((RadioButton) v).setTypeface(font);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // ignore
        }
    }


}