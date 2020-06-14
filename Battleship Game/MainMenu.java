import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Main Menu that players see when the game is first launched. From here
 * they can change the game's soundtracks, view instructions, or start the game.
 * <br>
 * <br>
 * Menu Music (Valorant Menu OST): <a href=https://www.youtube.com/watch?v=fOE9KngRlO8>Link</a>
 * 
 * @author Daniel Wei
 * @version June 14, 2020
 */
public class MainMenu extends World
{
    // Menu music is Riot Games' Valorant Menu Music, https://www.youtube.com/watch?v=fOE9KngRlO8
    public static final GreenfootSound menuMusic = new GreenfootSound("menuMusic.wav");
    
    private GreenfootImage bkgrnd = new GreenfootImage("bkgrnd.png");
    
    private StartBtn startBtn;
    private InstructBtn instructBtn;
    private MusicBtn musicBtn;
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
        
        musicBtn = new MusicBtn();
        addObject(musicBtn, getWidth() / 2, getHeight() / 3 * 2);
    }
    
    public void started() {
        menuMusic.playLoop();
    }
}
