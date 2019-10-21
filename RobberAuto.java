/*
Name: Rylan McAlsiter
Date: 8-10-19
*/

import java.awt.Graphics;
import java.util.Random;

public class RobberAuto extends Auto{
    private int xRatio;
    private int yRatio;

    public RobberAuto(){
        super("Robber Car", 5000, new Engine("MACH 4", 20, 200), "red-auto.jpg");
        Random rand = new Random();
        this.xRatio = rand.nextInt(11)-5;
        this.yRatio = rand.nextInt(11)-5;
        this.fillUp();
    }

    @Override
    public void updateImage(Graphics g){
        super.updateImage(g);
    }

    @Override
    public void updateState(int w, int h){
        this.drive(40, this.xRatio, this.yRatio);
                //Checks for bouncing
                if(getX() < 0 ){
                    System.out.println("Escaped");
                }else if(getX()+60 > w){
                    System.out.println("Escaped");
                }
                
                if(getY() < 0 ){
                    System.out.println("Escaped");
                }else if(getY()+60 > h){
                    System.out.println("Escaped");
                }
	}
}