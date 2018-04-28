package dragonRunner;

import java.awt.Color;
import java.awt.Graphics;

public class Ground extends GameObject {
	private int groundMoveSpeed;

	public Ground(int x, int y, int width, int height) {
		super(x, y, width, height);
		groundMoveSpeed = 4;
	}
	
	public void update() {
		x = x - groundMoveSpeed;
		super.update();
	}

	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
	}

}
