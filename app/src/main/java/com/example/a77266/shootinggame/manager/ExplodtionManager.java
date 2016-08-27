package com.example.a77266.shootinggame.manager;

import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.view.View;

import com.example.a77266.shootinggame.R;
import com.example.a77266.shootinggame.entity.Explodtion;

import java.util.ArrayList;

/**
 * Created by LinLiQiang on 2016-8-25 21:58.
 * Email : 772662623@qq.com
 * Function: 实例敌机数一样的Explode，提供绘制所有爆炸、获取单个Explode的外部方法
 */
public class ExplodtionManager {

    private MediaPlayer mediaPlayer = null;

    public static ArrayList<Explodtion> explodtions = new ArrayList<>();

    public ExplodtionManager(View view) {
        mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.explosion);
        for(int i = 0; i < 10; i++) {
            explodtions.add(new Explodtion(view));
        }
    }

    public static Explodtion getOneExplodtion() {
        for(Explodtion explodtion : explodtions) {
            if(!explodtion.isBifExploded()) {
                return explodtion;
            }
        }
        return null;
    }

    public void drawExplodtions(Canvas canvas) {
        for(Explodtion explodtion : explodtions) {
            if(explodtion.isBifExploded()) {
                explodtion.drawExplodtion(canvas);
                mediaPlayer.start();
            }
        }
    }
}
