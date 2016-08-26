package com.example.a77266.shootinggame.manager;

import android.graphics.Canvas;
import android.view.View;

import com.example.a77266.shootinggame.entity.Explodtion;

import java.util.ArrayList;

/**
 * Created by LinLiQiang on 2016-8-25 21:58.
 * Email : 772662623@qq.com
 */
public class ExplodtionManager {

    public static ArrayList<Explodtion> explodtions = new ArrayList<Explodtion>();

    public ExplodtionManager(View view) {
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
            }
        }
    }
}
