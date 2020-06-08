import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BomberPlane here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    
    public BomberPlane() {
         speed = 35; 
    }
    
    public BomberPlane(int speed, int row, int col, int xCoord, BattleWorld bw) {
        this.speed = speed; 
        this.row = row;
        this.col = col;
        this.xCoord = xCoord;
        this.bw = bw;
    }
    
    public void act() {
        move(speed);
        if (!droppedMissile && getX() >= xCoord) {
            m = new Missile(1, bw);
            bw.addObject(m, (col * bw.CELL_SIZE)+ bw.CELL_SIZE / 2 , (row * bw.CELL_SIZE) + bw.CELL_SIZE / 2);
            m.dropMissile((col * bw.CELL_SIZE)+ bw.CELL_SIZE / 2 , (row * bw.CELL_SIZE) + bw.CELL_SIZE / 2);
            droppedMissile = true;
        }
        
        if (getX() >= BattleWorld.CELL_SIZE * 20 - 10) {
            getWorld().removeObject(this);
        }
    }    
}
