package screens;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class GetReadyScreen implements Screen{
	
	GamePanel gp;
	BufferedImage getReady, tapInstruction;
	
	public GetReadyScreen(GamePanel gp) {
		this.gp = gp;
		getTileImage();
	}
	
	private void getTileImage() {
		try {
			
			getReady = ImageIO.read(getClass().getResourceAsStream("/Tiles/Get Ready.png"));
			tapInstruction = ImageIO.read(getClass().getResourceAsStream("/Tiles/Tap Instruction.png"));
			
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
	public void draw(Graphics2D g2) {
		gp.backGround.draw(g2);
		g2.drawImage(getReady, 88, 250, getReady.getWidth() * 2, getReady.getHeight() * 2, null);
		g2.drawImage(tapInstruction, 255, 350, tapInstruction.getWidth() * 2, tapInstruction.getHeight() * 2, null);
		gp.bird.drawStartScreen(g2);
		
		
	}
	
}

