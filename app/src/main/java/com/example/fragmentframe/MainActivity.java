package com.example.fragmentframe;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fragmentframe.base.BaseSupportActivity;
import com.example.fragmentframe.fragment.MainFragment;
import com.weikaiyun.fragmentation.SupportActivity;
import com.weikaiyun.fragmentation.SupportHelper;

/***
 * 单Activity+多Fragment
 * 1.使用viewpager2和bottomNavigationBar创建
 * 2.跳转fragment
 */
public class MainActivity extends BaseSupportActivity {

    @Override
    public int getContentViewID() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        MainFragment mainFragment = SupportHelper.findFragment(getSupportFragmentManager(), MainFragment.class);
        if (mainFragment == null) {
            mainFragment = MainFragment.newInstance();
            loadRootFragment(R.id.container, mainFragment);
        }
    }
}