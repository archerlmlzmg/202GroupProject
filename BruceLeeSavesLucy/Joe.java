import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Joe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Joe extends Figure implements IFighter, IGangster
{
    int current_motion_index = 0;
    int moveSpeed = 6;
    int moveVariable = 0;
    int moveStepLength = 3;
    private boolean opening = true;
    public GreenfootImage[] walk2LeftSet, walk2RightSet, openingSet, punch2LeftSet, crushSet;
    private BruceLee bruce;
    boolean death =false;
    boolean finishing = false;
    
    public Joe ()
    {
        openingSet = new GreenfootImage[30];
        for (int i = 0; i < openingSet.length; i++)
        {
            int m = i + 1;
            if (m <= 9)
            {
                GreenfootImage img = new GreenfootImage("s0" + m + "_" + m + ".gif");
                openingSet[i] = img;
            }
            else
            {
                GreenfootImage img = new GreenfootImage("s" + m + "_" + m + ".gif");
                openingSet[i] = img;
            }
        }

        walk2LeftSet = new GreenfootImage[12];
        for (int i = 0; i < walk2LeftSet.length; i++)
        {
            int m = i+ 1;
            if (m < 10)
            {
                GreenfootImage img = new GreenfootImage("Joe98_stance1_f0" + m +".gif");
                img.scale(img.getWidth() - 60,img.getHeight() - 100);
                walk2LeftSet[i] = img;
            }
            else
            {
                GreenfootImage img = new GreenfootImage("Joe98_stance1_f" + m +".gif");
                img.scale(img.getWidth() - 60,img.getHeight() - 100);
                walk2LeftSet[i] = img;
            } 
        }
        
        walk2RightSet = new GreenfootImage[12];
        for (int i = 0; i < walk2RightSet.length; i++)
        {
            int m = i+ 1;
            if (m < 10)
            {
                GreenfootImage img = new GreenfootImage("JoeMoveToRight_f0" + m +".gif");
                img.scale(img.getWidth() - 60,img.getHeight() - 100);
                walk2RightSet[i] = img;
            }
            else
            {
                GreenfootImage img = new GreenfootImage("JoeMoveToRight_f" + m +".gif");
                img.scale(img.getWidth() - 60,img.getHeight() - 100);
                walk2RightSet[i] = img;
            } 
        }
        
        punch2LeftSet = new GreenfootImage[29];
        for (int i = 0; i < punch2LeftSet.length; i++)
        {
            int m = i+ 1;
            if (m < 10)
            {
                GreenfootImage img = new GreenfootImage("JoePunch_f0" + m +".gif");
                //img.scale(img.getWidth() - 60,img.getHeight() - 100);
                punch2LeftSet[i] = img;
            }
            else
            {
                GreenfootImage img = new GreenfootImage("JoePunch_f" + m +".gif");
                //img.scale(img.getWidth() - 60,img.getHeight() - 100);
                punch2LeftSet[i] = img;
            } 
        }
        
        crushSet = new GreenfootImage[4];
        for(int i=0; i< crushSet.length;i++)
        {
            int m = i+ 1;
            GreenfootImage img = new GreenfootImage("JoeDie_f0" + m +".gif");
            //img.scale(img.getWidth() - 60,img.getHeight() - 100);
            crushSet[i] = img;
        }

        this.currentMotionSet = openingSet;
        this.setCurrentPose(Figure.POSE_STAND);
        this.setDirection(Figure.DIRECTION_LEFT);
        this.setAttackPoint(3);
        this.setFigureRadius(100);
    }
    
    /**
     * Act - do whatever the Joe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        isLeftMovable();
        joeShowup();
    }    
    
    private void joeShowup()
    {
       if (opening)
       {
            joeInit();
       }
       else
       {
            lookForMainCharacter();
       }
    }
    
    public void joeInit()
    {
        for(int i=0; i<30; i++)
        {
            
            if(current_motion_index >= currentMotionSet.length) 
            {
                    current_motion_index = 0;
            }
            setImage(currentMotionSet[current_motion_index]); 
            if(current_motion_index == currentMotionSet.length - 1)
            {
                    current_motion_index = 0;
            }
            else
            {
                    current_motion_index++;
                    Greenfoot.delay(5);
            }
            if (current_motion_index >= 29)
            {
                opening = false;  
                break;
            }
        }
    } 
    
    public void runToMainCharacter()
    {
        this.setCurrentPose(Figure.POSE_WALK);
        if(moveVariable < moveSpeed)
        {
            moveVariable++;
            return;
        }
        else
        {
            moveVariable = 0;
        }
        //step to next motion
        this.currentMotionSet = walk2LeftSet;
        if(current_motion_index >= currentMotionSet.length)
        {
            current_motion_index = 0;
        }
        setImage(currentMotionSet[current_motion_index]);
        if(current_motion_index == currentMotionSet.length - 1)
        {
            current_motion_index = 0;
        }
        else
        {
            current_motion_index++;
            setLocation(this.getX()-moveStepLength,this.getY());
        }
    }
    
    public void runAwayMainCharacter()
    {
        this.setCurrentPose(Figure.POSE_WALK);
        if(moveVariable < moveSpeed)
        {
            moveVariable++;
            return;
        }
        else
        {
            moveVariable = 0;
        }
        //step to next motion
        this.currentMotionSet = walk2RightSet;
        if(current_motion_index >= currentMotionSet.length)
        {
            current_motion_index = 0;
        }
        setImage(currentMotionSet[current_motion_index]);
        if(current_motion_index == currentMotionSet.length - 1)
        {
            current_motion_index = 0;
        }
        else
        {
            current_motion_index++;
            setLocation(this.getX()+moveStepLength,this.getY());
        }
    }
    
    public void lookForMainCharacter()
    {
       if(death==false){    
        setLocation(this.getX(),340);
        if(bruce == null){
           bruce= this.getWorld().getObjects(BruceLee.class).get(0);
        }
        if (this.getX() < 400) this.setDirection(0);
        if (this.getX() > 750) this.setDirection(1);
        if (this.getDirection() == 1){
            if(this.getX() > bruce.getX()+70){
               runToMainCharacter(); 
            }else{
               punch();
            }
            }else{
                if(this.getX() > bruce.getX()+70){
               runAwayMainCharacter(); 
            }else{
               punch();
            }
            }
        }else{
            die();
        }  
    }
    
    public void hit()
    {
        if (moveVariable < moveSpeed)
        {
            moveVariable++;
            return;
        }
        else
        {
            moveVariable = 0;
        }
        //step to next motion
        this.currentMotionSet = punch2LeftSet;
        if (current_motion_index >= currentMotionSet.length)
            current_motion_index = 0;
        setImage(currentMotionSet[current_motion_index]);
        if (current_motion_index == currentMotionSet.length - 1)
        {
            current_motion_index = 0;
            this.setCurrentPose(Figure.POSE_STAND);
            this.setCurrentMotionSet(stand2RightSet);
        }
        else
        {
            if (current_motion_index == 2 || current_motion_index == 5)
            {
                Greenfoot.playSound("Punch3.mp3");
                doActualBehavior();
                this.setCurrentPose(Figure.POSE_STAND);
                this.setCurrentMotionSet(stand2RightSet);
            }
            current_motion_index++;
            setLocation(this.getX(),this.getY());
        }
        if(getTargetFighter() != null){
            getTargetFighter().onAttacked(getAttackPoint());
        }
    }
    
    public int punch()
    {
        hit();
        this.setCurrentPose(Figure.POSE_PUNCH);
        return 0;
    }
    
    public int kick()
    {
        return 0;
    }
    
    public int defend()
    {
        return 0;
    }
    
    private void crush(){
        for(int i=0; i<3; i++)
        {
            if(moveVariable < moveSpeed)
            {
                moveVariable++;
                return;
            }
            else
            {
                moveVariable = 0;
            }
            //step to next motion
            this.currentMotionSet = crushSet;
            if(current_motion_index >= currentMotionSet.length)
            {
                current_motion_index = 0;
            }
            setImage(currentMotionSet[current_motion_index]);
            if(current_motion_index == currentMotionSet.length - 1)
            {
                current_motion_index = 0;
            }
            else
            {
                current_motion_index++;
                //Greenfoot.delay(5);
                setLocation(this.getX(),this.getY());
            }
            if (current_motion_index >= 2)
            {  
                    finishing=true;
                    break;
              }
        }
    }
    
    private void doActualBehavior(){
           if(getTargetFighter()!=null){
                getTargetFighter().onAttacked(getAttackPoint());
                Greenfoot.playSound("bruce_punch_2.mp3");
                System.out.println("attacked ["+((Figure)getTargetFighter()).getName()+"] by "+getAttackPoint()+" point.");
           }
        }
    
    public void onAttacked(int damage){
        setCurrentHP(getCurrentHP()-damage+getDefencePoint());
        notifyObserver();
        if (getCurrentHP()<=0) {
            death=true;
            setIsDying(true);
            System.out.println("boss is dying......");
            die();
        }
    }
    
    public void die(){
        //Greenfoot.delay(5);
        if(!finishing){
            crush();
            //JOptionPane.showMessageDialog(null, "Game Over! Bruce Lee saved Lucy!");
        }
        else
        {
            //getWorld().removeObject(this);
            finishing=true;
            if(!getIsDied()){
                setIsDied(true);
                System.out.println("boss is died...............");
            }
        }
        
    }
}