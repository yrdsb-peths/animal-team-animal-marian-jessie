import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen
 * 
 * @author marian & Jessie
 * @version May 2026
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("The Elephant",60);

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(titleLabel, getWidth()/2, 100);
        prepare();
    }

    public void act()
    {
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
        addObject(elephant,353,111);
        elephant.setLocation(463,86);
        elephant.setLocation(525,123);
        Label label = new Label("Use \u2190 and \u2192 to Move", 50);
        addObject(label,197,247);
        label.setLocation(301,218);
        Label label2 = new Label("Press <space> to Start", 50);
        addObject(label2,255,304);
        label2.setLocation(379,307);
        label2.setLocation(298,303);
    }
}
