package com.example.zhanghua.databindingstudy2.demos.listDemo;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView.ViewHolder;

/**
 * Created by ZhangHua on 04/07/2017.
 */

public class DataBindingViewHolder<T extends ViewDataBinding> extends ViewHolder {

    private T binding;

    public DataBindingViewHolder(T binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public T getBinding() {
        return binding;
    }
}
