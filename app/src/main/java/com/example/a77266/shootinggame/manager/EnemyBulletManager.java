package com.example.a77266.shootinggame.manager;

import android.graphics.Canvas;
import android.view.View;

import com.example.a77266.shootinggame.entity.EnemyBullet;
import com.example.a77266.shootinggame.entity.PlayerBullet;

/**
 * Created by LinLiQiang on 2016-8-13 16:05.
 * Email : 772662623@qq.com
 * Function: 定义所有敌机子弹，提供绘制所有敌机子弹、获取单个子弹实例、所有子弹实例的外部方法
 */
public class EnemyBulletManager {

    private static EnemyBullet[] enemyBullets = new EnemyBullet[256];

    public EnemyBulletManager(View view) {
        for(int i=0; i<enemyBullets.length; i++) {
            enemyBullets[i] = new EnemyBullet(view);
        }
    }

    public void drawEnemyBullet(Canvas canvas) {
        for(EnemyBullet enemyBullet : enemyBullets) {
            if(enemyBullet.isbDrawOrNot()) {
                enemyBullet.move();
                enemyBullet.drawSelf(canvas);
            }
        }
    }

    public static EnemyBullet getOneEnemyBullet() {
        for(EnemyBullet enemyBullet : enemyBullets) {
            if(!enemyBullet.isbDrawOrNot()) {
                enemyBullet.setbDrawOrNot(true);
                return enemyBullet;
            }
        }

        return null;
    }

    public static EnemyBullet[] getAllEnemyBullets() {
        return enemyBullets;
    }
}
