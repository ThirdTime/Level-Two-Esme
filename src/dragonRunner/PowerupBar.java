package dragonRunner;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class PowerupBar extends GameObject implements ActionListener {

	private long timeBarDepleted;
	private int systemCurrentTimeInSec;
	private Timer testTimer;
	private boolean fullyCharged = false;

	final int POWERUP_BAR_BKG_X_POSITION = 40;
	final int POWERUP_BAR_BKG_Y_POSITION = 15;
	final int POWERUP_BAR_BKG_WIDTH = 130;
	final int POWERUP_BAR_BKG_HEIGHT = 20;
	
	public long getTimeBarDepleted(){
		return timeBarDepleted;
	}
	
	public int getSystemCurrentTimeInSec(){
		return systemCurrentTimeInSec;
	}
	
	public PowerupBar() {
		super(45, 18, 20, 16);
		testTimer = new Timer(1000, this);
		testTimer.start();
	}

	public void deleteBar() {
		if (fullyCharged == true) {
			width = 0;
		}
		fullyCharged = false;
	}

	public boolean getFullyCharged() {
		return fullyCharged;
	}

	public void update() {
		super.update();
	}

	public void increaseBar() {
		if (width <= 115) {
			width = width + 5;
		} else if (width >= 120) {
			fullyCharged = true;
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(POWERUP_BAR_BKG_X_POSITION, POWERUP_BAR_BKG_Y_POSITION, POWERUP_BAR_BKG_WIDTH, POWERUP_BAR_BKG_HEIGHT);
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}

	@Override
	public void actionPerformed(ActionEvent testTimer) {
		increaseBar();
	}

}
