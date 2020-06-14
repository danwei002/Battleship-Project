import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * InstructBtn takes users to the instructions page when clicked.
 * 
 * @author Daniel Wei 
 * @version June 14, 2020
 */
public class InstructBtn extends Button
{
    /**
     * Create an InstructBtn
     */
    public InstructBtn()
    {
        selectedImg = new GreenfootImage("instructBtnselected.png");
        unselectedImg = new GreenfootImage("instructBtnUnselected.png");
        setImage(unselectedImg);
    }
    
    /**
     * Click handler
     */
    public void onClick()
    {
        World w = new Instructions();
        Greenfoot.setWorld(w);
    }
}
