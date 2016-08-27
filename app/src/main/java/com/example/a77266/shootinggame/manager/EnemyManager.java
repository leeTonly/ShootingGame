package com.example.a77266.shootinggame.manager;

import android.graphics.Canvas;
import android.view.View;

import com.example.a77266.shootinggame.entity.Enemy;

import java.util.ArrayList;

/**
 * Created by LinLiQiang on 2016-8-13 13:32.
 * Email : 772662623@qq.com
 * Function: 定义所有敌机，并提供绘制所有敌机的外部方法
 */
public class EnemyManager {

    ArrayList<Enemy> enemys = new ArrayList<>();
    private int j = 0;

    public EnemyManager(View view) {
        for(int i = 0; i < 10; i++) {
            enemys.add(new Enemy(view));
        }
    }

    public void drawEnemys(Canvas canvas, int iPlayerX) {
        for(Enemy enemy : enemys) {
            enemy.moveTo(iPlayerX);
            if(!enemy.getifDied()) {
                enemy.drawSelf(canvas);
                enemy.fire();
                enemy.enemyBoomCheck();
            }
        }
    }



}
