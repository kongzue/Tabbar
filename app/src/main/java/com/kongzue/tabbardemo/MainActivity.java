package com.kongzue.tabbardemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.kongzue.tabbar.Tab;
import com.kongzue.tabbar.TabBarView;
import com.kongzue.tabbar.interfaces.OnTabChangeListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    
    private TabBarView selectTabbar;
    private TabBarView selectTabbar2;
    private TabBarView tabTwoType;
    private TabBarView myTabbar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        selectTabbar = findViewById(R.id.selectTabbar);
        selectTabbar2 = findViewById(R.id.selectTabbar2);
        tabTwoType = findViewById(R.id.tabTwoType);
        myTabbar = findViewById(R.id.myTabbar);
        
        List<Tab> tabs = new ArrayList<>();
        tabs.add(new Tab(this, "首页", R.mipmap.img_maintab_home));
        tabs.add(new Tab(this, "联系人", R.mipmap.img_maintab_contacts).setUnreadNum(-5).setMaxUnreadNum(99));
        tabs.add(new Tab(this, "我的", R.mipmap.img_maintab_me));
        myTabbar.setTab(tabs)
                .setOnTabChangeListener(new OnTabChangeListener() {
                    @Override
                    public void onTabChanged(View v, int index) {
                        Log.i(">>>", "onTabChanged: " + index);
                        tabTwoType.setUnreadNum(2,index-1);
                    }
                })
                .setNormalFocusIndex(1)
        ;
    
        final List<Tab> tabSort = new ArrayList<>();
        tabSort.add(new Tab(this, "淘宝", R.mipmap.img_shop_tb));
        tabSort.add(new Tab(this, "天猫", R.mipmap.img_shop_tmall));
        tabSort.add(new Tab(this, "聚划算", R.mipmap.img_shop_jhc));
        tabSort.add(new Tab(this, "信用卡", R.mipmap.img_shop_visa));
        selectTabbar.setTab(tabSort).setOnTabChangeListener(new OnTabChangeListener() {
            @Override
            public void onTabChanged(View v, int index) {
                Toast.makeText(MainActivity.this,tabSort.get(index).getName(),Toast.LENGTH_SHORT).show();
            }
        });
        final List<Tab> tabSort2 = new ArrayList<>();
        tabSort2.add(new Tab(this, "京东", R.mipmap.img_shop_jd));
        tabSort2.add(new Tab(this, "苏宁", R.mipmap.img_shop_sn));
        tabSort2.add(new Tab(this, "蘑菇街", R.mipmap.img_shop_mg));
        tabSort2.add(new Tab(this, "聚美优品", R.mipmap.img_shop_jm));
        selectTabbar2.setTab(tabSort2).setOnTabChangeListener(new OnTabChangeListener() {
            @Override
            public void onTabChanged(View v, int index) {
                Toast.makeText(MainActivity.this,tabSort2.get(index).getName(),Toast.LENGTH_SHORT).show();
            }
        });
    
        List<Tab> tabs2 = new ArrayList<>();
        tabs2.add(new Tab(this, "首页", R.mipmap.tab2_home_off).setFocusIcon(this,R.mipmap.tab2_home_on));
        tabs2.add(new Tab(this, "消息", R.mipmap.tab2_message_off).setFocusIcon(this,R.mipmap.tab2_message_on).setUnreadNum(5).setMaxUnreadNum(99));
        tabs2.add(new Tab(this, "我的", R.mipmap.tab2_me_off).setFocusIcon(this,R.mipmap.tab2_me_on));
        tabTwoType.setTab(tabs2)
                .setOnTabChangeListener(new OnTabChangeListener() {
                    @Override
                    public void onTabChanged(View v, int index) {
                        Log.i(">>>", "onTabChanged: " + index);
                    }
                })
                .setNormalFocusIndex(1)
        ;
    
    }
}
