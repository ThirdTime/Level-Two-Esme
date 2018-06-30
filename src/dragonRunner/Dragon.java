package dragonRunner;

import java.awt.Color;
import java.awt.Graphics;

public class Dragon extends GameObject {

	public int ySpeed;
	boolean struckByArrow;
	boolean struckBySpike;
	
	public Dragon(int x, int y) {
		super(x, y, 70, 70);
		// TODO Auto-generated constructor stub
		ySpeed = 0;
		struckByArrow = false;
		struckBySpike = false;
	}

	public void update() {
		super.update();
		y = y - ySpeed;
		if(y<0){
			y = 1;
		}
		if(y> DragonRunnerMain.FRAME_HEIGHT - 150){
			y = DragonRunnerMain.FRAME_HEIGHT - 155;
		}
	}

	public void flyUp() {
		ySpeed = 9;
	}

	public void flyDown() {
		ySpeed = -9;
	}

	public void draw(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, width, height);
	}

}
