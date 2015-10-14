package com.hw.corcow.samplepopupwindow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onPopupWindow (View view) {
        MyPopupWindow popup = new MyPopupWindow(this);
        popup.setOutsideTouchable(true);
        popup.showAsDropDown(view);
    }
}
