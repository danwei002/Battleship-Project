import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * BomberPlanes are the visual planes that fly across the screen to drop
 * a Missile over a clicked cell. 
 * 
 * @author Govind Nair
 * @version June 14, 2020
 */
public class BomberPlane extends Actor {
    /**
     * Act - do whatever the BomberPlane wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed;
    private BattleWorld bw;
    private Missile m;
    private int row;
    private int col;
    private int xCoord;
    private boolean droppedMissile = false;
    
    /**
     * Create a BomberPlane
     */
    public BomberPlane() {
         speed = 35; 
    }
    
    /**
     * Create a BomberPlane with specified speed, grid row, grid column, x-coordinate, and BattleWorld
     * 
     * @param row The row the BomberPlane should fly across
     * @param col The column at which the BomberPlane should drop its missile.
     * @param xCoord The x-coordinate used to get the column where the missile should drop.
     * @param bw The BattleWorld this BomberPlane is in.
     */
    public BomberPlane(int speed, int row, int col, int xCoord, BattleWorld bw) {
        this.speed = speed; 
        this.row = row;
        this.col = col;
        this.xCoord = xCoord;
        this.bw = bw;
    }
    
    public void act() {
        move(speed);
        // Drop missile once xCoord has been reached
        if (!droppedMissile && getX() >= xCoord) {
            m = new Missile(1, bw);
            bw.addObject(m, (col * bw.CELL_SIZE)+ bw.CELL_SIZE / 2 , (row * bw.CELL_SIZE) + bw.CELL_SIZE / 2);
            m.dropMissile((col * bw.CELL_SIZE)+ bw.CELL_SIZE / 2 , (row * bw.CELL_SIZE) + bw.CELL_SIZE / 2);
            droppedMissile = true;
        }
        
        // Remove at right edge
        if (getX() >= BattleWorld.CELL_SIZE * 20 - 10) {
            getWorld().removeObject(this);
        }
    }    
}
