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
 */
public class Explodtion {

    Bitmap explode = null;
    int x = 0;
    int y = 0;

    private boolean bifExploded = false;

    public Explodtion(View view) {

        explode = BitmapFactory.decodeResource(view.getResources(),
                R.drawable.explored);
    }

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
