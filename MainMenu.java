import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu {
	private static void createAndShowGUI() {
		//creating the frame
		JFrame frame = new JFrame("Class Game Menu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the dimensions
		frame.setPreferredSize(new Dimension(340, 200));
		
		//declaring spring layout
		SpringLayout layout = new SpringLayout();
		frame.setLayout(layout);
		
		//making warlockButton
		JButton warlockButton = new JButton("Warlock");
		warlockButton.setEnabled(true);
		frame.add(warlockButton);
		//making warriorButton
		JButton warriorButton = new JButton("Warrior ");
		warriorButton.setEnabled(true);
		frame.add(warriorButton);
		//making shamanButton
		JButton shamanButton = new JButton("Shaman ");
		shamanButton.setEnabled(true);
		frame.add(shamanButton);
		//making paladinButton
		JButton paladinButton = new JButton("Paladin  ");
		paladinButton.setEnabled(true);
		frame.add(paladinButton);
		
		//making instrButton
		JButton instrButton = new JButton("Instructions");
		instrButton.setEnabled(true);
		frame.add(instrButton);
		
		//making the title
		JLabel title = new JLabel("Choose Your Class");
		frame.add(title);
		
		//making constraints for title
		layout.putConstraint(SpringLayout.WEST, title, 50, SpringLayout.WEST, frame);
		layout.putConstraint(SpringLayout.NORTH, title, 5, SpringLayout.NORTH, frame);
		
		
		//making constraints for warlockbutton
		layout.putConstraint(SpringLayout.WEST, warlockButton, 50, SpringLayout.WEST, frame);
		layout.putConstraint(SpringLayout.NORTH, warlockButton, 5, SpringLayout.SOUTH, title);
        
        //making constraints for warriorbutton
        layout.putConstraint(SpringLayout.WEST, warriorButton, 50, SpringLayout.WEST, frame);
        layout.putConstraint(SpringLayout.NORTH, warriorButton, 5, SpringLayout.SOUTH, warlockButton);
        
        //making constraints for shamanbutton
        layout.putConstraint(SpringLayout.WEST, shamanButton, 50, SpringLayout.WEST, frame);
        layout.putConstraint(SpringLayout.NORTH, shamanButton, 5, SpringLayout.SOUTH, warriorButton);
        
        //making constraints for paladinbutton
        layout.putConstraint(SpringLayout.WEST, paladinButton, 50, SpringLayout.WEST, frame);
        layout.putConstraint(SpringLayout.NORTH, paladinButton, 5, SpringLayout.SOUTH, shamanButton);
		
		//making constraints for instrbutton
		layout.putConstraint(SpringLayout.WEST, instrButton, 50, SpringLayout.EAST, shamanButton);
		layout.putConstraint(SpringLayout.NORTH, instrButton, 50, SpringLayout.NORTH, frame);
		
		//creating the event handler for launch button 
		warlockButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					javax.swing.SwingUtilities.invokeLater(new Runnable() {
          			 public void run() {
                            Warlock p = new Warlock();
               		 		Game.createAndShowGUI(p); //opens the game with a warlock as the user
							//frame.dispose();  not going to exit yet.
            			}
       		 });
				}
			});
        
        //creating the event handler for launch button
        warriorButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        Warrior p = new Warrior();
                        Game.createAndShowGUI(p); //opens the game
                        //frame.dispose();  not going to exit yet.
                    }
                });
            }
        });
        
        //creating the event handler for launch button
        shamanButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        Shaman p = new Shaman();
                        Game.createAndShowGUI(p); //opens the game
                        //frame.dispose();  not going to exit yet.
                    }
                });
            }
        });
        
        //creating the event handler for launch button
        warriorButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        Paladin p = new Paladin();
                        Game.createAndShowGUI(p); //opens the game
                        //frame.dispose();  not going to exit yet.
                    }
                });
            }
        });
			
		//creating the event handler for instructions button 
		instrButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					javax.swing.SwingUtilities.invokeLater(new Runnable() {
          			 public void run() {
               		 		Instructions.createAndShowGUI(); //opens the page
							//frame.dispose();
            			}
       		 });
				}
			});
			
		//making the frame visible
		frame.pack();
        frame.setVisible(true);
	
	}

	public static void main(String[] args) { 
	 javax.swing.SwingUtilities.invokeLater(new Runnable() {
          			 public void run() {
               		 		createAndShowGUI();
            			}
       		 });
	}
}