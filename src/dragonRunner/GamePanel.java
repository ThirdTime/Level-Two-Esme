package dragonRunner;

import java.awt.Color;
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
	// GameObject gameObject;

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
		g.drawImage(GamePanel.tempiMenuState, WIDTH, HEIGHT, dragonRunnerMain.FRAME_WIDTH, dragonRunnerMain.FRAME_HEIGHT, null);
	}
	/////////////////////////////////////////////

	public void updateInstructionState() {

	}

	public void drawInstructionState(Graphics g) {
		g.drawImage(GamePanel.tempiInstructionState, WIDTH, HEIGHT, dragonRunnerMain.FRAME_WIDTH, dragonRunnerMain.FRAME_HEIGHT, null);
	}
	/////////////////////////////////////////////

	public void updateGameState() {
		manager.update();
	}

	public void drawGameState(Graphics g) {
		manager.draw(g);
		g.drawImage(GamePanel.tempiGameState, WIDTH, HEIGHT, dragonRunnerMain.FRAME_WIDTH, dragonRunnerMain.FRAME_HEIGHT, null);
	}
	/////////////////////////////////////////////

	public void updateArrowState() {

	}

	public void drawArrowState(Graphics g) {
		g.drawImage(GamePanel.tempiArrowState, WIDTH, HEIGHT, dragonRunnerMain.FRAME_WIDTH, dragonRunnerMain.FRAME_HEIGHT, null);
	}
	/////////////////////////////////////////////

	public void updateSpikeState() {

	}

	public void drawSpikeState(Graphics g) {
		g.drawImage(GamePanel.tempiSpikeState, WIDTH, HEIGHT, dragonRunnerMain.FRAME_WIDTH, dragonRunnerMain.FRAME_HEIGHT, null);
	}
	/////////////////////////////////////////////

	public void updateWinState() {

	}

	public void drawWinState(Graphics g) {
		g.drawImage(GamePanel.tempiWinState, WIDTH, HEIGHT, dragonRunnerMain.FRAME_WIDTH, dragonRunnerMain.FRAME_HEIGHT, null);
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

		if (e.getKeyCode() == 83) {
			// that's [s]
			if (currentState == MENU_STATE) {
				currentState = GAME_STATE;
			} else if (currentState == INSTRUCTION_STATE) {
				currentState = GAME_STATE;
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
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}