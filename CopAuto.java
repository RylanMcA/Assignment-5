/*
Name: Rylan McAlsiter
Date: 8-10-19
*/

import java.awt.Graphics;
import java.util.Random;
import java.lang.Math;

public class CopAuto extends Auto{
    private static int xRatio;
    private static int yRatio;
    private int pXRatio; //personal x ratio
    private int pYRatio; //personal y ratio

    public CopAuto(){
        super("Cop Car", 5000, new Engine("C4", 30, 100), "cop-auto.jpg");
        Random r = new Random();
        this.xRatio = r.nextInt(11)-5;
        this.yRatio = r.nextInt(11)-5;
        this.fillUp();
    }

    @Override
    public void updateImage(Graphics g){
        super.updateImage(g);
    }

    @Override
    public void updateState(int w, int h){ //x = w, y = h
        //See if I need to change the ratios 
        if(Math.abs(this.xRatio) != Math.abs(this.pXRatio)){
            this.pXRatio = this.xRatio;
        }
        if(Math.abs(this.yRatio) != Math.abs(this.pYRatio)){
            this.pYRatio = this.yRatio;
        }
        
        //Checks for bouncing
        if(getX() < 0 ){
            pXRatio *= -1;
        }else if(getX()+60 > w){
            pXRatio *= -1;
        }
        
        if(getY() < 0 ){
            pYRatio *= -1;
        }else if(getY()+60 > h){
            pYRatio *= -1;
        }

        //Drive the car the distance.
        this.drive(2, this.pXRatio, this.pYRatio);
	}
}