package gameMain;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import monsters.Monster_Gandalf;
import monsters.Monster_Goblin;
import monsters.Monster_Gollum;
import monsters.Monster_KingGeoffrey;
import monsters.Monster_Witch;
import monsters.Monster_Zombie;
import monsters.SuperMonster;
import weapons.Weapon_Knife;
import weapons.Weapon_LongSword;
import weapons.Weapon_Axe;
import weapons.Weapon_Dagger;
import weapons.Weapon_Arrow;



public class Story {
	
	Game game;
	UI ui;
	VisibilityManager vm;
	Player player = new Player();
	SuperMonster monster;
	
	String requirements;
	
	int c;
	int silverRing;
	int ruby;
	int theOneRing;
	int bronzeCoins;
	int runes;
	int magicRoots;
	int beenToFork;
	int seenTheHorses;
	
	List<String> weaponsOwn = new ArrayList<String>();
	
	public Story(Game g, UI userInterface, VisibilityManager vManager) {
		
		game = g;
		ui = userInterface;
		vm = vManager;
		
	}
	
	public void defaultSetup() {
		
		player.hp = 10;
		ui.hpNumberLabel.setText("" + player.hp);
		
		player.coins = 2;
		ui.coinsNumberLabel.setText("" + player.coins);
		
		player.currentWeapon = new Weapon_Knife();
		ui.weaponNameLabel.setText(player.currentWeapon.name);
		
		player.healthPots = 2;
		ui.hPotsNumberLabel.setText("" + player.healthPots);
		
		weaponsOwn.add(player.currentWeapon.name);
		
		
		silverRing = 0;
		ruby = 0;
		theOneRing = 0;
		bronzeCoins = 0;
		runes = 0;
		magicRoots = 0;
		beenToFork = 0;
		seenTheHorses = 0;
	}
	public void selectPosition(String nextPosition) {
		
		switch(nextPosition) {
		case "townGate": townGate(); break;
		case "talkGuard": talkGuard(); break;
		case "attackGuard": attackGuard(); break;
		case "crossRoad": crossRoad(); break;
		case "goLake": goLake(); break;
		case "fight": fight(); break;
		case "playerAttack": playerAttack(); break;
		case "monsterAttack": monsterAttack(); break;
		case "win": win(); break;
		case "lose": lose(); break;
		case "toTitle": toTitle(); break;
		case "talkMerchants": talkMerchants(); break;
		case "longWay": longWay(); break;
		case "apologizeGuard": apologizeGuard(); break;
		case "goTavern": goTavern(); break;
		case "goWalk": goWalk(); break;
		case "restBathe": restBathe(); break;
		case "talkMagic": talkMagic(); break;
		case "talkDoc": talkDoc(); break;
		case "drinkAle": drinkAle(); break;
		case "talkDrunk": talkDrunk(); break;
		case "talkStrange": talkStrange(); break;
		case "findHorses": findHorses(); break;
		case "findDungeon": findDungeon(); break;
		case "enchantWeapon": enchantWeapon(); break;
		case "heal": heal(); break;
		case "orderAle": orderAle(); break;
		case "readSign": readSign(); break;
		case "enterDungeon": enterDungeon(); break;
		case "m": m();break;
		case "i": i(); break;
		case "h": h(); break;
		case "buyArrow": buyArrow(); break;
		case "buyAxe": buyAxe(); break;
		case "buyDagger": buyDagger(); break;
		
		
		}
	}
	
	public void m() {
		
		if(player.healthPots >0) {
		player.hp = player.hp + 20;
		player.healthPots = player.healthPots - 1;
		ui.hpNumberLabel.setText("" + player.hp);
		ui.hPotsNumberLabel.setText("" + player.healthPots);
		}
		else {
			
		}
		
	}
	
	public void i() {
		
		JOptionPane.showMessageDialog(null, "Silver Rings: " + silverRing + "\nRuby: " + ruby + "\nThe One Ring: " + theOneRing + "\nBronze Coins: " + bronzeCoins + "\nRunes: " + runes + "\nMagic Roots: " + magicRoots + "\nWeapons Owned: " + weaponsOwn, "Inventory", 1);
		
	}
	
	public void h() {
		JOptionPane.showMessageDialog(null,  requirements, "What you need to enter the city!", 1);
	}
	
