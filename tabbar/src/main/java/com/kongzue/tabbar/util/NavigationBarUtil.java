package com.kongzue.tabbar.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;

/**
 * Author: @Kongzue
 * Github: https://github.com/kongzue/
 * Homepage: http://kongzue.com/
 * Mail: myzcxhh@live.cn
 * CreateTime: 2018/10/19 13:45
 */
public class NavigationBarUtil {
    
    public static int getNavbarHeight(Activity context) {
        int rootHeight = getRootHeight(context);
        int navbarHeight = rootHeight - context.getWindowManager().getDefaultDisplay().getHeight();
        if (navbarHeight < 0) navbarHeight = 0;
        return navbarHeight;
    }
    
    private static int getRootHeight(Activity context) {
        int diaplayHeight = 0;
        Display display = context.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            display.getRealSize(point);
            diaplayHeight = point.y;
        } else {
            DisplayMetrics dm = new DisplayMetrics();
            context.getWindowManager().getDefaultDisplay().getMetrics(dm);
            diaplayHeight = dm.heightPixels; //得到高度```
        }
        return diaplayHeight;
    }
    
}
