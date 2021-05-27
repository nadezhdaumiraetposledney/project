package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureObject {
    public final TextureRegion[] textureObject;
    {
        Texture texture = new Texture(Gdx.files.internal("textures.png"));
        TextureRegion[][] tmp = TextureRegion.split(texture, texture.getWidth() / 3, texture.getHeight());
        textureObject = new TextureRegion[3];
        int index = 0;
            for(int j = 0; j < 3; ++j) {
                this.textureObject[index++] = tmp[0][j];
            }
    }

}
