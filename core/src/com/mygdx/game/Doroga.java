package com.mygdx.game;

public class Doroga {
    float x,y;
        float width, height;
        float dy;

        public Doroga (float x, float y){
            this.x=x;
            this.y=y;
            width = MainGame.SCR_WIDTH;
            height = MainGame.SCR_HEIGHT;
            dy=-3;
        }

        void move() {
            y += dy;
            if (y < -MainGame.SCR_HEIGHT) y = MainGame.SCR_HEIGHT;
        }
    }


