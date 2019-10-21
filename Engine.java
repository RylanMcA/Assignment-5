/*
Name: Rylan McAlsiter
Date: 8-10-19
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