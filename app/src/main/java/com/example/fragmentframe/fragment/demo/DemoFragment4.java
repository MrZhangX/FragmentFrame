package com.example.fragmentframe.fragment.demo;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fragmentframe.R;
import com.example.fragmentframe.base.BaseSupportFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DemoFragment4 extends BaseSupportFragment {
    private int param1;
    private String param2;
    private String param3;
    private String param4;

    public static DemoFragment4 newInstance(int p1, String p2, String p3, String p4) {
        Bundle args = new Bundle();
        args.putInt("param1", p1);
        args.putString("param2", p2);
        args.putString("param3", p3);
        args.putString("param4", p4);
        DemoFragment4 fragment = new DemoFragment4();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        param1 = getArguments().getInt("param1");
        param2 = getArguments().getString("param2");
        param3 = getArguments().getString("param3");
        param4 = getArguments().getString("param4");
    }

    @Override
    public void initView(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
        TextView textView = view.findViewById(R.id.title);
        textView.setText("DemoFragment" + param1);
        TextView button1 = view.findViewById(R.id.button1);
        button1.setText(param2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popTo(DemoFragment1.class, false);
            }
        });
        TextView button2 = view.findViewById(R.id.button2);
        button2.setText(param3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startWithPopTo(
                        DemoFragment5.newInstance(5, "testStartWithPopTo"),
                        DemoFragment1.class, false);
            }
        });
        TextView button3 = view.findViewById(R.id.button3);
        button3.setText(param4);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startWithPop(DemoFragment5.newInstance(5, "testStartWithPop"));
            }
        });
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_demo4;
    }
}