package com.example.a77266.shootinggame.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

import com.example.a77266.shootinggame.R;

/**
 * Created by LinLiQiang on 2016-8-11 19:29.
 * Email : 772662623@qq.com
 */
public class BackgroundManager {

    private Rect srcRect = null;
    private Rect destRect = null;
    private Rect destRect2 = null;
    private int dy = 0;
    private int dy2 = 0;
    private int iStartY1 = 0;
    private int iStartY2 = 0;

    private int iWinX = 0;
    private int iWinY = 0;

    private Bitmap bitmap = null;
    private int iBitmapX = 0;
    private int iBitmapY = 0;


    public BackgroundManager(View view) {
        iWinX = view.getWidth();
        iWinY = view.getHeight();
        bitmap = BitmapFactory.decodeResource(view.getResources(),
                R.drawable.bg);

        iBitmapX = iWinX;
        iBitmapY = iWinX*bitmap.getHeight()/bitmap.getWidth();

        iStartY1 = iWinY - iBitmapY;
        iStartY2 = iStartY1 - iBitmapY;

        dy = 0;
        dy2 = iStartY2;

        System.out.println(String.format("iBitmapX=%d,iBitmapY=%d,iStartY1=%d,iStartY2=%d",iBitmapX,iBitmapY,iStartY1,iStartY2));

        srcRect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        destRect = new Rect(0, iStartY1, iWinX, iWinY);
        destRect2 = new Rect(0, iStartY2, iWinX, iStartY1);

    }

    public void drawBackground(Canvas canvas) {
        dy += 15;
        dy2 += 15;
        destRect.set(0, iStartY1 + dy, iWinX, iWinY+dy);
        destRect2.set(0, dy2, iWinX, dy2+iBitmapY);
        canvas.drawBitmap(bitmap, srcRect, destRect, null);
        canvas.drawBitmap(bitmap, srcRect, destRect2, null);

        if(dy >= iBitmapY) {
            dy = -iBitmapY;
            System.out.println(String.format("(0, %d, %d, %d)", iStartY1 -iBitmapY*iWinX/iBitmapX, iWinX, iWinY-iBitmapY*iWinX/iBitmapX));
        }
        if(dy2 >= iWinY) {
            dy2 = iStartY2;
            System.out.println(String.format("(0, %d, %d, %d)", iStartY1 -iBitmapY*iWinX/iBitmapX, iWinX, iStartY1));
        }
    }
}
