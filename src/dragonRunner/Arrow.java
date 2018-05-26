package dragonRunner;

import java.awt.Color;
import java.awt.Graphics;

public class Arrow extends GameObject {

	private int arrowSpeed;

	public Arrow(int x, int y) {
		super(x, y, 80, 10);

		arrowSpeed = 4;

	}

	public void update() {
		x = x - arrowSpeed;
		super.update();
		
		if(x + width <= 0){
			isAlive = false;
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.fillRect(x, y, width, height);
	}
}