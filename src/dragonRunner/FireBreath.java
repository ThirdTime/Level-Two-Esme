package dragonRunner;

import java.awt.Color;
import java.awt.Graphics;

public class FireBreath extends GameObject{
	
	PowerupBar pob = new PowerupBar();
	private boolean wasFireFired = false;
	
	private int fireBreathSpeed;
	public FireBreath() {
		super(80, 0, 80, DragonRunnerMain.FRAME_HEIGHT);
		fireBreathSpeed = 5;
		// TODO Auto-generated constructor stub
	}
	
	public boolean fireFired() {
		return wasFireFired;
	}
	
	public void resetFire() {
		if(x> DragonRunnerMain.FRAME_WIDTH) {
			wasFireFired = false;
			fireBreathSpeed = 5;
			x = 80;
		}
	}
	
	public void fireFire() {
		if(pob.getFullyCharged() == true) {
			wasFireFired = true;
		}
	}
	
	public void update(){
		if(wasFireFired == true) {
			x = x + fireBreathSpeed;
		}
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}

}
