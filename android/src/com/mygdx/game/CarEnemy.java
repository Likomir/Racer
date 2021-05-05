package com.mygdx.game;

import com.badlogic.gdx.math.MathUtils;

public class CarEnemy {
    float x, y;
    float width, height;
    float dx, dy;
    boolean isAlive = true;

    void move(){
        x += dx;
        y += dy;
    }

}
