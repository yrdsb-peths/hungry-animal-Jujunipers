import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant, our hero.
 * 
 * @author Julia 
 * @version November 2023
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage idle = new GreenfootImage("images/elephant_idle/idle0.png");
    
    /**
     * Constructor - The code that gets run one time when object is created
     */
    
    public Elephant
    {
        setImage(idle);
    }
    
    public void act()
    {
        // Move elephant with arrow keys
        if(Greenfoot.isKeyDown("left"))
        {
            move(-1);
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(1);
        }
        
        // Remove apple if elephant eats it
        eat();
    }
    
    /**
     * Eat apple and spawn new apple if an apple is eaten
     */
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple(); // access the createApple() method from MyWorld class
            world.increaseScore();
            elephantSound.play();
        }
    }
}
