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

public class Engine{
    private String desc;
    private int Mpg;
    private int MaxSpeed;
    
    public Engine(String desc, int mpg, int max){
        //Checking DESCRIPTION String
        if(desc.length() == 0){
            this.desc = "Generic engine";
        } else {
            this.desc = desc;
        }

        //Checking MILES PER GALLON int
        if(mpg < 0){
            this.Mpg = 0;
        } else {
            this.Mpg = mpg;
        }

        //Checking MAX SPEED int
        if(max < 0){
            this.MaxSpeed = 0;
        } else {
            this.MaxSpeed = max;
        }
    }

    public String getDescription(){
        return desc+" (MPG: "+Mpg+", Max speed: "+ MaxSpeed+")";
    }
    public int getMpg(){
        return Mpg;
    }
    public int getMaxSpeed(){
        return MaxSpeed;
    }

}