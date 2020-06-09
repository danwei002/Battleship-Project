import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{
    private GreenfootImage bkgrnd = new GreenfootImage("bkgrnd.png");
    public static final GreenfootSound menuMusic = new GreenfootSound("menuMusic.wav");
    private StartBtn startBtn;
    private InstructBtn instructBtn;
    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public MainMenu()
    {    
        super(BattleWorld.CELL_SIZE * 20, BattleWorld.CELL_SIZE * 10, 1); 
        bkgrnd.scale(getWidth(), getHeight());
        setBackground(bkgrnd);
        
        startBtn = new StartBtn();
        addObject(startBtn, getWidth() / 2, getHeight() / 3);
        
        instructBtn = new InstructBtn();
        addObject(instructBtn, getWidth() / 2, getHeight() / 2);
    }
    
    public void started() {
        menuMusic.playLoop();
    }
}
