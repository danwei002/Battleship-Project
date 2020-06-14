import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * SwitchingTurnsText is a very simple Actor with no functionality. Its only
 * purpose is to display a fancy "Switching Turns" text to tell users when the turns are
 * switching and that one player should now turn away, and the other should swap back in.
 * 
 * @author Daniel Wei
 * @version June 14, 2020
 */
public class SwitchingTurnsText extends Actor
{
    /**
     * Create a SwitchingTurnsText
     */
    public SwitchingTurnsText()
    {
        GreenfootImage img = getImage();
        img.setTransparency(100);
        setImage(img);
    }
}
