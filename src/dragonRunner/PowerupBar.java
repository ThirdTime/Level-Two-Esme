package dragonRunner;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class PowerupBar extends GameObject implements ActionListener {

	long timeBarDepleted;
	int SystemCurrentTimeInSec;
	Timer testTimer;
	boolean fullyCharged = false;

	public PowerupBar() {
		super(45, 18, 20, 16);
		testTimer = new Timer(1000, this);
		testTimer.start();
		}

	public void deleteBar() {
		if(fullyCharged == true) {
		width = 0;
		fullyCharged = false;
		System.out.println("KABOOM!!!!!!!!!!!!!!!!!!");
		}
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
		g.fillRect(40, 15, 130, 20);
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}

	@Override
	public void actionPerformed(ActionEvent testTimer) {
		increaseBar();
	}

}
