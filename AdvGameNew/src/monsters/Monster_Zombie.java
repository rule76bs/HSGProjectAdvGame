package monsters;

public class Monster_Zombie extends SuperMonster{
	
	public Monster_Zombie() {
		name = "Zombie";
		hp = 50;
		attack = 8;
		probDropGem = 11;
		gemName = "BronzeCoin";
		maxCoinDrop = 25; 
		dropChancePotion = 20;
	}

}
