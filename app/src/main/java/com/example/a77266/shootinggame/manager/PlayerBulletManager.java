package com.example.a77266.shootinggame.manager;

import android.graphics.Canvas;
import android.view.View;

import com.example.a77266.shootinggame.entity.PlayerBullet;

/**
 * Created by LinLiQiang on 2016-8-13 16:05.
 * Email : 772662623@qq.com
 * Function: 定义所有player子弹，提供绘制所有player子弹、获取单个子弹实例、所有子弹实例的外部方法
 */
public class PlayerBulletManager {

    private static PlayerBullet[] playerBullets = new PlayerBullet[128];

    public PlayerBulletManager(View view) {
        for(int i=0; i<playerBullets.length; i++) {
            playerBullets[i] = new PlayerBullet(view);
        }
    }

    public void drawPlayerBullet(Canvas canvas) {
        for(PlayerBullet playerBullet : playerBullets) {
            if(playerBullet.isbDrawOrNot()) {
                playerBullet.move();
                playerBullet.drawSelf(canvas);
            }
        }
    }

    public static PlayerBullet getOnePlayerBullet() {
        for(PlayerBullet playerBullet : playerBullets) {
            if(!playerBullet.isbDrawOrNot()) {
                playerBullet.setbDrawOrNot(true);
                return playerBullet;
            }
        }

        return null;
    }

    public static PlayerBullet[] getAllPlayerBullets() {
        return playerBullets;
    }
}
