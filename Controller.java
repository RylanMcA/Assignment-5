/*
Name: Rylan McAlsiter
Date: 8-10-19
*/

import java.awt.Graphics;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import javax.swing.SwingUtilities;
import java.lang.Thread;

class Controller implements MouseListener, KeyListener
{
    Model model;
    View view;

    Controller() throws IOException, Exception {
        model = new Model();
        view = new View(this);
    }

    public void update(Graphics g) {
        model.update(g);
    }

    public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
            model.addSprite(e.getX(),e.getY());
            view.repaint();
		} else if (SwingUtilities.isRightMouseButton(e))  {
            model.updateScene(view.getWidth(), view.getHeight());
            view.repaint();
        }
    }

    public void mouseReleased(MouseEvent e) {    }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseClicked(MouseEvent e) {    }

    public void keyTyped(KeyEvent e){
        if(e.getKeyChar() == 'n'){
            System.out.println("Captured: "+RobberAuto.captures+"\nEscaped: "+RobberAuto.escaped);

        } else if(e.getKeyChar() == 'r'){
            RobberAuto.captures = 0;
            RobberAuto.escaped = 0;
            model.initialize();
            view.repaint();

        } else if(e.getKeyChar() == 's'){
            Thread thread = new Thread(new SpriteMover(model,view));
            thread.start();
        }
    }

    public void keyReleased(KeyEvent e){      }
    public void keyPressed(KeyEvent e){       }

    public static void main(String[] args) throws Exception {
        new Controller();
    }
}

