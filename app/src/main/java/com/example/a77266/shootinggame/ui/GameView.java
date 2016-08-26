package com.example.a77266.shootinggame.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.a77266.shootinggame.entity.EnemyBullet;
import com.example.a77266.shootinggame.manager.BackgroundManager;
import com.example.a77266.shootinggame.manager.EnemyBulletManager;
import com.example.a77266.shootinggame.manager.EnemyManager;
import com.example.a77266.shootinggame.manager.ExplodtionManager;
import com.example.a77266.shootinggame.manager.PlayerBulletManager;
import com.example.a77266.shootinggame.manager.PlayerManager;

/**
 * Created by LinLiQiang on 2016-8-11 19:00.
 * Email : 772662623@qq.com
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback, Runnable{

    private static final String TAG = "GameView";

    private Canvas canvas = null;
    private SurfaceHolder sh = null;
    private boolean bisRunning = true;

    private BackgroundManager backgroundManager = null;
    private PlayerManager playerManager = null;
    private EnemyManager enemyManager = null;
    private PlayerBulletManager playerBulletManager = null;
    private EnemyBulletManager enemyBulletManager = null;
    private ExplodtionManager explodtionManager = null;

    public GameView(Context context) {
        super(context);
        this.setFocusable(true);
        sh = this.getHolder();
        sh.addCallback(this);
    }

    private void drawView() {
        try {
            if(sh != null) {
                canvas = sh.lockCanvas();
                canvas.drawColor(Color.BLACK);
                backgroundManager.drawBackground(canvas);
                enemyManager.drawEnemys(canvas, playerManager.getPlayer().getX());
                enemyBulletManager.drawEnemyBullet(canvas);
                explodtionManager.drawExplodtions(canvas);
                playerManager.drawPlayer(canvas);
                playerBulletManager.drawPlayerBullet(canvas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(canvas != null) {
                sh.unlockCanvasAndPost(canvas);
            }
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.d(TAG, "surfaceCreated");
        backgroundManager = new BackgroundManager(this);
        playerManager = new PlayerManager(this);
        enemyManager = new EnemyManager(this);
        playerBulletManager = new PlayerBulletManager(this);
        enemyBulletManager = new EnemyBulletManager(this);
        explodtionManager = new ExplodtionManager(this);
        new Thread(this).start();
        bisRunning = true;
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        Log.d(TAG, "surfaceChanged");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Log.d(TAG, "surfaceDestroyed");
        bisRunning = false;
    }

    @Override
    public void run() {
        while(bisRunning) {
            drawView();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK)
            bisRunning = false;
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        playerManager.moveTo((int)event.getX(), (int)event.getY());
        return super.onTouchEvent(event);
    }
}
