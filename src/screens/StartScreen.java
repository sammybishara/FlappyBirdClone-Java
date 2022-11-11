package screens;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class StartScreen implements Screen{
	
	
	GamePanel gp;
	BufferedImage title, startButton;
	
	public StartScreen(GamePanel gp) {
		this.gp = gp;
		getTileImage();
	}
	
	// loads title and start button images
	public void getTileImage() {
		
		try {
			
			title = ImageIO.read(getClass().getResourceAsStream("/Tiles/Title.png"));
			startButton = ImageIO.read(getClass().getResourceAsStream("/Tiles/Start Button.png"));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void update() { 
		gp.backGround.update();	
		gp.bird.update();	
	}

	@Override
	public void draw(Graphics2D g2) {	// draws all objects
		gp.backGround.draw(g2);
		g2.drawImage(title, 85, 300, title.getWidth() * 2, title.getHeight() * 2, null);	
		g2.drawImage(startButton, 161, 510, startButton.getWidth() * 2, startButton.getHeight() * 2, null);
		gp.bird.drawStartScreen(g2);
	}
}
