// WARNING: This file is auto-generated and any changes to it will be overwritten
import java.util.*;
import greenfoot.*;
import java.awt.Color;

/**
 * 
 */
public class Enemy3 extends Figure implements Fighter
{

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
    
     public void addedToWorld(World world)
    {
        level = (AirHead) world;                
        xPlayer = getX();                        
        yPlayer = getY();                         
        feet = getImage().getHeight() / 2;
        Greenfoot.playSound("booty.mp3");
    }
   
    
    /**
     * 
     * 
     */
    public void act()
    {
          
        move();
        fall();
        death(die);
    }

    /**
     * 
     */
    public int punch()
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
                    setImage(Right[RDirection]);
                    RDirection = 0;
                    pacing++;
                break;
            }
            moveRight();
            
            if(pacing == -1)
                pacing = 13;
    }

    /**
     * 
     */
    public int kick()
    {
        if(direction == 1)
            dir = 1;
            
        if(direction == 0)
            dir = 0;
            
        if(dir == 1)    
        {
            for(int i = 0; i < 5; i++)
            {
                switch(Lhit)               
                {
                    case 0 :
                        setImage(DLeft[Lhit]);
                        Lhit++;
                        Greenfoot.delay(1);
                        Greenfoot.playSound("hit.mp3");
                    break;
                    case 1 :
                        setImage(DLeft[Lhit]);
                        Lhit++;
                        Greenfoot.playSound("hit.mp3");
                        Greenfoot.playSound("finishher.mp3");
                    break;
                    case 2 :
                        setImage(DLeft[Lhit]);
                        Lhit++;
                        Greenfoot.delay(1);
                        Greenfoot.playSound("die1.mp3");
                    break;                    
                    case 3 :
                        setImage(DLeft[Lhit]);
                        Lhit++;
                        Greenfoot.playSound("hit.mp3");
                    break;
                    case 4 :
                        Greenfoot.delay(3);
                        setImage(DLeft[Lhit]);
                        Lhit = 0;
                        Greenfoot.playSound("hit.mp3");
                        Greenfoot.playSound("girlscream.mp3");
                    break;
                }
           
            }
        
        }
        
        if(dir == 0)  
        {
            for(int i = 0; i < 5; i++)
            {
                switch(Rhit)            
                {
                    case 0 :
                        setImage(DRight[Rhit]);
                        Rhit++;
                        Greenfoot.delay(1);
                        Greenfoot.playSound("hit.wav");
                    break;
                    case 1 :
                        setImage(DRight[Rhit]);
                        Rhit++;
                        Greenfoot.playSound("hit.wav");
                    break;
                    case 2 :
                        setImage(DRight[Rhit]);
                        Rhit++;
                        Greenfoot.delay(1);
                        Greenfoot.playSound("die1.wav");    
                    break;
                    case 3 :
                        setImage(DRight[Rhit]);
                        Rhit++;
                        Greenfoot.playSound("hit.mp3");
                    break;
                    case 4 :
                        Greenfoot.delay(3);
                        setImage(DRight[Rhit]);
                        Rhit = 0;
                        Greenfoot.playSound("hit.mp3");
                        Greenfoot.playSound("girlscream.mp3");
                    break;
                }
                
            } 
        
        }
        damage++;
         public void death(int b)
    { 
        if(damage >= 6 && b != 5)
        {           
            for(int i = 0; i < 7; i++)
            {
                switch(bloodNum)           
                {
                    case 0 :
                        setImage(Blood[bloodNum]);
                        bloodNum = 6;
                        Greenfoot.delay(1);
                        Greenfoot.playSound("stab1.mp3");
                    break;
                    case 1 :
                        setImage(Blood[bloodNum]);
                        bloodNum--;
                        Greenfoot.playSound("stab1.mp3");
                    break;
                    case 2 :
                        setImage(Blood[bloodNum]);
                        bloodNum--;
                        Greenfoot.delay(1);
                        Greenfoot.playSound("stab1.mp3");
                    break;
                    case 3 :
                        setImage(Blood[bloodNum]);
                        bloodNum--;
                        Greenfoot.playSound("stab1.mp3");
                    break;
                    case 4 :
                        setImage(Blood[bloodNum]);
                        bloodNum--;
                        Greenfoot.delay(1);
                        Greenfoot.playSound("stab1.mp3");
                    break;
                    case 5 :
                        setImage(Blood[bloodNum]);
                        bloodNum--;
                        Greenfoot.playSound("stab.mp3");
                    break;
                    case 6 :
                        setImage(Blood[bloodNum]);
                        bloodNum--;
                        Greenfoot.delay(1);
                        Greenfoot.playSound("girlscream.mp3");
                    break;
                } 
                Greenfoot.playSound("impressive.mp3");
                
            }
            level.singleNinjas(0);
            MileenaExploding();
            
        }
        
        else if(b == 5)
        {
            MileenaExploding();
            level.singleNinjas(0);
        }
        
    }
     
     
  
    public int getXPlayer()
    {
        return xPlayer;
    }
       
       
  
    public int getYPlayer()
    {
        return yPlayer;
    } 
      
    
  
    public void MileenaExploding()
    {
        placeMileenaExploding(getX(), getY(), NUM_FRAGMENTS);
        Greenfoot.playSound("girlscream.mp3");
        Greenfoot.playSound("toasty1.mp3");
        getWorld().removeObject(this);       
    }
    
    
 
    private void placeMileenaExploding(int x, int y, int numFragments)
    {
        for(int i = 0; i < numFragments; i++)
        {
            getWorld().addObject(new MileenaExploding(), getX(), getY());
        }
        
    }    
    
    }
        death(0);
    }
}
