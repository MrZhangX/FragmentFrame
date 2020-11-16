package com.example.fragmentframe;

import android.app.Application;
import android.os.Build;
import android.os.Debug;
import android.util.Config;

import com.weikaiyun.fragmentation.Fragmentation;

/***
 * 创建时间：2020/11/16 19:33
 * 创建人：10850
 * 功能描述：第一步：Application初始化API
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fragmentation.builder() // 设置 栈视图 模式为 （默认）悬浮球模式   SHAKE: 摇一摇唤出  NONE：隐藏， 仅在Debug环境生效
                .stackViewMode(Fragmentation.BUBBLE)
                .debug(true) // 实际场景建议.debug(BuildConfig.DEBUG)
                .animation(R.anim.v_fragment_enter, R.anim.v_fragment_pop_exit, R.anim.v_fragment_pop_enter, R.anim.v_fragment_exit) //设置默认动画
                .install();
    }
}