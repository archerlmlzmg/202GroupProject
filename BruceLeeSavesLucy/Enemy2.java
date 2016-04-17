// WARNING: This file is auto-generated and any changes to it will be overwritten
import java.util.*;
import greenfoot.*;
import java.awt.Color;

/**
 * 
 */
public class Enemy2 extends Figure implements Fighter
{

    /**
     * 
     */
    public void act()
    {
        move();
        fall();
        death(die);
    }
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

        Liu liu = (Liu) getOneObjectAtOffset(20, 0, Liu.class);
        Liu liujab = (Liu) getOneObjectAtOffset(-20, 0, Liu.class);
        if(liu != null || liujab != null)         
        { 
            if(liu != null)
                dir = 0;                            
                punch(dir);  
                
            if(liujab != null)                    
                dir = 1;
                                 
        }
        
    }
    /**
     * 
     */
    public void punch(int direct)
    {
        if(direct == 0)
        {
            switch(PLDirection)                 
            {
                case 0 :
                    setImage(PLeft[PLDirection]);
                    PLDirection++;
                break;
                case 1 :
                    setImage(PLeft[PLDirection]);
                    PLDirection++;
                break;
                case 2 :
                    setImage(PLeft[PLDirection]);
                    PLDirection++;
                break;
                case 3 :
                    setImage(PLeft[PLDirection]);
                    PLDirection++;
                break;
                case 4 :
                    Greenfoot.playSound("punch1.mp3");
                    setImage(PLeft[PLDirection]);
                    PLDirection = 0;
                break;
            }
        
        }
        
        if(direct == 1)
        {
            switch(PRDirection)           
            {
                case 0 :
                    setImage(PRight[PRDirection]);
                    PRDirection++;
                break;
                case 1 :
                    setImage(PRight[PRDirection]);
                    PRDirection++;
                break;
                case 2 :
                    setImage(PRight[PRDirection]);
                    PRDirection++;
                break;
                case 3 :
                    setImage(PRight[PRDirection]);
                    PRDirection++;
                break;
                case 4 :
                    Greenfoot.playSound("punch1.mp3");
                    setImage(PRight[PRDirection]);
                    PRDirection = 0;
                break;
            }
            
        }
        singlePunch = false;
         
    }
   public void addedToWorld(World world)
    {
        level = (AirHead) world;                
        xPlayer = getX();                        
        yPlayer = getY();                       
        feet = getImage().getHeight() / 1;
    }

    /**
     * 
     */
    public int kick()
    {
        return 100;
    }
}
