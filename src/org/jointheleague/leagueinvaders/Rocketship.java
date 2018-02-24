package org.jointheleague.leagueinvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	
	//here's what you need to do: use the keypressed +
	//keyReleased methods to subtract or add respectively the x variable of the 
	//rocketship method by 5. This should move the ship
	//side to side. No, I don't know what the speed method is for.

	private int xSpeed;
	private int ySpeed;

	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		xSpeed = 0;
		ySpeed = 0;
	}
	
	//	public void setSpeed(int mySpeed) {
		//	speed = speed + mySpeed;
//	}
	
	public void update() {
		x = x + xSpeed;
		y = y + ySpeed;
		
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
