package com.hyunkwak.customviewtest;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button bt;
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.et);
        bt = findViewById(R.id.bt_two);

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