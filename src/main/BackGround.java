package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackGround {
	
	BufferedImage backGround, ground;
	int groundX = 1;
	int screenWidth, screenHeight;
	
	
	public BackGround(int screenWidth, int screenHeight) {
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
		getBackGroundImages();
	}
	
	// Retrieves the ground and background images
	public void getBackGroundImages() {
		
		try {
			
			backGround = ImageIO.read(getClass().getResourceAsStream("/Tiles/BackGround.png"));
			ground = ImageIO.read(getClass().getResourceAsStream("/Tiles/Ground.png"));	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// updates the x of the moving ground stripe
	public void update() {
		groundX--;
		if (groundX == -451) {		// resets if stripe has moved all the way off screen
			groundX = 0;
		}
	}
	
	// draws the moving ground stripe
	public void draw(Graphics2D g2) {
		g2.drawImage(backGround, 0, 0, backGround.getWidth() * 2, backGround.getHeight() * 2, null);	// draws background image 
		int remainingGroundX = (groundX + (backGround.getWidth() * 2)) - 11;		// calculates x of empty remaining space after the first ground is drawn
		g2.drawImage(ground, groundX, 626, ground.getWidth() * 2, ground.getHeight() * 2, null);	// first ground is drawn
		
		if (groundX != 0) {
			g2.drawImage(ground, remainingGroundX, 626, ground.getWidth() * 2, ground.getHeight() * 2, null);		// draws the remaining ground if there is any leftover space
		}
		
	}
}
