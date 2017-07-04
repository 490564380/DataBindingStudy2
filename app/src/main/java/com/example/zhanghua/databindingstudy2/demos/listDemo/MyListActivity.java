package com.example.zhanghua.databindingstudy2.demos.listDemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.zhanghua.databindingstudy2.R;
import com.example.zhanghua.databindingstudy2.databinding.ActivityListBinding;
import com.example.zhanghua.databindingstudy2.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class MyListActivity extends AppCompatActivity {

    private EmployeeAdapter employeeAdapter;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        binding.setPresenter(new Presenter());
        employeeAdapter = new EmployeeAdapter(this);
        binding.recyclerView.setAdapter(employeeAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        employeeAdapter.setOnItemClickListener(new EmployeeAdapter.OnItemClickListener() {
            @Override
            public void onEmployeeClick(Employee employee) {
                if (toast != null) toast.cancel();
                toast = Toast.makeText(MyListActivity.this, employee.getLastName() + " clicked", Toast.LENGTH_SHORT);
            }
        });

        List<Employee> demoList = new ArrayList<>();
        demoList.add(new Employee("Zhai", "Mark", false));
        demoList.add(new Employee("Zhai2", "Mark2", false));
        demoList.add(new Employee("Zhai3", "Mark3", true));
        demoList.add(new Employee("Zhai4", "Mark4", false));
        employeeAdapter.addAll(demoList);
    }

    public class Presenter {
        public void onClickAddItem(View view) {
            employeeAdapter.add(new Employee("Zhang", "Huakai", false));
        }

        public void onClickRemoveItem(View view) {
            employeeAdapter.remove();
        }

    }
}
