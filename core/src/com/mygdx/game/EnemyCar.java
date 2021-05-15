package com.mygdx.game;

import com.badlogic.gdx.math.MathUtils;


public class EnemyCar {
    int type;

    float x, y;
    float width, height;
    float dx, dy;
    boolean isAlive = true;

    public EnemyCar(float x, float y, float width){
        type = MathUtils.random(0,1);
        if (type == 0) dy = MathUtils.random(-4,-3);
        else dy = MathUtils.random(-5,-4);
        this.width = height = width;

    }

    void move(){
        x += dx;
        y += dy;
    }

}
