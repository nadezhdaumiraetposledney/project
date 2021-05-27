package com.mygdx.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.Animations;

public class GameCharacter extends Actor {
    Animations animations;
    boolean touching=true;

    public float getActorX() {
        return animations.getX();
    }

    public void setActorXY(float x, float y) {
        animations.setPosition(x,y);
    }

    public float getActorY() {
        return animations.getY();
    }

    public float getActorWidth(){
        return animations.getWidth();
    }

    public void setTouching(boolean touching) {
        this.touching = touching;
    }


    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
