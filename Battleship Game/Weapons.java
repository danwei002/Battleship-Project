import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Weapons are used by players to either attack enemy ships or gain intel on the enemy's position.
 * 
 * @author Govind Nair & Daniel Wei
 * @version June 14, 2020
 */
public abstract class Weapons extends Actor
{
    protected BattleWorld bw;
    protected GreenfootImage img;
    protected int damage;
    
    /**
     * Act - do whatever the Weapons wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
