package com.example.zhanghua.databindingstudy2.demos.component.testcomponent;

import android.databinding.DataBindingComponent;

import com.example.zhanghua.databindingstudy2.demos.component.productcomponent.MyBindingAdapter;

/**
 * @author markzhai on 16/7/21
 */
public class TestComponent implements DataBindingComponent {

    private MyBindingAdapter mAdapter = new TestBindingAdapter();

    @Override
    public MyBindingAdapter getMyBindingAdapter() {
        return mAdapter;
    }
}