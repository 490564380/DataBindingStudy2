package com.example.zhanghua.databindingstudy2.demos.expression;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zhanghua.databindingstudy2.R;
import com.example.zhanghua.databindingstudy2.databinding.ActivityExpressionBinding;
import com.example.zhanghua.databindingstudy2.model.Employee;

import java.util.Random;

public class ExpressionActivity extends AppCompatActivity {

    Random mRandom = new Random(System.currentTimeMillis());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Employee employee = new Employee("mark", "zhai");
        employee.setIsFired(mRandom.nextBoolean());
        employee.setAvatar("https://avatars2.githubusercontent.com/u/1106500?v=3&s=460");
        ActivityExpressionBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_expression);
        binding.setEmployee(employee);
    }

    //setDefaultComponent or make all BindingAdapter methods static
    @BindingAdapter({"imageUrl", "placeholder"})
    public static void loadImage(ImageView imageView, String imageUrl, Drawable placeholder) {
        Glide.with(imageView.getContext()).load(imageUrl).placeholder(placeholder).into(imageView);
    }
}
