import greenfoot.*;

public class MyWorld extends World {
    public int score = 0;
    Label scoreLabel;
    public MyWorld() {
        super(600, 400, 1);
        
        //Create the elephant object
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 200);
        
        //Create a label
        scoreLabel = new Label(0,80);
        addObject(scoreLabel, 50, 50);
        
        createApple();
    }
    
    /**
     * Increase score
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.
    }

    /**
     * create a new apple at random location at the top of screen
     */
    public void createApple()
    {
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        addObject(apple, x, 0);
    }
}
