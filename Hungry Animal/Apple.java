import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Food for our elephant.
 * 
 * @author Julia
 * @version November 2023
 */
public class Apple extends Actor
{
    public void act()
    {
        setLocation(getX(), getY() + 1);
    }
}
