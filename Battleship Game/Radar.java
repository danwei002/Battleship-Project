import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Radars are weapons that reveal the locations of all enemy Zoomboats
 * in a 5x5 square around the cell it was dropped in.
 * 
 * @author Daniel Wei
 * @version June 14, 2020
 */
public class Radar extends Weapons
{
    // The radius of the pulsing red circle that reveals Zoomboats
    private int pulseRadius = 1;
    
    // Radar image
    private GreenfootImage radarImg = new GreenfootImage("radar.png");
    
    // Pulsing sound
    private GreenfootSound radarPulse = new GreenfootSound("radarPulse.mp3");
    
    //private GreenfootSound radarPulse = new GreenfootSound("usedRadar.mp3"); - cypher voiceline, comment out above line and uncomment this one if u want to hear it
    
    // Zoomboat found sound
    private GreenfootSound foundSound = new GreenfootSound("shipFound.wav");
    
    // Pulsing sound played or not
    private boolean soundPlayed = false;
    
    // Ship found sound effect played or not
    private boolean foundSoundPlayed = false;
    
    /**
     * Create a Radar
     */
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
    
    /**
     * Handle Radar pulsing
     */
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
        List<Zoomboat> lzb = getIntersectingObjects(Zoomboat.class);
        
        // Play found sound if an enemy Zoomboat is detected
        if (lzb.size() != 0 && !foundSoundPlayed) {
            foundSoundPlayed = true;
            foundSound.setVolume(90);
            foundSound.play();
        }
        
        // Reveal found enemy Zoomboats
        for (Zoomboat zb: getIntersectingObjects(Zoomboat.class)) {
            if (zb.getSide() != bw.getTurn()) {
                zb.reveal();
            }
        }
        
        // Pulse a 5x5 radius, then remove self and switch turn
        if (pulseRadius < BattleWorld.CELL_SIZE * 2 + BattleWorld.CELL_SIZE / 2) {
            pulseRadius += 3;
        } else {
            getWorld().removeObject(this);
            bw.switchTurn();
        }
    }
}
