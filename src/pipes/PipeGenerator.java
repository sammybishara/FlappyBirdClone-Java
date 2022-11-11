package pipes;

import java.awt.Graphics2D;
import java.util.Random;
import main.GamePanel;
import score.ScoreBoard;

public class PipeGenerator {
	
	GamePanel gp;
	public Pipe pipe1;
	public Pipe pipe2;
	ScoreBoard scoreBoard;
	Random randomDirection;
	
	
	public PipeGenerator(GamePanel gp, ScoreBoard scoreBoard) {
		this.gp = gp;
		this.scoreBoard = scoreBoard;
		randomDirection = new Random();
		setDefaultValues();
	}
	
	public void setDefaultValues() {
		pipe1 = new Pipe(450, 400, gp);
		generateSecondPipe();
	}
	
	
	// updates each pipe on the screen
	public void update() {
		if (pipe1.rimX >= 200) {
			pipe1.update();
			
		} else {
			pipe1.update();
			pipe2.update();
		}
		
		// If the first pipe is offScreen, generate the next pipe 
		if (pipe1.rimX + pipe1.rimWidth <= 0) {
			generatePipes();
		}
		// updates the score if the player is in between the pipes 
		if (pipe1.getEndOfPipe() == 200 || pipe2.getEndOfPipe() == 200){
			scoreBoard.updateScore();
		}
	}
	
	public void draw(Graphics2D g2) {
		if (pipe1.rimX >= 200) {
			pipe1.draw(g2);
			
		} else {
			pipe1.draw(g2);
			pipe2.draw(g2);
		}
	}
	
	public void generatePipes() {
		pipe1 = pipe2;		// first pipe is off screen, so it now becomes the one on screen, and a new pipe is now generated
		generateSecondPipe();
	}
	
	public void generateSecondPipe() {
		int direction = randomDirection.nextInt(300);
		int y = pipe1.bottomRimY + direction - 150;
		pipe2 = new Pipe(450, y, gp);
		
		// checks if pipe is too high off screen and reassigns it 
		if (pipe2.topRimY < 0) {
			pipe2 = new Pipe(450, 238, gp);
		
		// checks if pipe is too low off screen and reassigns it 
		} else if ((pipe2.bottomRimY + pipe2.rimHeight) > 626) {
			pipe2 = new Pipe(450, 588, gp);
		}
	}
}
