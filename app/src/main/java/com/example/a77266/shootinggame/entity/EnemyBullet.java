package com.example.a77266.shootinggame.entity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

import com.example.a77266.shootinggame.R;

/**
 * Created by LinLiQiang on 2016-8-23 19:42.
 * Email : 772662623@qq.com
 * Function: 敌机子弹的类
 */
public class EnemyBullet {
    /*敌机子弹的图片*/
    private Bitmap bullet = null;

    /*bullet的坐标*/
    private int y = 0;
    private int x = 0;

    /*窗体的宽高*/
    private int winWidth = 0;
    private int winHeight = 0;

    /*敌机子弹的速度*/
    private int dy = 0;

    /*是否需要绘制此子弹的flag*/
    private boolean bDrawOrNot = false;

    public EnemyBullet(View view) {
        bullet = BitmapFactory.decodeResource(view.getResources(),
                R.drawable.bullet3);
        winHeight = view.getHeight();
        winWidth = view.getWidth();
    }

    /*外部调用设置子弹的初始位置*/
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void drawSelf(Canvas canvas) {
        canvas.drawBitmap(bullet, x, y, null);
    }

    /*外部调用设置子弹的移动速度*/
    public void setDy(int dy) {
        this.dy = dy;
    }

    /*Manager调用设置子弹的下一次坐标*/
    public void move() {
        y += dy;

        if(y > winHeight) {
            bDrawOrNot = false;
        }
    }

    public boolean isbDrawOrNot() {
        return bDrawOrNot;
    }

    public void setbDrawOrNot(boolean bDrawOrNot) {
        this.bDrawOrNot = bDrawOrNot;
    }

    public int getBulletWidth() {
        return bullet.getWidth();
    }

    public int getBulletHeight() {
        return bullet.getHeight();
    }
}
