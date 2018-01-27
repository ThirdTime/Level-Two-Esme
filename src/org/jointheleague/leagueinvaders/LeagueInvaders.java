package org.jointheleague.leagueinvaders;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	final int FRAME_WIDTH = 500;
	final int FRAME_LENGTH = 800;
	
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
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
