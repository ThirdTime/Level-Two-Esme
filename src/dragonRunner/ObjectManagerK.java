package dragonRunner;

//imports
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import org.jointheleague.leagueinvaders.Rocketship;

public class ObjectManagerK {
	
//THE CLOUDS:
	private long lastCloudCreated = 0;
	private int cloudGeneratorPause = 3000;

	// Making the Cloud List
	ArrayList<Cloud> cloudList = new ArrayList<>();

	public void addCloudToList(Cloud cloud) {
		cloudList.add(cloud);
	}

	// Randomly generating clouds
	public void generateClouds() {
		if (System.currentTimeMillis() - lastCloudCreated >= cloudGeneratorPause) {
			addCloudToList(new Cloud(dragonRunnerMain.FRAME_WIDTH,
					new Random().nextInt(dragonRunnerMain.FRAME_HEIGHT / 2), 60, 40));
			lastCloudCreated = System.currentTimeMillis();
		}
	}
//THE GROUND:
	Ground firstGround = new Ground(200, dragonRunnerMain.FRAME_HEIGHT - 150, 300, dragonRunnerMain.FRAME_HEIGHT);
	
	ArrayList<Ground> groundList = new ArrayList<>();
	
	public void addGroundToList(Ground ground) {
		groundList.add(ground);
	}
	
	public void loopGround() {
		if(firstGround.x + firstGround.width >= 400) {
			System.out.println("adding a ground");
			addGroundToList(new Ground(firstGround.x + firstGround.width, dragonRunnerMain.FRAME_HEIGHT - 150, 300, dragonRunnerMain.FRAME_HEIGHT));
		}
	}

//UPDATE AND DRAW:
	public void update() {
		firstGround.update();
		generateClouds();
		for (int i = 0; i < cloudList.size(); i++) {
			cloudList.get(i).update();
		}
	}

	public void draw(Graphics g) {
		firstGround.draw(g);
		for (int i = 0; i < cloudList.size(); i++) {
			cloudList.get(i).draw(g);
		}
	}
}
