// WARNING: This file is auto-generated and any changes to it will be overwritten
import java.util.*;
import greenfoot.*;
import java.awt.Color;

/**
 * 
 */
public class BruceLee extends Figure implements Fighter
{
    private int hSpeed = 10;    
    private int vSpeed = 0;     
    private int aSpeed = 2;    
    private int jumpStrength = 105;  
    
    private int RDirection = 0;    
    private int LDirection = 0;        
    private int PRDirection = 0;   
    private int PLDirection = 0;      
    private int KRDirection = 0; 
    private int KLDirection = 0;     
    private int BKRDirection = 0; 
    private int BKLDirection = 0;  
    
    private int direction = 1;  
    private int wallDest = 0;  
    private int wall1Dest = 0;  
    
    private Label myLabel;
    
    private int NStars = 0;       
    private int dead = 0;              
    private int damage = 0;    
    private int Lhit = 0;
    private int Rhit = 0;
    
    private int xPlayer;
    private int yPlayer;
    
    private boolean air = false;
    private int feet;
    
    private AirHead level;
    private static final int NUM_FRAGMENTS = 8;
    
    private boolean dun = false;
    private boolean once = true;
   
    private boolean singleJump = true;
    private boolean singlePunch = true; 
    private boolean singleKick = true; 
    private boolean singleBackKick = true;
    
    public BruceLee (Label label)
    {
        myLabel = label;
    }
    
    /**
     * 
     */
    public void act()
    {
    }

    /**
     * 
     */
    public int punch()
    {
        return 50;
    }

    /**
     * 
     */
    public int kick()
    {
        return 100;
    }
    
    /**
    * This method jump, It controls the jumping motion for the Liu object it's is facing. 
    */
    public boolean jump()
    {
        vSpeed = -jumpStrength;
        setImage(jump[direction]); 
        feet = getImage().getHeight() / 2;
        fall();
        return false;
    }
    
    /**
    * This method moveLeft, It checks for intersection of a wall and returns the
    *                       the set position to scroll the level if not out of bounds.
    */
    public void moveLeft()
    {
        if(wall() && xPlayer >= 5)
        {
            if(level.getScrollPosition() == 0 || xPlayer >=  level.getWorldWidth() / 2)
            {  
                xPlayer -= hSpeed;
                if(xPlayer >= level.getWorldWidth())
                    xPlayer -= 0;
               
                if(yPlayer >= 400)       
                    yPlayer = 399;              
                    setLocation(xPlayer, yPlayer);
            }
           
            else if(xPlayer >= 5)
            { 
                level.setScrollPosition(-10);
            }
            
        }
        
    }
    
    /**
    * This method moveRight, It checks for intersection of a wall and returns to scroll
    *                        the level if not out of bounds to the end of the level.
    */
    public void moveRight()
    {
        if(level.endofLevel(xPlayer, yPlayer + feet) && wall() && wall1()) 
        {
            dun = false;
            if(xPlayer <=  300 || level.getScrollPosition() == -1560)
            {
                xPlayer += hSpeed;
               
                if(yPlayer >= 400)    
                    yPlayer = 399;
                 
                if(xPlayer >= level.getWorldWidth())
                    xPlayer -= 10 ;
                    setLocation(xPlayer, yPlayer);
                    
            }
           
            else 
            {
                level.setScrollPosition(10);
            }
           
        }
        else
            dun = true;
         
    }
    
    /**
    * This method fall, It creates the illusion gravity and the ability to
    *                   go up on a jump and to check it is not out of bounds.                  
    */
    public void fall()          
    {
        if(!(AirHead.onGround(xPlayer, yPlayer + feet)) && vSpeed >= 0)    
        {
            yPlayer = yPlayer + vSpeed;
            if(yPlayer >= 400)        
                yPlayer = 399;              
                setLocation(xPlayer, yPlayer);
                vSpeed += aSpeed;
                air = true;
                 
            if(!level.burned(xPlayer, yPlayer + feet))
                burnedUp(); 

            if(yPlayer >= (level.getWorldHeight() - 1) && dead == 0)
            {
                Greenfoot.playSound("noo.mp3");
                damage = 12;
                death();
            }
                    
        }
        
        else if(AirHead.onGround(xPlayer, yPlayer + feet) && vSpeed < 0)
        {
            yPlayer = yPlayer + vSpeed;
            if(yPlayer >= 400)        
                yPlayer = 399;               
                setLocation(xPlayer, yPlayer);
                vSpeed += aSpeed;          
        }
        
        else
        {
            vSpeed = 0;
            air = false;
            singleJump = true;   
        }
        
    }
    
    //////////////////////////////////////////////////////////////////////////////////  
    /**
    * This method throwstar, It creates the throwing star and decrements
    *                        the number of throwing stars in inventory.                       
    */
    public void throwStar()
    {
        NStars--;
        int x = 0;
        int y = 0;
        if(direction == 1)
        {
            x = getX()+28;
            y = getY()-6;
        }
        
        else 
        {
            x = getX()+4;
            y = getY()-20;
        }
        getWorld().addObject(new ThrowingStar2(), x, y);
        myLabel.setText("Throwing Stars: " + NStars);
        
    }

    /**
    * This method direct, It returns the direction of the character for other classes to call.
    */
    public boolean direct()
    {
        if(direction == 0)
            return false;
          
            return true;
    }
      
      
    //////////////////////////////////////////////////////////////////////////////////   
    /**
    * This method wall, It checks for the wall. 
    */
    public boolean wall()
    {
        Actor attack = getOneObjectAtOffset(20, 0, Wall.class);
        if(attack != null) 
            return false;
          
            return true;
    }
}
