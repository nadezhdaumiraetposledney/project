package com.mygdx.game.Traffic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.game.Actors.GameCharacter;
import com.mygdx.game.Actors.Location;
import com.mygdx.game.Actors.Player;
import com.mygdx.game.Actors.Scene;

public class Point2d {
   GameCharacter character;
   Location location;


   public Point2d(GameCharacter character, Location location) {
      this.character = character;
      this.location=location;
   }

   public void TrafficActorRight (){
            if(character.getActorX()+ character.getActorWidth()<=location.getLocWidth(character.getActorY())) {
               character.setActorXY(10, 0);
               character.setTouching(true);
            }
            else {
               character.setTouching(false);
            }
   }

   public void TrafficActorLeft (float x){

         if (character.getActorX()+location.getLocX(0)>=x){
            character.setActorXY(-10,0);
            character.setTouching(true);
         }
         else {
            character.setTouching(false);
         }
   }
}
