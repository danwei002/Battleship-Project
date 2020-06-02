import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class boat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class boat extends Actor
{
    /**
     * Act - do whatever the boat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act() 
    {
        if (Greenfoot.isKeyDown("S"))
        {
            setLocation(getX(), getY() + BattleWorld.CELL_SIZE);
        }
        
        if (Greenfoot.isKeyDown("W"))
        {
            setLocation(getX(), getY() - BattleWorld.CELL_SIZE);
        }
        
        if (Greenfoot.isKeyDown("A"))
        {
            setLocation(getX() - BattleWorld.CELL_SIZE, getY());
        }
        
        if (Greenfoot.isKeyDown("D"))
        {
            setLocation(getX() + BattleWorld.CELL_SIZE, getY());
        }
        
        setLocation((int) (getX() / BattleWorld.CELL_SIZE) * BattleWorld.CELL_SIZE + getImage().getWidth() / 2, (int) (getY() / BattleWorld.CELL_SIZE) * BattleWorld.CELL_SIZE + getImage().getHeight() / 2);
    }    
}
