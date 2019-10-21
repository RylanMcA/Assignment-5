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
		if(s instanceof RobberAuto){
			for(int x = 0; x<60;x++){
				if(getX()+x == s.getX()+x){
					System.out.println("Overlap");
					return true;
				}

				if(getY()+x == s.getY()+x){
					System.out.println("Overlap");
					return true;
				}
			}
		}
		return false;
	}
	
	public void updateImage(Graphics g) {
		g.drawImage(getImage(), getX(), getY(), 60, 60, null);
	}

	public void updateState(int w, int h){
		//empty for now
	}
}