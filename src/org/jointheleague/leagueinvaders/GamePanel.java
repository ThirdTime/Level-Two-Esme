package org.jointheleague.leagueinvaders;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	
	Timer gameTimer = new Timer(1000 / 60, this);
	GameObject gameObject;
	
	public GamePanel() {
		gameObject = new GameObject(3, 2, 5, 7);
	}
	public void actionPerformed(ActionEvent e) {
		repaint();
		gameObject.update();
	}

	public void startGame() {
		gameTimer.start();
	}
	
	@Override
	public void paintComponent (Graphics g) {
		gameObject.draw(g);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("key ... typed");
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("key ... pressed");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("key ... released");
		
	}

}
