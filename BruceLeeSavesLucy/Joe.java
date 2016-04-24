import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Joe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Joe extends Figure
{
    int current_motion_index = 0;
    int moveSpeed = 3;
    int moveVariable = 0;
    int moveStepLength = 10;
    public GreenfootImage[] stand2LeftSet, openingSet;
    
    public Joe()
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
        this.currentMotionSet = stand2LeftSet;
        this.setCurrentPose(Figure.POSE_STAND);
    }
    /**
     * Act - do whatever the Joe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        move();
    }    
    
    public void move()
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
            current_motion_index++;
        }
    }
}
