import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TurnSwitch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TurnSwitch extends Button
{
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
   
    public void onClick() {
        BattleWorld w = (BattleWorld) getWorld();
        w.switchTurn();
    }
}
