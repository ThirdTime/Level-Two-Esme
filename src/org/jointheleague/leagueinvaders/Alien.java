package org.jointheleague.leagueinvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {

	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}
	
	public void update() {
		y = y + 1;
	}
	
	public void draw (Graphics g) {
		g.setColor(new Color(238, 221, 130));
		g.fillRect(x, y, width, height);
	}

}
