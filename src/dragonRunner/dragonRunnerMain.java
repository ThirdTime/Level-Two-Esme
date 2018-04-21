package dragonRunner;

import java.awt.Dimension;

import javax.swing.JFrame;


public class dragonRunnerMain {

	JFrame frame;
	GamePanel gamePanel;
	
	final static int FRAME_WIDTH = 900;
	final static int FRAME_HEIGHT = 400;
	
	public dragonRunnerMain (){
		frame = new JFrame();
		gamePanel = new GamePanel();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	public static void main(String[] args) {
		dragonRunnerMain thisClass = new dragonRunnerMain();
		thisClass.setup();
	}
	
	public void setup(){
		frame.addKeyListener(gamePanel);
		frame.add(gamePanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		frame.pack();
		gamePanel.startGame();
	}
}


/*
 * creating a To-Do list!
 * 
 */
