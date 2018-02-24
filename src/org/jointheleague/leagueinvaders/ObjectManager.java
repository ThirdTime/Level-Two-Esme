package org.jointheleague.leagueinvaders;

import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	
	//Instructions for future me!
	//I last left off on Pt. 10, step 14.
	//A projectile appears when I press space but it shows up randomly.
	//Next up:
	//figure out how to make it show up where the rocket is and move upwards :-)
	
	
	Rocketship rocket;
	ArrayList <Projectile> projectileObjectsList = new ArrayList <> ();
	
	public void addProjectile(Projectile projectile) {
		projectileObjectsList.add(projectile);
	}
	
	public ObjectManager (Rocketship r) {
		rocket = r;
	}
	
	public void update() {
		rocket.update();
		
		for(int i = 0; i < projectileObjectsList.size(); i++) {
			projectileObjectsList.get(i).update();
		}
	}
	
	public void draw (Graphics g) {
		rocket.draw(g);
		
		for(int i = 0; i < projectileObjectsList.size(); i++) {
			projectileObjectsList.get(i).draw(g);
		}
	}
}
