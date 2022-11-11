package score;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ScoreBoard {
	
	public int score;
	public BufferedImage[] largeNumbers;
	public BufferedImage[] smallNumbers;
	public BufferedImage bronzeMedal, silverMedal, goldMedal, platinumMedal;
	
	
	public ScoreBoard() {
		this.largeNumbers = new BufferedImage[10];
		this.smallNumbers = new BufferedImage[10];
		setDefaultValues();
		getNumbersAndMedals();
		
	}
	
	public void setDefaultValues() {
		this.score = 0;
	}
	
	public void getNumbersAndMedals() {
		
		try {
			
			// retrieves all numbers for both the end screen and the running screen
			for (int i = 0; i < 10; i++) {
				largeNumbers[i] = ImageIO.read(getClass().getResourceAsStream("/Tiles/Large Number "  + i + ".png"));
				smallNumbers[i] = ImageIO.read(getClass().getResourceAsStream("/Tiles/Small Number " + i + ".png"));
			}
			
			// Retrieves all the medal images
			bronzeMedal = ImageIO.read(getClass().getResourceAsStream("/Tiles/Bronze Medal.png"));
			silverMedal = ImageIO.read(getClass().getResourceAsStream("/Tiles/Silver Medal.png"));
			goldMedal = ImageIO.read(getClass().getResourceAsStream("/Tiles/Gold Medal.png"));
			platinumMedal = ImageIO.read(getClass().getResourceAsStream("/Tiles/Platinum Medal.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void updateScore() {
		score += 1;
	}
	
	public void draw(Graphics2D g2, BufferedImage[] numbers, int Y, int middle) {
		// converts the score to an array of digits
		String[] digits = String.valueOf(score).split("");
		int imageSize = 0;
		// calculates the width of all digits in the score
		for (String digit : digits) {
			
			BufferedImage num = numbers[Integer.valueOf(digit)];
			imageSize += (num.getWidth() * 2) + 3;
		}
		// determines where the score is centered
		int x = middle - (imageSize / 2);
			
		// draws the score
		for (String digit : digits) {
			
			BufferedImage num = numbers[Integer.valueOf(digit)];
			g2.drawImage(num, x, Y, num.getWidth() * 2, num.getHeight() * 2, null);
			x += (num.getWidth() * 2 ) + 3;
			
		}
	}
	// draws the medals based on final score
	public void drawMedals(Graphics2D g2) {
		if (score >= 40) {
			g2.drawImage(platinumMedal, 87, 372, platinumMedal.getWidth() * 2, platinumMedal.getHeight() * 2, null);
			
		} else if (score >= 30) {
			g2.drawImage(goldMedal, 87, 372, goldMedal.getWidth() * 2, goldMedal.getHeight() * 2, null);
			
		} else if (score >= 20) {
			g2.drawImage(silverMedal, 87, 372, silverMedal.getWidth() * 2, silverMedal.getHeight() * 2, null);
			
		} else if (score >= 10) {
			g2.drawImage(bronzeMedal, 87, 372, bronzeMedal.getWidth() * 2, bronzeMedal.getHeight() * 2, null);
		}
	}
	
	
	public void drawCurrentScore(Graphics2D g2) {
		draw(g2, largeNumbers, 20, 225);
	}
	
	public void drawFinalScore(Graphics2D g2) {
		draw(g2, smallNumbers, 357, 320);
	}
}
