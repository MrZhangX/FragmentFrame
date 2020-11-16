package com.example.fragmentframe.fragment.bottom;

import android.os.Bundle;

import com.example.fragmentframe.R;
import com.example.fragmentframe.base.BaseSupportFragment;

/***
 * 创建时间：2020/11/16 20:14
 * 创建人：10850
 * 功能描述：
 */
public class CommunityFragment extends BaseSupportFragment {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_community;
    }

    public static CommunityFragment newInstance() {
        Bundle args = new Bundle();
        CommunityFragment fragment = new CommunityFragment();
        fragment.setArguments(args);
        return fragment;
    }
}