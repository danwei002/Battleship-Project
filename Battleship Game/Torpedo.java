import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Torpedo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Torpedo extends Weapons
{
    private int index = 0;
    private boolean exploding = false;
    private GreenfootImage[] frames = {new GreenfootImage("mis7.png"), new GreenfootImage("mis8.png"), new GreenfootImage("mis9.png"),
                                                 new GreenfootImage("mis10.png"), new GreenfootImage("mis11.png")};
                                                
    public Torpedo(int damage, BattleWorld bw) {
        this.damage = damage;
        this.bw = bw;
    }
    /**
     * Act - do whatever the Torpedo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(exploding) {
            explode();
        }
    }  
    
    public void doTorpedo() {
        exploding = true;
    }
    
    public void explode(){
        if(index < 20) {     
            GreenfootImage missileExplosions  = frames[index / 4];
            setImage(missileExplosions);
            index++;
        }
        else {
            getWorld().removeObject(this);
            bw.switchTurn();
        }
    }
}
