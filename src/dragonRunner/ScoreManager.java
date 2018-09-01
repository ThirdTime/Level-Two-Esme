package dragonRunner;

public class ScoreManager {
	private int startTimeAsInt;
	private int endTimeAsInt;
	private static long gameStartTime;
	private long gameEndTime;
	private int timesGamePlayed;
	private int highScore;
	private int currentScore;
	private int lastScore;

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
	
	public void increaseTimesGamePlayed() {
		timesGamePlayed++;
	}
}
