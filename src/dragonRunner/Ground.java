package dragonRunner;

import java.awt.Color;
import java.awt.Graphics;

public class Ground extends GameObject {
	private int groundMoveSpeed;

	public Ground(int x, int y) {
		super(x, y, 300, DragonRunnerMain.FRAME_HEIGHT);
		groundMoveSpeed = 4;
	}
	
	public void update() {
		x = x - groundMoveSpeed;
		super.update();
		
		if(x + width <= 0){
			isAlive = false;
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
	}

}
