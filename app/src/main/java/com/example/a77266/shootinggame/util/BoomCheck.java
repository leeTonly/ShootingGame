package com.example.a77266.shootinggame.util;

/**
 * Created by LinLiQiang on 2016-8-24 20:21.
 * Email : 772662623@qq.com
 * Function: 检测两个图片是否碰撞
 */
public class BoomCheck {

    public static boolean ifBoom (Object object1, Object object2) {
        return false;
    }

    /*检测两个图片是否碰撞*/
    public static boolean ifBoom (int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        return x1 < x4 && y1 < y4 && x2 > x3 && y2 > y3;
    }
}
