package gameMain;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import gameMain.Game.ChoiceHandler;

public class UI {
	
	JFrame window;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, storyTextPanel, okButtonPanel, healthPotButtonPanel, helpButtonPanel;
	JLabel titleNameLabel, hpLabel, hpNumberLabel, weaponLabel, weaponNameLabel, hPotsLabel, hPotsNumberLabel, coinsLabel, coinsNumberLabel;
	JButton startButton, choice1, choice2, choice3, choice4, okButton, takeMed, inventory, helpButton;
	JTextArea mainTextArea, storyTextArea;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Helvetica", Font.BOLD, 15);
	String story = "You have been traveling for days just to come to this city! Finally you are here! you hvae been wanting to settle in the city and build up your legacy! The city is the future.. though you have been hearing some strange stories lately.. but who knows.. they might jsut be just some stories.\n\nAnyways.. you can already see the walls coming up.. let's see what it brings..";
	
	public void createUI(ChoiceHandler cHandler) {
		
		ImageIcon coinIcon = new ImageIcon(new ImageIcon("/Users/bensera/eclipse-workspace/Game/src/buttongame/coins.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		ImageIcon heartIcon = new ImageIcon(new ImageIcon("/Users/bensera/eclipse-workspace/Game/src/buttongame/heart.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		ImageIcon weaponIcon = new ImageIcon(new ImageIcon("/Users/bensera/eclipse-workspace/AdvGameNew/src/gameMain/sword.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		ImageIcon medIcon = new ImageIcon(new ImageIcon("/Users/bensera/eclipse-workspace/AdvGameNew/src/gameMain/med.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		ImageIcon invIcon = new ImageIcon(new ImageIcon("/Users/bensera/eclipse-workspace/AdvGameNew/src/gameMain/chest.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		ImageIcon takeMedIcon = new ImageIcon(new ImageIcon("/Users/bensera/eclipse-workspace/AdvGameNew/src/gameMain/med.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		ImageIcon helpIcon = new ImageIcon(new ImageIcon("/Users/bensera/eclipse-workspace/AdvGameNew/src/gameMain/help.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));

		
		// Window
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);//new Color(245, 245, 220)
		window.setLayout(null);
		
		// Title Screen
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 500);
		titleNamePanel.setBackground(Color.black);//new Color(245, 245, 220)
		titleNameLabel = new JLabel("DUNGEON");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		titleNamePanel.add(titleNameLabel);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);//new Color(245, 245, 220)
		startButton = new JButton("Start");
		startButton.setBackground(new Color(245, 245, 220));
		startButton.setForeground(Color.black);
		startButton.setFont(normalFont);
		startButton.setFocusPainted(false);
		startButton.addActionListener(cHandler);
		startButton.setActionCommand("start");
		startButtonPanel.add(startButton);
		
		window.add(titleNamePanel);
		window.add(startButtonPanel);	
		
		// Game Screen
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		window.add(mainTextPanel);
		
		mainTextArea = new JTextArea("This is the main rtext area");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setEditable(false);
		mainTextPanel.add(mainTextArea);
		
		storyTextPanel = new JPanel();
		storyTextPanel.setBounds(100, 100, 600, 500);
		storyTextPanel.setBackground(Color.black);//new Color(245, 245, 220)
		storyTextArea = new JTextArea(story);
		storyTextArea.setBounds(100, 100, 600, 250);
		storyTextArea.setBackground(Color.black);
		storyTextArea.setForeground(Color.white);
		storyTextArea.setFont(normalFont);
		storyTextArea.setLineWrap(true);
		storyTextArea.setEditable(false);
		storyTextPanel.add(storyTextArea);
		
		okButtonPanel = new JPanel();
		okButtonPanel.setBounds(300, 400, 200, 100);
		okButtonPanel.setBackground(Color.black);//new Color(245, 245, 220)
		okButton = new JButton("OK, got it!");
		okButton.setBackground(new Color(245, 245, 220));
		okButton.setForeground(Color.black);
		okButton.setFont(normalFont);
		okButton.setFocusPainted(false);
		okButton.addActionListener(cHandler);
		okButton.setActionCommand("ok");
		okButtonPanel.add(okButton);
		
		window.add(okButtonPanel);
		window.add(storyTextPanel);
		
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4, 1));
		window.add(choiceButtonPanel);
		
		healthPotButtonPanel = new JPanel();
		healthPotButtonPanel.setBounds(550, 350, 200, 200);
		healthPotButtonPanel.setBackground(Color.black);
		healthPotButtonPanel.setLayout(new GridLayout(2,1));
		window.add(healthPotButtonPanel);
		
		takeMed = new JButton(takeMedIcon);
		takeMed.setBackground(Color.black);
		takeMed.setForeground(Color.black);
		takeMed.setFont(normalFont);
		takeMed.setFocusPainted(false);
		takeMed.addActionListener(cHandler);
		takeMed.setActionCommand("m");
		takeMed.setOpaque(true);
		takeMed.setBorder(null);
		healthPotButtonPanel.add(takeMed);
		inventory = new JButton(invIcon);
		inventory.setBackground(Color.black);
		inventory.setForeground(Color.black);
		inventory.setFont(normalFont);
		inventory.setFocusPainted(false);
		inventory.addActionListener(cHandler);
		inventory.setActionCommand("i");
		inventory.setBorder(null);
		healthPotButtonPanel.add(inventory);
		
		helpButtonPanel = new JPanel();
		helpButtonPanel.setBounds(50, 350, 200, 200);
		helpButtonPanel.setBackground(Color.black);
		helpButtonPanel.setLayout(new GridLayout(2,1));
		window.add(helpButtonPanel);
		
		helpButton = new JButton(helpIcon);
		helpButton.setBackground(Color.black);
		helpButton.setForeground(Color.black);
		helpButton.setFont(normalFont);
		helpButton.setFocusPainted(false);
		helpButton.addActionListener(cHandler);
		helpButton.setActionCommand("h");
		helpButton.setOpaque(true);
		helpButton.setBorder(null);
		helpButtonPanel.add(helpButton);
		
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.black);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(cHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.black);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(cHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.black);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(cHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.black);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(cHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1, 8));
		window.add(playerPanel);
		
		hpLabel = new JLabel(heartIcon);
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		hpNumberLabel = new JLabel();
		hpNumberLabel.setFont(normalFont);
		hpNumberLabel.setForeground(Color.white);
		playerPanel.add(hpNumberLabel);
		weaponLabel = new JLabel(weaponIcon);
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);
		weaponNameLabel = new JLabel();
		weaponNameLabel.setFont(normalFont);
		weaponNameLabel.setForeground(Color.white);
		playerPanel.add(weaponNameLabel);
		
		hPotsLabel = new JLabel(medIcon);
		hPotsLabel.setFont(normalFont);
		hPotsLabel.setForeground(Color.white);
		playerPanel.add(hPotsLabel);
		hPotsNumberLabel = new JLabel();
		hPotsNumberLabel.setFont(normalFont);
		hPotsNumberLabel.setForeground(Color.white);
		playerPanel.add(hPotsNumberLabel);
		coinsLabel = new JLabel(coinIcon);
		coinsLabel.setFont(normalFont);
		coinsLabel.setForeground(Color.white);
		playerPanel.add(coinsLabel);
		coinsNumberLabel = new JLabel();
		coinsNumberLabel.setFont(normalFont);
		coinsNumberLabel.setForeground(Color.white);
		playerPanel.add(coinsNumberLabel);
		
		
		
		
		window.setVisible(true);

	
		
		
		
	}

}
