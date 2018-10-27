

import java.awt.Color;
import java.awt.Graphics;

public class FireBreath extends GameObject{
	
	PowerupBar powerUpBar = new PowerupBar();
	private boolean currentlyDisplayingFire = false;
	final static int FIREBREATH_X_POSITION = 80;
	final static int FIREBREATH_WIDTH = 80;
	
	private int fireBreathSpeed;
	public FireBreath() {
		super(FIREBREATH_X_POSITION, 0, 0, 0);
	}
	
	public boolean isFireCurrentlyDisplayed() {
		return currentlyDisplayingFire;
	}
	
	public void fireFire() {
		if(powerUpBar.getFullyCharged() == true) {
			width = FIREBREATH_WIDTH;
			height = DragonRunnerMain.FRAME_HEIGHT;
			currentlyDisplayingFire = true;
			fireBreathSpeed = 5;
			isAlive = true;
			powerUpBar.deleteBar();
		}
	}
	
	public void update(){
		super.update();
		if(currentlyDisplayingFire) {
			x = x + fireBreathSpeed;
		}
		
		powerUpBar.update();
		
		if(x >= DragonRunnerMain.FRAME_WIDTH){
			isAlive = false;
			currentlyDisplayingFire = false;
			fireBreathSpeed = 0;
			x = FIREBREATH_X_POSITION;
			width = 0;
			height = 0;
		}
		
	}
	
	public void draw(Graphics g) {
		g.drawImage(GamePanel.imgFire, x, y, width, height, null);
	}

}
