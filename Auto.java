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

public class Auto extends Sprite{
    private String desc;
    private GasTank tank;
    private Engine engine;

    public Auto(String desc, int maxFuel, Engine newEngine, String car){
        super(car);
        tank = new GasTank(maxFuel);

        //Checking DESC 
        if(desc.length() == 0){
            this.desc = "Generic Auto";
        } else {
            this.desc = desc;
        }

        //Checking ENGINE
        if(newEngine == null){
            this.engine = new Engine("",0,0);
        } else {
            this.engine = newEngine; 
        }
    }

    public String getDescription(){
        String test = desc+" (Engine: "+engine.getDescription()+"), "+
        String.format("fuel: %.2f/",this.tank.getLevel())+this.tank.getCapacity()
        + " location: ("+getX() + "," + getY()+")";
        return test;
    }

    public double getFuelLevel(){
        return tank.getLevel();
    }

    public int getMPG(){
        return engine.getMpg();
    }

    public void fillUp(){
        tank.setLevel(tank.getCapacity());
    }

    public int getMaxSpeed(){
        return engine.getMaxSpeed();
    }

    //Equations Source: Geeks for Geeks
    //x=x(i) +- d*math.sqrt(1/(1+(m*m)))
    //y=y(i) +- m*d*math.sqrt(1/(1+(m*m)))
    //Returns miles driven.
    public double drive(int distance, double xRatio, double yRatio){
        if(distance <= tank.getLevel()*engine.getMpg()){
            double gasUsed = (double)distance/engine.getMpg();
            tank.setLevel(tank.getLevel()-gasUsed); 
        } else {
            distance = (int) (tank.getLevel()*engine.getMpg());
            double d = distance;
            System.out.println(String.format("The car drove %.2f before running running out of gas",d));
            tank.setLevel(-1);
        }
        
        double m = 0;
        if(xRatio == 0){
            m = 0;
        } else {
            m = (yRatio/xRatio);
        }   
        if(xRatio < 0){ //x is negative
            this.setX( this.getX() - (int) (distance*Math.sqrt(1/(1+m*m))) );
            this.setY( this.getY() - (int) (m*distance*Math.sqrt(1/(1+m*m))) );
        } else { //x is positive. 
            this.setX( this.getX() + (int) (distance*Math.sqrt(1/(1+(m*m)))) );
            this.setY( this.getY() + (int) (m*distance*Math.sqrt(1/(1+(m*m)))) );
        }
        return distance;
    }

    @Override
    public void update(final Graphics graphics) {
        super.update(graphics);
    }
}