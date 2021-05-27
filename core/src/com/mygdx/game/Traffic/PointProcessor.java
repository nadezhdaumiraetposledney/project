package com.mygdx.game.Traffic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.game.Actors.GameCharacter;
import com.mygdx.game.Actors.Location;

public class PointProcessor extends Point2d implements InputProcessor {
    public boolean touch;

    public PointProcessor(GameCharacter character, Location location) {
        super(character, location);
    }


    public void Traffic (){
        if (Gdx.input.getX() > Gdx.graphics.getWidth() / 2 )
        {
            if(location.getLocWidth(character.getActorY())+location.getLocX(0)>Gdx.graphics.getWidth() && character.getActorX()>=Gdx.graphics.getWidth()/3-location.getLocX(0)) {
                location.setLocXY(- 10,0);
                character.setActorXY(10,0);
            }
            else TrafficActorRight();
        }
        else {
            if(location.getLocX(character.getActorY())<=0 && character.getActorX()<=Gdx.graphics.getWidth()/3-location.getLocX(0)) {
                location.setLocXY(10,0);
                character.setActorXY(-10,0);
            }
            else TrafficActorLeft(location.getLocX(character.getActorY()));
        }
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        touch = false;
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        touch = true;
        return false;
    }



    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
