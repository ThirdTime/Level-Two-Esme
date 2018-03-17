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

	public int getxRocketPos() {
		return xRocketPos;
	}

	public int getyRocketPos() {
		return yRocketPos;
	}

	public void update() {
		super.update();
		if (y > 740) {
			y = 740;
		} 
		
		if(y < 0){
			y = 1;
		}
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
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);

	}

}
