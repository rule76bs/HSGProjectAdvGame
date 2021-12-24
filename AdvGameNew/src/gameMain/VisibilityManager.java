package gameMain;

public class VisibilityManager {
	
	UI ui;
	
	public VisibilityManager(UI userInterface) {
		
		ui = userInterface;
				
		
	}
	
	public void showTitleScreen() {
		
		//Show Title Screen
		ui.titleNamePanel.setVisible(true);
		ui.startButtonPanel.setVisible(true);
		
		// Hide Game Screen and Story Screen
		ui.mainTextPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		ui.playerPanel.setVisible(false);
		ui.okButtonPanel.setVisible(false);
		ui.storyTextPanel.setVisible(false);
		ui.healthPotButtonPanel.setVisible(false);
		ui.helpButtonPanel.setVisible(false);
		
		
		
	}
	
	public void titleToTown() {
		//Hide Title Screen and Story Screen
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		ui.okButtonPanel.setVisible(false);
		ui.storyTextPanel.setVisible(false);
		
		//Show Game Screen
		ui.mainTextPanel.setVisible(true);
		ui.choiceButtonPanel.setVisible(true);
		ui.playerPanel.setVisible(true);
		ui.healthPotButtonPanel.setVisible(true);
		ui.helpButtonPanel.setVisible(true);

	}
	
	public void storyTime() {
		
		// Hide Title Screen and Game Screen
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		ui.mainTextPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		ui.playerPanel.setVisible(false);
		ui.healthPotButtonPanel.setVisible(false);
		ui.helpButtonPanel.setVisible(false);

		
		// Show Story Time Screen
		ui.okButtonPanel.setVisible(true);
		ui.storyTextPanel.setVisible(true);
		
	}
}
