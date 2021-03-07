package com.hyunkwak.customviewtest;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.AppCompatEditText;

public class NotSpindleToggleButton extends RelativeLayout {
    private Button bt;
    private AppCompatEditText et;

    public NotSpindleToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.not_spindle_button_toggle, this, true);
        et = findViewById(R.id.input_edit_text);
        bt = findViewById(R.id.input_button);

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty())
                    setOff(bt);
                else
                    setOn(bt);
            }
        });

    }

    private void setOff(Button bt) {
        bt.setClickable(false);
        bt.setBackgroundColor(getResources().getColor(R.color.grey));
    }

    private void setOn(Button bt) {
        bt.setClickable(true);
        bt.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
    }


}
