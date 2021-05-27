package com.mygdx.game.Actors;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Screens.GameScreen;

public class Object2 extends ObjectActor {

    Object2 object2;
    Vector2 vector2;

    public float getOX() {
        return object.getX();
    }

    public float getOY() {
        return object.getY();
    }

    public void setObject2(Object2 object2) {
        this.object2 = object2;
    }

    public Object2(TextureRegion texture, GameScreen screen, String name) {
        super(texture, screen, name);
    }

    @Override
    public void effect() {
        object.screen.getLocation().setLocXY(getOX()-object2.getOX(), getOY()-object2.getOY());
        object.screen.getPlayer().setActorXY(object2.getOX()-getOX(),object2.getOY()-getOY());
        super.effect();
    }

}
