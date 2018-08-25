package dragonRunner;

public class ScoreManager {
	int startTimeAsInt;
	int endTimeAsInt;
	static long gameStartTime;
	long gameEndTime;
	int timesGamePlayed;
	int highScore;
	int currentScore;
	int lastScore;

	public void startGame() {
		gameStartTime = System.currentTimeMillis();
	}

	public void calculateCurrentScore() {
		gameEndTime = System.currentTimeMillis();
		int startTimeAsInt = (int) gameStartTime;
		int endTimeAsInt = (int) gameEndTime;
		currentScore = (endTimeAsInt - startTimeAsInt) / 1000;
		calculateHighScore();
	}

	public void calculateHighScore() {
		if (timesGamePlayed == 1) {
			highScore = currentScore;
		} else {
			if (highScore < currentScore) {
				highScore = currentScore;
			} 
		}
	}

	public int getHighScore() {
		return highScore;
	}

	public int getCurrentScore() {
		return currentScore;
	}
}
