package com.mygdx.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Main;

public class Scene extends Actor {
    private Texture img;
    private Group group;
    private Stage stage;


    private float x,y;


    public float getSceneX() {
        return x;
    }

    public void setSceneXY(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public float getSceneY() {
        return y;
    }

    public float getSceneWidth(){
        return img.getWidth()*2.1f;
    }



    public Scene(final Texture img) {
        x=0;
        y=0;
        stage = new Stage();
        group=new Group();
        this.img = img;

        class SceneActor extends Actor{
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.draw(img,getX(),getY());
            }
        }
        SceneActor sceneActor = new SceneActor();
        sceneActor.setPosition(0,0);
        group.setBounds(0,0,this.img.getWidth(),this.img.getHeight());
        group.addActor(sceneActor);
        stage.addActor(group);
    }



    public void setGroup(Actor actor) {
        this.group.addActor(actor);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        group.setPosition(x,y);
        batch.begin();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        batch.end();
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
