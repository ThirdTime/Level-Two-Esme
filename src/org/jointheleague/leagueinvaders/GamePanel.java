package org.jointheleague.leagueinvaders;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int FRAME_WIDTH = 500;
	final int FRAME_LENGTH = 800;

	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	final int INSTRUCTION_STATE = 3;
	int currentState = MENU_STATE;

	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage bulletImg;
	public static BufferedImage spaceImg;

	Rocketship rocket = new Rocketship(250, 700, 50, 50);
	ObjectManager manager = new ObjectManager(rocket);

	Font titleFontLeague;
	Font titleFontInvaders;
	Font textPressEnter;
	Font textPressSpace;
	Font textGameOver;
	Font textEnemiesKilled;
	Font textPressEnterToRestart;
	Font textArrowKeys;
	Font textSpaceBar;
	Font textGoodLuck;
	Font textEnterToCont;

	void updateMenuState() {

	}

	void updateGameState() {
		manager.update();
		manager.purgeObjects();
		manager.manageEnemies();
		manager.checkCollision();

		if (!rocket.isAlive) {
			currentState = END_STATE;
		}
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
		g.drawImage(GamePanel.spaceImg, WIDTH, HEIGHT, FRAME_WIDTH, FRAME_LENGTH, null);

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
		g.drawString("You killed " + manager.getScore() + " enemie(s)", 70, 350);

		g.setFont(textPressEnterToRestart);
		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to restart", 60, 500);
	}
	
	void drawInstructionState(Graphics g) {
		g.setColor(new Color(255, 187, 153));
		g.fillRect(0, 0, FRAME_WIDTH, FRAME_LENGTH);
		
		g.setFont(textArrowKeys);
		g.setColor(Color.BLACK);
		g.drawString("Press ARROW KEYS to move", 40, 200);
		
		g.setFont(textSpaceBar);
		g.setColor(Color.BLACK);
		g.drawString("Press SPACE to shoot", 85, 300);
		
		g.setFont(textGoodLuck);
		g.setColor(Color.BLACK);
		g.drawString("Good luck!", 170, 390);
		
		g.setFont(textEnterToCont);
		g.setColor(Color.BLACK);
		g.drawString("(press ENTER to continue)", 120, 450);
	}

	Timer gameTimer = new Timer(1000 / 60, this);

	public GamePanel() {
		titleFontLeague = new Font("Arial", Font.BOLD, 80);
		titleFontInvaders = new Font("Arial", Font.BOLD, 80);

		textPressEnter = new Font("Arial", Font.PLAIN, 45);
		textPressSpace = new Font("Arial", Font.PLAIN, 30);

		textGameOver = new Font("Arial", Font.BOLD, 65);
		textEnemiesKilled = new Font("Arial", Font.PLAIN, 30);
		textPressEnterToRestart = new Font("Arial", Font.PLAIN, 30);
		
		textArrowKeys = new Font("Arial", Font.PLAIN, 30);
		textSpaceBar = new Font("Arial", Font.PLAIN, 30);
		textGoodLuck = new Font("Arial", Font.PLAIN, 30);
		textEnterToCont = new Font("Arial", Font.PLAIN, 20);

		try {
			alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
			rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
			bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
			spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		repaint();

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

		} else if (currentState == INSTRUCTION_STATE) {
			
			drawInstructionState(g);
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
				rocket = new Rocketship(250, 700, 50, 50);
				manager = new ObjectManager(rocket);
			}
			else if (currentState == INSTRUCTION_STATE){
				currentState = GAME_STATE;
			}
		}

		if (e.getKeyCode() == 37) {
			// System.out.println("L PRESSED");

			if (rocket.x <= -15) {
				rocket.x = 510;
			} else {
				rocket.setXSpeed(-5);
			}
		}

		if (e.getKeyCode() == 39) {
			// System.out.println("R PRESSED");
			if (rocket.x >= 510) {
				rocket.x = -50;
			} else {
				rocket.setXSpeed(5);
			}
		}

		if (e.getKeyCode() == 38) {
			// System.out.println("U PRESSED");
			rocket.setYSpeed(-5);
		}

		if (e.getKeyCode() == 40) {
			// System.out.println("D PRESSED");
			rocket.setYSpeed(5);
		}

		if (e.getKeyCode() == 32) {
			
			if(currentState == MENU_STATE){
				currentState = INSTRUCTION_STATE;
			
			}
			
			// System.out.println("space bar has been pressed!");
			manager.addProjectile(new Projectile(rocket.getxRocketPos(), rocket.getyRocketPos(), 10, 10));
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 37) {
			// System.out.println("L R");
			rocket.setXSpeed(0);
		}

		if (e.getKeyCode() == 39) {
			// System.out.println("R R");
			rocket.setXSpeed(0);
		}

		if (e.getKeyCode() == 38) {
			// System.out.println("U R");
			rocket.setYSpeed(0);
		}

		if (e.getKeyCode() == 40) {
			// System.out.println("D R");
			rocket.setYSpeed(0);
		}

	}

}
