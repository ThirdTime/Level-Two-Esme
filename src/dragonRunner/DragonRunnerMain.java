package dragonRunner;

import java.awt.Dimension;

import javax.swing.JFrame;


public class DragonRunnerMain {

	JFrame frame;
	GamePanel gamePanel;
	
	final static int FRAME_WIDTH = 1000;
	final static int FRAME_HEIGHT = 450;
	
	public DragonRunnerMain (){
		frame = new JFrame();
		gamePanel = new GamePanel();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	public static void main(String[] args) {
		DragonRunnerMain thisClass = new DragonRunnerMain();
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
