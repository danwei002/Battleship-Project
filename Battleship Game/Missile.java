import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Missile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Missile extends Weapons
{
    /**
     * Act - do whatever the Missile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed = 3; 
    private int damage = 5; 
    public void act() 
    {
        // Add your action code here.
    }    
    
    
    public void dropMissile(int x, int y){
        
        setLocation(x, y); 
        if(getOneIntersectingObject(Battleship.class)!=null){
            explode();
            
        }
    }
    
    public void explode(){
        
    }
    
}
