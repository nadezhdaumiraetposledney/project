package com.mygdx.game.Actors;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.Screens.GameScreen;

public class Object extends Sprite {
    TextureRegion texture;
    Player player;
    GameScreen screen;
    float x, y;

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setPos(float x, float y){
        this.setPosition(this.x+x,this.y+y);
    }

    public Object(TextureRegion texture, GameScreen screen) {
        this.texture=texture;
        this.screen=screen;
        player=screen.getPlayer();
    }

    public void update(SpriteBatch batch, Actor actor, float x, float y) {
        if(player.animations.getBoundingRectangle().overlaps(this.getBoundingRectangle()))
        {
            screen.setSelectedActor(actor);
        }
        batch.draw(texture,x,y);
    }
}

