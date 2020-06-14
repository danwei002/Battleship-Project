import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Cruisers are standard Battleships with no additional functionality. They are sized 2x1 cells and can endure 2 hits before going down.
 * 
 * @author Daniel Wei
 * @version June 14, 2020
 */
public class Cruiser extends Battleship {
    /**
     * Create a Cruiser with specified hp, player association, and BattleWorld
     * 
     * @param hp The HP this Cruiser will start with.
     * @param isLeft True if this Cruiser belongs to the left side player, false if it belongs to the right side player.
     * @param bw The BattleWorld this Cruiser is located in.
     */
    public Cruiser(int hp, boolean isLeft, BattleWorld bw) {
        width = BattleWorld.CELL_SIZE * 2 - 20;
        height = BattleWorld.CELL_SIZE - 10;
        this.hp = hp;
        this.isLeft = isLeft;
        this.bw = bw;
        img = getImage();
        img.scale(width, height);
        unselectedImg = new GreenfootImage("cruiser.png");
        selectedImg = new GreenfootImage("cruiserSelected.png");
        unselectedImg.scale(width, height);
        selectedImg.scale(width, height);
        setImage(img);
    }
    
    /**
     * Act - do whatever the Cruiser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        borderCheck();
        if (!bw.getGameState()) {
            preGame();
        }
        
        if (selected) {setImage(selectedImg);}
        else {setImage(unselectedImg);}
        
        if (getRotation() == 180 || getRotation() == 0) {
            setLocation((getX() / BattleWorld.CELL_SIZE) * BattleWorld.CELL_SIZE, (getY() / BattleWorld.CELL_SIZE) * BattleWorld.CELL_SIZE + BattleWorld.CELL_SIZE / 2);
        } else {
            setLocation((getX() / BattleWorld.CELL_SIZE) * BattleWorld.CELL_SIZE + BattleWorld.CELL_SIZE / 2, (getY() / BattleWorld.CELL_SIZE) * BattleWorld.CELL_SIZE);
        }
        if (hp <= 0) {getWorld().removeObject(this);}
    }  
}
