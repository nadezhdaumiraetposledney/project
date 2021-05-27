package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Main;

public class EndScreen implements Screen {

    private Main main;
    OrthographicCamera camera;
    int count;
    float time;

    public EndScreen(Main main,int count, float time) {
        this.main = main;
        this.count=count;
        this.time=time;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0.2f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        main.getBatch().setProjectionMatrix(camera.combined);
        main.getBatch().begin();
        main.getFont().setColor(1f,0.7f,0.7f,0.5f);
        main.getFont().getData().setScale(2,2);
        main.getFont().draw(main.getBatch(), string, 100, 300);
        main.getFont().getData().setScale(1,1);
        main.getFont().draw(main.getBatch(), "penguins collected: "+ count, 300, 300);
        main.getFont().draw(main.getBatch(), "elapsed time: "+ time, 300, 200);
        main.getBatch().end();
        if (Gdx.input.justTouched()){

            main.setScreen(new MenuScreen(main));
            dispose();
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
