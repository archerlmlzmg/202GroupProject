// WARNING: This file is auto-generated and any changes to it will be overwritten
import java.util.*;
import greenfoot.*; 
import java.awt.Color;

/**
 * this backgroud is supposed to change after every time bruce lee pass a floor
 */
public class Scene extends World
{
    private static final int worldWidth = 800;
    private static final int worldHeight = 500;
    
    private int activeAreaX1 = 10;
    private int activeAreaX2 = 700;
    private int activeAreaY1 = 10;
    private int activeAreaY2 = 500;
    
    private int level = 1;
    //private int level = 1;
    private int timer = 60;
    
    private BruceLee bruce;
    private boss boss;
    private Joe joe;
    private Kim kim;

    private Lucy lucy = new Lucy();

    public HealthBar healthBar = new HealthBar("Bruce Lee: ", "", 100, 100);
    public HealthBar healthBarBoss = new HealthBar("Boss: ", "",100, 100);
    
    
    /**
     * 
     */
    public Scene()
    {
        super(worldWidth, worldHeight, 1);
        bruce = new BruceLee();
        addObject(bruce,100,350);
        
        addObject(healthBar, 150, 50);
        joe = new Joe();
        addObject(healthBarBoss, 650, 50);   
        addObject(joe, 700, 340);
        boss = new boss();
        addObject(boss, 700, 340);
        
        kim = new Kim();
        addObject(kim, 340, 340);
    }
    
    public void act(){
        //System.out.println("testing");
        if (timer>0)
        {
            timer--;
           // if(timer == 0) checkLevel(level);
        }
    }
    
    public void checkLevel(int currentLevel)
    {
        if (currentLevel == 1)
        {
            joe = new Joe();
            
            addObject(joe, 700, 300);
            boss = new boss();
            addObject(boss, 700, 100);
            

           

        }
        
        if(currentLevel == 2)
        {
            addObject(new Goro(), 500, 300);
            boss = new boss();
            addObject(boss, 700, 300);
            //addObject(lucy, 750, 400);
        }
    }
    
    /**
    * 
    * This method getWorldWidth, This returns the world width.
    */
    public int getWorldWidth()
    {
        return worldWidth;
    }
    
    /**
     * This method getWorldHeight. This returns the world height.
     */
    public int getWorldHeight()
    {
        return worldHeight;
    }
}
