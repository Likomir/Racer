package com.mygdx.game;

public class Doroga {
    float x,y;
        float width, height;
        float dy;

        public Doroga (float x, float y){
            this.x=x;
            this.y=y;
            width = MyGdxGame.SCR_WIDTH;
            height = MyGdxGame.SCR_HEIGHT;
            dy=-3;
        }

        void move() {
            y += dy;
            if (y < -MyGdxGame.SCR_HEIGHT) y = MyGdxGame.SCR_HEIGHT;
        }
    }


