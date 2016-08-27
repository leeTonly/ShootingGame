package com.example.a77266.shootinggame.entity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

import com.example.a77266.shootinggame.R;

import java.util.ArrayList;

/**
 * Created by LinLiQiang on 2016-8-25 21:41.
 * Email : 772662623@qq.com
 * Function: 将爆炸效果做为一个类
 */
public class Explodtion {
    /*爆炸效果图片*/
    Bitmap explode = null;

    /*爆炸效果图片的坐标*/
    int x = 0;
    int y = 0;

    /*判断当前Explode是否需要绘制的flag*/
    private boolean bifExploded = false;

    public Explodtion(View view) {

        explode = BitmapFactory.decodeResource(view.getResources(),
                R.drawable.explored);
    }

    /*提供给外部设置Explode初始位置*/
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void drawExplodtion(Canvas canvas) {
        canvas.drawBitmap(explode, x, y, null);
        bifExploded = false;
    }

    public boolean isBifExploded() {
        return bifExploded;
    }

    public void setBifExploded(boolean bifExploded) {
        this.bifExploded = bifExploded;
    }
}
