package screens;

import java.awt.Graphics2D;
import main.GamePanel;

public class RunningScreen implements Screen {
	
	GamePanel gp;
	
	
	public RunningScreen(GamePanel gp) {
		this.gp = gp;
	}

	@Override
	public void update() {
		gp.backGround.update();	// updates background and moving stripe
		gp.bird.update();	// Updates pipe and player positions
		gp.bird.updateRunningScreen();
		gp.pipeGen.update();
	}

	@Override
	public void draw(Graphics2D g2) {
		gp.backGround.draw(g2);	// draws backGround and moving Stripe
		gp.pipeGen.draw(g2);		// draws Pipes for every screen except the start Screen
		gp.scoreBoard.drawCurrentScore(g2);	// draws the score
		gp.bird.drawRunningScreen(g2);	
	}
}
