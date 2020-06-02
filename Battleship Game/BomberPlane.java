import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BomberPlane here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BomberPlane extends Actor
{
    /**
     * Act - do whatever the BomberPlane wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed;
    public BomberPlane(){
         speed = 5; 
    }
    public BomberPlane(int speed){
     this.speed = speed;   
        
    }
    public void act() 
    {
        // Add your action code here.
        move(5);
    }    

    
    
    
    
    
}
