package controls;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import main.GamePanel;

public class MouseHandler implements MouseListener{
	
	
	Rectangle okButton, startButton;
	GamePanel gp;
	public boolean restartClicked, startClicked;
	
	
	public MouseHandler(GamePanel gamePanel) {
		okButton = new Rectangle(161, 510, 128, 46);
		startButton = new Rectangle(161, 510, 128, 44);
		gp = gamePanel;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		int x = e.getX();
		int y = e.getY();
		
		if (okButton.contains(x, y) && gp.activeScreen.equals("End Screen")) {
			restartClicked = true;
			
		} else if (startButton.contains(x, y) && gp.activeScreen.equals("Start Screen")) {
			startClicked = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// resets all mouse clicks
		restartClicked = false;
		startClicked = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
