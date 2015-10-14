package com.hw.corcow.samplepopupwindow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

/**
 * Created by Tacademy on 2015-10-14.
 */
public class MyPopupWindow extends PopupWindow {
    Context mContext;
    public MyPopupWindow(Context context) {             // popupWindow는 화면을 구성하므로 Context를 가진 생성자가 반드시 필요
        super(context);
        mContext = context;

        View view = LayoutInflater.from(context).inflate(R.layout.popup_custom, null);
        Button btn = (Button)view.findViewById(R.id.btn_b1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Popup B1 Click", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
        setContentView(view);

        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);


    }
}
