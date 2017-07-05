package com.example.zhanghua.databindingstudy2.demos.component.testcomponent;

import android.widget.TextView;

import com.example.zhanghua.databindingstudy2.R;
import com.example.zhanghua.databindingstudy2.demos.component.productcomponent.MyBindingAdapter;


public class TestBindingAdapter extends MyBindingAdapter {

    @Override
    public void setText(TextView view, String value) {
        view.setText(value + " test");
    }

    @Override
    public void setTextColor(TextView view, int value) {
        if (value == view.getContext()
                .getResources()
                .getColor(R.color.textColorDay)) {
            view.setTextColor(view.getContext()
                    .getResources()
                    .getColor(R.color.textColorNight));
        }
    }
}