import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WeaponSelected here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WeaponSelected extends Actor
{
    private String imageName;
    private GreenfootImage img;
    private int delay = 0;
    private int removal = 50;
    public WeaponSelected(String imageName) {
        this.imageName = imageName;
        img = new GreenfootImage(imageName);
        setImage(img);
    }
    
    /**
     * Act - do whatever the WeaponSelected wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (delay < removal) {delay++;}
        else {
            BattleWorld bw = (BattleWorld) getWorld();
            bw.weaponDisplayReset();
            bw.removeObject(this);
        }
        // Add your action code here.
    }    
}
