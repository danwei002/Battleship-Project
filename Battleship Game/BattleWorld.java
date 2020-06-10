import java.util.*;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BattleWorld extends World {
    public final static int CELL_SIZE = 80;
    
    GreenfootImage img = new GreenfootImage(CELL_SIZE * 20, CELL_SIZE * 10);
    
    // Grid to store what ship is present in each cell
    public Battleship[][] grid; // first index = column #, second index = row #
    
    // Players' ships
    private Zoomboat leftZoom1;
    private Zoomboat leftZoom2;
    private Cruiser leftCruiser1;
    private Cruiser leftCruiser2;
    private Submarine leftSub1;
    private Submarine leftSub2;
    
    private Zoomboat rightZoom1;
    private Zoomboat rightZoom2;
    private Cruiser rightCruiser1;
    private Cruiser rightCruiser2;
    private Submarine rightSub1;
    private Submarine rightSub2;
    
    private ArrayList<Battleship> leftPlayerShips = new ArrayList<Battleship>();
    private ArrayList<Battleship> rightPlayerShips = new ArrayList<Battleship>();
    
    // Used in all classes to determine if the game has begun
    private boolean gameStarted = false;
    
    // Store which player's turn it is
    private boolean isLeftTurn = true;
    
    // Mouse
    private MouseInfo mouse;
    
    // Turning switch button
    private TurnSwitch ts = new TurnSwitch();
    
    // End pre-game phase button
    private StartGame sg;
    
    // Main sound
    public static GreenfootSound bkgrndMusic = new GreenfootSound("bkgrndMusic.mp3");
    
    // See if the weapon selected display is still on screen
    private boolean weaponDisplayed = false;
    
    // Weapon selected type storage
    // 0 = missile
    // 1 = radar
    // 2 = torpedo
    private int weaponType = 0;
    
    // Key press
    private String pressedKey;
    
    // Show which player is currently playing
    private TurnText turnText;
    
    public BattleWorld() {   
        super(CELL_SIZE * 20, CELL_SIZE * 10, 1); 
        
        leftZoom1 = new Zoomboat(1, true, this);
        leftZoom2 = new Zoomboat(1, true, this);
        leftCruiser1 = new Cruiser(2, true, this);
        leftCruiser2 = new Cruiser(2, true, this);
        leftSub1 = new Submarine(3, true, this);
        leftSub2 = new Submarine(3, true, this);
    
        rightZoom1 = new Zoomboat(1, false, this);
        rightZoom2 = new Zoomboat(1, false, this);
        rightCruiser1 = new Cruiser(2, false, this);
        rightCruiser2 = new Cruiser(2, false, this);
        rightSub1 = new Submarine(3, false, this);
        rightSub2 = new Submarine(3, false, this);
        
        turnText = new TurnText();
        GreenfootImage tImage = turnText.getImage();
        tImage.scale(CELL_SIZE * 3, CELL_SIZE / 2);
        turnText.setImage(tImage);
        addObject(turnText, getWidth() / 4, 25);
        
        initialize();
        gameStarted = false;
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
        
        addObject(leftSub1, 0, CELL_SIZE);
        addObject(leftSub2, 0, CELL_SIZE * 2);
        addObject(leftCruiser1, CELL_SIZE, CELL_SIZE * 3);
        addObject(leftCruiser2, CELL_SIZE, CELL_SIZE * 4);
        addObject(leftZoom1, 0, CELL_SIZE * 5);
        addObject(leftZoom2, 0, CELL_SIZE * 6);
        addObject(rightSub1, CELL_SIZE * 19, CELL_SIZE);
        addObject(rightSub2, CELL_SIZE * 19, CELL_SIZE * 2);
        addObject(rightCruiser1, CELL_SIZE * 19, CELL_SIZE * 3);
        addObject(rightCruiser2, CELL_SIZE * 19, CELL_SIZE * 4);
        addObject(rightZoom1, CELL_SIZE * 19, CELL_SIZE * 5);
        addObject(rightZoom2, CELL_SIZE * 19, CELL_SIZE * 6);
        
        sg = new StartGame(this);
        
        addObject(ts, CELL_SIZE * 10, CELL_SIZE * 10 - 50);
        addObject(sg, CELL_SIZE * 10, CELL_SIZE * 10 - 95);
        
        grid = new Battleship[20][10];
    }
    
    /**
     * Initialize ArrayLists for player ships
     */
    private void initialize()
    {
        leftPlayerShips.add(leftZoom1);
        leftPlayerShips.add(leftZoom2);
        leftPlayerShips.add(leftCruiser1);
        leftPlayerShips.add(leftCruiser2);
        leftPlayerShips.add(leftSub1);
        leftPlayerShips.add(leftSub2);
        rightPlayerShips.add(rightZoom1);
        rightPlayerShips.add(rightZoom2);
        rightPlayerShips.add(rightCruiser1);
        rightPlayerShips.add(rightCruiser2);
        rightPlayerShips.add(rightSub1);
        rightPlayerShips.add(rightSub2);
    }
        
    public void act() {
        pressedKey = Greenfoot.getKey();
        if (gameStarted) {
            removeObject(ts);
            gridClicked();
            
            if (!weaponDisplayed) {
                
                if ("1".equals(pressedKey)) {
                    weaponDisplayed = true;
                    addObject(new WeaponSelected("missileSelected.png"), getWidth() / 2, getHeight() / 2);
                    weaponType = 0;
                } else if ("2".equals(pressedKey)) {
                    weaponDisplayed = true;
                    addObject(new WeaponSelected("radarSelected.png"), getWidth() / 2 , getHeight() / 2);
                    weaponType = 1;
                } else if ("3".equals(pressedKey)) {
                    weaponDisplayed = true;
                    addObject(new WeaponSelected("torpedoSelected.png"), getWidth() / 2, getHeight() / 2);
                    weaponType = 2;
                }
            }
        }
        
        processGrid();
        mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {fillCells(getCol(mouse.getX()), getRow(mouse.getY()));}
        shipSelect();
        //highlight();
        
        if (isLeftTurn) {
            turnText.setLocation(getWidth() / 4, 25);
            for (Battleship b: rightPlayerShips) {b.unselect(); b.conceal();}
            for (Battleship b: leftPlayerShips) {b.reveal();}
        } else {
            turnText.setLocation(getWidth() / 4 * 3, 25);
            for (Battleship b: leftPlayerShips) {b.unselect(); b.conceal();}
            for (Battleship b: rightPlayerShips) {b.reveal();}
        }
    }
    
    /**
     * Utility method to get the row number for a specified x-coordinate
     * 
     * @param x x-coordinate
     * @return int Row number (integer from 0 - 19)
     */
    public int getCol(int x) {
        return x / CELL_SIZE;
    }
    
    /**
     * Utility method to get the row number for a specified y-coordinate
     * 
     * @param y y-coordinate
     * @return int Column number (integer from 0 - 9)
     */
    public int getRow(int y) {
        return y / CELL_SIZE;
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
                else {grid[i][j] = null;}
            }
        }
    }
    
    /**
     * Utility function to test grid
     */
    private void highlight() {
        for (int i = 0; i < CELL_SIZE * 20; i += CELL_SIZE) {
            for (int j = 0; j < CELL_SIZE * 10; j += CELL_SIZE) {
                if (grid[i / CELL_SIZE][j / CELL_SIZE] != null) {img.setColor(Color.RED);}
                else {img.setColor(Color.BLUE);}
                img.fillRect(i + 1, j + 1, CELL_SIZE - 1, CELL_SIZE - 1);
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
        if (mouse == null) {return;}
        int x = mouse.getX();
        int y = mouse.getY();
        int row = getRow(y);
        int col = getCol(x);
        List <Battleship> l = (List <Battleship>) getObjectsAt(x, y, Battleship.class);
        if (weaponType == 0) {
            if (Greenfoot.mouseClicked(this) || (l.size() != 0 && Greenfoot.mouseClicked(l.get(0)))) { 
                if (grid[col][row] != null) {
                    if (grid[col][row].getSide() == isLeftTurn || grid[col][row] instanceof DestroyedShip) {return;}
                    else {bomb(x, y);}
                } else {
                    if (isLeftTurn) {
                        if (col >= 10) {bomb(x, y);}
                    } else {
                        if (col <= 9) {bomb(x, y);}
                    }
                }
            }
        } else if (weaponType == 1) {
            if (Greenfoot.mouseClicked(this) || (l.size() != 0 && Greenfoot.mouseClicked(l.get(0)))) {
                if (isLeftTurn) {
                    if (col >= 10) {
                        addObject(new Radar(), col * CELL_SIZE + CELL_SIZE / 2, row * CELL_SIZE + CELL_SIZE / 2);
                    }
                } else {
                    if (col <= 9) {
                        addObject(new Radar(), col * CELL_SIZE + CELL_SIZE / 2, row * CELL_SIZE + CELL_SIZE / 2);
                    }
                }
            }
        } else if (weaponType == 2) {
            if (Greenfoot.mouseClicked(this) || (l.size() != 0 && Greenfoot.mouseClicked(l.get(0)))) { 
                if (grid[col][row] != null) {
                    if (grid[col][row].getSide() == isLeftTurn || grid[col][row] instanceof DestroyedShip) {return;}
                    else {torpedo(x, y);}
                } else {
                    if (isLeftTurn) {
                        if (col >= 10) {torpedo(x, y);}
                    } else {
                        if (col <= 9) {torpedo(x, y);}
                    }
                }
            }
        }
    }
        
    public void bomb(int x, int y) {
        int row = getRow(y);
        int col = getCol(x);
        BomberPlane bomber = new BomberPlane(35, row, col, x, this);
        addObject(bomber, 0, (row * CELL_SIZE) + CELL_SIZE / 2);
        if (grid[col][row] != null && !grid[col][row].isSubmerged()) {
            grid[col][row].takeDamage(1);
            DestroyedShip ds = new DestroyedShip(CELL_SIZE, CELL_SIZE, isLeftTurn);
            grid[col][row] = ds;
            addObject(ds, col * CELL_SIZE + CELL_SIZE / 2, row * CELL_SIZE + CELL_SIZE / 2);
            if (isLeftTurn) {leftPlayerShips.add(ds);}
            else {rightPlayerShips.add(ds);}
        }
    }
    
    public void torpedo(int x, int y) {
        int row = getRow(y);
        int col = getCol(x);
        Torpedo torp = new Torpedo(1, this);
        addObject(torp, col * CELL_SIZE + CELL_SIZE / 2, row * CELL_SIZE + CELL_SIZE / 2);
        torp.doTorpedo();
        if (grid[col][row] != null && grid[col][row].isSubmerged()) {
            grid[col][row].takeDamage(1);
            DestroyedShip ds = new DestroyedShip(CELL_SIZE, CELL_SIZE, isLeftTurn);
            grid[col][row] = ds;
            addObject(ds, col * CELL_SIZE + CELL_SIZE / 2, row * CELL_SIZE + CELL_SIZE / 2);
            if (isLeftTurn) {leftPlayerShips.add(ds);}
            else {rightPlayerShips.add(ds);}
        }
    }
    
    /**
     * Selecting ship handler
     */
    private void shipSelect() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        Battleship selectedShip;
        if (mouse == null) {return;}
        if (isLeftTurn) {
            int x = mouse.getX();
            int y = mouse.getY();
            List<Battleship> l = (List <Battleship>) getObjectsAt(x, y, Battleship.class);
            if (l.size() == 0) {return;}
            selectedShip = l.get(0);
            if (Greenfoot.mousePressed(selectedShip)) {
                for (Battleship b: leftPlayerShips) {
                    if (b == selectedShip) {b.select();}
                    else {b.unselect();}
                }
            }
        } else {
            int x = mouse.getX();
            int y = mouse.getY();
            List<Battleship> l = (List <Battleship>) getObjectsAt(x, y, Battleship.class);
            if (l.size() == 0) {return;}
            selectedShip = l.get(0);
            if (Greenfoot.mousePressed(selectedShip)) {
                for (Battleship b: rightPlayerShips) {
                    if (b == selectedShip) {b.select();}
                    else {b.unselect();}
                }
            }
        }
    }
    
    /**
     * Switch turns
     */
    public void switchTurn() {
        SwitchingTurnsText stt = new SwitchingTurnsText();
        addObject(stt, getWidth() / 2, getHeight() / 2);
        weaponType = 0; // reset weapon to default
        Greenfoot.delay(300);
        removeObject(stt);
        isLeftTurn = !isLeftTurn;
    }
    
    /**
     * Get current turn
     * 
     * @return boolean True if left side turn, false if right side turn
     */
    public boolean getTurn() {
        return isLeftTurn;
    }
    
    /**
     * Get key press
     */
    public String keyPress() {
        return pressedKey;
    }
    
    /**
     * Set game started
     */
    public void startGame() {gameStarted = true;}
    
    /**
     * Get game state
     * 
     * @return boolean True if game started, false if not
     */
    public boolean getGameState() {return gameStarted;}
    
    /**
     * Reset weapon displayed boolean
     */
    public void weaponDisplayReset() {weaponDisplayed = false;}
    
}
