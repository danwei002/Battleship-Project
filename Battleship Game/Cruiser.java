import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cruiser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cruiser extends Battleship {
    public Cruiser(int hp, boolean isLeft) {
        width = BattleWorld.CELL_SIZE * 2 - 20;
        height = BattleWorld.CELL_SIZE - 10;
        this.hp = hp;
        this.isLeft = isLeft;
        img = getImage();
        img.scale(width, height);
        setImage(img);
    }
    /**
     * Act - do whatever the Cruiser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (Greenfoot.isKeyDown("space")) {
            turn(90);
        }
        borderCheck();
        if (getRotation() == 180 || getRotation() == 0) {
            setLocation((getX() / BattleWorld.CELL_SIZE) * BattleWorld.CELL_SIZE, (getY() / BattleWorld.CELL_SIZE) * BattleWorld.CELL_SIZE + BattleWorld.CELL_SIZE / 2);
        } else {
            setLocation((getX() / BattleWorld.CELL_SIZE) * BattleWorld.CELL_SIZE + BattleWorld.CELL_SIZE / 2, (getY() / BattleWorld.CELL_SIZE) * BattleWorld.CELL_SIZE);
        }
    }    
}
