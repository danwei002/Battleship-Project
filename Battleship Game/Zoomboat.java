import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
/**
 * Write a description of class Zoomboat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zoomboat extends Battleship
{
    private int currRow;
    private int currCol;
    
    public Zoomboat(int hp, boolean isLeft)
    {
        width = BattleWorld.CELL_SIZE - 10;
        height =  BattleWorld.CELL_SIZE / 2;
        this.hp = hp;
        this.isLeft = isLeft;
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
        BattleWorld bw = (BattleWorld) getWorld();
        currRow = bw.getRow(getY());
        currCol = bw.getCol(getX());
        borderCheck();
        if (!BattleWorld.gameStarted) {
            preGame();
        } else {
            if (selected) {
                String pressedKey = Greenfoot.getKey();
                int tmp;
                if ("w".equals(pressedKey) && currRow > 0) {
                    tmp = currRow - 1;
                    if (bw.grid[currCol][tmp] == null) {currRow = tmp;}
                    setLocation(getX(), currRow * BattleWorld.CELL_SIZE + BattleWorld.CELL_SIZE / 2);
                    bw.switchTurn();
                } else if ("a".equals(pressedKey) && currCol > 0 && (bw.getTurn() || (!bw.getTurn() && currCol > 10))) {
                    tmp = currCol - 1;
                    if (bw.grid[tmp][currRow] == null) {currCol = tmp;}
                    setLocation(currCol * BattleWorld.CELL_SIZE + BattleWorld.CELL_SIZE / 2, getY());
                    bw.switchTurn();
                } else if ("s".equals(pressedKey) && currRow < 19) {
                    tmp = currRow + 1;
                    if (bw.grid[currCol][tmp] == null) {currRow = tmp;}
                    setLocation(getX(), currRow * BattleWorld.CELL_SIZE + BattleWorld.CELL_SIZE / 2);
                    bw.switchTurn();
                } else if ("d".equals(pressedKey) && currCol < 19 && (!bw.getTurn() || (bw.getTurn() && currCol < 9))) {
                    tmp = currCol + 1;
                    if (bw.grid[tmp][currRow] == null) {currCol = tmp;}
                    setLocation(currCol * BattleWorld.CELL_SIZE + BattleWorld.CELL_SIZE / 2, getY());
                    bw.switchTurn();
                }
            }
        }

        if (selected) {setImage(selectedImg);}
        else {setImage(unselectedImg);}
        
        setLocation((int) (getX() / BattleWorld.CELL_SIZE) * BattleWorld.CELL_SIZE + BattleWorld.CELL_SIZE / 2, (int) (getY() / BattleWorld.CELL_SIZE) * BattleWorld.CELL_SIZE + BattleWorld.CELL_SIZE/ 2);
        if (hp <= 0) {getWorld().removeObject(this);}
    }  
}
