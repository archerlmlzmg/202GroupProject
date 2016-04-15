// WARNING: This file is auto-generated and any changes to it will be overwritten
import java.util.*;
import greenfoot.*;
import java.awt.Color;

/**
 * 
 */
public class Enemy2 extends Figure implements Fighter
{

    
    private int hSpeed = 10;    
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
    private static final int NUM_FRAGMENTS = 32;
    
    private GreenfootImage[] Left   = new GreenfootImage[5];         
    private GreenfootImage[] Right  = new GreenfootImage[5];          
    private GreenfootImage[] PLeft  = new GreenfootImage[5];          
    private GreenfootImage[] PRight = new GreenfootImage[5];        
    private GreenfootImage[] DLeft  = new GreenfootImage[5];         
    private GreenfootImage[] DRight = new GreenfootImage[5];        
    private GreenfootImage[] Blood  = new GreenfootImage[7];
    public enemy2(){
        for(int i = 0; i < 7; i++)
        {  
            Blood[i] = new GreenfootImage("rightblood" + i +".png");
        }
     
        for(int i = 0; i < 4; i++)
        {
            PLeft[i] = new GreenfootImage("mileenaleftsidekick" + i +".png"); 
            PRight[i] = new GreenfootImage("mileenaleftkick" + i +".png"); 
            DRight[i] = new GreenfootImage("mileenabeinghitright" + i +".png");
            DLeft[i] = new GreenfootImage("mileenabeinghitleft" + i +".png"); 
            Left[i] = new GreenfootImage("mileenafacingright" + i +".png");
            Right[i] = new GreenfootImage("mileenafacingleft" + i +".png");
        }
        
    }
    public void act()
    {
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
