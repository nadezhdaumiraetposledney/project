package com.mygdx.game.Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Npc extends Actor {
    Sprite sprite;
    private Texture npc_texture;

   // float x,y;

    public Npc(Texture npc_texture) {
        this.npc_texture = npc_texture;
        sprite = new Sprite(npc_texture);
       /* x= Gdx.graphics.getWidth();
        y=Gdx.graphics.getHeight()/10;*/
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(npc_texture,getX(),getY(),npc_texture.getWidth()*2.1f,npc_texture.getHeight()*2.1f);
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public void Crossing(Player player){
        if(player.sprite.getBoundingRectangle().overlaps(sprite.getBoundingRectangle()))
        {
        }
    }
}
