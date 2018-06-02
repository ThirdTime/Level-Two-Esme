package dragonRunner;

import java.util.Random;

public class SpikeFactory {
	
	static Spikes getRandomSpike(){
		int random = new Random().nextInt(3);
		if(random == 0){
			return SpikeFactory.buildWideSpike();
		} else if(random == 1){
			return SpikeFactory.buildTallSpike();
		} else if(random == 2){
			return SpikeFactory.buildLargeSpike();
		} else return null;
	}

	static Spikes buildWideSpike(){
		return new Spikes(DragonRunnerMain.FRAME_WIDTH,
				DragonRunnerMain.FRAME_HEIGHT -150, 100, 30);
		
	}
	
	static Spikes buildTallSpike(){
		return new Spikes(DragonRunnerMain.FRAME_WIDTH,
				DragonRunnerMain.FRAME_HEIGHT -150, 50, 100);
	}
	
	static Spikes buildLargeSpike(){
		return new Spikes(DragonRunnerMain.FRAME_WIDTH,
					DragonRunnerMain.FRAME_HEIGHT -150, 150, 150);
	}
}
