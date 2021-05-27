package com.mygdx.game.Actors;


import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.Screens.GameScreen;

public class ObjectActor extends Actor {
    public String name;
    Object object;
    TextureRegion texture;

    public void setObjectXY(float x, float y) {
        this.object.setPosition(x,y);
    }

    public ObjectActor(TextureRegion texture, GameScreen screen, String name) {
        this.texture=texture;
        object = new Object(texture,screen);
        object.setSize(texture.getRegionWidth(),texture.getRegionHeight());
        this.name = name;
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        object.update((SpriteBatch)batch,this,getX(),getY());
        //object.setPos(group.getX(),group.getY());
        //Gdx.app.log("s",subject.getX()+" "+subject.getY());
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public void effect() {}

}
