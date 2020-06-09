import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructBtn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructBtn extends Button
{
    public InstructBtn()
    {
        selectedImg = new GreenfootImage("instructBtnselected.png");
        unselectedImg = new GreenfootImage("instructBtnUnselected.png");
        setImage(unselectedImg);
    }
    
    public void onClick()
    {
        World w = new Instructions();
        Greenfoot.setWorld(w);
    }
}
