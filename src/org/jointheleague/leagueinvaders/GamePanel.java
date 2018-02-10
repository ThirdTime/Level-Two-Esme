package org.jointheleague.leagueinvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int FRAME_WIDTH = 500;
	final int FRAME_LENGTH = 800;
	
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;

	Font titleFont;
	
	void updateMenuState() {

	}

	void updateGameState() {

	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, FRAME_WIDTH, FRAME_LENGTH);
		g.setFont(titleFont);
		g.drawString("Testing!", 100, 200);
		
		// replace the 500 and 800 later with the actual variable values of the panel
		// but it's ok to be lazy for now
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, FRAME_WIDTH, FRAME_LENGTH);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.fillRect(0, 0, FRAME_WIDTH, FRAME_LENGTH);
	}

	Timer gameTimer = new Timer(1000 / 60, this);
	// GameObject gameObject;

	public GamePanel() {
		titleFont = new Font("Arial",Font.PLAIN, 100);
		// gameObject = new GameObject(3, 2, 5, 7);
	}

	public void actionPerformed(ActionEvent e) {
		repaint();
		// gameObject.update();

		if (currentState == MENU_STATE) {

			updateMenuState();

		} else if (currentState == GAME_STATE) {

			updateGameState();

		} else if (currentState == END_STATE) {

			updateEndState();

		}
	}

	public void startGame() {
		gameTimer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {

			drawMenuState(g);

		} else if (currentState == GAME_STATE) {

			drawGameState(g);

		} else if (currentState == END_STATE) {

			drawEndState(g);

		}
		// gameObject.draw(g);
	}

	@Override
	public void keyTyped(KeyEvent e) {


	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		if (e.getKeyCode() == 10) {
			if(currentState == MENU_STATE) {
				currentState = GAME_STATE;
			}
			else if(currentState == GAME_STATE) {
				currentState = END_STATE;
			}
			else if (currentState == END_STATE) {
				currentState = MENU_STATE;
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
