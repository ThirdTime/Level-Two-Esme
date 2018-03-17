package org.jointheleague.leagueinvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {

	private int speed;
	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		
		speed = 3;
	}
	
	public void update() {
		super.update();
		y = y + speed;
		
		if(y > 800){
			isAlive = false;
		}
	}
	
	public void draw (Graphics g) {
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);
	}

}
