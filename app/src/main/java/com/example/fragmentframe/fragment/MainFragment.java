package com.example.fragmentframe.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragmentframe.R;
import com.example.fragmentframe.base.BaseSupportFragment;
import com.example.fragmentframe.fragment.bottom.CommunityFragment;
import com.example.fragmentframe.fragment.bottom.HomeFragment;
import com.example.fragmentframe.fragment.bottom.MineFragment;
import com.example.fragmentframe.fragment.bottom.RemindFragment;
import com.weikaiyun.fragmentation.SupportHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;

/***
 * 创建时间：2020/11/16 19:57
 * 创建人：10850
 * 功能描述：
 */
public class MainFragment extends BaseSupportFragment {

    //控件
    private ImageView img_home;
    private TextView tv_home;
    private ImageView img_remind;
    private TextView tv_remind;
    private ImageView img_community;
    private TextView tv_community;
    private ImageView img_mine;
    private TextView tv_mine;

    private ConstraintLayout cl_home;
    private ConstraintLayout cl_remind;
    private ConstraintLayout cl_community;
    private ConstraintLayout cl_mine;

    private int HOME = 0;
    private int REMIND = 1;
    private int COMMUNITY = 2;
    private int MINE = 3;
    private int currentTab = HOME;

    private HomeFragment homeFragment;
    private MineFragment mineFragment;
    private CommunityFragment communityFragment;
    private RemindFragment remindFragment;

    //未选中的图片资源数组
    private int[] iconArr = new int[]{
            R.drawable.icon_bottom_homepage,
            R.drawable.icon_bottom_remind,
            R.drawable.icon_bottom_community,
            R.drawable.icon_bottom_mine
    };
    //已选中的图片资源数组
    private int[] selectedIconArr = new int[]{
            R.drawable.icon_bottom_homepage_selected,
            R.drawable.icon_bottom_remind_selected,
            R.drawable.icon_bottom_community_selected,
            R.drawable.icon_bottom_mine_selected
    };

    private int selectedTextColor;
    private int textColor;

    @Override
    public void initView(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            textColor = getContext().getColor(R.color.color_normal);
            selectedTextColor = getContext().getColor(R.color.color_selected);
        }

        img_home = view.findViewById(R.id.img_home);
        tv_home = view.findViewById(R.id.tv_home);
        img_community = view.findViewById(R.id.img_community);
        tv_community = view.findViewById(R.id.tv_community);
        img_mine = view.findViewById(R.id.img_mine);
        tv_mine = view.findViewById(R.id.tv_mine);
        img_remind = view.findViewById(R.id.img_remind);
        tv_remind = view.findViewById(R.id.tv_remind);

        cl_home = view.findViewById(R.id.cl_home);
        cl_remind = view.findViewById(R.id.cl_remind);
        cl_community = view.findViewById(R.id.cl_community);
        cl_mine = view.findViewById(R.id.cl_mine);


        HomeFragment homeFragmentInStack = SupportHelper.findFragment(getChildFragmentManager(), HomeFragment.class);
        if (homeFragmentInStack != null) {
            homeFragment = homeFragmentInStack;
            remindFragment = SupportHelper.findFragment(getChildFragmentManager(), RemindFragment.class);
            communityFragment = SupportHelper.findFragment(getChildFragmentManager(), CommunityFragment.class);
            mineFragment = SupportHelper.findFragment(getChildFragmentManager(), MineFragment.class);
        } else {
            homeFragment = HomeFragment.newInstance();
            remindFragment = RemindFragment.newInstance();
            communityFragment = CommunityFragment.newInstance();
            mineFragment = MineFragment.newInstance();
            loadMultipleRootFragment(R.id.fl_container, currentTab, homeFragment, remindFragment, communityFragment, mineFragment);
        }

        cl_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentTab != HOME) {
                    showHideFragment(homeFragment);
                    checkTab(HOME);
                }
            }
        });

        cl_remind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentTab != REMIND) {
                    showHideFragment(remindFragment);
                    checkTab(REMIND);
                }
            }
        });

        cl_community.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentTab != COMMUNITY) {
                    showHideFragment(communityFragment);
                    checkTab(COMMUNITY);
                }
            }
        });

        cl_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentTab != MINE) {
                    showHideFragment(mineFragment);
                    checkTab(MINE);
                }
            }
        });

        checkTab(HOME);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void checkTab(int tab) {
        currentTab = tab;
        switch (currentTab) {
            case 0: {
                img_home.setImageDrawable(getContext().getDrawable(selectedIconArr[HOME]));
                tv_home.setTextColor(selectedTextColor);
                img_remind.setImageDrawable(getContext().getDrawable(iconArr[REMIND]));
                tv_remind.setTextColor(textColor);
                img_community.setImageDrawable(getContext().getDrawable(iconArr[COMMUNITY]));
                tv_community.setTextColor(textColor);
                img_mine.setImageDrawable(getContext().getDrawable(iconArr[MINE]));
                tv_mine.setTextColor(textColor);
            }
            break;
            case 1: {
                img_home.setImageDrawable(getContext().getDrawable(iconArr[HOME]));
                tv_home.setTextColor(textColor);
                img_remind.setImageDrawable(getContext().getDrawable(selectedIconArr[REMIND]));
                tv_remind.setTextColor(selectedTextColor);
                img_community.setImageDrawable(getContext().getDrawable(iconArr[COMMUNITY]));
                tv_community.setTextColor(textColor);
                img_mine.setImageDrawable(getContext().getDrawable(iconArr[MINE]));
                tv_mine.setTextColor(textColor);
            }
            break;
            case 2: {
                img_home.setImageDrawable(getContext().getDrawable(iconArr[HOME]));
                tv_home.setTextColor(textColor);
                img_remind.setImageDrawable(getContext().getDrawable(iconArr[REMIND]));
                tv_remind.setTextColor(textColor);
                img_community.setImageDrawable(getContext().getDrawable(selectedIconArr[COMMUNITY]));
                tv_community.setTextColor(selectedTextColor);
                img_mine.setImageDrawable(getContext().getDrawable(iconArr[MINE]));
                tv_mine.setTextColor(textColor);
            }
            break;
            case 3: {
                img_home.setImageDrawable(getContext().getDrawable(iconArr[HOME]));
                tv_home.setTextColor(textColor);
                img_remind.setImageDrawable(getContext().getDrawable(iconArr[REMIND]));
                tv_remind.setTextColor(textColor);
                img_community.setImageDrawable(getContext().getDrawable(iconArr[COMMUNITY]));
                tv_community.setTextColor(textColor);
                img_mine.setImageDrawable(getContext().getDrawable(selectedIconArr[MINE]));
                tv_mine.setTextColor(selectedTextColor);
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + currentTab);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main;
    }

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }
} 