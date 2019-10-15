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

public class GasTank{
    private int capacity = 0;
    private double level = 0;

    public GasTank(int cap){
        
        if(cap <= 0){
            capacity = 0;
        } else {
            this.capacity = cap;
        }
        this.level = 0;
    }

    public int getCapacity(){
        return capacity;
    }

    public double getLevel(){
        return level;
    }

    public void setLevel(double levelIn){
        if(levelIn < 0){
            level = 0;
        } else if(levelIn > capacity){
            level = capacity;
        } else {
            level = levelIn;
        }
    }
}