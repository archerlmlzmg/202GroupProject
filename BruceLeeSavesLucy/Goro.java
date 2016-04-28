import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goro extends Figure
{
    int moveSpeed = 5;
    int moveVariable = 0;
    
    private int hSpeed = 4;    
    private int vSpeed = 0;    
    private int aSpeed = 2;     
    
    private int RDirection = 0;   
    private int LDirection = 0;     
    private int PRDirection = 0;    
    private int PLDirection = 0;   
    
    private int bloodNum = 6;
    private int direction = 1;     
    private int wallDest = 0;     
    
    //private Label myLabel;
    
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
    
    private Scene level;    
    private static final int NUM_FRAGMENTS = 24;
    
    private GreenfootImage[] Left   = new GreenfootImage[6];         
    private GreenfootImage[] Right  = new GreenfootImage[6];          
    private GreenfootImage[] PLeft  = new GreenfootImage[10];          
    private GreenfootImage[] PRight = new GreenfootImage[10];        
    //private GreenfootImage[] DLeft  = new GreenfootImage[5];         
   // private GreenfootImage[] DRight = new GreenfootImage[5];        
    private GreenfootImage[] Blood  = new GreenfootImage[7];
    
    public Goro()
    {
        for(int i = 0; i < 7; i++)
        {  
            Blood[i] = new GreenfootImage("rightblood" + i +".png");
        }
     
        for(int i = 0; i < 6; i++)
        {
            Left[i] = new GreenfootImage("goroRunLeft_" + i +".gif");
            Right[i] = new GreenfootImage("Gororun_" + i +".gif");
        }
        
        for(int i = 0; i < 10; i++){
            PRight[i] = new GreenfootImage("goroPunchToRight_" + i +".gif");
            PLeft[i] = new GreenfootImage("goroPunchToLeft_" + i +".gif"); 
        /*    DRight[i] = new GreenfootImage("beingrighthit" + i +".png");
            DLeft[i] = new GreenfootImage("beinglefthit" + i +".png"); */
        }
    
    }
    
    /**
    * This method addedToWorld, Assigns the level and returns the x and y positions
    *                           to the world and sets the feet parameter.
    */
    public void addedToWorld(World world)
    {
        level = (Scene) world;                
        xPlayer = getX();                        
        yPlayer = getY();                         
        feet = getImage().getHeight() / 2;
    }
    
    /**
     * Act - do whatever the Goro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
    //    bruceLee();
    //    death(die);
    }
    
    /**
    * This method move, It is for walking or attack motion to punch in the direction it's facing.
    */
    private void move()
    {
        if(pacing > 0)   
        {
            direction = 0;
            if(moveVariable < moveSpeed){
                moveVariable++;
                return;
            }else{
                moveVariable = 0;
            }
            switch(LDirection)              
            {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4 :
                    setImage(Left[LDirection]);
                    LDirection++;
                    pacing--;
                break;
                case 5 :
                //    Greenfoot.playSound("gorowalking.mp3");
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
            if(moveVariable < moveSpeed){
                moveVariable++;
                return;
            }else{
                moveVariable = 0;
            }
            switch(RDirection)         
            {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4 :
                    setImage(Right[RDirection]);
                    RDirection++;
                    pacing++;
                break;
                case 5 :
                //    Greenfoot.playSound("gorowalking.mp3");
                    setImage(Right[RDirection]);
                    RDirection = 0;
                    pacing++;
                break;
            }
            moveRight();
            
            if(pacing == -1)
                pacing = 13;
                
        }

        BruceLee lee = (BruceLee) getOneObjectAtOffset(10, 0, BruceLee.class);
        BruceLee leejab = (BruceLee) getOneObjectAtOffset(-10, 0, BruceLee.class);
        if(lee != null || leejab != null)         
        { 
            if(lee != null)
                dir = 0;                            
                punch(dir);  
                
            if(leejab != null)                    
                dir = 1;
                 
        }
        
    }
    

   //////////////////////////////////////////////////////////////////////////////////
   /**
    * This method moveLeft, It checks for wall collision and to see if out of bounds.
    */
    public void moveLeft()
    {
   //     if(wall())
        {
            xPlayer -= hSpeed;
            if(yPlayer >= 400)       
                yPlayer = 399;             
            
            if(xPlayer >= level.getWorldWidth() || xPlayer <= 0)
            { 
                die = 5;
            }
            
            else   
                setLocation(xPlayer, yPlayer);
                
        }
        
    }
    
    
   //////////////////////////////////////////////////////////////////////////////////
   /**
    * This method moveRight, It checks for wall collision and to see if out of bounds.
    */
    public void moveRight()
    {
   //     if(wall())
        {
            xPlayer += hSpeed;
            if(yPlayer >= 400)        
                yPlayer = 399;
                
            if(xPlayer >= level.getWorldWidth() || xPlayer <= 0)
            {
                die = 5;
            } 
            
            else     
                setLocation(xPlayer, yPlayer );
            
        }
        
    }
    
    /**
    * This method punch, It controls the punch motion in the direction it's facing.
    */
    public void punch(int direct)
    {
        if(direct == 0)
        {
            switch(PLDirection)                 
            {
                case 0 :
                case 1 :
                case 2 :
                case 3 :
                case 4 :
                case 5 :
                case 6 :
                case 7 :
                case 8 :
                    setImage(PLeft[PLDirection]);
                    PLDirection++;
                break;
                case 9 :
               //     Greenfoot.playSound("punch2.mp3");
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
                case 1 :
                case 2 :
                case 3 :
                case 4 :
                case 5 :
                case 6 :
                case 7 :
                case 8 :
                    setImage(PRight[PRDirection]);
                    PRDirection++;
                break;
                case 9 :
               //     Greenfoot.playSound("punch2.mp3");
                    setImage(PRight[PRDirection]);
                    PRDirection = 0;
                break;
            }
            
        }
        singlePunch = false;
         
    }
    
    /**
    * This method hit, It checks if goro is attacked.
    */   
    public void hit(int direction)
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
                        Greenfoot.delay(2);
                        Greenfoot.playSound("hit.mp3");
                    break;
                    case 1 :
                        setImage(DLeft[Lhit]);
                        Lhit++;
                        Greenfoot.delay(2);  
                        Greenfoot.playSound("hit.mp3");
                    break;
                    case 2 :
                        setImage(DLeft[Lhit]);
                        Lhit++;
                        Greenfoot.delay(2);
                        Greenfoot.playSound("die1.mp3");
                    break;                    
                    case 3 :
                        setImage(DLeft[Lhit]);
                        Lhit++;
                        Greenfoot.delay(2);
                        Greenfoot.playSound("hit.mp3");
                    break;
                    case 4 :
                        setImage(DLeft[Lhit]);
                        Lhit = 0;
                        Greenfoot.delay(1);
                        Greenfoot.playSound("hit.mp3");
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
                        Greenfoot.delay(2);
                        Greenfoot.playSound("hit.wav");
                    break;
                    case 1 :
                        setImage(DRight[Rhit]);
                        Rhit++;
                        Greenfoot.delay(2);
                        Greenfoot.playSound("hit.wav");
                    break;
                    case 2 :
                        setImage(DRight[Rhit]);
                        Rhit++;
                        Greenfoot.delay(2);
                        Greenfoot.playSound("die1.wav");    
                    break;
                    case 3 :
                        setImage(DRight[Rhit]);
                        Rhit++;
                        Greenfoot.delay(2);
                        Greenfoot.playSound("hit.mp3");
                    break;
                    case 4 :
                        setImage(DRight[Rhit]);
                        Rhit++;
                        Greenfoot.delay(2);
                        Greenfoot.playSound("hit.mp3");
                    break;
                }
                
            } 
        
        }
        damage++;
        death(0);
        
    }
    
   /**
    * This method wall, It checks for the wall.
    */
    public boolean wall()
    {
        Actor attack = getOneObjectAtOffset(20, 0, Wall.class);
        if(attack != null) 
            return true;
        
            return false;
    } 
}
