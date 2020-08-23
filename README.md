# Kongzue Tabbar
Kongzue Tabbar是一款简单的底部导航栏组件，仅需要简单配置即可满足绝大多数需要使用导航栏的场景。

<a href="https://github.com/kongzue/Tabbar/">
<img src="https://img.shields.io/badge/Tabbar-1.5.4-green.svg" alt="Kongzue Tabbar">
</a>
<a href="https://bintray.com/myzchh/maven/tabbar/1.5.4/link">
<img src="https://img.shields.io/badge/Maven-1.5.4-blue.svg" alt="Maven">
</a>
<a href="http://www.apache.org/licenses/LICENSE-2.0">
<img src="https://img.shields.io/badge/License-Apache%202.0-red.svg" alt="License">
</a>
<a href="http://www.kongzue.com">
<img src="https://img.shields.io/badge/Homepage-Kongzue.com-brightgreen.svg" alt="Homepage">
</a>

Demo预览图如下：

![Tabbar](https://github.com/kongzue/Res/raw/master/app/src/main/res/mipmap-xxxhdpi/Tabbar.png)

## 优势
- 无需两份图！每个 TabIcon 仅需一份颜色的图即可，Tabbar 会根据您设置的颜色自动叠加颜色！

- 易于上手，快速创建，满足绝大多数导航栏使用场景。

- 简单的方式就可以实现未读角标提醒。

## Demo
可通过 http://beta.kongzue.com/Tabbar 下载试用

## 使用方法

1) 从 Maven 仓库或 jCenter 引入：
Maven仓库：
```
<dependency>
  <groupId>com.kongzue.tabbar</groupId>
  <artifactId>tabbar</artifactId>
  <version>1.5.4</version>
  <type>pom</type>
</dependency>
```
Gradle：
在dependencies{}中添加引用：
```
implementation 'com.kongzue.tabbar:tabbar:1.5.4.1'
```
🆕 AndroidX 版本：
```
implementation 'com.kongzue.tabbarx:tabbar:1.5.4'
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
    app:tabPaddingVertical="5dp"
    app:paddingNavigationBar="false"/>
```

其中各属性解释如下：

字段 | 含义 | 默认值
---|---|---
focusColor  | 处于焦点状态的颜色  | #3e78ed
normalColor  | 处于普通状态的颜色  | #606060
iconPadding | 图标内边距  | 5dp
textSize  | 文本字号  | 12dp
tabPaddingVertical  | tab按钮上下内边距  | 5dp
tabClickBackground  | tab按钮按下效果  | ripple
paddingNavigationBar | 是否开启底部导航栏沉浸式 | false
noDyeing | 禁止染色 | false
noSelect | 禁止选择 | false
splitLine | 分隔线 | resId
unreadBackground | 未读消息小红点背景 | resId

也可通过set方法设置：
```
tabbar = findViewById(R.id.tabbar);

tabbar.setFocusColor(Color.rgb(62, 120, 238));                              //处于焦点状态的颜色
tabbar.setNormalColor(Color.rgb(96, 96, 96));                               //处于普通状态的颜色
tabbar.setTextSize(dp2px(12));                                              //文本字号
tabbar.setIconPadding(dp2px(5));                                            //图标内边距
tabbar.setTabPaddingVertical(dp2px(5));                                     //tab按钮上下内边距
tabbar.setTabClickBackground(TabBarView.TabClickBackgroundValue.RIPPLE);    //tab按钮按下效果

//从 1.4 版本起，新增两个新的选项：
tabbar.setNoSelect(false);                                                  //是否禁止选择效果
tabbar.setNoDyeing(false);                                                  //是否禁止颜色渲染
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

## 额外的说明
### Tab 的创建（构造）方式

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

### 按钮点击监听

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

### 设置默认焦点按钮：

可通过以下代码设置设置默认焦点按钮：
```
tabbar.setNormalFocusIndex(index);
```
其中，index 即要设置为焦点的按钮的索引号。

### 当前提供三种 Tab 按钮按下效果:

字段 | 含义 | 是否默认
---|---|---
ripple  | 默认矩形水波纹效果|是
rippleOutside  | 外弧形水波纹效果|否
gray  | 纯灰色| 否

具体表现效果如下：

![TabbarClick](https://github.com/kongzue/Res/raw/master/app/src/main/res/mipmap-xxxhdpi/tabclickbkg.png)

### 关于沉浸式

当您设置开启沉浸式时可能会出现 Tabbar 被底部按键导航栏（NavigationBar）遮挡的问题，此时开启 paddingNavigationBar 即可解决此问题。设置方法为：

在XML布局中：
```
app:paddingNavigationBar = "true"
```

开启后，Tabbar会自动设置一段 paddingBottom 边距以适应底栏高度。

### 启用未读角标

在您创建一个Tab的时候，可以为其设置角标。

![TabbarUnread](https://github.com/kongzue/Res/raw/master/app/src/main/res/mipmap-xxxhdpi/tabbar_unread_demo.png)

例如：
```
new Tab(this, "联系人", R.mipmap.img_maintab_contacts).setUnreadNum(123).setMaxUnreadNum(99);
```
其中，UnreadNum 为角标数字，值为 0 时隐藏角标，为负数时不显示数字只显示一个红点，当 UnreadNum 超过 MaxUnreadNum 的值时会显示为 MaxUnreadNum+，例如上边的示例会显示为“99+”

也可通过代码动态设置未读数量角标：
```
//参数：(第几个Tab, 未读数量)
tabbar.setUnreadNum(2, 123);
//备注：可通过设置未读数量为 0 来清除角标。
```

### 禁用选择和禁用染色

1.4 版本起，新增了禁止选择（noSelect）和禁止颜色渲染（noDyeing）的选项，其目的是使 Tabbar 能够有更为广泛的应用场景，其中典型的场景为电商的分类选择，如下图所示：

![TabbarUnread](https://github.com/kongzue/Res/raw/master/app/src/main/res/mipmap-xxxhdpi/tabbar_noselect_and_nodyeing.png)

您可以通过 XML 布局文件中直接设置这些属性：
```
<com.kongzue.tabbar.TabBarView
    android:id="@+id/selectTabbar"
    android:layout_width="match_parent"
    android:layout_height="65dp"
    app:iconPadding="2dp"
    app:noDyeing="true"
    app:noSelect="true"
    app:normalColor="#606060"
    app:paddingNavigationBar="false"
    app:tabClickBackground="empty"
    app:tabPaddingVertical="5dp"
    app:textSize="12dp" />
