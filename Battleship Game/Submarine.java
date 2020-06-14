import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Submarines are Battleship with the special functionality of being able to submerge underwater should the player
 * choose to do so. When submerged underwater, submarines are immune to being hit by aerial Missiles, but are vulnerable
 * to underwater Torpedos. When they are not submerged, they are immune to underwater Torpedos, but vulnerable to aerial Missiles.
 * Submarines have three hitpoints and are 3x1 cells in size.
 * 
 * @author Daniel Wei
 * @version June 14, 2020
 */
public class Submarine extends Battleship
{
    private GreenfootImage submergedUnselected = new GreenfootImage("submarineSubmerged.png");
    private GreenfootImage submergedSelected = new GreenfootImage("submarineSubmergedSelect.png");
    private GreenfootImage unselect = new GreenfootImage("submarine.png");
    private GreenfootImage select = new GreenfootImage("submarineSelected.png");
    
    /**
     * Create a Submarine with specified hp, player association, and BattleWorld
     * 
     * @param hp The HP this Submarine will start with.
     * @param isLeft True if this Submarine belongs to the left side player, false if it belongs to the right side player.
     * @param bw The BattleWorld this Submarine is in.
     */
    public Submarine(int hp, boolean isLeft, BattleWorld bw)
    {
        width = BattleWorld.CELL_SIZE * 3 - 20;
        height = BattleWorld.CELL_SIZE - 10;
        this.hp = hp;
        this.isLeft = isLeft;
        this.bw = bw;
        img = getImage();
        img.scale(width, height);
        unselectedImg = new GreenfootImage("submarine.png");
        selectedImg = new GreenfootImage("submarineSelected.png");
        unselectedImg.scale(width, height);
        selectedImg.scale(width, height);
        unselect.scale(width, height);
        select.scale(width, height);
        submergedUnselected.scale(width, height);
        submergedSelected.scale(width, height);
        setImage(img);
    }
    
    /**
     * Act - do whatever the Submarine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (!bw.getGameState()) {
            preGame();
        } else {
            if (selected) {
                if ("space".equals(bw.keyPress())) {
                    if (submerged) {
                        unselectedImg = unselect;
                        selectedImg = select;
                        submerged = false;
                    } else {
                        unselectedImg = submergedUnselected;
                        selectedImg =  submergedSelected;
                        submerged = true;
                    }
                }
            }
        }
        
        if (selected) {setImage(selectedImg);}
        else {setImage(unselectedImg);}
        
        borderCheck();
        setLocation((int) (getX() / BattleWorld.CELL_SIZE) * BattleWorld.CELL_SIZE + BattleWorld.CELL_SIZE / 2, (int) (getY() / BattleWorld.CELL_SIZE) * BattleWorld.CELL_SIZE + BattleWorld.CELL_SIZE/ 2);
        if (hp <= 0) {getWorld().removeObject(this);}
    } 
    
    /**
     * Conceals the Submarine between turns from the opposing player
     */
    public void conceal()
    {
        unselectedImg.setTransparency(1);
        selectedImg.setTransparency(1);
        submergedUnselected.setTransparency(1);
        submergedSelected.setTransparency(1);
        img.setTransparency(1);
        setImage(img);
    }
    
    /**
     * Reveals the Submarine when it is the associated player's turn.
     */
    public void reveal()
    {
        unselectedImg.setTransparency(255);
        selectedImg.setTransparency(255);
        submergedUnselected.setTransparency(255);
        submergedSelected.setTransparency(255);
        img.setTransparency(255);
        setImage(img);
    }
}
