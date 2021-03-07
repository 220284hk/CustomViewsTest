package com.hyunkwak.customviewtest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.AppCompatEditText;

public class NotSpindleToggleButton extends RelativeLayout {
    public Button bt;
    public AppCompatEditText et;

    public NotSpindleToggleButton(Context context) {
        super(context);
    }

    public NotSpindleToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.not_spindle_button_toggle, this, true);
        et = findViewById(R.id.input_edit_text);
        bt = findViewById(R.id.input_button);


    }

}
