import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Switches to MusicSelect world
 * 
 * @author Daniel Wei
 * @version June 14, 2020
 */
public class MusicBtn extends Button
{
    public MusicBtn() {
        selectedImg = new GreenfootImage("musicBtnselected.png");
        unselectedImg = new GreenfootImage("musicBtnUnselected.png");
        setImage(unselectedImg);
    }   
    
    public void onClick()
    {
        World w = new MusicSelect();
        Greenfoot.setWorld(w);
    }
}
