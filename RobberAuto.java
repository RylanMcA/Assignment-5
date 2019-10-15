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

public class RobberAuto extends Auto{
    private int xRatio;
    private int yRatio;

    public RobberAuto(){
        super("Robber Car", 20, new Engine("MACH 4", 20, 200), "red-auto.jpg");
        Random rand = new Random();
        this.xRatio = rand.nextInt(11)-5;
        this.yRatio = rand.nextInt(11)-5;
        this.fillUp();
    }

    @Override
    public void update(Graphics g){
        this.drive(40, this.xRatio, this.yRatio);
        super.update(g);
    }

}