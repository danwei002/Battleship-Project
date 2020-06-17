import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Start the main game phase (exit pre-game phase)
 * 
 * @author Daniel Wei 
 * @version June 14, 2020
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
