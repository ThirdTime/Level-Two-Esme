package org.jointheleague.leagueinvaders;

import java.awt.Graphics;

public class GameObject {
    int x;
    int y;
    int width;
    int height;
    
    //hi! this is a test
	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void update() {
		//x = x+1;
		//y = y+1;
	}
	
	public void draw(Graphics g) {
		///g.fillRect(x, y, 100, 100);
	}
}
