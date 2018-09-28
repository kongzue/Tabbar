package com.kongzue.tabbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

/**
 * Author: @Kongzue
 * Github: https://github.com/kongzue/
 * Homepage: http://kongzue.com/
 * Mail: myzcxhh@live.cn
 * CreateTime: 2018/9/28 02:16
 */
public class Tab {
    
    private String name;
    private Bitmap icon;
    
    public Tab(@Nullable Context context, @Nullable String name, @DrawableRes int resId) {
        setName(name);
        setIcon(context, resId);
    }
    
    public Tab(@Nullable String name, @Nullable Drawable icon) {
        setName(name);
        setIcon(icon);
    }
    
    public Tab(@Nullable String name, @Nullable Bitmap icon) {
        setName(name);
        setIcon(icon);
    }
    
    public String getName() {
        return name;
    }
    
    public Tab setName(@Nullable String name) {
        this.name = name;
        return this;
    }
    
    public Bitmap getIcon() {
        return icon;
    }
    
    public Tab setIcon(@Nullable Bitmap icon) {
        this.icon = icon;
        return this;
    }
    
    public Tab setIcon(@Nullable Context context, @DrawableRes int resId) {
        this.icon = BitmapFactory.decodeResource(context.getResources(), resId);
        return this;
    }
    
    public Tab setIcon(@Nullable Drawable drawable) {
        BitmapDrawable bd = (BitmapDrawable) drawable;
        this.icon = bd.getBitmap();
        return this;
    }
}
