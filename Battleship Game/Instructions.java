import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A world designed to give players instructions on how to play the game.
 * 
 * @author Daniel Wei & Govind Nair
 * @version June 14, 2020
 */
public class Instructions extends World
{
    private GreenfootImage bkgrnd = new GreenfootImage("instructions.png");
    private BackBtn backBtn;
    /**
     * Constructor for objects of class Instructions.
     */
    public Instructions()
    {    
        super(BattleWorld.CELL_SIZE * 20, BattleWorld.CELL_SIZE * 10, 1);
        bkgrnd.scale(getWidth(), getHeight());
        setBackground(bkgrnd);
        
        backBtn = new BackBtn(new MainMenu());
        addObject(backBtn, 150, 50);
    }
}
