package main;



import java.awt.Rectangle;
import entity.Bird;
import pipes.Pipe;

public class CollisionChecker {

	
	Bird bird;
	
	public CollisionChecker(Bird bird) {
		this.bird = bird;
	}
	
	
	public boolean checkForCurrentCollision(Pipe pipe) {
			
			Rectangle player = new Rectangle(bird.x + 12, bird.y + 8, 48, 38);
			Rectangle bottomRim = new Rectangle(pipe.rimX, pipe.bottomRimY, pipe.rimWidth, pipe.rimHeight);
			Rectangle topRim = new Rectangle(pipe.rimX, pipe.topRimY, pipe.rimWidth, pipe.rimHeight);
			Rectangle topPipe = new Rectangle(pipe.pipeX, 0, pipe.pipeWidth, pipe.topPipeHeight);
			Rectangle bottomPipe = new Rectangle(pipe.pipeX, pipe.bottomPipeY, pipe.pipeWidth, pipe.bottomPipeHeight);
			
			if (player.intersects(bottomRim)) {
				return true;
				
			} else if (player.intersects(topRim)) {
				return true;
				
			} else if (player.intersects(bottomRim)) {
				return true;
				
			} else if (player.intersects(topPipe)) {
				return true;
				
			} else if (player.intersects(bottomPipe)) {
				return true;
				
			} else if ((bird.y + 46) >= 626) {
				return true;
			}
			return false;
			
		
	}
}
