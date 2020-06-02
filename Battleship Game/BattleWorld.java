import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BattleWorld extends World
{
    public final static int CELL_SIZE = 50;
    
    GreenfootImage img = new GreenfootImage(CELL_SIZE * 20, CELL_SIZE * 10);
    
    public Actor[][] grid;
    public BattleWorld()
    {    
        super(CELL_SIZE * 20, CELL_SIZE * 10, 1); 
        img.setColor(Color.BLUE);
        img.fillRect(0, 0, CELL_SIZE * 20, CELL_SIZE * 10);
        img.setColor(Color.BLACK);
        for (int i = 0; i < CELL_SIZE * 20; i += CELL_SIZE) 
        {
            img.drawLine(i, 0, i, CELL_SIZE * 10);
        }
        
        for (int i = 0; i < CELL_SIZE * 10; i += CELL_SIZE) 
        {
            img.drawLine(0, i, CELL_SIZE * 20, i);
        }
        
        img.fillRect(CELL_SIZE * 10 - 3, 0, 7, CELL_SIZE * 10);
        setBackground(img);
        
        grid = new Actor[20][10];
    }
    
    public void act()
    {
        fillCells(getRow(), getCol());
    }
    
    public int getRow()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse == null) {return -100;}
        return mouse.getX() / CELL_SIZE;
    }
    
    public int getCol()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse == null) {return -100;}
        return mouse.getY() / CELL_SIZE;
    }
    
    private void fillCells(int rX, int rY)
    {
        for (int i = 0; i < CELL_SIZE * 20; i += CELL_SIZE) 
        {
            for (int j = 0; j < CELL_SIZE * 10; j += CELL_SIZE) 
            {
                if (i / CELL_SIZE == rX && j / CELL_SIZE == rY) {img.setColor(Color.CYAN);}
                else {img.setColor(Color.BLUE);}
                img.fillRect(i + 1, j + 1, CELL_SIZE - 1, CELL_SIZE - 1);
            }
        }
        img.setColor(Color.BLACK);
        img.fillRect(CELL_SIZE * 10 - 3, 0, 7, CELL_SIZE * 10);
        setBackground(img);
    }
}
