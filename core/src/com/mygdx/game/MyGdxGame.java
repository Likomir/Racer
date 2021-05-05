package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public class MyGdxGame extends ApplicationAdapter {
    public static final int SCR_HEIGHT = 800, SCR_WIDTH = 800;
    SpriteBatch batch;
    OrthographicCamera camera;
    Vector3 touchPos;
    BitmapFont font;

    private MainCar car;
    Array<> enemy = new Array<>();
    Texture img;
    Texture imgCar1;
    Texture imgCar2[] = new Texture[2];
    Doroga doroga[] = new Doroga[2];

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
        touchPos = new Vector3();

        imgCar1 = new Texture("carm.png");
        imgCar2[0] = new Texture("carre.png");
        img = new Texture("doroga.png");
        doroga[0] = new Doroga(0, 0);
        doroga[1] = new Doroga(0, SCR_HEIGHT);
        car = new MainCar(SCR_WIDTH/5*4,SCR_HEIGHT/6,100,220);
    }

    @Override
    public void render() {
        if (Gdx.input.isTouched()) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            car.drive(touchPos.x,touchPos.y);
        }
        for (int i = 0; i < 2; i++) doroga[i].move();
		car.move();

        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        for (int i = 0; i < 2; i++)
            batch.draw(img, doroga[i].x, doroga[i].y, doroga[i].width, doroga[i].height);
        batch.draw(imgCar1, car.x,car.y,car.width,car.height);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        imgCar1.dispose();
    }
}
