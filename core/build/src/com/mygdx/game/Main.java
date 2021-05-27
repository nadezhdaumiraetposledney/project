package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mygdx.game.Screens.MenuScreen;

public class Main extends Game {
	private SpriteBatch batch;
	private BitmapFont font;

	public SpriteBatch getBatch() {
		return batch;
	}

	public BitmapFont getFont() {
		return font;
	}

	@Override
	public void create () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1f, 1f, 1f, 1);
		batch = new SpriteBatch();
		font = new BitmapFont();
		setScreen(new MenuScreen(this));
	}

	@Override
	public void dispose () {
		screen.dispose();
	}
}
