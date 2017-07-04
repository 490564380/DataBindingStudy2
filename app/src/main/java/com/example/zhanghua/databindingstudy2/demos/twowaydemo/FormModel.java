package com.example.zhanghua.databindingstudy2.demos.twowaydemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.zhanghua.databindingstudy2.BR;

/**
 * @author markzhai on 16/7/14
 * @version 1.3.0
 */
public class FormModel extends BaseObservable {

    private String mName;
    private String mPassword;

    public FormModel(String name, String password) {
        mName = name;
        mPassword = password;
    }

    @Bindable
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
        notifyPropertyChanged(BR.password);
    }
}
