package com.mygdx.game.Traffic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class SubjectProcessor implements InputProcessor {

    public boolean touch=false;
    public byte c=0;
    float y;

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
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        y=Gdx.input.getY();
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(y-Gdx.input.getY()>=100){
            touch=true;
            c=0;
        }
        if (Gdx.input.getY()-y>=100){
            touch=true;
            c=1;
        }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        /*if(Gdx.input.justTouched()){
        y=Gdx.input.getY();}*/
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