	// you come to the town
	public void townGate() {
		
		ui.mainTextArea.setText("You are at the gate of the Town. \nA guard is standing in front of you as well as some merchants next to the road. \n\nwhat do you do?");
		ui.choice1.setText("Talk to the guard");
		ui.choice2.setText("Attack the guard!");
		ui.choice3.setText("Talk to Merchants");
		ui.choice4.setText("Leave");
		
		game.nextPosition1 = "talkGuard";
		game.nextPosition2 = "attackGuard";
		game.nextPosition3 = "talkMerchants";
		game.nextPosition4 = "crossRoad";
		game.nextPosition5 = "m";
		game.nextPosition6 = "i";
		game.nextPosition7 = "h";
		
		
	}
	
	public void talkMerchants() {
		ui.mainTextArea.setText("I Sell Weapons. Currently I have for Sale:\nArrow: 200 Coins, Potential Damage 35\nAxe: 120 Coins, Potential Damage 25\nDagger: 60 Coins, Potential Damage 20\n\nWould you like to buy one?");
		ui.choice1.setText("Buy Arrow");
		ui.choice2.setText("Buy Axe");
		ui.choice3.setText("Buy Dagger");
		ui.choice4.setText("Another Time!");
		
		game.nextPosition1 = "buyArrow";
		game.nextPosition2 = "buyAxe";
		game.nextPosition3 = "buyDagger";
		game.nextPosition4 = "townGate";
		
	}
	
