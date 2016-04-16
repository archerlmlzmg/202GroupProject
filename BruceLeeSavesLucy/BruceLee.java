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
}
