package main;

import javax.swing.JFrame;

public class App {

	public static void main(String[] args) {
		
		// Frame settings
		JFrame window = new JFrame();
		
		// Sets close operation when the user uses x to exit
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false); 
		window.setTitle("Flappy Bird");
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		// Causes this window to fit the layouts of its subcomponents (gamePanel)
		window.pack(); 
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.startGameThread();
	}

}
