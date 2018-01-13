package org.jointheleague.level2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//imports
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/* INSTRUCTIONS:
 * make a GUI with two buttons, add name and read names.
 * when the add name is clicked, make an input dialog that adds the person's name to the array list
 * view names shows all the names on the array list like this with a show message dialog
 * Guest #1: Miguel Leon
 * Guest #2: Jae-suk Park
 * Guest #3: Miriam Goldmann
 * and so on.
 */

public class GuestBook implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton readNameButton = new JButton();
	JButton addNameButton = new JButton();

	String userInputtedName;

	ArrayList<String> guestList = new ArrayList<>();
	ArrayList<String> bannedGuestList = new ArrayList<>();
	
	public void bannedGuests() {
		bannedGuestList.add("Isis Jenkins");
		bannedGuestList.add("Michiyo Oguri");
		bannedGuestList.add("he");
	}
	
	
	public static void main(String[] args) {
		GuestBook thisClass = new GuestBook();
		thisClass.createUI();
		
	}
	
	
	public void createUI() {
		frame.add(panel);
		frame.setTitle("Guest Book");
		panel.add(addNameButton);
		panel.add(readNameButton);
		readNameButton.setText("Read Names");
		addNameButton.setText("Add Name");

		addNameButton.addActionListener(this);
		readNameButton.addActionListener(this);
		frame.setVisible(true);
		frame.pack();
	}

	public void actionPerformed(ActionEvent e) {
		JButton buttonClicked = (JButton) e.getSource();
		if (buttonClicked == addNameButton) {
			userInputtedName = JOptionPane.showInputDialog("Please add a name.");
			//if(bannedGuestList.contains(userInputtedName)) {
				JOptionPane.showMessageDialog(null, "This person is banned from our guestlist.");
			//} else {
			guestList.add(userInputtedName);
			//}
			System.out.println(bannedGuestList);
		}
		
		if (buttonClicked == readNameButton) {
			JOptionPane.showMessageDialog(null, simplyWrittenArray(guestList));
		}

	}

	public String simplyWrittenArray(ArrayList<String> list) {
		String toDisplay = "";
		for (int i = 0; i < guestList.size(); i++) {
			int iPlusOne = i + 1;
			toDisplay = toDisplay + "Guest #" + iPlusOne + ": " + list.get(i) + "\n";
		}
		return toDisplay;

	}
	
}
