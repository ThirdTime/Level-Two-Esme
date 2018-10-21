package dragonRunner;

import java.util.Random;

public class SpikeFactory {

	static Spikes getRandomSpike() {
		int random = new Random().nextInt(3);
		if (random == 0) {
			return SpikeFactory.buildWideSpike();
		} else if (random == 1) {
			return SpikeFactory.buildTallSpike();
		} else if (random == 2) {
			return SpikeFactory.buildLargeSpike();
		} else
			return null;
	}

	static Spikes buildWideSpike() {
		return new Spikes(DragonRunnerMain.FRAME_WIDTH, (DragonRunnerMain.FRAME_HEIGHT - Ground.HEIGHT_OF_GROUND) - 50,
				150, 50);
	}

	static Spikes buildTallSpike() {
		return new Spikes(DragonRunnerMain.FRAME_WIDTH, (DragonRunnerMain.FRAME_HEIGHT - Ground.HEIGHT_OF_GROUND) - 80,
				50, 80);
	}

	static Spikes buildLargeSpike() {
		return new Spikes(DragonRunnerMain.FRAME_WIDTH, (DragonRunnerMain.FRAME_HEIGHT - Ground.HEIGHT_OF_GROUND) - 100,
				100, 100);
	}
}
