package dragonRunner;

import java.awt.Color;
import java.awt.Graphics;

public class FireBreath extends GameObject{
	
	PowerupBar powerUpBar = new PowerupBar();
	private boolean currentlyDisplayingFire = false;
	
	private int fireBreathSpeed;
	public FireBreath() {
		super(80, 0, 0, 0);
	}
	
	public boolean isFireCurrentlyDisplayed() {
		return currentlyDisplayingFire;
	}
	
	public void fireFire() {
		if(powerUpBar.getFullyCharged() == true) {
			width = 80;
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
			x = 80;
			width = 0;
			height = 0;
		}
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}

}
