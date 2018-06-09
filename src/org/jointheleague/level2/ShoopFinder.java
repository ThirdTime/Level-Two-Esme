package org.jointheleague.level2;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ShoopFinder {
	public static void main(String[] args) {
		
		ArrayList <Shoop> pets = new ArrayList <>();
		pets.add(new Shoop("shannon", 3));
		pets.add(new Shoop("shawn", 10));
		String name = JOptionPane.showInputDialog(null, "Enter Shoop's name.");
		String ageString = JOptionPane.showInputDialog(null, "Enter your Shoop's age.");
		int age = Integer.parseInt(ageString);
		Shoop petToFind = new Shoop(name, age);
		if(pets.contains(petToFind)) {
			JOptionPane.showMessageDialog(null, "We found your pet!");
		} else {
			JOptionPane.showMessageDialog(null, "We didn't find your pet :-(");
		}
		
	}
}
