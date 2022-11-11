package screens;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class PauseScreen implements Screen{
	
	GamePanel gp;
	BufferedImage pauseButton;
	
	public PauseScreen(GamePanel gp) {
		this.gp = gp;
		getTileImage();		// gets the image of the pause button
	}
	
	private void getTileImage() {
		
		try {
			
			pauseButton = ImageIO.read(getClass().getResourceAsStream("/Tiles/pause button.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
	// nothing is updated during the pause screen
	}

	@Override
	public void draw(Graphics2D g2) {
		gp.backGround.draw(g2);		// draws the background and moving stripe
		gp.pipeGen.draw(g2);		// draws Pipes for every screen except the start Screen
		gp.bird.drawRunningScreen(g2);
		g2.drawImage(pauseButton, 204, 377, pauseButton.getWidth() * 2, pauseButton.getHeight() * 2, null);		// draws the pause button
		gp.scoreBoard.drawCurrentScore(g2);
		
	}

}
