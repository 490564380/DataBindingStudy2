package com.example.zhanghua.databindingstudy2.demos.listDemo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhanghua.databindingstudy2.BR;
import com.example.zhanghua.databindingstudy2.R;
import com.example.zhanghua.databindingstudy2.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ZhangHua on 04/07/2017.
 */

public class EmployeeAdapter extends RecyclerView.Adapter<DataBindingViewHolder> {

    private static final int ITEM_VIEW_TYPE_ON = 1;
    private static final int ITEM_VIEW_TYPE_OFF = 2;
    private final LayoutInflater layoutInflater;
    private final ArrayList<Employee> employees;
    private OnItemClickListener onItemClickListener;

    public EmployeeAdapter(Context context) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        employees = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        Employee employee = employees.get(position);
        if (employee.isFired.get()) {
            return ITEM_VIEW_TYPE_OFF;
        } else {
            return ITEM_VIEW_TYPE_ON;
        }
    }

    @Override
    public DataBindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding;
        if (viewType == ITEM_VIEW_TYPE_OFF) {
            binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_employee_off, parent, false);
        } else {
            binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_employee, parent, false);
        }
        return new DataBindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(DataBindingViewHolder holder, int position) {
        final Employee employee = employees.get(position);
        ViewDataBinding binding = holder.getBinding();
        binding.setVariable(BR.item, employee);
        binding.executePendingBindings();
        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onEmployeeClick(employee);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return employees == null ? 0 : employees.size();
    }

    public interface OnItemClickListener {
        void onEmployeeClick(Employee employee);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void addAll(List<Employee> employees) {
        this.employees.addAll(employees);
    }

    Random mRandom = new Random(System.currentTimeMillis());

    public void add(Employee employee) {
        int position = mRandom.nextInt(employees.size() + 1);
        employees.add(position, employee);
        notifyItemInserted(position);
    }

    public void remove() {
        if (employees.size() == 0) {
            return;
        }
        int position = mRandom.nextInt(employees.size());
        employees.remove(position);
        notifyItemRemoved(position);
    }

}
