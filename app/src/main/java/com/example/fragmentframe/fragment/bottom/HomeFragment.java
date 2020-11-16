package com.example.fragmentframe.fragment.bottom;

import android.os.Bundle;
import android.view.View;

import com.example.fragmentframe.R;
import com.example.fragmentframe.base.BaseSupportFragment;
import com.example.fragmentframe.fragment.demo.DemoFragment1;
import com.weikaiyun.fragmentation.SupportFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/***
 * 创建时间：2020/11/16 20:14
 * 创建人：10850
 * 功能描述：
 */
public class HomeFragment extends BaseSupportFragment {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initView(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
        view.findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //此处使用_mActivity.start, 则DemoFragment1与MainFragment平级
                _mActivity.start(DemoFragment1.newInstance(1, "start2"));
            }
        });
    }
}