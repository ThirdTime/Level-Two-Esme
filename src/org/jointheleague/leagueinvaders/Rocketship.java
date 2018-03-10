package org.jointheleague.leagueinvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	
	private int xRocketPos;
	private int yRocketPos;
	
	private int xSpeed;
	private int ySpeed;

	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		xSpeed = 0;
		ySpeed = 0;
		xRocketPos = x;
		yRocketPos = y;
	}
	
	public int getxRocketPos () {
		return xRocketPos;
	}
	
	public int getyRocketPos () {
		return yRocketPos;
	}
	
	public void update() {
		super.update();
		x = x + xSpeed;
		xRocketPos = x + 20;
		y = y + ySpeed;
		yRocketPos = y + 17;
		
	}
	
	public void setXSpeed(int newXSpeed) {
		xSpeed = newXSpeed;
	}
	
	public void setYSpeed(int newYSpeed) {
		ySpeed = newYSpeed;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
		
	}

	
	
}
