import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zoomboat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zoomboat extends Battleship
{
    public Zoomboat(int hp, boolean isLeft)
    {
        width = BattleWorld.CELL_SIZE - 10;
        height =  BattleWorld.CELL_SIZE / 2;
        this.hp = hp;
        this.isLeft = isLeft;
        img = getImage();
        img.scale(width, height);
        setImage(img);
    }
    
    public void act() 
    {
        borderCheck();
        setLocation((int) (getX() / BattleWorld.CELL_SIZE) * BattleWorld.CELL_SIZE + BattleWorld.CELL_SIZE / 2, (int) (getY() / BattleWorld.CELL_SIZE) * BattleWorld.CELL_SIZE + BattleWorld.CELL_SIZE/ 2);
    }    
}
