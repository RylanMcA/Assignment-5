/*
Name: Rylan McAlsiter
Date: 8-10-19
*/

import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


class Sprite
{
	private String jpgName;
	private int locationX;
	private int locationY;
	private Image image;

	public Sprite(String jpgName)
	{
		setImage(jpgName);
		locationX = 0;
		locationY = 0;
	}
	
	public int getX() {	return locationX; }
	public int getY() {	return locationY; }
	public void setX(int x) { locationX = x; }
	public void setY(int y) { locationY = y; }
	
	public void setImage(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException ioe) {
            System.out.println("Unable to load image file.");
        }
	}
	public Image getImage() { return image; }	

	public boolean overlaps(Sprite s){
		if((getX()-60 < s.getX() && s.getX() < getX()+60) 
		&& (getY()-60 < s.getY() && s.getY() < getY()+60)){
			if(s instanceof RobberAuto && !s.isCaptured()){
				System.out.println("Gotcha!");
				s.captured();
			}
			return true;
		}
		return false;
	}
	
	public void captured(){		}
	public boolean isCaptured(){	return false;	}

	public void updateImage(Graphics g) {
		g.drawImage(getImage(), getX(), getY(), 60, 60, null);
	}

	public void updateState(int w, int h){
		//empty for now
	}
}