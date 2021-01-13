# Battleship-Project
A Battleship inspired game created using Java and the Greenfoot IDE.
<br>
<br>
![Image of Game](https://i.imgur.com/ergPgig.png)

## About the Game
A game developed using Java and the Greenfoot IDE by me and my friend for our Grade 12 Computer Science final project (received a grade of 95%).
It is a twist on the classic <a href="https://en.wikipedia.org/wiki/Battleship_(game)">Battleship board game</a>. 
The objective of the game remains the same, to destroy all of your opponents' boats, however, in our version of Battleship, we implemented new
functionalities to boats and weapons to allow for more mindgames between opponents.
<br>
<br>
This game was developed using many object-oriented principles (encapsulation, abstraction, inheritance). The two primary classes are Battleship and Weapon, each of which have many child classes which are the boats and weapons you can see in game. 

Our custom features:
* Boat Functionalities:
  * Submarine (3 cell boat): can be submerged or above water; submerged submarines are unable to be hit by Missiles, but vulnerable to torpedos, above water submarines are the opposite
  * Zoomboat (1 cell boat): can move to an adjacent grid cell on each turn
  * Cruiser (2 cell boat): no special functionalities
* Weapons
  * Missile: standard overhead strike on a single grid cell
  * Torpedo: underwater weapon that can strike submerged submarines
  * Radar: pulses and reveals all enemy Zoomboats in a 5x5 square centered around the grid cell it was used on
 
## How To Play
The objective of the game is to destroy all of your opponent's boats before they destroy yours.<br>
<br>
Controls:
* Setup Phase:
  * <kbd>Left Click</kbd> : select a boat
  * Drag and drop boats to move them around 
  * <kbd>spacebar</kbd> : rotate a boat
* Main Game Phase:
  * <kbd>1</kbd> <kbd>2</kbd> <kbd>3</kbd> : cycle between weapons
  * <kbd>Left Click</kbd> : select a boat or use weapon on grid cell
  * <kbd>spacebar</kbd> : when selected submarine, spacebar to submerge it or bring it back above the water
  * <kbd>wasd</kbd> : move a selected Zoomboat to an empty adjacent cell

## How to Run
1. Download <a href="https://www.greenfoot.org/download">Greenfoot</a>
2. There is no .gfar in this repository as it would exceed GitHub's 100MB limit. Instead, download the repository as a .zip file, extract its contents, then run the project.greenfoot file inside the Battleship Game folder. The MainMenu world should automatically instantiate, if not, right click on the MainMenu object in the right side
hierarchy, and click new MainMenu()

