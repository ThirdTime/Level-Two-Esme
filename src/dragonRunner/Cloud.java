package dragonRunner;

import java.awt.Color;
import java.awt.Graphics;

public class Cloud extends GameObject {

	private int cloudSpeed;

	public Cloud(int x, int y, int width, int height) {
		super(x, y, width, height);

		cloudSpeed = 1;
	}

	public void update() {
		x = x - cloudSpeed;
		super.update();
		
		if(x + width <= 0){
			isAlive = false;
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}

}



