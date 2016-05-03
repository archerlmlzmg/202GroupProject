import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Joe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Joe extends Figure implements Fighter, Gangster
{
    int current_motion_index = 0;
    int moveSpeed = 3;
    int moveVariable = 0;
    int moveStepLength = 1;
    private boolean opening = true;
    public GreenfootImage[] stand2LeftSet, openingSet;
    private BruceLee bruce;
    
    public Joe ()
    {
        openingSet = new GreenfootImage[30];
        for (int i = 0; i < openingSet.length; i++)
        {
            int m = i + 1;
            if (m < 10)
            {
                GreenfootImage img = new GreenfootImage("JoeOpening_f0" + m +".gif");
                openingSet[i] = img;
            }
            else
            {
                GreenfootImage img = new GreenfootImage("JoeOpening_f" + m +".gif");
                openingSet[i] = img;
            }
        }

        stand2LeftSet = new GreenfootImage[12];
        for (int i = 0; i < stand2LeftSet.length; i++)
        {
            int m = i+ 1;
            if (m < 10)
            {
                GreenfootImage img = new GreenfootImage("Joe98_stance1_f0" + m +".gif");
                img.scale(img.getWidth() - 50,img.getHeight() - 70);
                stand2LeftSet[i] = img;
            }
            else
            {
                GreenfootImage img = new GreenfootImage("Joe98_stance1_f" + m +".gif");
                img.scale(img.getWidth() - 50,img.getHeight() - 70);
                stand2LeftSet[i] = img;
            } 
        }
        
        if (opening)
        {
            this.currentMotionSet = openingSet;
            this.setCurrentPose(Figure.POSE_STAND);
            opening = false;
        }
        else
        {
            this.currentMotionSet = stand2LeftSet;
            this.setCurrentPose(Figure.POSE_WALK);
        }
    }
    /**
     * Act - do whatever the Joe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        lookForMainCharacter();
        runToMainCharacter();
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
        GreenfootImage[] motionSet = this.currentMotionSet;
        if(current_motion_index >= motionSet.length)
            current_motion_index = 0;
        setImage(motionSet[current_motion_index]);
        if(current_motion_index == motionSet.length - 1){
            current_motion_index = 0;
        }else{
            Greenfoot.delay(5);
            current_motion_index++;
            setLocation(this.getX()-moveStepLength,this.getY());
        }
    }
    
    public void lookForMainCharacter(){        
        if(bruce == null){
           bruce= this.getWorld().getObjects(BruceLee.class).get(0);
        }
        
        if(moveVariable < moveSpeed){
            moveVariable++;
            return;
        }else{
            moveVariable = 0;
        }
        
        if(this.getX()>bruce.getX()){
            runToMainCharacter();
        }
        
        System.out.println(bruce.toString());
    }
    
    public void onAttacked(int damage){
    
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
