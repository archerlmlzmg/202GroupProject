// WARNING: This file is auto-generated and any changes to it will be overwritten
import java.util.*;
import greenfoot.*;
import java.awt.Color;

/**
 * 
 */
public class Enemy1 extends Figure implements Fighter
{
    private String ENEMY1_NAME = "goro";
    private int ACTION_FRAMES = 4;
	
	private int hSpeed = 6;    
    private int vSpeed = 0;    
    private int aSpeed = 2;     
    
    private int RDirection = 0;   
    private int LDirection = 0;     
    private int PRDirection = 0;    
    private int PLDirection = 0;   
    
    private int bloodNum = 6;
    private int direction = 1;     
    private int wallDest = 0;     
    
    private Label myLabel;
    
    private int NStars = 0;      
    private int dead = 0;               
    private int damage = 0;         
    private int Lhit = 0;              
    private int Rhit = 0;               
    private int pacing = 12;   
    
    private boolean singlePunch = true; 
    
    private int dir = 0;
    private int xPlayer;
    private int yPlayer;
    private int feet;    
    
    private int scrollPosition = 0;
    private int die = 0;
    
    private AirHead level;    
    private static final int NUM_FRAGMENTS = 24;
    
    private GreenfootImage[] Left   = new GreenfootImage[5];         
    private GreenfootImage[] Right  = new GreenfootImage[5];          
    private GreenfootImage[] PLeft  = new GreenfootImage[5];          
    private GreenfootImage[] PRight = new GreenfootImage[5];        
    private GreenfootImage[] DLeft  = new GreenfootImage[5];         
    private GreenfootImage[] DRight = new GreenfootImage[5];        
    private GreenfootImage[] Blood  = new GreenfootImage[7];
    
    public Enemy1()
    {
        for(int i = 0; i < 7; i++)
        {  
            Blood[i] = new GreenfootImage("rightblood" + i +".png");
        }
     
        for(int i = 0; i < ACTION_FRAMES; i++)
        {
            Left[i] = new GreenfootImage(ENEMY1_NAME + "leftwalking" + i +".png");
            Right[i] = new GreenfootImage(ENEMY1_NAME + "rightwalking" + i +".png");
            PRight[i] = new GreenfootImage(ENEMY1_NAME + "leftpunch" + i +".png");
            PLeft[i] = new GreenfootImage(ENEMY1_NAME + "rightpunch" + i +".png"); 
            DRight[i] = new GreenfootImage(ENEMY1_NAME + "beingrighthit" + i +".png");
            DLeft[i] = new GreenfootImage(ENEMY1_NAME + "beinglefthit" + i +".png"); 
        }
    
    }

    /**
     * This method act, It is called whenever the 'Act' or 'Run' button gets pressed
     *                  in the environment, It contains the method calls for move, and
     *                  to fall and also to death during the BruceLee saves lucy game.
     */
    public void act()
    {
    	move();
        fall();
        death(die);
    }
    
   /**
    * This method move, It is for walking or attack motion to punch in the direction it's facing.
    */
    private void move()
    {
        if(pacing > 0)   
        {
            direction = 0;                             
            switch(LDirection)              
            {
                case 0 :
                    setImage(Left[LDirection]);
                    LDirection++;
                    pacing--;
                break;
                case 1 :
                    setImage(Left[LDirection]);
                    LDirection++;
                    pacing--;
                break;
                case 2 :
                    setImage(Left[LDirection]);
                    LDirection++;
                    pacing--;
                break;
                case 3 :
                    setImage(Left[LDirection]);
                    LDirection++;
                    pacing--;
                break;
                case 4 :
                    Greenfoot.playSound(ENEMY1_NAME + "walking.mp3");
                    setImage(Left[LDirection]);
                    LDirection = 0;
                    pacing--;
                break;
            }
            moveLeft();
        
            if(pacing == 1)
                pacing = -13;
                
        }
        
        if(pacing <= 0)  
        {
            direction = 1;              
            switch(RDirection)         
            {
                case 0 :
                    setImage(Right[RDirection]);
                    RDirection++;
                    pacing++;
                break;
                case 1 :
                    setImage(Right[RDirection]);
                    RDirection++;
                    pacing++;
                break;
                case 2 :
                    setImage(Right[RDirection]);
                    RDirection++;
                    pacing++;
                break;
                case 3 :
                    setImage(Right[RDirection]);
                    RDirection++;
                    pacing++;
                break;
                case 4 :
                    Greenfoot.playSound("gorowalking.mp3");
                    setImage(Right[RDirection]);
                    RDirection = 0;
                    pacing++;
                break;
            }
            moveRight();
            
            if(pacing == -1)
                pacing = 13;
                
        }

        BruceLee lee = (BruceLee) getOneObjectAtOffset(20, 0, BruceLee.class);  //BruceLee at the left direction
        BruceLee leejab = (BruceLee) getOneObjectAtOffset(-20, 0, BruceLee.class);   //BruceLee at the right direction
        if(lee != null || leejab != null)         
        { 
            if(lee != null)
                dir = 0;         //0 is the left direction                   
                punch(dir);  
                
            if(leejab != null)                    
                dir = 1;        //1 is the right direction
                 
        }
        
    }

    /**
     * 
     */
    public int punch()
    {
        return 100;
    }

    /**
     * 
     */
    public int kick()
    {
        return 100;
    }
}
