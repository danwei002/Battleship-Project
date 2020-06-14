import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * MusicSelect is a world where players can select the soundtrack they wish to here
 * in the game.
 * <br>
 * <br>
 * Track 1 (Peter Crowley - Battleship): <a href="https://www.youtube.com/watch?v=78k6Wy_c_t0">Link</a>
 * <br>
 * <br>
 * Track 2 (Nintendo - Super Mario Galaxy's Buoy Base Galaxy OST): <a href="https://www.youtube.com/watch?v=z29bt-wjS88">Link</a>
 * <br>
 * <br>
 * Track 3 (Nintendo - Super Mario Galaxy's Battlerock Galaxy OST): <a href="https://www.youtube.com/watch?v=KYhmHovdBxY">Link</a>
 * <br>
 * <br>
 * 
 * @author Daniel Wei
 * @version June 14, 2020
 */
public class MusicSelect extends World
{
    public static final GreenfootSound track1 = new GreenfootSound("bkgrndMusic.mp3");
    public static final GreenfootSound track2 = new GreenfootSound("bkgrndMusic2.mp3");
    public static final GreenfootSound track3 = new GreenfootSound("bkgrndMusic3.mp3");
    
    private GreenfootImage bkgrnd = new GreenfootImage("musicSelect.png");
    
    private BackBtn backBtn;
    private Soundtrack1 st1;
    private Soundtrack2 st2;
    private Soundtrack3 st3;
    /**
     * Constructor for objects of class MusicSelect.
     * 
     */
    public MusicSelect()
    {    
        super(BattleWorld.CELL_SIZE * 20, BattleWorld.CELL_SIZE * 10, 1);
        bkgrnd.scale(getWidth(), getHeight());
        setBackground(bkgrnd);
        
        backBtn = new BackBtn(new MainMenu());
        addObject(backBtn, 150, 50);
        
        st1 = new Soundtrack1();
        st2 = new Soundtrack2();
        st3 = new Soundtrack3();
        
        addObject(st1, getWidth() / 2, getHeight() / 3);
        addObject(st2, getWidth() / 2, getHeight() / 2);
        addObject(st3, getWidth() / 2, getHeight() / 3 * 2);
    }
}
