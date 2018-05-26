package dragonRunner;

import java.awt.Color;
import java.awt.Graphics;

public class Dragon extends GameObject{
	
	public int ySpeed;
	
	public Dragon(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		ySpeed = 0;
	}
	
	public void update(){
		y = y + ySpeed;
	}
	
	public void dragonJump(){
		ySpeed = 3;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, width, height);	
	}

}
