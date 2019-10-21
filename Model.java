/*
Name: Rylan McAlsiter
Date: 8-10-19
*/

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;


class Model
{
    public ArrayList<Sprite> sprite;
    private int type;

    Model() throws IOException {
      sprite = new ArrayList<Sprite>();
      type = 0; //0 spawns cop first, 1 spawns robber first
      sprite.add(new Bank());
    }

    public void addSprite(int x, int y){
      Auto e;

      //Type will alternate between 0 and 1 due to the type++ and type--
      if(type == 0){ //Spawns a cop car
        e = new CopAuto();
        type++;
      } else { //Spawns a red car.
        e = new RobberAuto();
        type--;
      }

      sprite.add(e); //adds it to the arraylist through polymorphism.

      //Places sprite where the mouse is clicked.
      sprite.get(sprite.size()-1).setX(x);
      sprite.get(sprite.size()-1).setY(y);

      if(e instanceof RobberAuto){
        sprite.get(sprite.size()-1).setX(300);
        sprite.get(sprite.size()-1).setY(300);
      }
    }

    public void update(Graphics g){
      //Allows each of the autos to be displayed.
      for(Sprite s : sprite){
        s.updateImage(g);
      }
    }

    public void updateScene(int w, int h){
      	for(int i = 1; i<sprite.size();i++){
          if(sprite.get(i) instanceof CopAuto){
            for(int j = 1; j<sprite.size(); j++){
              sprite.get(i).overlaps(sprite.get(j));
            }
          }
          sprite.get(i).updateState(w, h);
        }
    }

    
}
