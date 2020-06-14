import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
/**
 * Zoomboats are Battleship with the special functionality of being the only ship that is able to move
 * after the initial pre-game phase. By using WASD, players can opt to use a turn to reposition their Zoomboats
 * one cell up, down, left, or right. Zoomboats have one hit point and are 1x1 cells in size.
 * 
 * @author Daniel Wei
 * @version June 14, 2020
 */
public class Zoomboat extends Battleship
{
    private int currRow;
    private int currCol;
    
    /**
     * Create a Zoomboat with specified hp, player association, and BattleWorld
     * 
     * @param hp The HP this Zoomboat will start with.
     * @param isLeft True if this Zoomboat belongs to the left side player, false if it belongs to the right side player.
     * @param bw The BattleWorld this Zoomboat is in.
     */
    public Zoomboat(int hp, boolean isLeft, BattleWorld bw)
    {
        width = BattleWorld.CELL_SIZE - 10;
        height =  BattleWorld.CELL_SIZE / 2;
        this.hp = hp;
        this.isLeft = isLeft;
        this.bw = bw;
        img = getImage();
        img.scale(width, height);
        unselectedImg = new GreenfootImage("zoomboat.png");
        selectedImg = new GreenfootImage("zoomboatSelected.png");
        unselectedImg.scale(width, height);
        selectedImg.scale(width, height);
        setImage(img);
    }
    
    public void act() 
    {
        bw = (BattleWorld) getWorld();
        currRow = bw.getRow(getY());
        currCol = bw.getCol(getX());
        borderCheck();
        if (!bw.getGameState()) {
            preGame();
        } else {
            // Zoomboat movement handler
            if (selected) {
                String pressedKey = bw.keyPress();
                int tmp;
                if ("w".equals(pressedKey) && currRow > 0) {
                    tmp = currRow - 1;
                    if (bw.grid[currCol][tmp] == null) {
                        currRow = tmp;
                        setLocation(getX(), currRow * BattleWorld.CELL_SIZE + BattleWorld.CELL_SIZE / 2);
                        bw.switchTurn();
                    }
                    
                } else if ("a".equals(pressedKey) && currCol > 0 && (bw.getTurn() || (!bw.getTurn() && currCol > 10))) {
                    tmp = currCol - 1;
                    if (bw.grid[tmp][currRow] == null) {
                        currCol = tmp;
                        setLocation(currCol * BattleWorld.CELL_SIZE + BattleWorld.CELL_SIZE / 2, getY());
                        bw.switchTurn();
                    }
                } else if ("s".equals(pressedKey) && currRow < 9) {
                    tmp = currRow + 1;
                    if (bw.grid[currCol][tmp] == null) {
                        currRow = tmp;
                        setLocation(getX(), currRow * BattleWorld.CELL_SIZE + BattleWorld.CELL_SIZE / 2);
                        bw.switchTurn();
                    }
                    
                } else if ("d".equals(pressedKey) && currCol < 19 && (!bw.getTurn() || (bw.getTurn() && currCol < 9))) {
                    tmp = currCol + 1;
                    if (bw.grid[tmp][currRow] == null) {
                        currCol = tmp;
                        setLocation(currCol * BattleWorld.CELL_SIZE + BattleWorld.CELL_SIZE / 2, getY());
                        bw.switchTurn();
                    }
                }
            }
        }

        if (selected) {setImage(selectedImg);}
        else {setImage(unselectedImg);}
        
        setLocation((int) (getX() / BattleWorld.CELL_SIZE) * BattleWorld.CELL_SIZE + BattleWorld.CELL_SIZE / 2, (int) (getY() / BattleWorld.CELL_SIZE) * BattleWorld.CELL_SIZE + BattleWorld.CELL_SIZE/ 2);
        if (hp <= 0) {getWorld().removeObject(this);}
    }  
}
