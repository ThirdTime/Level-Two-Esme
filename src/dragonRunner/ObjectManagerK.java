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
	ArrayList<Ground> groundList = new ArrayList<>();
	
	public void addGroundToList(Ground ground) {
		groundList.add(ground);
	}
	
	public void loopGround() {
		if(groundList.size() == 0) {
			addGroundToList(new Ground(0, dragonRunnerMain.FRAME_HEIGHT - 150, 300, dragonRunnerMain.FRAME_HEIGHT));
		}
		
		Ground lastGroundOnScreen = groundList.get(groundList.size() -1);
		if(lastGroundOnScreen.x + lastGroundOnScreen.width < dragonRunnerMain.FRAME_WIDTH) {
			System.out.println("adding a ground");
			addGroundToList(new Ground(lastGroundOnScreen.x + lastGroundOnScreen.width, dragonRunnerMain.FRAME_HEIGHT - 150, 300, dragonRunnerMain.FRAME_HEIGHT));
		}
	}

//UPDATE AND DRAW:
	public void update() {
		generateClouds();
		loopGround();
		for (int i = 0; i < cloudList.size(); i++) {
			cloudList.get(i).update();
		}
		
		for (int i = 0; i < groundList.size(); i++) {
			groundList.get(i).update();
		}
	}

	public void draw(Graphics g) {
		for (int i = 0; i < cloudList.size(); i++) {
			cloudList.get(i).draw(g);
		}
		
		for (int i = 0; i < groundList.size(); i++) {
			groundList.get(i).draw(g);
		}
	}
}
