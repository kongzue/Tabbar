# Kongzue Tabbar
Kongzue Tabbar是一款简单的底部导航栏组件，仅需要简单配置即可满足绝大多数需要使用导航栏的场景。

<a href="https://github.com/kongzue/Tabbar/">
<img src="https://img.shields.io/badge/Tabbar-1.0-green.svg" alt="Kongzue BaseFramework">
</a>
<a href="https://bintray.com/myzchh/maven/tabbar/1.0/link">
<img src="https://img.shields.io/badge/Maven-1.0-blue.svg" alt="Maven">
</a>
<a href="http://www.apache.org/licenses/LICENSE-2.0">
<img src="https://img.shields.io/badge/License-Apache%202.0-red.svg" alt="License">
</a>
<a href="http://www.kongzue.com">
<img src="https://img.shields.io/badge/Homepage-Kongzue.com-brightgreen.svg" alt="Homepage">
</a>

Demo预览图如下：

![Tabbar](https://github.com/kongzue/Res/raw/master/app/src/main/res/mipmap-xxxhdpi/Tabbar.png)

### 优势
- 无需两份图！每个 TabIcon 仅需一份颜色的图即可，Tabbar 会根据您设置的颜色自动叠加颜色！

- 易于上手，快速创建，满足绝大多数导航栏使用场景。

### 使用方法

1) 从 Maven 仓库或 jCenter 引入：
Maven仓库：
```
<dependency>
  <groupId>com.kongzue.tabbar</groupId>
  <artifactId>tabbar</artifactId>
  <version>1.0</version>
  <type>pom</type>
</dependency>
```
Gradle：
在dependencies{}中添加引用：
```
implementation 'com.kongzue.tabbar:tabbar:1.0'
```

2) 从XML布局文件创建：
```
<com.kongzue.tabbar.TabBarView xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/tabbar"
    android:layout_width="match_parent"
    android:layout_height="55dp"
    app:focusColor="#3e78ed"
    app:iconPadding="2dp"
    app:normalColor="#606060"
    app:textSize="12dp"
    app:tabPaddingVertical="5dp"/>
```

其中各属性解释如下：

字段 | 含义 | 默认值
---|---|---
focusColor  | 处于焦点状态的颜色  | #3e78ed
normalColor  | 处于普通状态的颜色  | #606060
iconPadding | 图标内边距  | 5dp
textSize  | 文本字号  | 12dp
tabPaddingVertical  | tab按钮上下内边距  | 5dp

也可通过set方法设置：
```
tabbar = findViewById(R.id.tabbar);

tabbar.setFocusColor(Color.rgb(62, 120, 238));      //处于焦点状态的颜色
tabbar.setNormalColor(Color.rgb(96, 96, 96));       //处于普通状态的颜色
tabbar.setTextSize(dp2px(12));                      //文本字号
tabbar.setIconPadding(dp2px(5));                    //图标内边距
tabbar.setTabPaddingVertical(dp2px(5));             //tab按钮上下内边距
```

3) 创建Tab：

首先需要创建一个 List<Tab> 用来存放Tab数据：
```
List<Tab> tabs = new ArrayList<>();
tabs.add(new Tab(this, "首页", R.mipmap.img_maintab_home));
tabs.add(new Tab(this, "联系人", R.mipmap.img_maintab_contacts));
tabs.add(new Tab(this, "我的", R.mipmap.img_maintab_me));
```

然后将它们设置到 Tabbar 即可：
```
tabbar.setTab(tabs);
```

完成！

### 额外的说明
1) Tab 的创建（构造）方式

Tab 支持多种构建方式：
```
new Tab(this, "首页", R.mipmap.img_maintab_home)      //使用资源文件创建
new Tab("首页", bitmap);                              //使用 Bitmap 位图创建
new Tab("首页", drawable);                            //使用 drawable 创建
```
Tab 亦支持 get、set 方法，可以通过他们设置属性值。

其次，关于 Tab 字段的说明：

字段 | 含义 | 是否必须
---|---|---
name  | Tab 标签名称|是
icon  | Tab 图标| 是

2) 按钮点击监听

可通过以下代码设置监听
```
tabbar.setOnTabChangeListener(new OnTabChangeListener() {
    @Override
    public void onTabChanged(int index) {
        Log.i(">>>", "onTabChanged: " + index);
    }
})
```
其中，index 即当前点击了哪个按钮的索引号。

3) 设置默认焦点按钮：

可通过以下代码设置设置默认焦点按钮：
```
tabbar.setNormalFocusIndex(index);
```
其中，index 即要设置为焦点的按钮的索引号。

## 开源协议
```
Copyright Tabbar

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

