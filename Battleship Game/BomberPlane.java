import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BomberPlane here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BomberPlane extends Actor {
    /**
     * Act - do whatever the BomberPlane wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed;
    private BattleWorld bw;
    public BomberPlane() {
         speed = 35; 
    }
    
    public BomberPlane(int speed) {
        this.speed = speed; 
    }
    
    public void act() {
        move(speed);
        if (getX() >= BattleWorld.CELL_SIZE * 20 - 10) {
            getWorld().removeObject(this);
        }
    }    
}
