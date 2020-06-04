import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Submarine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Submarine extends Battleship
{
    public Submarine(int hp, boolean isLeft)
    {
        width = BattleWorld.CELL_SIZE * 3 - 20;
        height = BattleWorld.CELL_SIZE - 10;
        this.hp = hp;
        this.isLeft = isLeft;
        img = getImage();
        img.scale(width, height);
        setImage(img);
    }
    
    /**
     * Act - do whatever the Submarine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (!BattleWorld.gameStarted) {
            preGame();
        }
        
        borderCheck();
        setLocation((int) (getX() / BattleWorld.CELL_SIZE) * BattleWorld.CELL_SIZE + BattleWorld.CELL_SIZE / 2, (int) (getY() / BattleWorld.CELL_SIZE) * BattleWorld.CELL_SIZE + BattleWorld.CELL_SIZE/ 2);
        if (hp <= 0) {getWorld().removeObject(this);}
    } 
}
