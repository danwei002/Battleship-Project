import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * DestroyedShip is an indicator for players to know where they have hit an opponent's ship.
 * It is a red X that appears on the grid in a cell should a player hit an enemy ship inside that cell.
 * 
 * @author Daniel Wei
 * @version June 14, 2020
 */
public class DestroyedShip extends Battleship
{
    /**
     * Create a DestroyedShip with specified width, height, and player association
     * 
     * @param width The width of the DestroyedShip.
     * @param height The height of the DestroyedShip.
     * @param isLeft True if this DestroyedShip belongs to the left side player, false if it belongs to the right side player.
     */
    public DestroyedShip(int width, int height, boolean isLeft) {
        this.width = width;
        this.height = height;
        this.isLeft = isLeft;
        this.hp = 0;
        img = getImage();
        img.scale(width, height);
        setImage(img);
    }
    
    /**
     * Reveals the Red X
     */
    public void reveal() 
    {
        img.setTransparency(255);
    }
    
    /**
     * Conceals the Red X 
     */
    public void conceal()
    {
        img.setTransparency(1);
    }
}
