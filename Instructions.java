
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Instructions {
	public static void createAndShowGUI() {
		JFrame frame = new JFrame("Instructions");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//setting up the frame
		frame.setPreferredSize(new Dimension(420, 300));
		
		//declaring spring layout
		SpringLayout layout = new SpringLayout();
		frame.setLayout(layout);
		
		//making the title
		JLabel title = new JLabel("Instructions");
		//making constraints for title
		layout.putConstraint(SpringLayout.WEST, title, 50, SpringLayout.WEST, frame);
		layout.putConstraint(SpringLayout.NORTH, title, 50, SpringLayout.NORTH, frame);
		frame.add(title);
		
		//writing the instructions
		JLabel ta = new JLabel("<html>There are 4 classes to choose from <br> There are 4 spells for each class <br> The first Spell is a damage spell <br> The second spell is a damage over time spell <br> The third spell is a healing spell <br> And the fourth spell is a debuff spell");
		layout.putConstraint(SpringLayout.WEST, ta, 50, SpringLayout.WEST, frame);
		layout.putConstraint(SpringLayout.NORTH, ta, 50, SpringLayout.SOUTH, title);
		frame.add(ta);
		
		
		frame.pack();
        frame.setVisible(true);
	
	
	
	}

}