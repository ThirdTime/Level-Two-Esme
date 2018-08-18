package dragonRunner;

import java.awt.Color;
import java.awt.Graphics;

public class PowerupBar extends GameObject{

	ScoreManager timingChecker = new ScoreManager();
	long timeBarDepleted;
	int SystemCurrentTimeInSec = (int) (System.currentTimeMillis() / 1000);
	
	public PowerupBar() {
		super(45, 18, 120, 16);
		// TODO Auto-generated constructor stub
	}
	
	public void deleteBar() {
		//when space is pressed bar is deleted
	}
	
	
	public void update() {
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(40, 15, 130, 20);
		g.setColor(Color.WHITE);
		g.fillRect(45, 18, 120, 16);
	}
	

}
