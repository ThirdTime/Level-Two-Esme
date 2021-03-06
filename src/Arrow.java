

import java.awt.Graphics;

public class Arrow extends GameObject {

	private int arrowSpeed;

	public Arrow(int x, int y) {
		super(x, y, 80, 10);
		arrowSpeed = 10;

	}

	public void update() {
		super.update();
		x = x - arrowSpeed;
		
		if(x + width <= 0){
			isAlive = false;
		}
	}

	public void draw(Graphics g) {
		g.drawImage(GamePanel.imgArrow, x, y, width, height, null);
	}
}