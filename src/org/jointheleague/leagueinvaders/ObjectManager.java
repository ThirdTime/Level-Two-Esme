package org.jointheleague.leagueinvaders;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	private long enemyTimer = 0;
	private int enemySpawnTime = 600;

	Rocketship rocket;
	Projectile bullet;
	private int score = 0;
	
	public int getScore(){
		return score;
	}
	
	ArrayList<Projectile> projectileObjectsList = new ArrayList<>();

	public void addProjectile(Projectile projectile) {
		projectileObjectsList.add(projectile);
	}

	ArrayList<Alien> alienObjectsList = new ArrayList<>();

	public void addAlien(Alien alien) {
		alienObjectsList.add(alien);
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.FRAME_WIDTH), 0, 50, 50));
			enemyTimer = System.currentTimeMillis();
		}
	}

	public ObjectManager(Rocketship r) {
		rocket = r;
	}

	public void update() {
		rocket.update();
		
		for (int i = 0; i < alienObjectsList.size(); i++) {
			alienObjectsList.get(i).update();
		}
		
		for (int i = 0; i < projectileObjectsList.size(); i++) {
			projectileObjectsList.get(i).update();
		}
	}

	public void draw(Graphics g) {
		rocket.draw(g);

		for (int i = 0; i < alienObjectsList.size(); i++) {
			alienObjectsList.get(i).draw(g);
		}
		
		for (int i = 0; i < projectileObjectsList.size(); i++) {
			projectileObjectsList.get(i).draw(g);
		}
	}

	public void purgeObjects() {
		for (int i = projectileObjectsList.size() - 1; i >= 0; i--) {
			if (projectileObjectsList.get(i).isAlive == false) {
				projectileObjectsList.remove(i);
			}
		}
		
		for (int i = alienObjectsList.size() - 1; i >= 0; i--) {
			if (alienObjectsList.get(i).isAlive == false) {
				alienObjectsList.remove(i);
			}
		}
		
	}
	
	public void checkCollision(){
		for(Alien a : alienObjectsList){
	        if(rocket.collisionBox.intersects(a.collisionBox)){
	                rocket.isAlive = false;
	        }  
	        for(Projectile p : projectileObjectsList){
	        		if(p.collisionBox.intersects(a.collisionBox)){
	        			a.isAlive = false;
	        			p.isAlive = false;
	        			score = score + 1;
	        		}
	        }
		}
	}
	
	
}
