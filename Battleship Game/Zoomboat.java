import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
/**
 * Write a description of class Zoomboat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zoomboat extends Battleship
{
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
        if (hp <= 0) {getWorld().removeObject(this);}
        borderCheck();
        if (!BattleWorld.gameStarted) {
            preGame();
        }

        if (selected) {setImage(selectedImg);}
        else {setImage(unselectedImg);}
        
        setLocation((int) (getX() / BattleWorld.CELL_SIZE) * BattleWorld.CELL_SIZE + BattleWorld.CELL_SIZE / 2, (int) (getY() / BattleWorld.CELL_SIZE) * BattleWorld.CELL_SIZE + BattleWorld.CELL_SIZE/ 2);
        if (hp <= 0) {getWorld().removeObject(this);}
    }  
}
