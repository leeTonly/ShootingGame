package com.example.a77266.shootinggame.entity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.view.View;

import com.example.a77266.shootinggame.R;
import com.example.a77266.shootinggame.manager.EnemyBulletManager;
import com.example.a77266.shootinggame.manager.ExplodtionManager;
import com.example.a77266.shootinggame.manager.PlayerBulletManager;
import com.example.a77266.shootinggame.util.BoomCheck;

import java.io.IOException;
import java.util.Random;

/**
 * Created by LinLiQiang on 2016-8-12 20:40.
 * Email : 772662623@qq.com
 */
public class Enemy {
    private Bitmap enemy = null;
    private int x = 0;
    private int y = 0;

    private int dx = 0;
    private int dy = 0;

    private int i = 0;

    private MediaPlayer mediaPlayer = null;

    private boolean ifDied = false;

    private int iWinWidth = 0;
    private int iWinHeight = 0;

    private boolean bisRight = true;

    public Enemy(View view) {
        i = 0;

        mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.explosion);
//        try {
//            mediaPlayer.prepare();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        x = new Random().nextInt(view.getWidth());
        y = new Random().nextInt(50) - 100;
        dx = new Random().nextInt(5);
        dy = new Random().nextInt(5) + 4;

        iWinHeight = view.getHeight();
        iWinWidth = view.getWidth();

        enemy = BitmapFactory.decodeResource(view.getResources(),
                R.drawable.enemy1);

    }

    public void drawSelf(Canvas canvas) {
        canvas.drawBitmap(enemy, x, y, null);
    }

    public void moveTo(int iPlayerX) {
        /**
         * 在玩家飞机两边设置两条隐藏界线，
         * 当敌机飞到玩家附近，则会一直在两条界线内移动。
         * */
        if(iPlayerX + 200 < x) {
            if(bisRight)
                bisRight = false;
            x -= dx;
        } else if(iPlayerX - 200 > x) {
            if(!bisRight)
                bisRight = true;
            x += dx;
        } else {
            if(bisRight)
                x += dx;
            else
                x -= dx;
        }

        y += dy;

        if(this.ifDied || x < -enemy.getWidth() || x > iWinWidth || y > iWinHeight) {
            x = new Random().nextInt(iWinWidth);
            y = new Random().nextInt(50) - 100;
            this.ifDied = false;
        }
    }

    public void fire() {
        if(i < 10) {
            i++;
        } else {
            i = 0;
            if(y > 0) {
                EnemyBullet enemyBullet = EnemyBulletManager.getOneEnemyBullet();
                if(enemyBullet != null) {
                    enemyBullet.setPosition(x+(enemy.getWidth()-enemyBullet.getBulletWidth())/2,
                            y+enemy.getHeight());
                    enemyBullet.setDy(dy + 5);
                }
            }
        }
    }

    public boolean getifDied() {
        return ifDied;
    }

    public void enemyBoomCheck() {
        for(PlayerBullet playerBullet : PlayerBulletManager.getAllPlayerBullets()) {
            if(!this.ifDied
                    && playerBullet.isbDrawOrNot()
                    && BoomCheck.ifBoom(x, y,
                        x+enemy.getWidth(), y+enemy.getHeight(),
                        playerBullet.getX(), playerBullet.getY(),
                        playerBullet.getX()+playerBullet.getBulletWidth(), playerBullet.getY()+playerBullet.getBulletHeight())) {
                mediaPlayer.start();
                this.ifDied = true;
                playerBullet.setbDrawOrNot(false);
                Explodtion explodtion = ExplodtionManager.getOneExplodtion();
                explodtion.setPosition(x,y);
                explodtion.setBifExploded(true);
                //break;
            }

        }
    }

}
