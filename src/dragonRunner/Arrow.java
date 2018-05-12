package dragonRunner;

import java.awt.Color;
import java.awt.Graphics;

public class Arrow extends GameObject {

	private int arrowSpeed;

	public Arrow(int x, int y, int width, int height) {
		super(x, y, width, height);

		arrowSpeed = 4;

	}

	public void update() {
		x = x - arrowSpeed;
		super.update();
	}

	public void draw(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.fillRect(x, y, width, height);
	}
}