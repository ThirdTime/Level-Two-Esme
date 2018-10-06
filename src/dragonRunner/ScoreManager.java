package dragonRunner;

public class ScoreManager {
	private int startTimeAsInt;
	private int endTimeAsInt;
	private static long gameStartTime;
	private long gameEndTime;
	private int timesGamePlayed;
	private int highScore;
	private int currentTime;
	private int lastScore;

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
	
	public void increaseTimesGamePlayed() {
		timesGamePlayed++;
	}
}
