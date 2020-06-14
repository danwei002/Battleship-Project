import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A fake loading screen to make the game feel more like a game, as many games
 * have loading screens.
 * <br>
 * <br>
 * Loading Music (Valorant Loading Music): <a href="http://your.source.com/link">Link</a>
 * 
 * @author Daniel Wei
 * @version June 14, 2020
 */
public class LoadingScreen extends World
{
    private GreenfootImage img;
    private GreenfootSound loadingMusic = new GreenfootSound("loadingMusic.mp3");
    private int barWidth;
    private int barHeight;
    private int borderWidth;
    private int filledWidth;
    private int maxFilledWidth;
    private int loadingIndex = 0;
    private int x;
    private int y;
    private World nextWorld;
    
    /**
     * Constructor for objects of class LoadingScreen.
     * 
     */
    public LoadingScreen(World w)
    {    
        super(BattleWorld.CELL_SIZE * 20, BattleWorld.CELL_SIZE * 10, 1);
        nextWorld = w;
        GreenfootImage bkgrnd = new GreenfootImage("loading.png");
        bkgrnd.scale(getWidth(), getHeight());
        img = new GreenfootImage(getWidth() , getHeight());
        img.drawImage(bkgrnd, 0, 0);
        
        barWidth = BattleWorld.CELL_SIZE * 16;
        barHeight = BattleWorld.CELL_SIZE;
        borderWidth = BattleWorld.CELL_SIZE / 6;
        maxFilledWidth = barWidth - borderWidth * 2;
        
        img.setFont(img.getFont().deriveFont(36f));
        img.setColor(Color.BLACK);
        img.fillRect(getWidth() / 2 - barWidth / 2, getHeight() / 2 - barHeight / 2, barWidth, barHeight);
        img.setColor(Color.GREEN);
        img.fillRect(getWidth() / 2 - barWidth / 2 + borderWidth, getHeight() / 2 - barHeight / 2 + borderWidth, 0, barHeight - borderWidth * 2);
        setBackground(img);
        
        loadingMusic.playLoop();
    }
    
    public void act()
    {
        if (filledWidth < maxFilledWidth) {
            filledWidth += 3;
            img.fillRect(getWidth() / 2 - barWidth / 2 + borderWidth, getHeight() / 2 - barHeight / 2 + borderWidth, filledWidth, barHeight - borderWidth * 2);
        } else {
            loadingMusic.stop();
            BattleWorld.bkgrndMusic.setVolume(50);
            BattleWorld.bkgrndMusic.playLoop();
            Greenfoot.setWorld(nextWorld);
        }
    }
}
