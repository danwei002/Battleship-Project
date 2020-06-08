import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Submarine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Submarine extends Battleship
{
    private BattleWorld bw;
    private boolean submerged = false;
    private GreenfootImage submergedUnselected = new GreenfootImage("submarineSubmerged.png");
    private GreenfootImage submergedSelected = new GreenfootImage("submarineSubmergedSelect.png");
    private GreenfootImage unselect = new GreenfootImage("submarine.png");
    private GreenfootImage select = new GreenfootImage("submarineSelected.png");
    
    public Submarine(int hp, boolean isLeft)
    {
        width = BattleWorld.CELL_SIZE * 3 - 20;
        height = BattleWorld.CELL_SIZE - 10;
        this.hp = hp;
        this.isLeft = isLeft;
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
        if (!BattleWorld.gameStarted) {
            preGame();
        } else {
            if (selected) {
                if ("space".equals(BattleWorld.pressedKey)) {
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
    
    public void conceal()
    {
        unselectedImg.setTransparency(1);
        selectedImg.setTransparency(1);
        submergedUnselected.setTransparency(1);
        submergedSelected.setTransparency(1);
        img.setTransparency(1);
        setImage(img);
    }
    
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
