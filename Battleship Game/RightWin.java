import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * RightWin is the world displayed when the right side player has won the game.
 * <br>
 * <br>
 * Victory Music: <a href="https://www.youtube.com/watch?v=ghk8O1yiY0I">Link</a>
 * 
 * @author Daniel Wei
 * @version June 15, 2020
 */
public class RightWin extends World
{
    private GreenfootImage bkgrnd = new GreenfootImage("rightWin.png");
    private GreenfootSound victoryMusic = new GreenfootSound("victoryMusic.mp3");
    private BackBtn backBtn;
    /**
     * Constructor for objects of class RightWin.
     */
    public RightWin()
    {    
        super(BattleWorld.CELL_SIZE * 20, BattleWorld.CELL_SIZE * 10, 1); 
        bkgrnd.scale(getWidth(), getHeight());
        setBackground(bkgrnd);
        
        backBtn = new BackBtn(new MainMenu());
        addObject(backBtn, 150, 50);
        
        victoryMusic.setVolume(65);
        victoryMusic.play();
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(backBtn)) {
            victoryMusic.stop();
            MainMenu.menuMusic.playLoop();
        }
        
        if (!victoryMusic.isPlaying()) {
            MainMenu.menuMusic.playLoop();
            Greenfoot.setWorld(new MainMenu());
        }
    }
}
