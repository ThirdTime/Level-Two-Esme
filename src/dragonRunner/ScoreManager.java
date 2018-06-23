package dragonRunner;

public class ScoreManager {
	int startTimeAsInt;
	int endTimeAsInt;
	long gameStartTime;
	long gameEndTime;
	int timesGamePlayed;
	int highScore;
	int currentScore;

	public void startGame() {
		gameStartTime = System.currentTimeMillis();
	}

	public void endGame() {
		gameEndTime = System.currentTimeMillis();
		calculateCurrentScore();
		calculateHighScore();
	}

	public void calculateCurrentScore() {
		int startTimeAsInt = (int) gameStartTime;
		int endTimeAsInt = (int) gameEndTime;
		currentScore = (endTimeAsInt - startTimeAsInt) / 1000;
	}

	public int calculateHighScore() {
		if (highScore == 0) {
			return highScore;
		} else {
			if (highScore > currentScore) {
				highScore = currentScore;
				currentScore = 0;
				return highScore;
			} else
				return highScore;
		}
	}

	public int getHighScore() {
		return highScore;
	}

	public int getCurrentScore() {
		return currentScore;
	}
}
