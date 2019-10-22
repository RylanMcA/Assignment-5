/*
Name: Rylan McAlsiter
Date: 8-10-19
*/

import java.awt.Graphics;
import java.util.Random;

public class RobberAuto extends Auto{
    private int xRatio;
    private int yRatio;
    private boolean cap;
    private static int captures;
    private boolean esc;
    private static int escaped;

    public RobberAuto(){
        super("Robber Car", 5000, new Engine("MACH 4", 20, 200), "red-auto.jpg");
        Random rand = new Random();
        this.xRatio = rand.nextInt(11)-5;
        this.yRatio = rand.nextInt(11)-5;
        this.cap = false;
        this.captures = 0;
        this.esc = false;
        this.escaped = 0;
        this.fillUp();
    }

    @Override
    public void updateImage(Graphics g){
        super.updateImage(g);
    }

    @Override
    public void captured(){
        setImage("jail.jpg");
        this.cap = true;
        captures++;
    }

    @Override
    public boolean isCaptured(){
        return this.cap;
    }

    public boolean hasEscaped(){
        return this.esc;
    }

    @Override
    public void updateState(int w, int h){
        if (!esc && !esc){
            if(getX() < 0 ){
                System.out.println("Escaped!");
                escaped++;
                this.esc = true;
            }else if(getX()+60 > w){
                System.out.println("Escaped!");
                escaped++;
                this.esc = true;
            }
            
            if(getY() < 0 ){
                System.out.println("Escaped!");
                escaped++;
                this.esc = true;
            }else if(getY()+60 > h){
                System.out.println("Escaped!");
                escaped++;
                this.esc = true;
            }
        }

        if(!cap){
            this.drive(40, this.xRatio, this.yRatio);
        }

	}
}