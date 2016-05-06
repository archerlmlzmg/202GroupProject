import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kim here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kim extends Figure implements IFighter, IGangster
{    
    int current_motion_index = 0;
    int moveSpeed = 1;
    int moveVariable = 0;
    int moveStepLength = 3;
    private boolean opening = true;
    public GreenfootImage[] punchSet;
    private BruceLee bruce;
    
    public Kim()
    {
        punchSet = new GreenfootImage[46];
        for (int i = 0; i < punchSet.length; i++)
        {
            int m = i+ 1;
            if (m < 10)
            {
                GreenfootImage img = new GreenfootImage("kimPunch_f0" + m +".gif");
                //img.scale(img.getWidth() - 60,img.getHeight() - 100);
                punchSet[i] = img;
            }
            else
            {
                GreenfootImage img = new GreenfootImage("kimPunch_f" + m +".gif");
                //img.scale(img.getWidth() - 60,img.getHeight() - 100);
                punchSet[i] = img;
            } 
        }
        
        this.currentMotionSet = punchSet;
        this.setCurrentPose(Figure.POSE_STAND);
    }
    /**
     * Act - do whatever the kim wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        kimShowup();
    }    
    
    private void kimShowup()
    {
       if (opening)
        {
            kimInit();
        }
        else
        {
            lookForMainCharacter();
        }
    }
    
    public void kimInit()
    {
        Greenfoot.delay(5);
        for(int i=0; i<30; i++){
            
            if(current_motion_index >= currentMotionSet.length) {
                    current_motion_index = 0;
            }
                    setImage(currentMotionSet[current_motion_index]); 
            if(current_motion_index == currentMotionSet.length - 1){
                    current_motion_index = 0;
            }else{
                    current_motion_index++;
                    Greenfoot.delay(5);
            }
            if(current_motion_index>=29){
                opening = false;  
                break;
            }
        }
    } 
    
    public void runToMainCharacter()
    {
        if(moveVariable < moveSpeed){
            moveVariable++;
            return;
        }else{
            moveVariable = 0;
        }
        //step to next motion
        this.currentMotionSet = punchSet;
        if(current_motion_index >= currentMotionSet.length)
            current_motion_index = 0;
        setImage(currentMotionSet[current_motion_index]);
        if(current_motion_index == currentMotionSet.length - 1){
            current_motion_index = 0;
        }else{
            current_motion_index++;
            Greenfoot.delay(5);
            setLocation(this.getX()-moveStepLength,this.getY());
        }
    }
    
    public void lookForMainCharacter()
    {
        setLocation(this.getX(),340);
        if(bruce == null){
           bruce= this.getWorld().getObjects(BruceLee.class).get(0);
        }
        if(this.getX() > bruce.getX()+70){
           runToMainCharacter(); 
        }else{
           runToMainCharacter();
        }
    }
    
    public void onAttacked(int damage)
    {
        this.notifyObserver();
    }
    
    public int punch()
    {
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
    public void die()
    {
    }
    
}
