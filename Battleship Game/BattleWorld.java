import java.util.*;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BattleWorld extends World {
    public final static int CELL_SIZE = 60;
    
    GreenfootImage img = new GreenfootImage(CELL_SIZE * 20, CELL_SIZE * 10);
    
    // Grid to store what ship is present in each cell
    public Battleship[][] grid;
    
    // Players' ships
    private Battleship[] leftPlayerShips;
    private Battleship[] rightPlayerShips;
    
    public BattleWorld() {    
        super(CELL_SIZE * 20, CELL_SIZE * 10, 1); 
        img.setColor(Color.BLUE);
        img.fillRect(0, 0, CELL_SIZE * 20, CELL_SIZE * 10);
        img.setColor(Color.BLACK);
        for (int i = 0; i < CELL_SIZE * 20; i += CELL_SIZE) {
            img.drawLine(i, 0, i, CELL_SIZE * 10);
        }
        
        for (int i = 0; i < CELL_SIZE * 10; i += CELL_SIZE) {
            img.drawLine(0, i, CELL_SIZE * 20, i);
        }
        
        img.fillRect(CELL_SIZE * 10 - 3, 0, 7, CELL_SIZE * 10);
        setBackground(img);
        
        grid = new Battleship[20][10];
    }
        
    public void act() {
        fillCells(getRow(), getCol());
        gridClicked();
        processGrid();
    }
    
    /**
     * Utility method to get the row number that the mouse is located in
     * 
     * @return int Row number (integer from 0 - 19)
     */
    public int getRow() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse == null) {return -100;}
        return mouse.getX() / CELL_SIZE;
    }
    
    /**
     * Utility method to get the column number that the mouse is located in
     * 
     * @return int Column number (integer from 0 - 19)
     */
    public int getCol() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse == null) {return -100;}
        return mouse.getY() / CELL_SIZE;
    }
    
    /**
     * Process the grid to determine the
     * locations of the ships
     */
    private void processGrid() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                int xCoord = CELL_SIZE / 2 + i * CELL_SIZE;
                int yCoord = CELL_SIZE / 2 + j * CELL_SIZE;
                List <Battleship> l = (List <Battleship>) getObjectsAt(xCoord, yCoord, Battleship.class);
                if (l.size() != 0) {grid[i][j] = l.get(0);}
            }
        }
    }

    /**
     * Used for mouse hover detection
     */
    private void fillCells(int rX, int rY)
    {
        for (int i = 0; i < CELL_SIZE * 20; i += CELL_SIZE) {
            for (int j = 0; j < CELL_SIZE * 10; j += CELL_SIZE) {
                if (i / CELL_SIZE == rX && j / CELL_SIZE == rY) {img.setColor(Color.CYAN);}
                else {img.setColor(Color.BLUE);}
                img.fillRect(i + 1, j + 1, CELL_SIZE - 1, CELL_SIZE - 1);
            }
        }
        img.setColor(Color.BLACK);
        img.fillRect(CELL_SIZE * 10 - 3, 0, 7, CELL_SIZE * 10);
        setBackground(img);
    }
    
    /**
     * Grid click event handler
     */
    private void gridClicked() {
        BomberPlane bomber = new BomberPlane();
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse == null) {return;}
        int x = mouse.getX();
        int y = mouse.getY();
        List <Battleship> l = (List <Battleship>) getObjectsAt(x, y, Battleship.class);
        if (Greenfoot.mouseClicked(this) || (l.size() != 0 && Greenfoot.mouseClicked(l.get(0)))) { 
            bomb(x, y);
        }
    }
        
    public void bomb(int x, int y) {
        BomberPlane bomber = new BomberPlane();
        addObject(bomber, 0, (y / CELL_SIZE * CELL_SIZE) + CELL_SIZE / 2);
        Missile missile = new Missile();
        // missile.dropMissile(x / CELL_SIZE * CELL_SIZE) + CELL_SIZE / 2, y / CELL_SIZE * CELL_SIZE) + CELL_SIZE / 2); 
    }
    
}
