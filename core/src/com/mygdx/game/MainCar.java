package com.mygdx.game;

public class MainCar {

    float width, height;
    float x,y;
    float dx,dy;
    float vx=6;

    boolean isAlive = true;

    public MainCar(float x, float y, float width, float height) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    void drive(float tx,float ty){
        if (tx>x)x+=vx;
        if (tx<x)x-=vx;
        //if (tx>x) dx++;
        //if (tx<x) dx--;
}

    void move(){
        x += dx;
        y += dy;
        if (x<width/2+1){
            dx = 0;
            x = width/2;
        }
        if (x> MainGame.SCR_WIDTH-width/2){
            dx = 0;
            x = MainGame.SCR_WIDTH-width/2;


        }
    }
}