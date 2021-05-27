package com.mygdx.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Animations;
import com.mygdx.game.Screens.GameScreen;
import com.mygdx.game.Traffic.Point2d;

import java.util.Random;

public class Npc extends GameCharacter {

    Texture  texture;
    Point2d point2d;
    Player player;
    Location location;
    GameScreen screen;
    Random random = new Random();
    float time=0;



    public Npc(Texture texture, GameScreen screen) {
        this.texture= texture;
        this.screen=screen;
        animations =new Animations(texture);
        animations.setPosition(Gdx.graphics.getWidth()/3,50);
        animations.setSize(texture.getWidth()/4*2.1f,texture.getHeight()/2*2.1f);
        point2d=new Point2d(this, screen.getLocation());
        location=screen.getLocation();
        player = screen.getPlayer();
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        time +=Gdx.graphics.getDeltaTime();

        if (touching == false) {
            if (animations.getCurrentAnimations() == 1) {
                animations.setCurrentAnimations(0);
            } else {
                animations.setCurrentAnimations(1);
            }
            touching = true;
        }
        else {
                if(time>=5 && random.nextInt(1000)<2){
                    if (animations.getCurrentAnimations() == 1) {
                        animations.setCurrentAnimations(0);
                    } else {
                        animations.setCurrentAnimations(1);
                    }
                    time=0;
                }
        }

        if(animations.getCurrentAnimations()==0){
            point2d.TrafficActorRight();
        } else  {
            point2d.TrafficActorLeft(location.getLocX());
        }
        animations.update((SpriteBatch) batch);
        effect(player);
        super.draw(batch, parentAlpha);
    }

    public void effect(Player player) {
        if(player.animations.getBoundingRectangle().overlaps(this.animations.getBoundingRectangle())) {
            screen.dispose();
        }
    }

    /*  @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.setPosition(getX(),getY());
        sprite.draw(batch);
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public void CrossingNpc(Player player){
        //Gdx.app.log("d",player.animations.getBoundingRectangle()+" "+sprite.getBoundingRectangle());
        if(player.animations.getBoundingRectangle().overlaps(sprite.getBoundingRectangle()))
        {
           *//* Gdx.input.getTextInput(new Input.TextInputListener() {
                @Override
                public void input(String text) {

                }

                @Override
                public void canceled() {

                }
            },"dialogue","Hello","");*//*
           Gdx.app.log("npc","sprite");
        }
    }*/
}
