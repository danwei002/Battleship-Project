import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MusicSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MusicSelect extends World
{
    public static final GreenfootSound track1 = new GreenfootSound("bkgrndMusic.mp3");
    public static final GreenfootSound track2 = new GreenfootSound("bkgrndMusic2.mp3");
    
    private GreenfootImage bkgrnd = new GreenfootImage("musicSelect.png");
    
    
    private BackBtn backBtn;
    private Soundtrack1 st1;
    private Soundtrack2 st2;
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
        
        addObject(st1, getWidth() / 2, getHeight() / 3);
        addObject(st2, getWidth() / 2, getHeight() / 2);
    }
}
