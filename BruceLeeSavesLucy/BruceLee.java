import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BruceLee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BruceLee extends Figure
{

    int current_stand_index = 0;
    int moveSpeed = 3;
    int moveVariable = 0;
    int moveStepLength = 10;
    
    public BruceLee(){
        //initialte walking
        stand2RightSet = new GreenfootImage[18];
        for(int i=0; i<stand2RightSet.length;i++){
            int m = i+ 1;
            stand2RightSet[i] = new GreenfootImage("bruce_" + m +".gif");
        }
        walkRightSet = new GreenfootImage[2];
        for(int i=0; i<walkRightSet.length;i++){
            int m = i+ 1;
            stand2RightSet[i] = new GreenfootImage("bruce_walk_" + m +".gif");
        }
    }
    /**
     * Act - do whatever the BruceLee wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(this.getCurrentPose() == Figure.POSE_STAND)
            setStand();
        checkKeypress();
    }
    private void setStand(){
        if(this.direction == Figure.DIRECT_RIGHT)
            traverseMotionSet(stand2RightSet);
        else
            traverseMotionSet(stand2LeftSet);
            
    }
    public void setWalk(){
        this.setCurrentPose(Figure.POSE_WALK)
        traverseMotionSet(walkRightSet);
    }
    private void traverseMotionSet(GreenfootImage[] motionSet){
        if(moveVariable < moveSpeed){
            moveVariable++;
            return;
        }else{
            moveVariable = 0;
        }
        setImage(motionSet[current_stand_index]);
        if(current_stand_index == motionSet.length - 1){
            current_stand_index = 0;
            if(this.getCurrentPose() != Figure.POSE_STAND){
                this.setCurrentPose(Figure.POSE_STAND);
            }
        }else{
            current_stand_index++;
        }
    }
    public void checkKeypress()
   {
        if(Greenfoot.isKeyDown("right")) 
        {
            //setImage("walk.gif");
            setLocation(getX()+moveStepLength,getY());
            direction = 1;
        }
        else if(Greenfoot.isKeyDown("left"))
        {
            //setImage("standflip.gif");
            setLocation(getX()-moveStepLength,getY());
            direction = 2;
        }
       
            
         //else //setImage("stand.gif");
        if(!Greenfoot.isKeyDown("down")&&!Greenfoot.isKeyDown("x")&&direction==1&&!Greenfoot.isKeyDown("right"))
        {
            //setImage("stand.gif");
        }
        if(!Greenfoot.isKeyDown("down")&&!Greenfoot.isKeyDown("x")&&direction==2&&!Greenfoot.isKeyDown("left"))
        {
            //setImage("standflip.gif");
        }
        /*if(!Greenfoot.isKeyDown("up"))
        {
            gForce = true;
            counterWeight();
        }*/
    }
}
