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
Our custom features:
* Boat Functionalities:
  * Submarine (3 cell boat): can be submerged or above water; submerged submarines are unable to be hit by Missiles, but vulnerable to torpedos, above water submarines are the opposite
  * Zoomboat (1 cell boat): can move to an adjacent grid cell on each turn
  * Cruiser (2 cell boat): no special functionalities
* Weapons
  * Missile: standard overhead strike on a single grid cell
  * Torpedo: underwater weapon that can strike submerged submarines
  * Radar: pulses and reveals all enemy Zoomboats in a 5x5 square centered around the grid cell it was used on
 
<br>
## How To Play
The objective of the game is to destroy all of your opponent's boats before they destroy yours.<br>
<br>
Controls:
* Setup Phase:
  * <kbd>Left Click</kbd>: select a boat
  * Drag and drop boats to move them around 
  * <kbd>spacebar</kbd>: rotate a boat
