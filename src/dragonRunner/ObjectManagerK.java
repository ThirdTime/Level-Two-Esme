package dragonRunner;

//imports
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManagerK {
	private long lastCloudCreated = 0;
	private int cloudGeneratorPause = 3000;
	
	// Making the Cloud List
	ArrayList <Cloud> cloudList = new ArrayList <>();
	
	public void addCloudToList (Cloud cloud){
		cloudList.add(cloud);
	}
	
	//Randomly generating clouds
	public void generateClouds() {
		if (System.currentTimeMillis() - lastCloudCreated >= cloudGeneratorPause) {
			addCloudToList(new Cloud(dragonRunnerMain.FRAME_WIDTH, new Random().nextInt(dragonRunnerMain.FRAME_HEIGHT / 2), 60, 40));
			lastCloudCreated = System.currentTimeMillis();
		}
	}
	
	public void update(){
		generateClouds();
		for(int i = 0; i < cloudList.size(); i++){
			cloudList.get(i).update();
		}
	}
	
	public void draw(Graphics g){
		for(int i = 0; i < cloudList.size(); i++){
			cloudList.get(i).draw(g);
		}
	}
}
