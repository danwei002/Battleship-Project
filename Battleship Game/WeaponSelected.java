import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * WeaponSelected is the visual display that shows when users are swapping between weapons.
 * 
 * @author Daniel Wei
 * @version June 14, 2020
 */
public class WeaponSelected extends Actor
{
    private String imageName;
    private GreenfootImage img;
    private int delay = 0;
    private int removal = 50;
    
    /**
     * Create a WeaponSelected with the specified imageName.
     * 
     * @param imageName The name of the image to assign to this WeaponSelected.
     */
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
