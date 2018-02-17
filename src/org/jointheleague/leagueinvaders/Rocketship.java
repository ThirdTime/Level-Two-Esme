package org.jointheleague.leagueinvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	
	//here's what you need to do: use the keypressed +
	//keyReleased methods to subtract or add respectively the x variable of the 
	//rocketship method by 5. This should move the ship
	//side to side. No, I don't know what the speed method is for.

	private int speed = x;

	public Rocketship(int speed, int x, int y, int width, int height) {
		super(x, y, width, height);
		this.speed = speed;
		this.x = x;
		
	}
		public void setSpeed(int howFastDoYouWantToZoomZoom) {
		this.speed = howFastDoYouWantToZoomZoom;
	}
	
	public void update() {
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
		
	}

	
	
}
