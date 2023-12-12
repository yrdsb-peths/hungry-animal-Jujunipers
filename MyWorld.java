import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The World our hero lives in.
 * 
 * @author Julia 
 * @version November 2023
 */
public class MyWorld extends World
{
    public int score;
    Label scoreLabel = new Label(0, 80);
    int level = 1;
    int hp = 3;
    Label hpLevel = new Label("Lives:" + hp, 50);
    
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); // false --> objects are not bounded to the world, so they will not get stuck at the edge of the world and stop moving out
        
        // Create the elephant object
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 310);
        
        // Create a label
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        hpLevel = new Label("Lives:" + hp, 50);
        addObject(hpLevel, 200, 50);
        
        createApple();
    }
    
    /**
     * End the game and draw 'GameOver'
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    /**
     * Increase score
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        if(score % 5 == 0) // increase lvl for every 5 points
        {
            level += 1;
        }
    }
    
    /**
     * Create a new apple at random location at top of screen
     */
    public void createApple()
    {
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
    
    /**
     * See if you like this pac man boundary system
     */
     public void checkTeleportElephant()
    {
        Elephant ella = (Elephant) getObjects(Elephant.class).get(0);

        int worldWidth = getWidth();
        int worldHeight = getHeight();

        if (ella.getX() <= 0)
        {
            ella.setLocation(worldWidth - 1, ella.getY());
        }
        else if (ella.getX() >= worldWidth)
        {
            ella.setLocation(1, ella.getY());
        }
        
        if (ella.getY() <= 0)
        {
            ella.setLocation(ella.getX(), worldHeight - 1);
        }
        else if (ella.getY() >= worldHeight)
        {
            ella.setLocation(ella.getX(), 1);
        }
    }
    
    public void act()
    {
        checkTeleportElephant();
        if(Greenfoot.isKeyDown("r"))
        {
            restart();
        }
    }
    /**
     * this restarts the game so it doesn't need to get reset to run
     */
    public void restart()
    {
        removeObjects(getObjects(null));
        score = 0;
        level = 1;
        
        Elephant ben = new Elephant();
        addObject(ben, 300, 310);
        
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        
        createApple();
    }
     * Decrease one life if apple his the ground, and play a game sound
     */
    public void hpDecrease()
    {
        hp--;
        hpLevel.setValue("Lives: " + hp);
        
        if(hp == 0)
        {
            gameOver();
        }
        else
        {
            createApple();
        }
    }
}
