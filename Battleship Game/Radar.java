import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Radar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Radar extends Weapons
{
    private int pulseRadius = 1;
    private GreenfootImage radarImg = new GreenfootImage("radar.png");
    private GreenfootSound radarPulse = new GreenfootSound("radarPulse.mp3");
    private boolean soundPlayed = false;
    
    public Radar() {
        img = radarImg;
        radarImg.scale(BattleWorld.CELL_SIZE / 4 * 3, BattleWorld.CELL_SIZE / 4 * 3);
        img.scale(BattleWorld.CELL_SIZE / 4 * 3, BattleWorld.CELL_SIZE / 4 * 3);
        setImage(img);
    }
    
    /**
     * Act - do whatever the Radar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    { 
        setLocation(getX() / BattleWorld.CELL_SIZE * BattleWorld.CELL_SIZE + BattleWorld.CELL_SIZE / 2, getY() / BattleWorld.CELL_SIZE * BattleWorld.CELL_SIZE + BattleWorld.CELL_SIZE / 2);
        pulse();
    }   
    
    public void scan(int col, int row)
    {
        
    }
    
    private void pulse()
    {
        if (!soundPlayed) {
            radarPulse.play();
            soundPlayed = true;
        }

        img = new GreenfootImage(pulseRadius * 2, pulseRadius * 2);
        img.drawImage(radarImg, pulseRadius - (BattleWorld.CELL_SIZE / 4 * 3) / 2, pulseRadius - (BattleWorld.CELL_SIZE / 4 * 3) / 2);
        img.setColor(Color.RED);
        img.drawOval(0, 0, pulseRadius * 2, pulseRadius * 2);
        setImage(img);
        
        BattleWorld bw = (BattleWorld) getWorld();
        for (Zoomboat zb: getIntersectingObjects(Zoomboat.class)) {
            if (zb.getSide() != bw.getTurn()) {
                zb.reveal();
            }
        }
        
        if (pulseRadius < BattleWorld.CELL_SIZE * 2 + BattleWorld.CELL_SIZE / 2) {
            pulseRadius += 3;
        } else {
            getWorld().removeObject(this);
            bw.switchTurn();
        }
    }
}
