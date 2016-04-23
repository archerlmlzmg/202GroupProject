// WARNING: This file is auto-generated and any changes to it will be overwritten
import java.util.*;
import greenfoot.*;
import java.awt.Color;

/**
 * 
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
    private BruceLee bruce;
    private boss boss;
    private Joe joe;
    /**
     * 
     */
    public Scene()
    {
        super(worldWidth, worldHeight, 1);
        bruce = new BruceLee();
        addObject(bruce,100,350);
        checkLevel(level);
    }
    
    public void act(){
        //System.out.println("testing");
    }
    
    public void checkLevel(int currentLevel)
    {
        if (currentLevel == 1)
        {
            joe = new Joe();
            addObject(joe, 700, 350);
            boss = new boss();
            addObject(boss, 500, 300);
            addObject(joe, 700, 350);
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
}
