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
import java.util.Random;

public class CopAuto extends Auto{
    private static int xRatio;
    private static int yRatio;

    public CopAuto(){
        super("Cop Car", 30, new Engine("C4", 30, 100), "cop-auto.jpg");
        Random r = new Random();
        this.xRatio = r.nextInt(11)-5;
        this.yRatio = r.nextInt(11)-5;
        this.fillUp();
    }

    @Override
    public void update(Graphics g){
        this.drive(20, this.xRatio, this.yRatio);
        super.update(g);
    }
}