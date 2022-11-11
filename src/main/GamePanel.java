package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
import javax.swing.JPanel;
import controls.KeyHandler;
import controls.MouseHandler;
import entity.Bird;
import pipes.PipeGenerator;
import score.ScoreBoard;
import screens.EndScreen;
import screens.GetReadyScreen;
import screens.PauseScreen;
import screens.RunningScreen;
import screens.Screen;
import screens.StartScreen;

public class GamePanel extends JPanel implements Runnable{
	
	
	// Settings for screen
	public final int screenWidth = 225 * 2; // 450 pixels wide
	public final int screenHeight = 400 * 2; // 800 pixels tall

	// Key input, Mouse input, Game Thread, and active Screen
	public String activeScreen = "Start Screen";
	KeyHandler keyH = new KeyHandler(this);
	MouseHandler mouseH = new MouseHandler(this);
	Thread gameThread;
	
	//FPS
	int FPS = 100;
	
	// Score 
	public ScoreBoard scoreBoard = new ScoreBoard();
	
	// Pipe Manager
	public PipeGenerator pipeGen = new PipeGenerator(this, scoreBoard);
	
	// Player 
	public Bird bird = new Bird(keyH, this); 
	
	// Background and counter for Stripe
	public BackGround backGround = new BackGround(screenWidth, screenHeight);
	
	// Different Screens
	HashMap<String, Screen> screens = new HashMap<>();
	Screen startScreen = new StartScreen(this);		
	Screen runningScreen = new RunningScreen(this);
	Screen pauseScreen = new PauseScreen(this);
	Screen endScreen = new EndScreen(this);
	Screen readyScreen = new GetReadyScreen(this);
	
	// Collision detection
	public CollisionChecker cCheck = new CollisionChecker(bird);
	
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(this.screenWidth, this.screenHeight)); // sets the dimensions of the screen 
		this.setDoubleBuffered(true); // all drawing will be done off screen in a painting buffer
		this.addKeyListener(keyH); // adds the keyboard input to the game handler
		this.addMouseListener(mouseH);
		this.setFocusable(true); // the game panel can be focused to receive key input
		// adds Screens to HashMap
		this.screens.put("Running Screen", runningScreen);		
		this.screens.put("Start Screen", startScreen);
		this.screens.put("Pause Screen", pauseScreen);
		this.screens.put("End Screen", endScreen);
		this.screens.put("Get Ready", readyScreen);
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();// automatically calls the run method of this object
	}
	
	
	public void run() {
		
		// draw internal for 100 FPS in nanoseconds
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while (gameThread != null) {
			
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;	// time elapsed divided by draw interval
			lastTime = currentTime;
			
			// if time elapsed is the draw interval or is slightly greater, update and repaint
			if (delta >= 1) {
				update();
				repaint();
				delta--;
			}
		}
	}
	
	public void update() {
		Screen currentScreen = getActiveScreen();// gets the current Screen, updates Pipe and player, and animations
		currentScreen.update();
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g; 
		Screen currentScreen = this.screens.get(activeScreen);
		currentScreen.draw(g2);		// draw method of current Screen
		g2.dispose();	
	}
	
	public Screen getActiveScreen() {
	
		if (mouseH.restartClicked) {
				activeScreen = "Start Screen";
				bird.setDefaultValues();	
				pipeGen.setDefaultValues();
				scoreBoard.setDefaultValues();
			
		} else if (mouseH.startClicked) {
			activeScreen = "Get Ready";
			
		} else if (keyH.upPressed && !bird.isDead) {
			activeScreen = "Running Screen";
			
		} else if (keyH.pausePressed) {
			activeScreen = "Pause Screen";
			
		// Ends the game if there is a collision with either pipe that is generated on Screen
		} else if (bird.isDead) {
			activeScreen = "End Screen";
		}

		return this.screens.get(activeScreen);
	}
}
