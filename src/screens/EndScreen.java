package screens;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;


public class EndScreen implements Screen{
	
	
	GamePanel gp;
	BufferedImage gameOverPanel, scoreBoard, okButton;
	
	
	public EndScreen(GamePanel gp) {
		this.gp = gp;
		getTileImages();		// gets the score board and game over panel images
	}
	
	
	private void getTileImages() {

		try {
			gameOverPanel = ImageIO.read(getClass().getResourceAsStream("/Tiles/Game Over.png"));
			scoreBoard = ImageIO.read(getClass().getResourceAsStream("/Tiles/ScoreBoard.png"));
			okButton = ImageIO.read(getClass().getResourceAsStream("/Tiles/Ok Button.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
	}

	@Override
	public void draw(Graphics2D g2) {
		gp.backGround.draw(g2);	
		gp.pipeGen.draw(g2);		
		gp.bird.drawEndScreen(g2);		
		g2.drawImage(gameOverPanel, 78, 230, gameOverPanel.getWidth() * 2, gameOverPanel.getHeight() * 2, null);	
		g2.drawImage(scoreBoard, 47, 311, scoreBoard.getWidth() * 2, scoreBoard.getHeight() * 2, null);
		gp.scoreBoard.drawMedals(g2);		
		gp.scoreBoard.drawFinalScore(g2);
		g2.drawImage(okButton, 161, 510, okButton.getWidth() * 2, okButton.getHeight() * 2, null);
		
	}

}
