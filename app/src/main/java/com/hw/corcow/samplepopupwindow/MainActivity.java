package com.hw.corcow.samplepopupwindow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.support.v7.widget.ListPopupWindow;

public class MainActivity extends AppCompatActivity {

    EditText inputView;
    android.support.v7.widget.ListPopupWindow listPopup;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputView = (EditText) findViewById(R.id.editText);
        listPopup = new ListPopupWindow(this);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        listPopup.setAdapter(mAdapter);
        listPopup.setAnchorView(inputView);

        inputView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = s.toString();
                if (TextUtils.isEmpty(text)) {
                    listPopup.dismiss();
                } else {
                    mAdapter.clear();
                    mAdapter.add(text + "--- 1");
                    mAdapter.add(text + "--- 2");
                    mAdapter.add(text + "--- 3");
                    mAdapter.add(text + "--- 4");
                    mAdapter.add(text + "--- 5");
                    listPopup.show();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        listPopup.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = mAdapter.getItem(position).toString();
                inputView.setText(item);
                listPopup.dismiss();
            }
        });
    }

    public void onPopupWindow (View view) {
        MyPopupWindow popup = new MyPopupWindow(this);
        popup.setOutsideTouchable(true);
        popup.showAsDropDown(view);
    }
}
