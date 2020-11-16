package com.example.fragmentframe.fragment.demo;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fragmentframe.R;
import com.example.fragmentframe.base.BaseSupportFragment;
import com.example.fragmentframe.fragment.demo.DemoFragment2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DemoFragment1 extends BaseSupportFragment {

    private int param1;
    private String param2;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_demo;
    }

    @Override
    public void initView(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
        TextView tv = view.findViewById(R.id.title);
        tv.setText("DemoFragment" + param1);
        TextView btn = view.findViewById(R.id.button);
        btn.setText(param2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start(DemoFragment2.newInstance(2, "start3"));
            }
        });
    }

    public static DemoFragment1 newInstance(int p1, String p2) {
        Bundle args = new Bundle();
        args.putInt("param1", p1);
        args.putString("param2", p2);
        DemoFragment1 fragment = new DemoFragment1();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        param1 = getArguments().getInt("param1");
        param2 = getArguments().getString("param2");
    }
}