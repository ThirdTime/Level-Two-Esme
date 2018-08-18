package dragonRunner;

public class ScoreManager {
	int startTimeAsInt;
	int endTimeAsInt;
	long gameStartTime;
	long gameEndTime;
	int timesGamePlayed;
	int highScore;
	int currentTime;
	int lastScore;

	public void startGame() {
		gameStartTime = System.currentTimeMillis();
	}

	public void calculateCurrentTime() {
		gameEndTime = System.currentTimeMillis();
		int startTimeAsInt = (int) gameStartTime;
		int endTimeAsInt = (int) gameEndTime;
		currentTime = (endTimeAsInt - startTimeAsInt) / 1000;
		calculateHighScore();
	}

	public void calculateHighScore() {
		if (timesGamePlayed == 1) {
			highScore = currentTime;
		} else {
			if (highScore < currentTime) {
				highScore = currentTime;
			} 
		}
	}

	public int getHighScore() {
		return highScore;
	}

	public int getCurrentTime() {
		return currentTime;
	}
}
