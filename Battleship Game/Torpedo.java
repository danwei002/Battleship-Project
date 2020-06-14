import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Torpedos are underwater weapons capable of affecting and damaging submerged Submarines.
 * 
 * @author Govind Nair
 * @version June 14, 2020
 */
public class Torpedo extends Weapons
{
    private int index = 0; // animation index
    private boolean exploding = false;
    //Array that contains the frames for the torpedo animation
    private GreenfootImage[] frames = {new GreenfootImage("mis7.png"), new GreenfootImage("mis8.png"), new GreenfootImage("mis9.png"),
                                                 new GreenfootImage("mis10.png"), new GreenfootImage("mis11.png")};
              
    /**
     * Create a Torpedo with specified damage and BattleWorld.
     * 
     * @param damage Damage this Torpedo will deal to a Submarine it collides with.
     * @param bw BattleWorld this Torpedo is in.
     */          
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
    
    /**
     * Start explosion
     */
    public void doTorpedo() {
        exploding = true;
    }
    
    /**
     * Explosion animation handler
     */
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
