package dragonRunner;

import java.awt.Graphics;

public class Dragon extends GameObject {

	public int ySpeed;
	boolean struckByArrow;
	boolean struckBySpike;
	
	public Dragon(int x, int y) {
		super(x, y, 70, 70);
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
		if(y> DragonRunnerMain.FRAME_HEIGHT - Ground.HEIGHT_OF_GROUND - 70){
			y = DragonRunnerMain.FRAME_HEIGHT - Ground.HEIGHT_OF_GROUND - 70 - 2;
		}
	}

	public void flyUp() {
		ySpeed = 9;
	}

	public void flyDown() {
		ySpeed = -9;
	}

	public void draw(Graphics g) {
		g.drawImage(GamePanel.imgDragon, x, y, width, height, null);
	}

}
