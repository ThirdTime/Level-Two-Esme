package dragonRunner;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer gameTimer;
//	GameObject gameObject;

	final int MENU_STATE = 0;
	final int INSTRUCTION_STATE = 1;
	final int GAME_STATE = 2;
	final int END_STATE_ARROW = 3;
	final int END_STATE_SPIKE = 4;
	final int END_STATE_WIN = 5;
	int currentState = MENU_STATE;

	public GamePanel() {
		gameTimer = new Timer(1000 / 60, this);
	//	gameObject = new GameObject(10, 10, 40, 40);
	}

	/////////////////////////////////////////////
	// START OF STATES
	/////////////////////////////////////////////
	public void updateMenuState() {

	}

	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, dragonRunnerMain.FRAME_WIDTH, dragonRunnerMain.FRAME_HEIGHT);    
	}
	/////////////////////////////////////////////

	public void updateInstructionState() {

	}

	public void drawInstructionState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, dragonRunnerMain.FRAME_WIDTH, dragonRunnerMain.FRAME_HEIGHT);    
	}
	/////////////////////////////////////////////

	public void updateGameState() {

	}

	public void drawGameState(Graphics g) {
		g.setColor(Color.PINK);
		g.fillRect(0, 0, dragonRunnerMain.FRAME_WIDTH, dragonRunnerMain.FRAME_HEIGHT);    
	}
	/////////////////////////////////////////////

	public void updateArrowState() {

	}

	public void drawArrowState(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, dragonRunnerMain.FRAME_WIDTH, dragonRunnerMain.FRAME_HEIGHT);    
	}
	/////////////////////////////////////////////

	public void updateSpikeState() {

	}

	public void drawSpikeState(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, dragonRunnerMain.FRAME_WIDTH, dragonRunnerMain.FRAME_HEIGHT);    
	}
	/////////////////////////////////////////////

	public void updateWinState() {

	}

	public void drawWinState(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, dragonRunnerMain.FRAME_WIDTH, dragonRunnerMain.FRAME_HEIGHT);    
	}
	/////////////////////////////////////////////
	// END OF STATES
	/////////////////////////////////////////////

	public void actionPerformed(ActionEvent e) {
		repaint();
	//	gameObject.update();

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
//		gameObject.draw(g);
		
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
		System.out.println("TYPED");

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("pressed");
		
		if(e.getKeyCode() == 83){
			//that's [s]
			if (currentState == MENU_STATE) {
				currentState = GAME_STATE;
			} else if(currentState == INSTRUCTION_STATE){
				currentState = GAME_STATE;
			}
		}
		
		if(e.getKeyCode() == 73){
			//that's [i]
			if (currentState == MENU_STATE) {
				currentState = INSTRUCTION_STATE;
			}
			
		}
		
		if (e.getKeyCode() == 38) {
			System.out.println("UP PRESSED");
		}

		if (e.getKeyCode() == 40) {
			System.out.println("DOWN PRESSED");

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("r");

	}

}
