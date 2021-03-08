package com.hyunkwak.customviewtest;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.LinkedList;

public class TestActivity extends AppCompatActivity {
    Button bt;
    TextView tv;
    String[] countries = new String[]{"Canada", "France", "Korea"};
    LinkedList<String> mWordList = new LinkedList<>(Arrays.asList(countries));

    private RecyclerView mRecyclerView;
    private CountryListAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        bt = findViewById(R.id.bt);
        tv = findViewById(R.id.example_textview);


//        LinkedList<String> mWordList = new LinkedList<>(Arrays.asList(countries));
//        // Get a handle to the RecyclerView.
//        mRecyclerView = findViewById(R.id.recyclerview);
//        // Create an adapter and supply the data to be displayed.
//        mAdapter = new CountryListAdapter(this, mWordList);
//        // Connect the adapter with the RecyclerView.
//        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        bt.setOnClickListener(v -> {
            onButtonShowPopupWindowClick(v);
        });
//
    }

    public void onButtonShowPopupWindowClick(View view) {
        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);

        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new CountryListAdapter(this, mWordList);
        mRecyclerView.setAdapter(mAdapter);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);


        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener((v, event) -> {
            popupWindow.dismiss();
            return true;
        });
    }
}
