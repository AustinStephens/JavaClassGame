
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class Game {
	public static Player user;
	public static Player enemy;
	public static boolean gameOver;
	public static JFrame frame;
	public static JTextArea output;
	public static JButton damageButton;
	public static JButton dotButton;
	public static JButton hosButton;
	public static JButton debuffButton;
	
	public static void createAndShowGUI(Player p) {
		user = p;
		
		
		frame = new JFrame("Class Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setting up the frame
		frame.setPreferredSize(new Dimension(400, 300));
		
		SpringLayout layout = new SpringLayout();
		frame.setLayout(layout);
		
		//making damageButton
		damageButton = new JButton(user.damageName);
		damageButton.setEnabled(true);
		frame.add(damageButton);
		
		//making dotButton
		dotButton = new JButton(user.dotName);
		dotButton.setEnabled(true);
		frame.add(dotButton);
		
		//making hosButton
		hosButton = new JButton(user.hosName);
		hosButton.setEnabled(true);
		frame.add(hosButton);
		
		//making debuffButton
		debuffButton = new JButton(user.debuffName);
		debuffButton.setEnabled(true);
		frame.add(debuffButton);
		
		//dialog output
		output = new JTextArea();
		frame.add(output);
		
		
		//HEALTH BARS
		JLabel enemyHealthLabel = new JLabel("Enemy Health");
		frame.add(enemyHealthLabel);
		
		JLabel enemyHealthBar = new JLabel("100/100");
		frame.add(enemyHealthBar);
		
		JLabel userHealthLabel = new JLabel("Your Health");
		frame.add(userHealthLabel);
		
		JLabel userHealthBar = new JLabel("100/100");
		frame.add(userHealthBar);
		
		//making constraints for damageButton
		layout.putConstraint(SpringLayout.WEST, damageButton, 50, SpringLayout.WEST, frame);
		layout.putConstraint(SpringLayout.NORTH, damageButton, 20, SpringLayout.NORTH, frame);
		
		//making constraints for dotButton
		layout.putConstraint(SpringLayout.WEST, dotButton, 50, SpringLayout.WEST, frame);
		layout.putConstraint(SpringLayout.NORTH, dotButton, 20, SpringLayout.SOUTH, damageButton);
		
		//making constraints for hosButton
		layout.putConstraint(SpringLayout.WEST, hosButton, 50, SpringLayout.WEST, frame);
		layout.putConstraint(SpringLayout.NORTH, hosButton, 20, SpringLayout.SOUTH, dotButton);
		
		//making constraints for debuffButton
		layout.putConstraint(SpringLayout.WEST, debuffButton, 50, SpringLayout.WEST, frame);
		layout.putConstraint(SpringLayout.NORTH, debuffButton, 20, SpringLayout.SOUTH, hosButton);
		
		//making constraints for ehl
		layout.putConstraint(SpringLayout.EAST, enemyHealthLabel, -50, SpringLayout.EAST, frame);
		layout.putConstraint(SpringLayout.NORTH, enemyHealthLabel, 20, SpringLayout.NORTH, frame);
		
		//making constraints for ehb
		layout.putConstraint(SpringLayout.EAST, enemyHealthBar, -50, SpringLayout.EAST, frame);
		layout.putConstraint(SpringLayout.NORTH, enemyHealthBar, 2, SpringLayout.SOUTH, enemyHealthLabel);
		
		//making constraints for uhb
		layout.putConstraint(SpringLayout.EAST, userHealthBar, -50, SpringLayout.EAST, frame);
		layout.putConstraint(SpringLayout.NORTH, userHealthBar, 2, SpringLayout.SOUTH, userHealthLabel);
		
		//making constraints for uhl
		layout.putConstraint(SpringLayout.EAST, userHealthLabel, -50, SpringLayout.EAST, frame);
		layout.putConstraint(SpringLayout.NORTH, userHealthLabel, 20, SpringLayout.SOUTH, enemyHealthBar);
		
		//making constraints for output
		layout.putConstraint(SpringLayout.EAST, output, -20, SpringLayout.EAST, frame);
		layout.putConstraint(SpringLayout.NORTH, output, 10, SpringLayout.SOUTH, userHealthBar);
		
		//randomy generating enemy class
		String opponent = "";
		int ranNum = pickRandomNumber();
		//NEED TO REVISE THIS, MAKE NAME A PROPERTY OF EACH PLAYER CLASS SO I CAN CALL IT INSTEAD OF WRITING IT EACH TIME
		switch (ranNum)
		{
			case 1:
				enemy = new Warlock();
				opponent = "Warlock";
				break;
			case 2:
				enemy = new Warrior();
				opponent = "Warrior";
				break;
			case 3:
				enemy = new Shaman();
				opponent = "Shaman";
				break;
			case 4:
				enemy = new Paladin();
				opponent = "Paladin";
				break;
		}
		output.setText("You are playing against a " + opponent);
		
		user.healthBar = userHealthBar;
		enemy.healthBar = enemyHealthBar;
		
		
		//creating the event handler for spell 1
		damageButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					javax.swing.SwingUtilities.invokeLater(new Runnable() {
          			 public void run() {
          				 	updates();
                            user.damageSpell(enemy);
               		 		gameLoop();
            			}
       		 });
				}
		});
        
		//creating the event handler for spell 2
		dotButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					javax.swing.SwingUtilities.invokeLater(new Runnable() {
          			 public void run() {
          				 	updates();
                            user.dotSpell(enemy);
                            gameLoop();
            			}
       		 });
				}
		});
        
		//creating the event handler for spell 3
		hosButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					javax.swing.SwingUtilities.invokeLater(new Runnable() {
          			 public void run() {
          				 	updates();
                            user.hosSpell();
                            gameLoop();
            			}
       		 });
				}
		});
        
		//creating the event handler for spell 4
		debuffButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					javax.swing.SwingUtilities.invokeLater(new Runnable() {
          			 public void run() {
          				 	updates();
                            user.debuffSpell();
               		 		gameLoop();
            			}
       		 });
				}
		});
        
		
		
		frame.pack();
        frame.setVisible(true);		
	
	}
	
	public static int pickRandomNumber()
	{
		return (int)(Math.random() * 4 + 1);
	}
	
	public static void randomEnemyAttack()
	{
		int num = pickRandomNumber();
		switch (num)
		{
			case 1:
				enemy.damageSpell(user);
				break;
			case 2:
				enemy.dotSpell(user);
				break;
			case 3:
				enemy.hosSpell();
				break;
			case 4:
				enemy.debuffSpell();
				break;
		}
	}
	
	public static void gameLoop()
	{
		user.getDotState().dotSpell(enemy);
		enemy.getDotState().dotSpell(user);
		
		randomEnemyAttack();
		
		user.updateBar();
		enemy.updateBar();
		
		output.setText("");
		
		if (enemy.getHealth() == 0)
		{
			exitGame();
		}
		else if (user.getHealth() == 0)
		{
			exitGame();
		}
	}
	
	public static void updates()
	{
		user.updateCounts();
		enemy.updateCounts();
	}
	
	public static void exitGame()
	{
		damageButton.setEnabled(false);
		dotButton.setEnabled(false);
		hosButton.setEnabled(false);
		debuffButton.setEnabled(false);
		
		try
		{
			Thread.sleep(4000);
		}
		catch (Exception e)
		{
			
		}
		
		frame.setVisible(false);
		frame.dispose();
		
	}
	
	//MAKE A LOOP FUNCTION THAT IS CALLED AFTER EACH BUTTON CLICK,
	//RANDOMYLY PICKS ENEMY ATTACK, DOTS, CHECKS IF HEALTH IS 0
	//BEFORE CONTINUING, IF IT IS DISABLES ALL BUTTONS, SAYS WHO WON
	//THEN WAITS AND EXITS.

}