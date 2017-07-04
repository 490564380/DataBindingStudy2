package com.example.zhanghua.databindingstudy2.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableBoolean;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by ZhangHua on 03/07/2017.
 */

public class Employee extends BaseObservable {
    private String lastName;
    private String firstName;
    public ObservableArrayMap<String, String> user = new ObservableArrayMap<>();
    private String avatar;
    public ObservableBoolean isFired = new ObservableBoolean();

    public Employee(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        isFired.set(false);
        user.put("boss","ZhangHua");
        user.put("employee","ZhangHuakai");
        user.put("assistance","ZhangBozhi");
    }

    public Employee(String lastName, String firstName, ObservableBoolean isFired) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.isFired = isFired;
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    @Bindable
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
        notifyPropertyChanged(BR.avatar);
    }

    public void setIsFired(boolean fired) {
        this.isFired.set(fired);
    }
}
