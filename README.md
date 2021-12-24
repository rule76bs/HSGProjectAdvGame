# HSGProjectAdvGame
Text Based Adventure Game with GUI in JAVA


## Hello!

### A little bit about this project:
This is a rather simple text based adventure game with a GUI programmed in java. This was a group project for a course at the university which I ended up doing by myself.
After a lot of looking and not knowing what to do, this [Java For Beginners: Text-based Adventure Game Project (10/10)](https://www.youtube.com/watch?v=EpB9u4ItOYU) Youtube video inspired me to try to make a text based adventure game, but I wanted to make this with a GUI. I managed to get quite far, but at a certain point my inability hindered me and frustrated me as I could not make the buttons work the way I wished to. So after a long search I stumbled upon another tutorial on YouTube [How to Make a Text Based Adventure Game with Multiple Classes - Java GUI Program for Beginner Part 1](https://youtu.be/Y5gnsK6PWbk) where I learned a better way to structure the program. This is a 4 part series, I did use this as my basis, but I added quite a few functionalities and features of my own to the game! I hope it works well enough and even though there are so many things that I want to add to it for now this is it! Thank you!

### What is this game about?
This game is an adventure game set in a fantasy world. Not a particular fantasy world, it has a few elements from different existing fantasyworlds.  You are traveling to a town, where they do not let you inside, because of some mysterious happenings in the area. You must find out what is happening and help the city! You can explore a (very) small world (again, text-based  - and I am not the best writer.. yet) and fight some enemies! Upgrade your weapons or spend some time in the tavern.. whatever you prefer!

### Important to know
One thing I consider important to know when trying out this game: in the file "UI.java" - on lines 29-35 I have linked png images for icons. They are linked to where they are on my laptopt -> so you would need to change the directory in order so that it works on your computer as well - I fear otherwise it will not show the icons in the game (which are important as some of them also function as buttons).

### How to run the Game
The game is started from the "Game.java" file generally. Afterwards it opens a window, where the game starts. First you get to a title screen with the name of the game. After continuing you go to the story screen, which gives a little bit of a background of the game storywise. Clicking ok on that field takes you to the main game screen.

### The main game screen
This game is text based, therefore you will be using button and your mouse to navigate and operate in it. Buttons include four "choice" buttons visible in th emiddle, which adapt to what is happening, one inventory button (looks like a chest) on the right side, a take a health potion button on the right side, and a help button on the left side. In the middle there is a text field which will orient you about where you and what is happening. The top of the screen displays some of the player stats that might just be useful for the player. You can exit the game with the x on the window -> it does not yet have a save function (need to go figure that out).

### File Structure
So the files are made up of currenlty 3 packages.
- mainGame package: This is where I have the files with the UserInterface, the actual game mechanics etc.
- monsters: This is where I am collecting the monsters. It is a separate package because as I keep working on this the number of monster will be growing and this helps to keep a bette overview
- weapons: Same concept as with the monster, except that these are the weapons that the player gets to use.

#### Weapons
There are 5 types of weapons currently available, each with different strengths.
Main Features include:
- Name: String
- damage: int the mas damage this weapon can do.
- enchanted: boolean, whether it is enchanted or not.
- enchantedBenefit: int once enchanted, how much can it boost the weapon's attack
- price: int - not yet in use

#### Monster
There are currently 6 monsters available, each also with different features.
- Name: String
- hp: int healthpoint
- attack: int max attack
- probDropGem: int probability of dropping a gem (is needed to finish the game)
- gemName: String Name of the gem that each type of monster drops
- maxCoinDrop: in maximum amount of coin that is dropped after defeat
- dropChancePotion: int percentage chance of a health potion dropping

#### Items in this game
- Heart Icon: Shows the health left of a player - once it hits zero game is over
- Knife Icon: Type of weapon you are wielding
- Medicine Icon: Number of health potions you have
- Coins: Number of coins you have
- Medicine Icon to the right: when clicked, you consume 1 health potion -> increases health by 20
- Chest Icon: Shows inventory of items collected and weapons owned
- Question mark: Shows what you need to unlock the city BUT only AFTER you talked to the guard

#### Ideas to add
There are a lot of things I kind of would like ot add, but I am running out of time to do it. Though the possibilities seem endless.
- Add a clickable inventory where I can choose my weapon
- Add a clickable shop with more than just three items
- Add armour
- Add more weapons, more Monsters, people etc.
- Add more pictures or icons representing enemies, weapons etc.
- Choosing and personalizing character
- Absolutely need to make it a little bit more aesthetically pleasing (text, alignment, the whole window etc.)
- It would be nice to be able to display all the weapons and their characteristics in the future
- And many more ideas I have already forgotten.. but generlaly make this a more proper game!

If you read so far, thank you for this course! I wish I had taken the time to learn more - this actually did make it fun for me and kept me engaged!
