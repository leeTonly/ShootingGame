package com.example.a77266.shootinggame.manager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

import com.example.a77266.shootinggame.R;
import com.example.a77266.shootinggame.entity.Player;

/**
 * Created by LinLiQiang on 2016-8-12 19:15.
 * Email : 772662623@qq.com
 * Function: 此类实现player的管理，实例一个player，并提供绘制player的外部方法
 */
public class PlayerManager {

    private Player player;

    public PlayerManager(View view) {
        this.player = new Player(view);
    }

    public void drawPlayer(Canvas canvas) {
        this.player.drawSelf(canvas);
    }

    public void moveTo(int iPlayerX, int iPlayerY) {
        this.player.moveTo(iPlayerX, iPlayerY);
    }

    public Player getPlayer() {
        return player;
    }
}
