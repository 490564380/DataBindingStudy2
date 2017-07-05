package com.example.zhanghua.databindingstudy2;

import android.app.Application;
import android.databinding.DataBindingUtil;

import com.example.zhanghua.databindingstudy2.demos.component.productcomponent.ProductionComponent;

/**
 * Created by ZhangHua on 05/07/2017.
 */

public class DemoApplication extends Application {

    public static boolean isTest = false;

    @Override
    public void onCreate() {
        super.onCreate();
        DataBindingUtil.setDefaultComponent(new ProductionComponent());
    }
}
