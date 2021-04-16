package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Actors.Npc;
import com.mygdx.game.Actors.Player;
import com.mygdx.game.Actors.Scene;
import com.mygdx.game.Screens.GameSc;
import com.mygdx.game.Traffic.Point2d;

public class Main extends Game {

	public SpriteBatch batch;
	public Texture img;
	public Player player;
	private Texture[] pengTexture;
	public Scene scene1;
	public Point2d point2d;
	public Npc npc;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new GameSc(this));
		Gdx.gl.glClearColor(1f, 1f, 1f, 1);

		pengTexture=new Texture[3];
		pengTexture[0]=new Texture(Gdx.files.internal("pengwalk.png"));
		pengTexture[1]=new Texture(Gdx.files.internal("pengwalkleft.png"));
		pengTexture[2]=new Texture(Gdx.files.internal("pengst.png"));
		player = new Player(pengTexture,"player");

		npc=new Npc(new Texture("pengst.png"));
		npc.setPosition(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()/10);
		scene1= new Scene(new Texture("fon.jpg"));
		scene1.setGroup(npc);

		point2d= new Point2d(player,scene1);
	}

	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
