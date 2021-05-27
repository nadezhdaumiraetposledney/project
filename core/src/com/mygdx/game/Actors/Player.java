package com.mygdx.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.Animations;


public class Player extends GameCharacter {

Texture [] textures;



    public Player(Texture[] texture, final String name) {
        this.textures= texture;
        animations =new Animations(textures[0]);
        setActorXY(Gdx.graphics.getWidth()/3,50);
        animations.setSize(new Texture(Gdx.files.internal("pengst.png")).getWidth()*2.1f,new Texture(Gdx.files.internal("pengst.png")).getHeight()*2.1f);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (Gdx.input.getX() > Gdx.graphics.getWidth() / 2 && animations.getCurrentAnimations()!=0) {
            animations.setCurrentAnimations(0);
        } else if(Gdx.input.getX() < Gdx.graphics.getWidth() / 2 && animations.getCurrentAnimations()!=1){
            animations.setCurrentAnimations(1);
        }
        if (Gdx.input.isTouched() && touching) {
            animations.update((SpriteBatch) batch);
        }
        else {
            batch.draw(textures[1],animations.getX(),animations.getY(),animations.getWidth(),animations.getHeight());
        }
        super.draw(batch, parentAlpha);
    }

}
