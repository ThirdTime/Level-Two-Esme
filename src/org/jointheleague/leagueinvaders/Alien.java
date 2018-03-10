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
	}
	
	public void draw (Graphics g) {
		g.setColor(new Color(238, 221, 130));
		g.fillRect(x, y, width, height);
	}

}
