package com.mygdx.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.Animations;


public class Player extends Actor {
Sprite sprite;
Animations animations;
private Texture [] state;

private boolean touching=true;

    public void setTouching(boolean touching) {
        this.touching = touching;
    }

    private float x,y;

    public float getPengX() {
        return x;
    }

    public void setPengXY(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public float getPengY() {
        return y;
    }

    public float getPengWidth(){
        return state[2].getWidth()*2.1f;
    }


    public Player(Texture[] texture, final String name) {
        state = texture;
        x=Gdx.graphics.getWidth()/3;
        y=Gdx.graphics.getHeight()/10;
        sprite = new Sprite(state[0]);
        animations =new Animations(state[0]);
    }


    @Override
    public void act(float delta) {
        super.act(delta);

    }

    public void draw(SpriteBatch batch) {
        if(Gdx.input.justTouched()) {
            if (Gdx.input.getX() > Gdx.graphics.getWidth() / 2) {
                animations.setWalkSheet(state[0]); //right

            } else {
                animations.setWalkSheet(state[1]); //left

            }
        }
        if (Gdx.input.isTouched() && touching) {
            batch.begin();
            animations.update(batch,x,y);
            batch.end();
        }
        else {
            batch.begin();
            batch.draw(state[2],x,y,state[2].getWidth()*2.1f,state[2].getHeight()*2.1f);
            batch.end();
        }
    }
}
