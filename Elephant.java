import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootSound elephantSound = new GreenfootSound("elephant_sound.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    
    int moveSpeed = 2;
    int dashCounter = 0;
    
    boolean dashing = false;
 
    
    public Elephant()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(100, 100);
            
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100, 100);
        }
        

        setImage(idleRight[0]);
        animationTimer.mark();
 
    }
    
    int imageIndex = 0;
    public void animateElephant()
    {
        if(animationTimer.millisElapsed() < 150)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);

        }
        else
        {
            setImage(idleLeft[imageIndex]);

        }
        
        imageIndex++;
        if(imageIndex >= idleRight.length)
        {
            imageIndex = 0;
        }
        
    }
    
    
    public void act()
    {
        movement();
        control();
        eat();
        animateElephant();
    }
    
    public void movement()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - moveSpeed, getY());
            facing = "left";
        }
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + moveSpeed, getY());
            facing = "right";
        }
    }
    
    public void control()
    {
        if(Greenfoot.isKeyDown("shift") && !dashing)
        {
            moveSpeed = 5;
            dashing = true;
            dashCounter = 120;
        }
        
        if(dashing)
        {
            dashCounter--;
            
            if(dashCounter <= 0)
            {
                moveSpeed = 2;
                dashing = false;
            }
        }
    }
    
    
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.spawnApple();
            world.increaseScore();
            elephantSound.play();
        }
    }
}
