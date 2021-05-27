package com.mygdx.game.Actors;


import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Screens.GameScreen;

public class Object1 extends ObjectActor {


    public Object1(TextureRegion texture, GameScreen screen, String name) {
        super(texture, screen, name);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }


    public void effect() {
        remove();
        object.screen.setCount(1);
    }

}
