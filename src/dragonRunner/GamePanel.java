package dragonRunner;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer gameTimer;

	private final int MENU_STATE = 0;
	private final int INSTRUCTION_STATE = 1;
	private final int GAME_STATE = 2;
	private final int END_STATE_ARROW = 3;
	private final int END_STATE_SPIKE = 4;
	private int currentState = MENU_STATE;

	public static BufferedImage instructionState;
	public static BufferedImage imgSpikeDeathBackground;
	public static BufferedImage imgArrowDeathBackground;
	public static BufferedImage imgMenuStateBackground;
	public static BufferedImage imgInstructionsStateBackground;
	public static BufferedImage imgGameBackground;
	public static BufferedImage imgCloud;
	public static BufferedImage imgArrow;
	public static BufferedImage imgSpikes;
	public static BufferedImage imgGround;
	public static BufferedImage imgDragon;
	public static BufferedImage imgFire;

	ObjectManagerK manager = new ObjectManagerK();
	ScoreManager scoreManager = new ScoreManager();

	public GamePanel() {
		gameTimer = new Timer(1000 / 60, this);

		try {
			imgInstructionsStateBackground = ImageIO
					.read(this.getClass().getResourceAsStream("./gameImages/instructionsState.png"));
			imgMenuStateBackground = ImageIO.read(this.getClass().getResourceAsStream("./gameImages/startState.png"));
			imgSpikeDeathBackground = ImageIO.read(this.getClass().getResourceAsStream("./gameImages/spikeDeath.jpg"));
			imgArrowDeathBackground = ImageIO.read(this.getClass().getResourceAsStream("./gameImages/arrowDeath.jpg"));
			imgGameBackground = ImageIO.read(this.getClass().getResourceAsStream("./gameImages/imgGameBackground.png"));
			imgCloud = ImageIO.read(this.getClass().getResourceAsStream("./gameImages/cloud.png"));
			imgArrow = ImageIO.read(this.getClass().getResourceAsStream("./gameImages/arrow.png"));
			imgSpikes = ImageIO.read(this.getClass().getResourceAsStream("./gameImages/spikes.png"));
			imgGround = ImageIO.read(this.getClass().getResourceAsStream("./gameImages/ground.jpg"));
			imgDragon = ImageIO.read(this.getClass().getResourceAsStream("./gameImages/Dragon.png"));
			imgFire = ImageIO.read(this.getClass().getResourceAsStream("./gameImages/fire.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/////////////////////////////////////////////
	// START OF STATES
	/////////////////////////////////////////////
	public void updateMenuState() {

	}

	public void drawMenuState(Graphics g) {
		g.drawImage(GamePanel.imgMenuStateBackground, WIDTH, HEIGHT, DragonRunnerMain.FRAME_WIDTH,
				DragonRunnerMain.FRAME_HEIGHT, null);
	}
	/////////////////////////////////////////////

	public void updateInstructionState() {

	}

	public void drawInstructionState(Graphics g) {
		g.drawImage(GamePanel.imgInstructionsStateBackground, WIDTH, HEIGHT, DragonRunnerMain.FRAME_WIDTH,
				DragonRunnerMain.FRAME_HEIGHT, null);
	}
	/////////////////////////////////////////////

	public void updateGameState() {
		manager.update();
		scoreManager.calculateCurrentTime();
		if (manager.dragon.struckByArrow) {
			currentState = END_STATE_ARROW;
			playSound("./gameSounds/soundGameOver.wav");
		}

		if (manager.dragon.struckBySpike) {
			currentState = END_STATE_SPIKE;
			playSound("./gameSounds/soundGameOver.wav");
		}
	}

	public void drawGameState(Graphics g) {
		g.drawImage(GamePanel.imgGameBackground, WIDTH, HEIGHT, DragonRunnerMain.FRAME_WIDTH,
				DragonRunnerMain.FRAME_HEIGHT, null);

		Font helvetica = new Font("Helvetica", Font.PLAIN, 30);
		g.setFont(helvetica);
		g.setColor(Color.ORANGE);
		manager.draw(g);
		g.setColor(Color.BLACK);
		g.drawString("S: " + scoreManager.getCurrentTime(), 850, 30);
		g.drawString("HS: " + scoreManager.getHighScore(), 750, 30);
	}
	/////////////////////////////////////////////

	public void updateArrowState() {

	}

	public void drawArrowState(Graphics g) {
		g.drawImage(GamePanel.imgArrowDeathBackground, WIDTH, HEIGHT, DragonRunnerMain.FRAME_WIDTH,
				DragonRunnerMain.FRAME_HEIGHT, null);

		Font helvetica = new Font("Helvetica", Font.PLAIN, 80);
		g.setFont(helvetica);
		g.setColor(Color.YELLOW);
		g.drawString("" + scoreManager.getCurrentTime(), 600, 230);
		g.drawString("" + scoreManager.getHighScore(), 660, 305);
	}
	/////////////////////////////////////////////

	public void updateSpikeState() {

	}

	public void drawSpikeState(Graphics g) {
		g.drawImage(GamePanel.imgSpikeDeathBackground, WIDTH, HEIGHT, DragonRunnerMain.FRAME_WIDTH,
				DragonRunnerMain.FRAME_HEIGHT, null);

		Font helvetica = new Font("Helvetica", Font.PLAIN, 80);
		g.setFont(helvetica);
		g.setColor(Color.YELLOW);
		g.drawString("" + scoreManager.getCurrentTime(), 600, 230);
		g.drawString("" + scoreManager.getHighScore(), 660, 305);
	}

	/////////////////////////////////////////////
	// END OF STATES
	/////////////////////////////////////////////

	// PLAY SOUNDS
	private void playSound(String fileName) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}

	public void actionPerformed(ActionEvent e) {
		repaint();
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == INSTRUCTION_STATE) {
			updateInstructionState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE_ARROW) {
			updateArrowState();
		} else if (currentState == END_STATE_SPIKE) {
			updateSpikeState();
		}
	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == INSTRUCTION_STATE) {
			drawInstructionState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE_ARROW) {
			drawArrowState(g);
		} else if (currentState == END_STATE_SPIKE) {
			drawSpikeState(g);
		}
	}

	public void startGame() {
		gameTimer.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == 38) { // Keycode: Up Arrow
			manager.dragonUp();
		}

		if (e.getKeyCode() == 40) { // Keycode: Down Arrow
			manager.dragonDown();
		}

		if (e.getKeyCode() == 83) { // Keycode: S
			if (currentState == MENU_STATE) {
				currentState = GAME_STATE;
				playSound("./gameSounds/soundGameBegin.wav");
				scoreManager.startGame();
			} else if (currentState == INSTRUCTION_STATE) {
				currentState = GAME_STATE;
				playSound("./gameSounds/soundGameBegin.wav");
				scoreManager.startGame();
			}
		}

		if (e.getKeyCode() == 73) { // Keycode: I
			if (currentState == MENU_STATE) {
				playSound("./gameSounds/soundGameSelect.wav");
				currentState = INSTRUCTION_STATE;
			}

		}

		if (e.getKeyCode() == 82) { // Keycode: R
			if ((currentState == END_STATE_ARROW) || (currentState == END_STATE_SPIKE)) {
				currentState = MENU_STATE;
				playSound("./gameSounds/soundGameSelect.wav");
				manager = new ObjectManagerK();
			}
		}

		if (e.getKeyCode() == 32) { // Keycode: Space
			manager.deleteBar();
			manager.fireFire();

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == 38) { // Keycode: Up Arrow
			manager.dragonStop();
		}

		if (e.getKeyCode() == 40) { // Keycode: Down Arrow
			manager.dragonStop();
		}
	}

}
