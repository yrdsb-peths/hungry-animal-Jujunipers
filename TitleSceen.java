import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen.
 * 
 * @author Julia
 * @version December 2023
 */
public class TitleSceen extends World
{
    Label titleLabel = new Label("Hungry Elephant", 60);
    /**
     * Constructor for objects of class TitleSceen.
     * 
     */
    public TitleSceen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(titleLabel, getWidth()/2, getHeight()/2); // getWidth() gets width of world
        prepare();
    }

    /**
     * The main world act loop
     */
    public void act() // the act loop is just the game's while loop
    {
        // Start the game if user pressed the space bar
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,500,118);
        titleLabel.setLocation(240, 120);
        Label label1 = new Label("Use \u2190 and \u2192 to move", 40);
        addObject(label1,300,230);
        Label label2 = new Label("Press <space> to Start", 40);
        addObject(label2,300,300);
    }
}
