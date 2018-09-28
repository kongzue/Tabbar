package com.kongzue.tabbardemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.kongzue.tabbar.Tab;
import com.kongzue.tabbar.TabBarView;
import com.kongzue.tabbar.interfaces.OnTabChangeListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    
    private TabBarView tabbar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabbar = findViewById(R.id.tabbar);
        
        List<Tab> tabs = new ArrayList<>();
        tabs.add(new Tab(this, "首页", R.mipmap.img_maintab_home));
        tabs.add(new Tab(this, "联系人", R.mipmap.img_maintab_contacts));
        tabs.add(new Tab(this, "我的", R.mipmap.img_maintab_me));
        
        tabbar.setTab(tabs)
                .setOnTabChangeListener(new OnTabChangeListener() {
                    @Override
                    public void onTabChanged(int index) {
                        Log.i(">>>", "onTabChanged: " + index);
                    }
                })
                .setNormalFocusIndex(1)
        ;
    }
}
