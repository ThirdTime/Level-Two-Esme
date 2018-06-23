package dragonRunner;

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
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer gameTimer;
	
	final int MENU_STATE = 0;
	final int INSTRUCTION_STATE = 1;
	final int GAME_STATE = 2;
	final int END_STATE_ARROW = 3;
	final int END_STATE_SPIKE = 4;
	final int END_STATE_WIN = 5;
	int currentState = MENU_STATE;
	
	public static BufferedImage tempiArrowState;
	public static BufferedImage tempiInstructionState;
	public static BufferedImage tempiMenuState;
	public static BufferedImage tempiSpikeState;
	public static BufferedImage tempiWinState;
	public static BufferedImage tempiGameState;
	
	ObjectManagerK manager = new ObjectManagerK();
	ScoreManager scoreManager = new ScoreManager();
	
	public GamePanel() {
		gameTimer = new Timer(1000 / 60, this);
		
		try {
			tempiArrowState = ImageIO.read(this.getClass().getResourceAsStream("tempImgArrowState.png"));
			tempiGameState = ImageIO.read(this.getClass().getResourceAsStream("tempImgGameState.png"));
			tempiInstructionState = ImageIO.read(this.getClass().getResourceAsStream("tempImgInstructionState.png"));
			tempiMenuState = ImageIO.read(this.getClass().getResourceAsStream("tempImgMenuState.png"));
			tempiSpikeState = ImageIO.read(this.getClass().getResourceAsStream("tempImgSpikeState.png"));
			tempiWinState = ImageIO.read(this.getClass().getResourceAsStream("tempImgWinState.png"));
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
		g.drawImage(GamePanel.tempiMenuState, WIDTH, HEIGHT, DragonRunnerMain.FRAME_WIDTH, DragonRunnerMain.FRAME_HEIGHT, null);
	}
	/////////////////////////////////////////////

	public void updateInstructionState() {

	}

	public void drawInstructionState(Graphics g) {
		g.drawImage(GamePanel.tempiInstructionState, WIDTH, HEIGHT, DragonRunnerMain.FRAME_WIDTH, DragonRunnerMain.FRAME_HEIGHT, null);
	}
	/////////////////////////////////////////////

	public void updateGameState() {
		manager.update();
		if(manager.dragon.struckByArrow){
			currentState = END_STATE_ARROW;
		//	gameEndTime = System.currentTimeMillis();
		//	timesGamePlayed = timesGamePlayed + 1;
		//	currentScore = getStringScore();
		}
		
		if(manager.dragon.struckBySpike){
			currentState = END_STATE_SPIKE;
		//	gameEndTime = System.currentTimeMillis();
		//	timesGamePlayed = timesGamePlayed + 1;
		//	currentScore = getStringScore();
		}
	}

	public void drawGameState(Graphics g) {
		Font helvetica = new Font ("Helvetica", Font.PLAIN, 80);
		g.setFont(helvetica);
		g.setColor(Color.ORANGE);
	//	g.drawString(scoreManager.highScore, 100, 100);
		manager.draw(g);
		System.out.println(scoreManager.getHighScore());
		//g.drawImage(GamePanel.tempiGameState, WIDTH, HEIGHT, DragonRunnerMain.FRAME_WIDTH, DragonRunnerMain.FRAME_HEIGHT, null);
	}
	/////////////////////////////////////////////

	public void updateArrowState() {

	}

	public void drawArrowState(Graphics g) {
		Font helvetica = new Font ("Helvetica", Font.PLAIN, 80);
		g.setFont(helvetica);
		g.setColor(Color.MAGENTA);
		g.drawString("Your score is " + scoreManager.getCurrentScore(), 100, 100);
		g.drawString("High score is " + scoreManager.getHighScore(), 100, 200);
	}
	/////////////////////////////////////////////

	public void updateSpikeState() {

	}

	public void drawSpikeState(Graphics g) {
		Font helvetica = new Font ("Helvetica", Font.PLAIN, 80);
		g.setFont(helvetica);
		g.setColor(Color.MAGENTA);
		g.drawString("Your score is " + scoreManager.getCurrentScore(), 100, 100);
		g.drawString("High score is " + scoreManager.getHighScore(), 100, 200);
	//	g.drawImage(GamePanel.tempiSpikeState, WIDTH, HEIGHT, DragonRunnerMain.FRAME_WIDTH, DragonRunnerMain.FRAME_HEIGHT, null);
	}
	/////////////////////////////////////////////

	public void updateWinState() {

	}

	public void drawWinState(Graphics g) {
		g.drawImage(GamePanel.tempiWinState, WIDTH, HEIGHT, DragonRunnerMain.FRAME_WIDTH, DragonRunnerMain.FRAME_HEIGHT, null);
	}
	/////////////////////////////////////////////
	// END OF STATES
	/////////////////////////////////////////////

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
		} else if (currentState == END_STATE_WIN) {
			updateWinState();
		}

	}

	public void paintComponent(Graphics g) {
		// gameObject.draw(g);

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
		} else if (currentState == END_STATE_WIN) {
			drawWinState(g);
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

		if (e.getKeyCode() == 38){
			//that's the up arrow
			manager.dragonUp();
		}
		
		if (e.getKeyCode() == 40){
			//that's the down arrow
			manager.dragonDown();
		}
		
		if (e.getKeyCode() == 83) {
			// that's [s]
			if (currentState == MENU_STATE) {
				currentState = GAME_STATE;
				scoreManager.startGame();
			} else if (currentState == INSTRUCTION_STATE) {
				currentState = GAME_STATE;
				scoreManager.startGame();
			}
		}

		if (e.getKeyCode() == 73) {
			// that's [i]
			if (currentState == MENU_STATE) {
				currentState = INSTRUCTION_STATE;
			}

		}

		if (e.getKeyCode() == 82) {
			// that's [r]
			if ((currentState == END_STATE_ARROW) || (currentState == END_STATE_SPIKE)
					|| (currentState == END_STATE_WIN)) {
				currentState = MENU_STATE;
				manager = new ObjectManagerK();
			}
		}

		if (e.getKeyCode() == 81) {
			/*
			 * that's [q]
			 * 
			 * assigning the death (arrow) state here just so that I can see it without
			 * playing the game delete this once collision boxes are programmed
			 */

			if (currentState == GAME_STATE) {
				currentState = END_STATE_ARROW;
				scoreManager.endGame();
			}

		}

		if (e.getKeyCode() == 87) {
			/*
			 * that's [w]
			 * 
			 * assigning the win state here just so that I can see it without playing the
			 * game delete this once collision boxes are programmed
			 */

			if (currentState == GAME_STATE) {
				currentState = END_STATE_WIN;
			}
		}

		if (e.getKeyCode() == 69) {
			/*
			 * that's [e]
			 * 
			 * assigning the death (spike) state here just so that I can see it without
			 * playing the game delete this once collision boxes are programmed
			 */

			if (currentState == GAME_STATE) {
				currentState = END_STATE_SPIKE;
				scoreManager.endGame();
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == 38){
			//that's the up arrow
			manager.dragonStop();
		}
		
		if (e.getKeyCode() == 40){
			//that's the down arrow
			manager.dragonStop();
		}
	}

}
