package org.jointheleague.leagueinvaders;

//THE WEBSITE:
/** https://league-level2.github.io */
//LEAGUE INVADERS STEPS:
/** https://league-level2.github.io/league_invaders_contents */
//THE GAME ITSELF:
/** https://league-level2.github.io/league_invaders_demo */

import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	final static int FRAME_WIDTH = 500;
	final int FRAME_LENGTH = 800;
	GamePanel gamePanel = new GamePanel();
	
	public LeagueInvaders(){
		frame = new JFrame();
		frame.setSize(FRAME_WIDTH, FRAME_LENGTH);
	}
	
	public static void main(String[] args) {
		LeagueInvaders thisClass = new LeagueInvaders();
		thisClass.setup();
		//play the game here
	}
	
	public void setup (){
		frame.addKeyListener(gamePanel);
		frame.add(gamePanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_LENGTH));
		frame.pack();
		gamePanel.startGame();
	}
}
