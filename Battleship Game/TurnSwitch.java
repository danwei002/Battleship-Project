import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * TurnSwitch is a button only avaiable during the pre-game phase where players are
 * setting up their ship layouts. It switches between players to allow both to get an
 * opportunity to set up their layouts.
 * 
 * @author Daniel Wei
 * @version June 14, 2020
 */
public class TurnSwitch extends Button
{
    /**
     * Create a TurnSwitch
     */
    public TurnSwitch()
    {
        selectedImg = new GreenfootImage("turnBtnselected.png");
        unselectedImg = new GreenfootImage("turnBtnUnselected.png");
        
        setImage(unselectedImg);   
        
        int width = getImage().getWidth() / 7;
        int height = getImage().getHeight() / 7;
        selectedImg.scale(width, height);
        unselectedImg.scale(width, height);
    }
    
    /**
     * Click handler
     */
    public void onClick() {
        BattleWorld w = (BattleWorld) getWorld();
        w.switchTurn();
    }
}
