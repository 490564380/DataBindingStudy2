package com.example.zhanghua.databindingstudy2;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.zhanghua.databindingstudy2.databinding.ActivityMainBinding;
import com.example.zhanghua.databindingstudy2.demos.animation.AnimationActivity;
import com.example.zhanghua.databindingstudy2.demos.expression.ExpressionActivity;
import com.example.zhanghua.databindingstudy2.demos.lambdademo.LambdaActivity;
import com.example.zhanghua.databindingstudy2.demos.listDemo.MyListActivity;
import com.example.zhanghua.databindingstudy2.demos.simpleDemo.SimpleActivity;
import com.example.zhanghua.databindingstudy2.demos.twowaydemo.TwoWayActivity;

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

        public void showListDemo(View view) {
            startActivity(new Intent(MainActivity.this, MyListActivity.class));
        }

        public void showTwoWayDemo(View view) {
            startActivity(new Intent(MainActivity.this, TwoWayActivity.class));
        }

        public void showExpressionDemo(View view) {
            startActivity(new Intent(MainActivity.this, ExpressionActivity.class));
        }

        public void showLambdaDemo(View view) {
            startActivity(new Intent(MainActivity.this, LambdaActivity.class));
        }

        public void showAnimationDemo(View view) {
            startActivity(new Intent(MainActivity.this, AnimationActivity.class));
        }
    }
}
