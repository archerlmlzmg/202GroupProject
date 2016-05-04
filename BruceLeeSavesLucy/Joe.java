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
    int moveSpeed = 1;
    int moveVariable = 0;
    int moveStepLength = 1;
    private boolean opening = true;
    public GreenfootImage[] moveSet, openingSet, punchSet;
    private BruceLee bruce;
    
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

        moveSet = new GreenfootImage[12];
        for (int i = 0; i < moveSet.length; i++)
        {
            int m = i+ 1;
            if (m < 10)
            {
                GreenfootImage img = new GreenfootImage("Joe98_stance1_f0" + m +".gif");
                img.scale(img.getWidth() - 60,img.getHeight() - 100);
                moveSet[i] = img;
            }
            else
            {
                GreenfootImage img = new GreenfootImage("Joe98_stance1_f" + m +".gif");
                img.scale(img.getWidth() - 60,img.getHeight() - 100);
                moveSet[i] = img;
            } 
        }
        
        punchSet = new GreenfootImage[29];
        for (int i = 0; i < punchSet.length; i++)
        {
            int m = i+ 1;
            if (m < 10)
            {
                GreenfootImage img = new GreenfootImage("JoePunch_f0" + m +".gif");
                //img.scale(img.getWidth() - 60,img.getHeight() - 100);
                punchSet[i] = img;
            }
            else
            {
                GreenfootImage img = new GreenfootImage("JoePunch_f" + m +".gif");
                //img.scale(img.getWidth() - 60,img.getHeight() - 100);
                punchSet[i] = img;
            } 
        }
        
        

        this.currentMotionSet = openingSet;
        this.setCurrentPose(Figure.POSE_STAND);
    }
    /**
     * Act - do whatever the Joe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.

        //move();
        //lookForMainCharacter();
        joeShowup();

    }    
    
    private void joeShowup(){
       if (opening)
        {
            joeInit();
        }
        else
        {
            runToMainCharacter();
        }
    }
    
    public void joeInit()
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
    
    
    public void runToMainCharacter(){
        if(moveVariable < moveSpeed){
            moveVariable++;
            return;
        }else{
            moveVariable = 0;
        }
        //step to next motion
        this.currentMotionSet = moveSet;
        if(current_motion_index >= currentMotionSet.length)
            current_motion_index = 0;
        setImage(currentMotionSet[current_motion_index]);
        if(current_motion_index == currentMotionSet.length - 1){
            current_motion_index = 0;
        }else{
            current_motion_index++;
            setLocation(this.getX()-moveStepLength,this.getY());
        }
    }
    public void lookForMainCharacter(){
        if(moveVariable < moveSpeed){
            moveVariable++;
            return;
        }else{
            moveVariable = 0;
        }
        if(bruce == null){
            setLocation(this.getX(),340);
            if(bruce == null){
               bruce= this.getWorld().getObjects(BruceLee.class).get(0);
            }
            if(this.getX() > bruce.getX()){
               runToMainCharacter(); 
            }else{
               hit();
            }
        }
    }
    
    public void onAttacked(int damage){
    
    }

    
    public void hit(){
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
            setLocation(this.getX(),this.getY());
        }
    }
    
    public int punch(){
        return 0;
    }
    public int kick(){
        return 0;
    }
    public int defend(){
        return 0;
    }
    public void die(){
    }
}
