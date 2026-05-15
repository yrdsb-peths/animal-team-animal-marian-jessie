import greenfoot.*;

public class MyWorld extends World {
    public int score = 0;
    Label scoreLabel;
    int level = 1;
    
    int lives = 3;
    Label livesLabel;
    
    public MyWorld() {
        super(600, 400, 1, false);
        
        GreenfootImage bg = new GreenfootImage("background2.jpg");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
        //Create the elephant object
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 200);
        
        //Create a label
        scoreLabel = new Label(0,80);
        addObject(scoreLabel, 50, 50);
        
        livesLabel = new Label("Lives: 3", 40);
        addObject(livesLabel, 500, 40);
        spawnApple();
    }
    
    /**
     * End the game and draw 'Game Over'
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        if(score % 3 == 0)
        {
            level++;
        }
    }
    
    public void loseLife()
    {
        lives--;
        livesLabel.setValue("Lives: " + lives);
        
        if(lives <= 0)
        {
            gameOver();
        }
        else
        {
            spawnApple();
        }
    }
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
        
        Greenfoot.stop();
    }
    /**
     * Increase score
     */


    /**
     * create a new apple at random location at the top of screen
     */
    public void spawnApple()
    {
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, 0);
    }
}
