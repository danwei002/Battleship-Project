import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DestroyedShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DestroyedShip extends Battleship
{
    public DestroyedShip(int width, int height, boolean isLeft) {
        this.width = width;
        this.height = height;
        this.isLeft = isLeft;
        img = getImage();
        img.scale(width, height);
        setImage(img);
    }
    /**
     * Reveals the Red X that appears when a part of the ship is destroyed.
     */
    public void reveal() 
    {
        img.setTransparency(255);
    }
    /**
     * Conceals the Red X when the ship is not destroyed. 
     */
    public void conceal()
    {
        img.setTransparency(1);
    }
}
