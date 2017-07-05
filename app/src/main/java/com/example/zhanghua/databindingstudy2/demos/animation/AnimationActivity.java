package com.example.zhanghua.databindingstudy2.demos.animation;

import android.databinding.DataBindingUtil;
import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhanghua.databindingstudy2.R;
import com.example.zhanghua.databindingstudy2.databinding.ActivityAnimationBinding;

public class AnimationActivity extends AppCompatActivity {

    private ActivityAnimationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_animation);
        binding.setPresenter(new AnimationPresenter());
        binding.addOnRebindCallback(new OnRebindCallback() {
            @Override
            public boolean onPreBind(ViewDataBinding binding) {
                ViewGroup root = (ViewGroup)binding.getRoot();
                TransitionManager.beginDelayedTransition(root);
                return true;
            }
        });
    }

    public class AnimationPresenter {
        public void onCheckedChanged(View buttonView, boolean isChecked) {
            binding.setShowImage(isChecked);
        }
    }
}
