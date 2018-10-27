

import java.awt.Graphics;

public class Spikes extends GameObject {

	private int spikeSpeed;

	public Spikes(int x, int y, int width, int height) {
		super(x, y, width, height);
		spikeSpeed = 8;
	}

	public void update() {
		x = x - spikeSpeed;
		super.update();
		if (x + width <= 0) {
			isAlive = false;
		}
	}

	public void draw(Graphics g) {
		g.drawImage(GamePanel.imgSpikes, x, y, width, height, null);
	}

}
