package com.example.zhanghua.databindingstudy2.demos.simpleDemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.zhanghua.databindingstudy2.R;
import com.example.zhanghua.databindingstudy2.databinding.ActivitySimpleBinding;
import com.example.zhanghua.databindingstudy2.model.Employee;

public class SimpleActivity extends AppCompatActivity {

    Employee employee = new Employee("Albet", "Einstein");
    private ActivitySimpleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        employee.user.put("boss","ZhangHua");
        employee.user.put("employee","ZhangHuakai");
        employee.user.put("assistance","ZhangBozhi");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_simple);
        binding.setEmployee(employee);
        binding.setPresenter(new Presenter());
    }

    public class Presenter {

        public void showViewStub(View view) {
            if (!binding.viewStub.isInflated())
                binding.viewStub.getViewStub().inflate();
        }

        public void onFirstNameChanged(CharSequence s, int start, int before, int count) {
            employee.setFirstName(s.toString());
            employee.setIsFired(!employee.isFired.get());
        }

        public void onLastNameChanged(CharSequence s, int start, int before, int count) {
            employee.setLastName(s.toString());
        }

        public void onFistNameClick(View view) {
            Toast.makeText(SimpleActivity.this, "fist name clicked", Toast.LENGTH_SHORT).show();
        }

        public void onClickListenerBinding(Employee employee) {
            Toast.makeText(SimpleActivity.this, employee.getLastName(),
                    Toast.LENGTH_SHORT).show();
        }

    }
}
