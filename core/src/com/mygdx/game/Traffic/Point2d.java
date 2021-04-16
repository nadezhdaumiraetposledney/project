package com.mygdx.game.Traffic;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.Actors.Player;
import com.mygdx.game.Actors.Scene;

public class Point2d {
   Player player;
   Scene scene;

   public Point2d(Player player, Scene scene) {
      this.player = player;
      this.scene = scene;
   }

   public void Traffic (){
      if(Gdx.input.isTouched()){
         if (Gdx.input.getX() > Gdx.graphics.getWidth() / 2 )
         {
            Gdx.app.log("log",scene.getSceneX()+" "+Gdx.graphics.getWidth());
            if(scene.getSceneWidth()/3+scene.getSceneX()>Gdx.graphics.getWidth() && player.getPengX()>=Gdx.graphics.getWidth()/3) {
               scene.setSceneXY(- 10,0);
            }
            else {
               if(player.getPengX()+ player.getPengWidth()<=Gdx.graphics.getWidth()) {
                  player.setPengXY(10, 0);
                  player.setTouching(true);
               }
               else {
                  player.setTouching(false);
               }
            }
         }
         else {
            if(scene.getSceneX()<=0 && player.getPengX()<=Gdx.graphics.getWidth()/3) {
               scene.setSceneXY(10,0);
            }
            else {
               if (player.getPengX()>=0){
               player.setPengXY(-10,0);
               player.setTouching(true);
            }
               else {
               player.setTouching(false);
            }
            }
         }
      }
   }
}