	public void buyArrow() {
		if(player.coins >= 200) {
			
			player.coins = player.coins - 200;
			ui.coinsNumberLabel.setText("" + player.coins);
			player.currentWeapon = new Weapon_Arrow();
			ui.weaponNameLabel.setText(player.currentWeapon.name);
			weaponsOwn.add(player.currentWeapon.name);

			
			ui.mainTextArea.setText("Congratulations! You are 200 Coins lighter! Your enemies will be shaking of fear and admiration!");
			ui.choice1.setText("Walk away with new Weapon");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			game.nextPosition1 = "townGate";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		
		else {
			ui.mainTextArea.setText("Hmm appears you can't afford this..");
			ui.choice1.setText("You tried..");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			game.nextPosition1 = "townGate";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		
	}
	
	public void buyAxe() {
if(player.coins >= 120) {
			
			player.coins = player.coins - 120;
			ui.coinsNumberLabel.setText("" + player.coins);
			player.currentWeapon = new Weapon_Axe();
			ui.weaponNameLabel.setText(player.currentWeapon.name);
			weaponsOwn.add(player.currentWeapon.name);

			
			ui.mainTextArea.setText("Congratulations! You are 120 Coins lighter! Your enemies will be shaking of fear and admiration!");
			ui.choice1.setText("Walk away with new Axe");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			game.nextPosition1 = "townGate";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		
		else {
			ui.mainTextArea.setText("Hmm appears you can't afford this..");
			ui.choice1.setText("You tried..");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			game.nextPosition1 = "townGate";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
	}
	

	public void buyDagger() {
		if(player.coins >= 60) {
			
			player.coins = player.coins - 60;
			ui.coinsNumberLabel.setText("" + player.coins);
			player.currentWeapon = new Weapon_Dagger();
			ui.weaponNameLabel.setText(player.currentWeapon.name);
			weaponsOwn.add(player.currentWeapon.name);

			
			ui.mainTextArea.setText("Congratulations! You are 60 Coins lighter! Your enemies will be shaking of fear and admiration!");
			ui.choice1.setText("Walk away with new Dagger");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			game.nextPosition1 = "townGate";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		
		else {
			ui.mainTextArea.setText("Hmm appears you can't afford this..");
			ui.choice1.setText("You tried..");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			game.nextPosition1 = "townGate";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
	}

	
	public void talkGuard() {
		
		requirements = "Silver Ring >= 3\nRuby >= 2\nThe One Ring >= 1\nBronze Coins >= 5\nRunes >= 3\nMagic roots >= 4\nCoins >= 250";
		
		if(silverRing ==0) {
			ui.mainTextArea.setText("Guard: Hello stranger. I have never seen your face. \n I cannot let a stranger into town.. especially not in these ..  strange times..");
			ui.choice1.setText("But I have come a long way!");
			ui.choice2.setText(">");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			game.nextPosition1 = "longWay";
			game.nextPosition2 = "townGate";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else if(silverRing >= 3 && ruby >= 2 && theOneRing >= 1 && bronzeCoins >= 5 && runes >= 3 && magicRoots >= 4 && player.coins >= 250) {
			ending();
		}
		
	}
	
	public void longWay() {
		ui.mainTextArea.setText("'But I have come a long way to make it here.. is there no way you can let me in'?\nGuard:'I'm Sorry but we have had a lot of strange things happening here lately.. but if you can prove yourself to be trustworthy than maybe I will change my mind..\n\n#Collect enough Gems and Coins and other items to gain entry#\nThese are the items you need: " + requirements);
		ui.choice1.setText("Thank the guard and step away");
		ui.choice2.setText(">");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "townGate";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void attackGuard() {
		ui.mainTextArea.setText("Guard: 'Hey don't be stupid!' \n\n The guard attacked you so hard you gave up. \n You receive 3 damage");
		player.hp = player.hp -3;
		ui.hpNumberLabel.setText("" + player.hp);
		ui.choice1.setText("Apologize");
		ui.choice2.setText("Leave");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "apologizeGuard";
		game.nextPosition2 = "townGate";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		
	}
	
	public void apologizeGuard() {
		ui.mainTextArea.setText("'I'm sorry Guard, desperation makes me foolish!'");
		
		
		ui.choice1.setText("Leave");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "townGate";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void crossRoad() {
		ui.mainTextArea.setText("You are at a roadcrossing. A sign points to the peaceful lake, you can also cool your head on a walk or maybe simply refresh with an ale at the nearby tavern?");
		ui.choice1.setText("Go to Lake");
		ui.choice2.setText("Go to Tavern");
		ui.choice3.setText("Explore the Surroundings");
		ui.choice4.setText("Go back to the Town");
		
		game.nextPosition1 = "goLake";
		game.nextPosition2 = "goTavern";
		game.nextPosition3 = "goWalk";
		game.nextPosition4 = "townGate";
		
	}
	
	public void goLake() {
		ui.mainTextArea.setText("What a beautiful Lake! Bet a wash would be refeshing! You might also want to upgrade your weapon or see a healer!");
		
		ui.choice1.setText("Rest and Bathe");
		ui.choice2.setText("Talk to Magician");
		ui.choice3.setText("Talk to Healer");
		ui.choice4.setText("Go back to the Roadcross");
		
		game.nextPosition1 = "restBathe";
		game.nextPosition2 = "talkMagic";
		game.nextPosition3 = "talkDoc";
		game.nextPosition4 = "crossRoad";
	}
	
	
	
	public void goTavern() {
		ui.mainTextArea.setText("The lovely smell of freshly brewed Ale and less than lovely smell of sweat and vomit fill the air!\n You should see what the towndrunk has to say, though a fresh ale is also never a bad choice\n\nA Stranger eyes you misteriously");
		
		ui.choice1.setText("Taste Heaven");
		ui.choice2.setText("Talk to Drunk");
		ui.choice3.setText("Talk to Stranger");
		ui.choice4.setText("Return to Roadcross");
		
		game.nextPosition1 = "drinkAle";
		game.nextPosition2 = "talkDrunk";
		game.nextPosition3 = "talkStrange";
		game.nextPosition4 = "crossRoad";
	}
	
	public void drinkAle() {
ui.mainTextArea.setText("A pitcher only costs you 2 coins and you are thirsty.. you simply cannot pass up this deal!");
		
		ui.choice1.setText("Order a Pitcher");
		ui.choice2.setText("Step away from Temptation");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "orderAle";
		game.nextPosition2 = "goTavern";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void orderAle() {
		if(player.coins >= 2) {
			ui.mainTextArea.setText("Mhm.. you just tasted heaven on earth! Too bad they only serve you one pitcher at a time..\n\n(You paid 2 coins)");
			player.coins = player.coins - 2;
			ui.coinsNumberLabel.setText("" + player.coins);
			ui.choice1.setText("Step away satisfied");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			game.nextPosition1 = "goTavern";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else {
			ui.mainTextArea.setText("Hmm appears you can't afford this.. well the imagination will have to do");
			ui.choice1.setText("Unhappily step away");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			game.nextPosition1 = "goTavern";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
	}
	
	public void talkDrunk() {
		ui.mainTextArea.setText("Drunk:'LaLaLA.. oh hey who are you? do you have a coin to spare?'\nYou:'I do not.. Can you tell me something about the strange things happening here..?'\nDrunk:'For a coin I will tell you about the monsters that steal people at night..'");
		ui.choice1.setText("Sorry but no sorry..");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "goTavern";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void talkStrange() {
		ui.mainTextArea.setText("Stranger:'Hey there fella.. haven't seen you before.. what are you looking for in this neck of the woods'\nYou:'Well I am traveling from far away to settle in this town.. however there appears to be something strange happening?!'\nStrange:'Oh yeah.. some people talk about rapture for our sins, others are thinking it might be an invasion from other planets.. though \nthere is a story of a haunted dungeon in area.. but that is all I will say'");
		ui.choice1.setText("Hmm - maybe I'll take a look..");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "goTavern";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	
	public void goWalk() {
		
		if(beenToFork < 1) {
			ui.mainTextArea.setText("You come to a fork in the road.. which way will you go?");
			beenToFork = 1;
			ui.choice1.setText("I will follow my nose!");
			ui.choice2.setText("Go to the Left!");
			ui.choice3.setText("Go to the Right!");
			ui.choice4.setText("Return to Roadcross");
			
			game.nextPosition1 = "goWalk";
			game.nextPosition2 = "findHorses";
			game.nextPosition3 = "findDungeon";
			game.nextPosition4 = "crossRoad";
		}
		else {
		ui.mainTextArea.setText("'Round and 'round you go.. you come back to the same place!");
		
		ui.choice1.setText("My nose can't be wrong!");
		ui.choice2.setText("Go to the Left!");
		ui.choice3.setText("Go to the Right!");
		ui.choice4.setText("Return to Roadcross");
		
		game.nextPosition1 = "goWalk";
		game.nextPosition2 = "findHorses";
		game.nextPosition3 = "findDungeon";
		game.nextPosition4 = "crossRoad";
		}
		
	}
	
	public void findHorses() {
		if(seenTheHorses < 1) {
		ui.mainTextArea.setText("You find yourself on the border of a large field.. the tall grass is bending in the wind,\nHorses are grazing in the sunlight.. what a sight..\n But wait.. what is that shiny thing..?\n\n(Obtain Long Sword)");
		player.currentWeapon = new Weapon_LongSword();
		ui.weaponNameLabel.setText(player.currentWeapon.name);
		seenTheHorses = seenTheHorses +1;
		ui.choice1.setText("Return to the Fork");
		ui.choice2.setText("Return to the Roadcross");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "goWalk";
		game.nextPosition2 = "crossRoad";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		}
		else {
			ui.mainTextArea.setText("You find yourself back staring at the view.. hard to not come back to a place such as this");
			
			ui.choice1.setText("Return to the Fork");
			ui.choice2.setText("Return to the Roadcross");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			game.nextPosition1 = "goWalk";
			game.nextPosition2 = "crossRoad";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
	}
	
	public void findDungeon() {
		ui.mainTextArea.setText("You come to what looks like a dungeon.. may this be what the Stranger talks about?\ntaking a closer look you can see that there is a sign\n\nWhat do you do?");
		
		ui.choice1.setText("Read the Sign");
		ui.choice2.setText("Enter the Dungeon");
		ui.choice3.setText("Return to the Fork");
		ui.choice4.setText("Return to the Roadcross");
		
		game.nextPosition1 = "readSign";
		game.nextPosition2 = "enterDungeon";
		game.nextPosition3 = "goWalk";
		game.nextPosition4 = "crossRoad";
	}
	
	public void readSign() {
ui.mainTextArea.setText("Danger\n- DO NOT ENTER - \n\n *You have found it! The source of evil! Fight the monsters inside, collect the items you need to unlock the city, receive coins and potions. But beware.. not many make it ou alive..");
		
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "findDungeon";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void enterDungeon() {
		
		int i = new java.util.Random().nextInt(100)+1;
		
		if(i < 50) {
			monster = new Monster_Goblin();

		}
		else if(i < 60) {
			monster = new Monster_Gollum();

		}
		else if(i < 70) {
			monster = new Monster_Zombie();
		}
		else if(i < 80) {
			monster = new Monster_KingGeoffrey();
		}
		else if(i < 95) {
			monster = new Monster_Witch();
		}
		else {
			monster = new Monster_Gandalf();
		}
		
		
		
		ui.mainTextArea.setText("You encounter a " + monster.name + "!");
		ui.choice1.setText("Fight!");
		ui.choice2.setText("Run!");
		ui.choice3.setText("Exit Dungeon");
		ui.choice4.setText("");
		
		game.nextPosition1 = "fight";
		game.nextPosition2 = "enterDungeon";
		game.nextPosition3 = "findDungeon";
		game.nextPosition4 = "";
	}
	
	public void restBathe() {
		
		if(player.hp<15) {
		ui.mainTextArea.setText("After a quick rest and wash in the lake you feel like a new person.\n\nYour Health goes up to 15!");
		player.hp = 15;
		ui.hpNumberLabel.setText("" + player.hp);
		ui.choice1.setText("Dry and leave the lake!");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "goLake";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		}
		else {
			ui.mainTextArea.setText("After a quick rest and washign yourself in the lake you feel like a new person.\nAre you ready to go on?");
			ui.choice1.setText("Attack!");
			ui.choice2.setText("Run!");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			game.nextPosition1 = "playerAttack";
			game.nextPosition2 = "crossRoad";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
	}
	
	public void talkMagic() {
		
		if(player.currentWeapon.enchanted == false) {
			ui.mainTextArea.setText("I am a magician! I specialize in the arts of weapon enhancement.. how may I help you?\n\n#Weapon Enchanting costs you 20 coins and will add some damage to your current weapon!");
			ui.choice1.setText("Enchant my Weapon please!");
			ui.choice2.setText("Yeah no what are you on?");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			game.nextPosition1 = "enchantWeapon";
			game.nextPosition2 = "goLake";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else {
			ui.mainTextArea.setText("I am a magician! I specialize in the arts of weapon enhancement.. how may I help you?\n\n*Seems like your weapon already is enchanted*");
		ui.choice1.setText("Ok!");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "goLake";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
			
		}
		
	}
	
	public void enchantWeapon() {
		
		if(player.coins >= 20) {
			player.currentWeapon.enchanted = true;
			player.coins = player.coins - 20;
			ui.coinsNumberLabel.setText("" + player.coins);
			ui.mainTextArea.setText("Your weapon has been successfully enchanted!\nIt yields now " + player.currentWeapon.enchantBenefit + " more damage potential");
			ui.choice1.setText("Ok!");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			game.nextPosition1 = "goLake";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else {
			ui.mainTextArea.setText("You do not have enough coins.. come back when you have enough!");
			ui.choice1.setText("Ok!");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			game.nextPosition1 = "goLake";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		
	}
	
	public void talkDoc() {
		ui.mainTextArea.setText("I am a healer - I've got all the good stuff!\n\nOne good fixing will cost you three goats or 25 coins.. it's worth it though!\nI also have Healthpotions (30coins) for sale! The perfect pick-me up for during the day!");
		ui.choice1.setText("Give me the good stuff!!");
		ui.choice2.setText("Buy Health Potion");
		ui.choice3.setText("No Thanks.");
		ui.choice4.setText("");
		
		game.nextPosition1 = "heal";
		game.nextPosition2 = "buyPotion";
		game.nextPosition3 = "goLake";
		game.nextPosition4 = "";
	}
	
	public void buyPotion() {
		
		if(player.coins >= 25) {
			player.coins = player.coins - 25;
			player.healthPots = player.healthPots + 1;
			ui.hPotsNumberLabel.setText("" + player.healthPots);
			ui.coinsNumberLabel.setText("" + player.coins);
			ui.mainTextArea.setText("There ya go.. enjoy");
			ui.choice1.setText("Thank You!");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			game.nextPosition1 = "goLake";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else {
			ui.mainTextArea.setText("You do not have enough coins.. come back when you have enough!");
			ui.choice1.setText("Ok!");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			game.nextPosition1 = "goLake";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
	
	}
	
	public void heal() {
		if(player.coins >= 25) {
			player.coins = player.coins - 25;
			player.hp = player.hp + 20;
			ui.hpNumberLabel.setText("" + player.hp);
			ui.coinsNumberLabel.setText("" + player.coins);
			ui.mainTextArea.setText("It works! you feel strong enough to take out trees!");
			ui.choice1.setText("Thank You!");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			game.nextPosition1 = "goLake";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else {
			ui.mainTextArea.setText("You do not have enough coins.. come back when you have enough!");
			ui.choice1.setText("Ok!");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			game.nextPosition1 = "goLake";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		
	}
	
	public void fight() {
		
		ui.mainTextArea.setText(monster.name + ": " + monster.hp + "\n\n What do you do?");
		ui.choice1.setText("Attack!");
		ui.choice2.setText("Run!");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "playerAttack";
		game.nextPosition2 = "enterDungeon";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		
	}
	
	
	public void playerAttack() {
		int enchantedExtraDam;
		if(player.currentWeapon.enchanted == true) {
			enchantedExtraDam = player.currentWeapon.enchantBenefit;
		}
		else {
			enchantedExtraDam = 0;
		}
		
		int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage + enchantedExtraDam);
		
		ui.mainTextArea.setText("You attack the " + monster.name + " and gave " + playerDamage + " damage");
		
		monster.hp = monster.hp - playerDamage;
		
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		if(monster.hp>0) {
			game.nextPosition1 = "monsterAttack";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else if(monster.hp<1) {
			game.nextPosition1 = "win";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
	}
	public void monsterAttack() {
		
		int monsterDamage = new java.util.Random().nextInt(monster.attack);
		ui.mainTextArea.setText("The " + monster.name + " gave you " + monsterDamage + "damage!");
		
		player.hp = player.hp - monsterDamage;
		ui.hpNumberLabel.setText("" + player.hp);
		
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		if(player.hp>0) {
			game.nextPosition1 = "fight";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else if (player.hp<1) {
			game.nextPosition1 = "lose";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		
		
	}
	public void win() {
		
		int dropChanceGem = new java.util.Random().nextInt(101);
		int dropCoins = new java.util.Random().nextInt(monster.maxCoinDrop);
		int dropPotion = new java.util.Random().nextInt(101);
		int potionDrop = 0;
		if(dropPotion <= monster.dropChancePotion) {
			potionDrop = 1;
		}
		
		if(monster.probDropGem >= dropChanceGem) {
			
		ui.mainTextArea.setText("You've defeated the " + monster.name + "!\nThe monster dropped a " + monster.gemName + "\n\n(You obtained a " + monster.gemName + ")\nYou also receive " + dropCoins + " Coins, and " + potionDrop + " Health Potions.");
		
		player.coins = player.coins + dropCoins;
		ui.coinsNumberLabel.setText("" + player.coins);
		player.healthPots = player.healthPots + potionDrop;
		ui.hPotsNumberLabel.setText("" + player.healthPots);
		
		if(monster.gemName == "SilverRing" ) {
			silverRing = silverRing + 1;
		}
		else if(monster.gemName == "Ruby" ) {
			ruby = ruby + 1;
		}
		else if(monster.gemName == "TheOneRing" ) {
			theOneRing = theOneRing + 1;
		}
		else if(monster.gemName == "BronzeCoin" ) {
			bronzeCoins = bronzeCoins + 1;
		}
		else if(monster.gemName == "Rune" ) {
			runes = runes + 1;
		}
		else if(monster.gemName == "MagicRoot" ) {
			magicRoots = magicRoots + 1;
		}
		
		ui.choice1.setText("Go on!");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "enterDungeon";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		}
		else {
			ui.mainTextArea.setText("You've defeated the " + monster.name + "!\nYou  receive " + dropCoins + " Coins, and " + potionDrop + " Health Potions.");
			player.coins = player.coins + dropCoins;
			ui.coinsNumberLabel.setText("" + player.coins);
			player.healthPots = player.healthPots + potionDrop;
			ui.hPotsNumberLabel.setText("" + player.healthPots);
			
			ui.choice1.setText("Go on!");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			game.nextPosition1 = "enterDungeon";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
			
		}

	}
	
	public void lose() {
		ui.mainTextArea.setText("You are dead!\n\n<GAME OVER>");
		ui.choice1.setText("To the Title Screen");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "toTitle";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";

	}
	public void ending() {
		ui.mainTextArea.setText("Guard: Oh you killed the Monsters and brought us the needed items!\nThank you. You are a hero.\nWelcome to the Town\n\n<THE END>");
		
		ui.choice1.setVisible(false);
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		
	}
	
	public void toTitle() {
		
		defaultSetup();
		vm.showTitleScreen();
	}

}
