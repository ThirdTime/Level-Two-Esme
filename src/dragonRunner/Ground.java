package dragonRunner;

import java.awt.Color;
import java.awt.Graphics;

public class Ground extends GameObject {
	private int groundMoveSpeed;
	final static int HEIGHT_OF_GROUND = 80;

	public Ground(int x, int y) {
		super(x, y, 300, HEIGHT_OF_GROUND);
		groundMoveSpeed = 8;
	}
	
	public void update() {
		x = x - groundMoveSpeed;
		super.update();
		
		if(x + width <= 0){
			isAlive = false;
		}
	}

	public void draw(Graphics g) {
		g.drawImage(GamePanel.imgGround, x, y, width, height, null);
	}

}
