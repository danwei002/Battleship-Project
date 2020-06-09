import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MusicBtn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
