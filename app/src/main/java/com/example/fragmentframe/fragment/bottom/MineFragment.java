package com.example.fragmentframe.fragment.bottom;

import android.os.Bundle;

import com.example.fragmentframe.R;
import com.example.fragmentframe.base.BaseSupportFragment;

/***
 * 创建时间：2020/11/16 20:14
 * 创建人：10850
 * 功能描述：
 */
public class MineFragment extends BaseSupportFragment {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    public static MineFragment newInstance() {
        Bundle args = new Bundle();
        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }
}