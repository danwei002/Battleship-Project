import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Missiles are aerial weapons that affect and damage all unsubmerged Battleships. 
 * 
 * @author Govind Nair
 * @version June 14, 2020
 */
public class Missile extends Weapons
{
    // array that contains the frames for the explosion animation.
    private GreenfootImage[] missileExplosion = {new GreenfootImage("mis2.png"), new GreenfootImage("mis3.png"), new GreenfootImage("mis4.png"), new GreenfootImage("mis5.png"), 
                                                 new GreenfootImage("mis6.png"), new GreenfootImage("mis7.png"), new GreenfootImage("mis8.png"), new GreenfootImage("mis9.png"),
                                                 new GreenfootImage("mis10.png"), new GreenfootImage("mis11.png")};
    private int index = 0; // animation index
    private boolean exploding = false; // boolean to check if the missile is exploding
    private GreenfootSound fireSound = new GreenfootSound("missileFire.mp3");
    
    /**
     * Create a Missile with specified damage and BattleWorld.
     * 
     * @param damage The damage this missile should deal to a Battleship it hits.
     * @param bw The BattleWorld this missile is in.
     */
    public Missile(int damage, BattleWorld bw){
       this.damage = damage;
       this.bw = bw;
       fireSound.setVolume(50);
       fireSound.play();
    }
    
    /**
     * Create a Missile with preset damage.
     */
    public Missile(){
        damage = 1;
    }
    
    public void act() 
    {
        // Add your action code here.
        if(exploding) {
            explode();
        }
    }
    
    /**
     * Drop the missile at a certain x and y coordinate.
     * 
     * @param x X-coordinate to drop at.
     * @param y Y-coordinate to drop at.
     */
    public void dropMissile(int x, int y){
        exploding = true; 
    }
    
    /**
     * Missile explosion animation handler
     */
    public void explode(){
        if(index < 40) {     
            GreenfootImage missileExplosions  = missileExplosion[index/4];
            setImage(missileExplosions);
            index++;
        }
        else {
            getWorld().removeObject(this);
            bw.switchTurn();
        }
    }
}
