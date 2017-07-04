package com.example.zhanghua.databindingstudy2;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.zhanghua.databindingstudy2.databinding.ActivityMainBinding;
import com.example.zhanghua.databindingstudy2.demos.simpleDemo.SimpleActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setPresenter(new Presenter());
    }

    public class Presenter {

        public void showSimpleDemo(View view) {
            startActivity(new Intent(MainActivity.this, SimpleActivity.class));
        }


    }
}
