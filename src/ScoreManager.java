

public class ScoreManager {
	private static long gameStartTime;
	private long gameEndTime;
	private int highScore;
	private int currentTime;

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
		if (highScore < currentTime) {
			highScore = currentTime;
		}
	}

	public int getHighScore() {
		return highScore;
	}

	public int getCurrentTime() {
		return currentTime;
	}
}
