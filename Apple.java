import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Food for our elephant.
 * 
 * @author Julia
 * @version November 2023
 */
public class Apple extends Actor
{
    GreenfootImage apple = new GreenfootImage("images/apple1.png");
    
    public void act()
    {
        // Apple falls downwards
        setLocation(getX(), getY() + 1);
        
        // Remove apple and draw game over when apple gets to bottom
        MyWorld world = (MyWorld) getWorld(); // returns a copy of the world that the apple lives in
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
}
