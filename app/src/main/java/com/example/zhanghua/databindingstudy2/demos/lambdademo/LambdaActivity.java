package com.example.zhanghua.databindingstudy2.demos.lambdademo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.zhanghua.databindingstudy2.R;
import com.example.zhanghua.databindingstudy2.databinding.ActivityLambdaBinding;
import com.example.zhanghua.databindingstudy2.model.Employee;

public class LambdaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLambdaBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_lambda);
        binding.setEmployee(new Employee("mark", "zhai"));
        binding.setPresenter(new LambdaActivityPressenter());
    }

    public class LambdaActivityPressenter {

        public void onEmployeeClick(Employee employee) {
            Toast.makeText(LambdaActivity.this, "onEmployeeClick",
                    Toast.LENGTH_SHORT).show();
        }

        //because onLongClick need reture boolean
        public boolean onEmployeeLongClick(Employee employee, Context context) {
            Toast.makeText(context, "onEmployeeLongClick",
                    Toast.LENGTH_SHORT).show();
            return true;
        }

        public void onFocusChange(Employee employee, boolean focus) {
            Toast.makeText(LambdaActivity.this, "onFocusChange--isOnFocus " + focus,
                    Toast.LENGTH_SHORT).show();
        }
    }
}
