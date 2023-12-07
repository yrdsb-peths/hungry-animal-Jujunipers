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
    int speed = 1;
    GreenfootSound hpSound = new GreenfootSound("decrease.mp3");
    
    
    public void act()
    {
        // Apple falls downward, speed of y increases as level increases
        setLocation(getX(), getY() + speed);
        
        // Remove apple and draw game over when apple gets to bottom
        MyWorld world = (MyWorld) getWorld(); // returns a copy of the world that the apple lives in
        if(getY() >= world.getHeight())
        {
            world.hpDecrease();
            hpSound.play();
            world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
