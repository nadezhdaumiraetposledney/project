package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Actors.Location;
import com.mygdx.game.Actors.Npc;
import com.mygdx.game.Actors.ObjectActor;
import com.mygdx.game.Actors.Player;
import com.mygdx.game.Main;
import com.mygdx.game.Traffic.PointProcessor;
import com.mygdx.game.Traffic.SubjectProcessor;

public class GameScreen extends Stage implements Screen{
    Main main;
    OrthographicCamera camera;

    private Player player;
    private Texture[] pengTexture;
    private Actor selectedActor;
    private int count;
    {
        pengTexture=new Texture[2];
        pengTexture[0]=new Texture(Gdx.files.internal("pengwalk.png"));
        pengTexture[1]=new Texture(Gdx.files.internal("pengst.png"));
    }
    private PointProcessor pointProcessor;
    private SubjectProcessor subjectProcessor;
    private InputMultiplexer multiplexer;
    private Npc npc;
    private SpriteBatch batch;
    private Location location;
    private float time;


    public Location getLocation() {
        return location;
    }
    public void setCount(int count) {
        this.count += count;
    }

    public void setSelectedActor(Actor selectedActor) {
        this.selectedActor = selectedActor;
    }

    public Player getPlayer() {
        return player;
    }

    public GameScreen(Main main) {
        this.main=main;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        multiplexer = new InputMultiplexer();
        player = new Player(pengTexture,"player");
        subjectProcessor = new SubjectProcessor();
        location= new Location(new Texture("fon.png"),this);
        location.setGroup(player);

        for (int i = 0; i < 4; i++) {
            location.addNpc(this);
        }

        pointProcessor= new PointProcessor(player,location);
        count=0;
        multiplexer.addProcessor(pointProcessor);
        multiplexer.addProcessor(subjectProcessor);
        Gdx.input.setInputProcessor(multiplexer);
        batch = new SpriteBatch();
        time=0;
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        time +=Gdx.graphics.getDeltaTime();

        if(subjectProcessor.touch){
            if(selectedActor!=null){
                ((ObjectActor)selectedActor).effect();
                Gdx.app.log("d",count+"");
            }
            //subject1.Crossing(player);
            subjectProcessor.touch=false;
        }
        else {
            if (pointProcessor.touch) {
                pointProcessor.Traffic();
            }
        }
        selectedActor=null;
        player.act(Gdx.graphics.getDeltaTime());
        location.draw();
        main.getBatch().setProjectionMatrix(camera.combined);
        main.getBatch().begin();
        main.getFont().setColor(Color.WHITE);
        main.getFont().draw(main.getBatch(), count+"/7", 50, 50);
        main.getBatch().end();

        if (count==7 && location.getLocY()==0 && location.getLocX(player.getActorY())==0){
            main.setScreen(new GameScreen(main));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        main.setScreen(new EndScreen(main,count,time));
        location.dispose();
        batch.dispose();
        super.dispose();
    }
}
