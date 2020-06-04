import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartGame extends Button
{
    public StartGame()
    {
        selectedImg = new GreenfootImage("startGameBtnselected.png");
        unselectedImg = new GreenfootImage("startGameBtnUnselected.png");
        
        setImage(unselectedImg);   
        
        int width = getImage().getWidth() / 7;
        int height = getImage().getHeight() / 7;
        selectedImg.scale(width, height);
        unselectedImg.scale(width, height);
    }
    
    public void onClick()
    {
        BattleWorld.gameStarted = true;
        getWorld().removeObject(this);
    }
}
