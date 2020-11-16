package com.example.fragmentation_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/***
 * 这里使用ViewPager2+BottomNavigationBar
 * 还需要使用Navigation+DrawerLayout
 * 配合menu进行开发
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
