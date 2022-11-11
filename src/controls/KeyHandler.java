package controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GamePanel;

public class KeyHandler	implements KeyListener {
	
	public boolean upPressed, pausePressed;
	GamePanel gp;
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	
	@Override
	public void keyPressed(KeyEvent e) {
		// retrieves the key code of the key pressed
		int code = e.getKeyCode(); 
		
		if (code == KeyEvent.VK_UP && gp.activeScreen.equals("Running Screen")) { 
			pausePressed = true;
			
			// add !gp.activeScreen.equals("Start Screen) && !gp.activeScreen.equals(End Screen)
		} else if (code == KeyEvent.VK_SPACE && !gp.activeScreen.equals("Start Screen") && !gp.activeScreen.equals("End Screen")) {
			upPressed = true;
		}	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_UP) { 
			pausePressed = false;
			
		} else if (code == KeyEvent.VK_SPACE) {
			upPressed = false;
		}
	}
	
}