```

也可以通过代码设置：
```
tabbar.setNoSelect(false);
tabbar.setNoDyeing(false);
```

### 二套图支持

![Tabbar2Type](https://github.com/kongzue/Res/raw/master/app/src/main/res/mipmap-xxxhdpi/tabbar_2_type.png)

若您的设计师提供了两套完全不一样的 Tab 图标，即选中状态下显示的图标和非选中时显示的图标完全不同，不可以通过一套图染色的方式实现，可参考本章节提供的方法：

首先，在 XML 中创造布局：
```
<com.kongzue.tabbar.TabBarView
    android:id="@+id/tabTwoType"
    android:layout_width="match_parent"
    android:layout_height="58dp"
    app:focusColor="#f14961"                        ← 此处为选中时文字的颜色
    app:iconPadding="2dp"
    app:normalColor="#a2a2a2"                       ← 此处为非选中时文字的颜色
    android:background="#fff"
    app:noDyeing="true"                             ← 设置为图标非染色模式
    app:paddingNavigationBar="false"
    app:tabClickBackground="ripple"
    app:tabPaddingVertical="3dp"
    app:textSize="12dp" />
```

接下来在代码中为 Tabbar 添加内容：
```
List<Tab> tabs2 = new ArrayList<>();
tabs2.add(new Tab(this, "首页", R.mipmap.tab2_home_off).setFocusIcon(this,R.mipmap.tab2_home_on));            //使用 setFocusIcon(bitmap/drawable/resId) 来添加选中时的第二套图标
tabs2.add(new Tab(this, "消息", R.mipmap.tab2_message_off).setFocusIcon(this,R.mipmap.tab2_message_on);
tabs2.add(new Tab(this, "我的", R.mipmap.tab2_me_off).setFocusIcon(this,R.mipmap.tab2_me_on));
tabTwoType.setTab(tabs2);
```

完成！

### 分隔线

从 1.5.3 版本起支持了分割线功能，可设置属性来启用：
```
app:splitLine="@drawable/split_line"
```

如果只需要颜色来填充分隔线，可以在属性中引用您的颜色，注意不可以设置16进制的颜色值，只能引用属性设置：
```
app:splitLine="@color/colorAccent"
```

若您需要制作一个上下有间距的分隔线，可以创建一个 drawable 的 XML 文件，以下是范例 split_line.xml：
```
<?xml version="1.0" encoding="UTF-8"?>
<inset xmlns:android="http://schemas.android.com/apk/res/android"
    android:insetTop="5dp"
    android:insetBottom="5dp"
    android:drawable="@color/colorAccent">
</inset>
```

完成效果如图所示：
![Tabbar2Type](https://github.com/kongzue/Res/raw/master/app/src/main/res/mipmap-xxxhdpi/tabbar_split_line.png)

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

## 更新日志
v1.5.4.1（测试版本）:
- 修复bug；

v1.5.4:
- 修复了获取导航栏高度值错误的问题；
- 新增未读表计小红点属性设置 unreadBackground；

v1.5.3:
- 新增方法 setUnreadNum(index, unreadNum) 用以直接设置未读数量；
- 新增方法 getChild(index) 可以直接获取对应子按钮；
- 新增属性 splitLine 可以设置分隔线；
- 修复未读数量红点可能出现的位置显示 bug；

v1.5.2:
- 修复在 Android 5.1.1 版本上的染色兼容问题 × 2；

v1.5.1:
- 修复在 Android 5.1.1 版本上的染色兼容问题；

v1.5:
- 新增二套图支持；

v1.4:
- 新增支持禁止选择（noSelect）和禁止颜色渲染（noDyeing）的选项；

v1.3:
- 支持角标显示；

v1.2:
- 修复bug；
- 新增属性 paddingNavigationBar 底栏沉浸式开关（具体请参照文档）；

v1.1:
- 新增属性 “tabClickBackground” 控制按下的不同效果；
- 新增部分注释；

