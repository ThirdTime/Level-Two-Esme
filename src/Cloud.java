

import java.awt.Graphics;

public class Cloud extends GameObject {

	private int cloudSpeed;

	public Cloud(int x, int y) {
		super(x, y, 60, 40);

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
		g.drawImage(GamePanel.imgCloud, x, y, width, height, null);
	}

}



