package com.example.a77266.shootinggame.entity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

import com.example.a77266.shootinggame.R;
import com.example.a77266.shootinggame.manager.PlayerBulletManager;

/**
 * Created by LinLiQiang on 2016-8-12 20:37.
 * Email : 772662623@qq.com
 * Function: player飞机类
 */
public class Player {
    /*player图片*/
    private Bitmap bitmap = null;

    /*player图片Rect和需要绘制的Rect*/
    private Rect srcRect = null;
    private Rect destRect = null;

    /*窗体宽高*/
    private int iWinWidth = 0;
    private int iWinHeight = 0;

    /*player坐标*/
    private int iPlayerX = 0;
    private int iPlayerY = 0;

    private int i = 0;

    public Player(View view) {
        /*获取当前窗口的宽高*/

        iWinWidth = view.getWidth();
        iWinHeight = view.getHeight();

        bitmap = BitmapFactory.decodeResource(view.getResources(),
                R.drawable.player);

        srcRect = new Rect(0,0,bitmap.getWidth(), bitmap.getHeight());
        destRect = new Rect((iWinWidth-bitmap.getWidth())/2,
                iWinHeight - bitmap.getHeight(),
                (iWinWidth-bitmap.getWidth())/2+bitmap.getWidth(),
                iWinHeight);

        iPlayerX = iWinWidth/2;
        iPlayerY = iWinHeight;
    }

    /*绘制player时，设置其子弹*/
    public void drawSelf(Canvas canvas) {
        if(i < 3) {
            i++;
        } else {
            i=0;
            fire();
        }
        canvas.drawBitmap(bitmap, srcRect, destRect, null);
    }

    /*设置player当前位置*/
    public void moveTo(int iPlayerX, int iPlayerY) {
        this.iPlayerX = iPlayerX;
        this.iPlayerY = iPlayerY;
        destRect.set(iPlayerX - bitmap.getWidth()/2,
                iPlayerY - bitmap.getHeight(),
                iPlayerX + bitmap.getWidth()/2,
                iPlayerY);
    }

    public int getX() {
        return iPlayerX;
    }

    /*获取player子弹实例，并设置player子弹的位置*/
    public void fire() {
        PlayerBullet playerBullet = PlayerBulletManager.getOnePlayerBullet();
        if(playerBullet != null) {
            playerBullet.setPosition(iPlayerX - playerBullet.getBulletWidth()/2,
                    iPlayerY - bitmap.getHeight() - playerBullet.getBulletHeight());
        }
    }
}
