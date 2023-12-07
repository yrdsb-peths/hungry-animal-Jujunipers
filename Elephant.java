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
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    // Direction the elephant is facing
    String facing = "right";
    
    // Create instance of imported timer
    SimpleTimer animationTimer = new SimpleTimer();
    
    // length and width values to set/change scale for the elephant
    // image ratio: width 49, height 43
    int size = 530;
    int size_x = size-451;
    int size_y = size-457;
    
    // move speed of elephant
    int speed = 2;
    
    /**
     * Constructor - The code that gets run one time when object is created
     */
    public Elephant()
    {
        // Set each element in the idle[] array with an idle image, load the images
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(size_x, size_y);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(size_x, size_y);
        }
        
        animationTimer.mark(); // resets timer to start at 0
        
        // Initial elephant image
        setImage(idleRight[0]);
    }
    
    /**
     * Animate the elephant
     */
    // Loop that cycles through idle[] array
    int imageIndex = 0;
    public void animateElephant()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return; // not return anything and get out of the method
            // What happens here is that we stay in this if statement for
            // ~100 milliseconds before getting out of the if statement
            // and moving on to next code (i observed this thru experimenting
            // with Log.info)
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
        
    }
    
    public void act()
    {
        // Move elephant with arrow keys
        if(Greenfoot.isKeyDown("left"))
        {
            move(-speed);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(speed);
            facing = "right";
        }
        
        // Remove apple if elephant eats it
        eat();
        
        // Animate the elephant
        animateElephant();
    }
    
    /**
     * Eat apple and spawn new apple if an apple is eaten
     */
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            
            MyWorld world = (MyWorld) getWorld(); // Create variable world, set to getWorld (which is the current world, type World, superclass of MyWorld), and cast to MyWorld type
            world.createApple(); // access the createApple() method from MyWorld class using the world instance of MyWorld
            world.increaseScore();
            
            elephantSound.play();
            
            // Increase elephant size for every 5 apples
            if(world.score % 3 == 0)
            {
                size += 6;
                size_x = size-451;
                size_y = size-457;
                for(int i = 0; i < idleRight.length; i++)
                {
                    idleRight[i].scale(size_x, size_y);
                }
                
                for(int i = 0; i < idleRight.length; i++)
                {
                    idleLeft[i].scale(size_x, size_y);
                }
                setLocation(getX(), getY()-3); // move elephant up slightly to compensate for size increase
            }
            
            if(world.score % 6 == 0)
            {
                speed += 1;
            }
            
            
        }
    }
}
