package dragonRunner;

//imports
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManagerK {

	Dragon dragon = new Dragon(50, 50, 50, 50);
	
	// THE CLOUDS:
	private long lastCloudCreated = 0;

	// Making the Cloud List
	ArrayList<Cloud> cloudList = new ArrayList<>();

	public void addCloudToList(Cloud cloud) {
		cloudList.add(cloud);
	}

	// Randomly generating clouds
	public void generateClouds() {
		int re = new Random().nextInt(500000);
		int cloudGeneratorPause = re;

		if (System.currentTimeMillis() - lastCloudCreated >= cloudGeneratorPause) {
			addCloudToList(
					new Cloud(dragonRunnerMain.FRAME_WIDTH, new Random().nextInt(dragonRunnerMain.FRAME_HEIGHT / 2)));
			lastCloudCreated = System.currentTimeMillis();
		}
	}

	// THE GROUND:
	ArrayList<Ground> groundList = new ArrayList<>();

	public void addGroundToList(Ground ground) {
		groundList.add(ground);
	}

	public void loopGround() {
		if (groundList.size() == 0) {
			addGroundToList(new Ground(0, dragonRunnerMain.FRAME_HEIGHT - 150));
		}

		Ground lastGroundOnScreen = groundList.get(groundList.size() - 1);
		if (lastGroundOnScreen.x + lastGroundOnScreen.width < dragonRunnerMain.FRAME_WIDTH) {
			addGroundToList(
					new Ground(lastGroundOnScreen.x + lastGroundOnScreen.width, dragonRunnerMain.FRAME_HEIGHT - 150));
		}
	}

	// THE ARROWS:
	public long lastArrowFired = 0;

	ArrayList<Arrow> arrowList = new ArrayList<>();

	public void addArrowToList(Arrow arrow) {
		arrowList.add(arrow);
	}

	public void fireArrows() {
		int r = new Random().nextInt(100000) + 2000;
		int arrowPause = r;

		if (System.currentTimeMillis() - lastArrowFired >= arrowPause) {
			addArrowToList(
					new Arrow(dragonRunnerMain.FRAME_WIDTH, new Random().nextInt(dragonRunnerMain.FRAME_HEIGHT / 2)));
			lastArrowFired = System.currentTimeMillis();
		}
	}

	// THE SPIKES:
	public long lastSpikeGenerated = 0;
	ArrayList<Spikes> spikesList = new ArrayList<>();

	int spikeScrollPause = new Random().nextInt(1500) + 3000;


	public void addSpikeToList(Spikes spike) {
		spikesList.add(spike);
	}

	public void generateSpikes() {
		if (System.currentTimeMillis() - lastSpikeGenerated >= spikeScrollPause) {
			addSpikeToList(SpikeFactory.getRandomSpike());
			lastSpikeGenerated = System.currentTimeMillis();
		}
	}

	// UPDATE AND DRAW:
	public void update() {
		dragon.update();
		generateClouds();
		loopGround();
		fireArrows();
		generateSpikes();

		this.purgeObjects(groundList);
		this.purgeObjects(arrowList);
		this.purgeObjects(cloudList);
		this.purgeObjects(spikesList);
		
		this.updateArrayList(cloudList);
		this.updateArrayList(groundList);
		this.updateArrayList(arrowList);
		this.updateArrayList(spikesList);
	}

	public void draw(Graphics g) {
		dragon.draw(g);
		
		this.drawArrayList(arrowList, g);
		this.drawArrayList(cloudList, g);
		this.drawArrayList(groundList, g);
		this.drawArrayList(spikesList, g);
	}

	// MISC METHODS
	// PURGE OBJECTS
	public void purgeObjects(ArrayList<? extends GameObject> list) {
		for (int i = list.size() - 1; i >= 0; i--) {
			if (list.get(i).isAlive == false) {
				list.remove(i);
			}
		}
	}

	// UPDATE ARRAY LIST
	public void updateArrayList(ArrayList<? extends GameObject> arl) {
		for (int i = 0; i < arl.size(); i++) {
			arl.get(i).update();
		}
	}

	// DRAW ARRAY LIST
	public void drawArrayList(ArrayList<? extends GameObject> arl, Graphics g) {
		for (int i = 0; i < arl.size(); i++) {
			arl.get(i).draw(g);
		}
	}

}
