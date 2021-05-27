package com.mygdx.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Screens.GameScreen;
import com.mygdx.game.TextureObject;

import java.util.Random;

public class Location extends Stage {
Scene [][] scenes;
Group groupscenes;
Group group;

Random random = new Random();
final int[] sceneArr;
////////////////////////////////////

    TextureRegion[] textureRegions;
    private Stage stage;
    GameScreen screen;
    Scene randomScene;
    Scene scene;


    private float x,y;


    public float getLocX(float y) {
        if(y>=0 && y<=scenes[0][0].getSceneHeight()){
            return group.getX();
        }
        else {
            return group.getX()+groupscenes.getX();
        }
    }
    public float getLocX() {
            return group.getX()+groupscenes.getX();
    }


    public void setLocXY(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public float getLocY() {
        return y;
    }

    public float getLocWidth(float y){
        if( y<=scenes[0][0].getSceneHeight()){
            return group.getWidth();
        }
        if(y>=scenes[1][0].getGroup().getY() && y<=scenes[2][0].getGroup().getY()){
            return (scenes[1].length+1)*scenes[0][0].getSceneWidth();
        }
        return (scenes[2].length+1)*scenes[0][0].getSceneWidth();
    }

    public float getLocHeight(){
        return groupscenes.getHeight();
    }
    //////////////////////////////////////////

    public Location(Texture img, GameScreen screen) {
        Texture texture = new Texture("p.png");
        scene = new Scene(img);
        this.screen=screen;
        groupscenes = new Group();
        group=new Group();
        stage = new Stage();
        x=0;
        y=0;
        sceneArr=new int[20];

        textureRegions = new TextureObject().textureObject;
        groupscenes.setBounds(texture.getWidth(),0,texture.getWidth()*8,texture.getHeight()*3);
        group.setBounds(0,0,texture.getWidth()*9,texture.getHeight()*3);
        group.addActor(scene.getGroup());
        group.addActor(groupscenes);

        scenes = new Scene[3][];
        scenes[0]=new Scene[8];
        scenes[1]=new Scene[7];
        scenes[2]=new Scene[5];


        for (int i = 0; i < 8; i++) {
            scenes[0][i]=new Scene(texture);
            scenes[0][i].setScenePosition(scenes[0][i].getSceneWidth()*i,0);
            groupscenes.addActor(scenes[0][i].getGroup());
            sceneArr[i]=i;
        }
        for (int i = 0; i < 7; i++) {
            scenes[1][i]=new Scene(texture);
            scenes[1][i].setScenePosition(scenes[1][i].getSceneWidth()*i,scenes[0][0].getSceneHeight());
            groupscenes.addActor(scenes[1][i].getGroup());
            sceneArr[i+8]=i+10;
        }
        for (int i = 0; i < 5; i++) {
            scenes[2][i]=new Scene(texture);
            scenes[2][i].setScenePosition(scenes[2][i].getSceneWidth()*i,scenes[0][0].getSceneHeight()*2);
            groupscenes.addActor(scenes[2][i].getGroup());
            sceneArr[i+15]=i+20;
        }

        for (int i = 0; i < 7; i++) {
            int[] arr = sceneArr;
            randomScene = randomScene(scenes,arr);
            Object1 object = new Object1(textureRegions[0],screen,"peng");
            addObject(randomScene ,object,scenes[0][0].getSceneWidth()/3,50);
        }
        for (int i = 0; i < 5; i++) {
            int[] arr = sceneArr;
            int j = random.nextInt(arr.length);
            while (arr[j] < 8 ) {
                j = random.nextInt(arr.length);
            }
            Object2 object1 = new Object2(textureRegions[1],screen,"peng");
            Object2 object2 = new Object2(textureRegions[2],screen,"peng");
            addObject(scenes[arr[j] / 10][arr[j] % 10],object1,2*scenes[0][0].getSceneWidth()/3,Gdx.graphics.getHeight()/10);
            addObject(scenes[arr[j] / 10 - 1][arr[j] % 10],object2,2*scenes[0][0].getSceneWidth()/3,Gdx.graphics.getHeight()/10);
            object1.setObject2(object2);
            object2.setObject2(object1);
            arr[j]=-1;
            arr[SearchInArr(arr,arr[j]-10)]=-1;
        }
        stage.addActor(group);
    }


    @Override
    public void draw() {
        group.setPosition(x,y);
        if(screen.getPlayer().getActorX()<=groupscenes.getX()){
            groupscenes.setZIndex(0);
        }
        else {
           groupscenes.setZIndex(1);
        }
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        super.draw();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public Scene randomScene(Scene[][] scenes,int[] arr){
        int j = random.nextInt(arr.length);
        while (arr[j] < 0) {
            j = random.nextInt(arr.length);
        }
        int k = arr[j];
        arr[j]=-1;
        return scenes[k/10][k%10];
    }


    public void addObject(Scene scene,ObjectActor object, float x, float y){
        //randomScene = randomScene(scenes);
        scene.setGroup(object);
        object.setPosition(x,y);
        object.setObjectXY(object.getX()+scene.getSceneX()+groupscenes.getX(),object.getY()+scene.getSceneY());
    }
    public void addObject(int n,ObjectActor object, float x, float y){
        for (int i = 0; i < n; i++) {
            int[] arr = sceneArr;
            int j = random.nextInt(scenes.length);
            while (arr[j] < 0) {
                j = random.nextInt(scenes.length);
            }
            Scene scene = scenes[arr[j] / 10][arr[j] % 10];
            scene.setGroup(object);
            object.setPosition(x,y);
            object.setObjectXY(object.getX()+scene.getSceneX()+groupscenes.getX(),object.getY()+scene.getSceneY());
        }
    }

    public void addNpc(GameScreen screen){
        int k=random.nextInt(scenes.length);
        int m=random.nextInt(scenes[k].length-1)+1;
        Npc npc = new Npc(new Texture("seal.png"),screen);
        npc.setActorXY(scenes[k][m].getSceneX(),scenes[k][m].getSceneY());
        npc.animations.setdXY(groupscenes.getX(),groupscenes.getY());
        groupscenes.addActor(npc);
    }

    public void setGroup(Actor actor) {
        this.group.addActor(actor);
    }

    public int SearchInArr(int[] arr, int x){
        int i=0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j]==x) {
                i=j;
                break;
            }
        }
        return i;
    }
}
