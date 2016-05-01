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
    private GreenfootImage[] DLeft  = new GreenfootImage[6];         
    private GreenfootImage[] DRight = new GreenfootImage[6];        
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
            DRight[i] = new GreenfootImage("Gororighthit_" + i +".gif");
            DLeft[i] = new GreenfootImage("Gororighthit_" + i +".gif");
        }
        
        for(int i = 0; i < 10; i++){
            PRight[i] = new GreenfootImage("goroPunchToRight_" + i +".gif");
            PLeft[i] = new GreenfootImage("goroPunchToLeft_" + i +".gif"); 
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
        bruceLee();
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
            if(moveVariable < moveSpeed){
                moveVariable++;
                return;
            }else{
                moveVariable = 0;
            }
            switch(LDirection)              
            {
                case 0:
                    setImage(Left[LDirection]);
                    LDirection++;
                    pacing--;
                    break;
                case 1:
                    setImage(Left[LDirection]);
                    LDirection++;
                    pacing--;
                    break;
                case 2:
                    setImage(Left[LDirection]);
                    LDirection++;
                    pacing--;
                    break;
                case 3:
                    setImage(Left[LDirection]);
                    LDirection++;
                    pacing--;
                    break;
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
                    setImage(Right[RDirection]);
                    RDirection++;
                    pacing++;
                    break;
                case 1:
                    setImage(Right[RDirection]);
                    RDirection++;
                    pacing++;
                    break;
                case 2:
                    setImage(Right[RDirection]);
                    RDirection++;
                    pacing++;
                    break;
                case 3:
                    setImage(Right[RDirection]);
                    RDirection++;
                    pacing++;
                    break;
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

        BruceLee lee = (BruceLee) getOneObjectAtOffset(20, 0, BruceLee.class);
        BruceLee leejab = (BruceLee) getOneObjectAtOffset(-20, 0, BruceLee.class);
        if(lee != null || leejab != null)         
        { 
            System.out.println("lee or leejab is not null");
            if(lee != null)
                dir = 0;   
            if(leejab != null)                    
                dir = 1;
            punch(dir);       
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
        System.out.println("Enter the punch founction");
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
                    setImage(PLeft[PLDirection]);
                    PLDirection++;
                    break;
                case 5 :
                    setImage(PLeft[PLDirection]);
                    PLDirection++;
                    break;
                case 6 :
                    setImage(PLeft[PLDirection]);
                    PLDirection++;
                    break;
                case 7 :
                    setImage(PLeft[PLDirection]);
                    PLDirection++;
                    break;
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
                    setImage(PRight[PRDirection]);
                    PRDirection++;
                    break;
                case 5 :
                    setImage(PRight[PRDirection]);
                    PRDirection++;
                    break;
                case 6 :
                    setImage(PRight[PRDirection]);
                    PRDirection++;
                    break;
                case 7 :
                    setImage(PRight[PRDirection]);
                    PRDirection++;
                    break;
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
                    case 0:
                        setImage(DLeft[Lhit]);
                        Lhit++;
                        Greenfoot.delay(2);
                    //    Greenfoot.playSound("hit.mp3");
                    break;
                    case 1:
                        setImage(DLeft[Lhit]);
                        Lhit++;
                        Greenfoot.delay(2);
                   //     Greenfoot.playSound("hit.mp3");
                    break;
                    case 2:
                        setImage(DLeft[Lhit]);
                        Lhit++;
                        Greenfoot.delay(2);
                   //     Greenfoot.playSound("hit.mp3");
                    break;
                    case 3 :
                        setImage(DLeft[Lhit]);
                        Lhit++;
                        Greenfoot.delay(2);
                  //      Greenfoot.playSound("hit.mp3");
                    break;
                    case 4:
                        setImage(DLeft[Lhit]);
                        Lhit++;
                        Greenfoot.delay(2);
                  //      Greenfoot.playSound("hit.mp3");
                    break;
                    case 5 :
                        setImage(DLeft[Lhit]);
                        Lhit = 0;
                        Greenfoot.delay(1);
                  //      Greenfoot.playSound("hit.mp3");
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
                    //    Greenfoot.playSound("hit.mp3");
                    break;
                    case 1 :
                        setImage(DRight[Rhit]);
                        Rhit++;
                        Greenfoot.delay(2);
                    //    Greenfoot.playSound("hit.mp3");
                    break;
                    case 2 :
                        setImage(DRight[Rhit]);
                        Rhit++;
                        Greenfoot.delay(2);
                    //    Greenfoot.playSound("hit.mp3");    
                    break;
                    case 3 :
                        setImage(DRight[Rhit]);
                        Rhit++;
                        Greenfoot.delay(2);
                    //    Greenfoot.playSound("hit.mp3");
                    break;
                    case 4 :
                        setImage(DRight[Rhit]);
                        Rhit++;
                        Greenfoot.delay(2);
                    //    Greenfoot.playSound("hit.mp3");
                    break;
                }
                
            } 
        
        }
        damage++;
        death(0);
        
    }
    
    
     /**
    * This method death, It checks to see if the damage to goro is
    *                    above 6 hits, and calls to GoroExploding.
    */
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
                   //     Greenfoot.playSound("stab1.mp3");
                    break;
                    case 1 :
                        setImage(Blood[bloodNum]);
                        bloodNum--;
                        Greenfoot.delay(1);
                  //      Greenfoot.playSound("stab1.mp3");
                    break;
                    case 2 :
                        setImage(Blood[bloodNum]);
                        bloodNum--;
                        Greenfoot.delay(1);
                  //      Greenfoot.playSound("stab1.mp3");
                    break;
                    case 3 :
                        setImage(Blood[bloodNum]);
                        bloodNum--;
                        Greenfoot.delay(1);
                  //      Greenfoot.playSound("finishhim.mp3");
                  //      Greenfoot.playSound("stab1.mp3");
                    break;
                    case 4 :
                        setImage(Blood[bloodNum]);
                        bloodNum--;
                        Greenfoot.delay(1);
                  //      Greenfoot.playSound("stab1.mp3");
                    break;
                    case 5 :
                        setImage(Blood[bloodNum]);
                        bloodNum--;
                        Greenfoot.delay(1);
                  //      Greenfoot.playSound("stab.mp3");
                    break;
                    case 6 :
                        setImage(Blood[bloodNum]);
                        bloodNum--;
                        Greenfoot.delay(1);
                  //      Greenfoot.playSound("gororoar.mp3");
                    break;
                } 
                //Greenfoot.playSound("outstanding.mp3");
                
            }
        //    level.singleNinjas(0);
           level.removeObject(this);
           return;
            
        }
        
        else if(b == 5)
        {
       //     level.singleNinjas(0);
            level.removeObject(this);          
        }
        
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
    
    public void bruceLee()
    {
        BruceLee bruce = (BruceLee) getOneIntersectingObject(BruceLee.class);
                   
        if(bruce != null)           
            hit(direction);
            
    }
}
