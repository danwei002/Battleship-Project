import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartGame extends Button
{
    private BattleWorld bw;
    public StartGame(BattleWorld bw)
    {
        selectedImg = new GreenfootImage("startGameBtnselected.png");
        unselectedImg = new GreenfootImage("startGameBtnUnselected.png");
        this.bw = bw;
        setImage(unselectedImg);   
        
        int width = getImage().getWidth() / 7;
        int height = getImage().getHeight() / 7;
        selectedImg.scale(width, height);
        unselectedImg.scale(width, height);
    }
    
    public void onClick()
    {
        bw.startGame();
        getWorld().removeObject(this);
    }
}
