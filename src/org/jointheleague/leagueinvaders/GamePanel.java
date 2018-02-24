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

	Rocketship rocket = new Rocketship(250, 700, 50, 50);
	ObjectManager manager = new ObjectManager(rocket);
	
	Font titleFontLeague;
	Font titleFontInvaders;
	Font textPressEnter;
	Font textPressSpace;
	Font textGameOver;
	Font textEnemiesKilled;
	Font textPressEnterToRestart;

	void updateMenuState() {

	}

	void updateGameState() {
		manager.update();
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(new Color(48, 44, 105));
		g.fillRect(0, 0, FRAME_WIDTH, FRAME_LENGTH);

		g.setFont(titleFontLeague);
		g.setColor(Color.GRAY);
		g.drawString("LEAGUE", 60, 150);

		g.setFont(titleFontInvaders);
		g.setColor(Color.GRAY);
		g.drawString("INVADERS", 20, 250);

		g.setFont(textPressEnter);
		g.setColor(Color.GRAY);
		g.drawString("Press ENTER to start", 18, 400);

		g.setFont(textPressSpace);
		g.setColor(Color.GRAY);
		g.drawString("Press SPACE for instructions", 32, 470);
	}

	void drawGameState(Graphics g) {
		g.setColor(new Color(4, 2, 26));
		g.fillRect(0, 0, FRAME_WIDTH, FRAME_LENGTH);

		manager.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(new Color(206, 100, 100));
		g.fillRect(0, 0, FRAME_WIDTH, FRAME_LENGTH);

		g.setFont(textGameOver);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 30, 200);

		g.setFont(textEnemiesKilled);
		g.setColor(Color.BLACK);
		g.drawString("You killed [x many] enemies", 30, 350);

		g.setFont(textPressEnterToRestart);
		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to restart", 60, 500);
	}

	Timer gameTimer = new Timer(1000 / 60, this);
	// GameObject gameObject;

	public GamePanel() {
		titleFontLeague = new Font("Arial", Font.BOLD, 80);
		titleFontInvaders = new Font("Arial", Font.BOLD, 80);

		textPressEnter = new Font("Arial", Font.PLAIN, 45);
		textPressSpace = new Font("Arial", Font.PLAIN, 30);

		textGameOver = new Font("Arial", Font.BOLD, 65);
		textEnemiesKilled = new Font("Arial", Font.PLAIN, 30);
		textPressEnterToRestart = new Font("Arial", Font.PLAIN, 30);

		// gameObject = new GameObject(3, 2, 5, 7);
	}

	public void actionPerformed(ActionEvent e) {
		repaint();

	//	rocket.update();

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

		if (e.getKeyCode() == 10) {
			if (currentState == MENU_STATE) {
				currentState = GAME_STATE;
			} else if (currentState == GAME_STATE) {
				currentState = END_STATE;
			} else if (currentState == END_STATE) {
				currentState = MENU_STATE;
			}
		}

		if (e.getKeyCode() == 37) {
			System.out.println("L PRESSED");
			rocket.setXSpeed(-5);
		}

		if (e.getKeyCode() == 39) {
			System.out.println("R PRESSED");
			rocket.setXSpeed(5);
		}

		if (e.getKeyCode() == 38) {
			System.out.println("U PRESSED");
			rocket.setYSpeed(-5);
		}

		if (e.getKeyCode() == 40) {
			System.out.println("D PRESSED");
			rocket.setYSpeed(5);
		}
		
		if(e.getKeyCode() == 32) {
			System.out.println("space bar has been pressed!");
			manager.addProjectile(new Projectile(rocket.x, rocket.y, 10, 10));
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 37) {
			System.out.println("L R");
			rocket.setXSpeed(0);
		}

		if (e.getKeyCode() == 39) {
			System.out.println("R R");
			rocket.setXSpeed(0);
		}
		
		if (e.getKeyCode() == 38) {
			System.out.println("U R");
			rocket.setYSpeed(0);
		}

		if (e.getKeyCode() == 40) {
			System.out.println("D R");
			rocket.setYSpeed(0);
		}


	}

}
