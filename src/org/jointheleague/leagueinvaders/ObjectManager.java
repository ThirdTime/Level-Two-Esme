package org.jointheleague.leagueinvaders;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	private long enemyTimer = 0;
	private int enemySpawnTime;

	Rocketship rocket;
	ArrayList<Projectile> projectileObjectsList = new ArrayList<>();

	public void addProjectile(Projectile projectile) {
		projectileObjectsList.add(projectile);
	}

	Alien alien;
	ArrayList<Alien> alienObjectsList = new ArrayList<>();

	public void addAlien(Alien alien) {
		alienObjectsList.add(alien);
	}

	public ObjectManager(Rocketship r) {
		rocket = r;
	}

	public void update() {
		rocket.update();

		for (int i = 0; i < projectileObjectsList.size(); i++) {
			projectileObjectsList.get(i).update();
		}
	}

	public void draw(Graphics g) {
		rocket.draw(g);

		for (int i = 0; i < projectileObjectsList.size(); i++) {
			projectileObjectsList.get(i).draw(g);
		}
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.FRAME_WIDTH), 0, 50, 50));
			enemyTimer = System.currentTimeMillis();
		}
	}

	public void purgeObjects() {
		System.out.println("purge objects is running :-)");
		for(int i = projectileObjectsList.size(); i > 0; i--) {
			System.out.println("the calm before the crash: Index " + i + " Size: " + projectileObjectsList.size());
			//if (projectileObjectsList.get(i).isAlive == false) {
		//		projectileObjectsList.remove(i);
		//		System.out.println("you is dead");
		//	}
		}
	}
}
