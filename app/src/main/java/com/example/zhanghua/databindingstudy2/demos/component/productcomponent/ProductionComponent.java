package com.example.zhanghua.databindingstudy2.demos.component.productcomponent;

/**
 * @author markzhai on 16/7/22
 * @version 1.3.0
 */
public class ProductionComponent implements android.databinding.DataBindingComponent {

    private MyBindingAdapter mAdapter = new ProductionBindingAdapter();

    @Override
    public MyBindingAdapter getMyBindingAdapter() {
        return mAdapter;
    }
}
