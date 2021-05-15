package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class MainGame extends ApplicationAdapter {
    public static final int SCR_HEIGHT = 800, SCR_WIDTH = 800;
    SpriteBatch batch;
    OrthographicCamera camera;
    Vector3 touchPos;
    BitmapFont font;

    private MainCar car;
    Array<EnemyCar> enemy = new Array<>();
    Texture img;
    Texture imgCar;
    Texture imgCar2[] = new Texture[2];
    Doroga doroga[] = new Doroga[2];

    long timeFromStartGame;
    long timeSpawnEnemyInterval = 1500;
    long timeLastSpawnEnemy = 3000;

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
        touchPos = new Vector3();

        imgCar = new Texture("carm.png");
        imgCar2[0] = new Texture("carre.png");
        img = new Texture("doroga.png");
        doroga[0] = new Doroga(0, 0);
        doroga[1] = new Doroga(0, SCR_HEIGHT);
        car = new MainCar(SCR_WIDTH / 5 * 4, SCR_HEIGHT / 6, 120, 250);

        timeFromStartGame = TimeUtils.millis();
        System.out.println(timeFromStartGame);
    }

    @Override
    public void render() {
        if (Gdx.input.isTouched()) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            car.drive(touchPos.x, touchPos.y);
        }

        if (TimeUtils.millis() - timeLastSpawnEnemy >= timeSpawnEnemyInterval)
            spawnEnemy();
        for (int i = 0; i < enemy.size; i++) {
            enemy.get(i).move();
            if (!enemy.get(i).isAlive) enemy.removeIndex(i);
        }
        car.move();
        for (int i = 0; i < 2; i++) doroga[i].move();

        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        for (int i = 0; i < 2; i++)
            batch.draw(img, doroga[i].x, doroga[i].y, doroga[i].width, doroga[i].height);
        batch.draw(imgCar, car.x, car.y, car.width, car.height);

        //for (int i=0; i<enemy.size; i++)
            //batch.draw(imgCar2[enemy.get(i).type], enemy.get(i).x-enemy.get(i).width/2, enemy.get(i).y-enemy.get(i).height/2,
                    //enemy.get(i).width, enemy.get(i).height);
        batch.end();
    }
        void spawnEnemy () {
            float w = 100;
            enemy.add(new EnemyCar(MathUtils.random(w / 2, SCR_WIDTH - 50), SCR_HEIGHT + w, w));
            timeLastSpawnEnemy = TimeUtils.millis();
        }
        @Override
        public void dispose () {
            batch.dispose();
            img.dispose();
            imgCar.dispose();
        }
    }