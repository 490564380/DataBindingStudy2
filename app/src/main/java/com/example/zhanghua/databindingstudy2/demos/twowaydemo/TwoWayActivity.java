package com.example.zhanghua.databindingstudy2.demos.twowaydemo;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.zhanghua.databindingstudy2.R;
import com.example.zhanghua.databindingstudy2.databinding.ActivityTwoWayBinding;

public class TwoWayActivity extends AppCompatActivity {

    private ActivityTwoWayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_two_way);
        FormModel formModel = new FormModel("ZhangHuakai", "123456");
        formModel.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            private Toast toast;

            @Override
            public void onPropertyChanged(Observable observable, int i) {
                if (toast != null) toast.cancel();
                toast = Toast.makeText(TwoWayActivity.this, String.valueOf(i), Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        binding.setFormmodl(formModel);
    }
}
