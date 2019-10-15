/*
Name: Rylan McAlsiter
Date: 8-10-19
Description: This program will open a window with a cop car driving around first.
When the left mouse is clicked, a red car will drive around the screen.
Clicking again will make a cop car. Clicking more will alternate between red and cop.

The cars will drive till they run out of gas.

Right clicking will refill all the car's gas tanks and they will continue driving.

The program will close when the user hits the x at the top right
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
      type = 1;
      sprite.add(new CopAuto());
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
    }

    public void update(Graphics g){
      //Allows each of the autos to be displayed.
      for(Sprite s : sprite){
        s.update(g);
      }
    }

    public void fillUps(){
      			for(int i = 0; 0<sprite.size();i++){
                ((Auto) sprite.get(i)).fillUp();
            }
    }

}
