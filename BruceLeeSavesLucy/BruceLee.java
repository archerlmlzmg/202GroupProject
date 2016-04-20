import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BruceLee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BruceLee extends Figure
{

    int current_motion_index = 0;
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
        walk2RightSet = new GreenfootImage[2];
        for(int i=0; i<walk2RightSet.length;i++){
            int m = i+ 1;
            stand2RightSet[i] = new GreenfootImage("bruce_walk_" + m +".gif");
        }
        stand2LeftSet = new GreenfootImage[2];
        for(int i=0; i<stand2LeftSet.length;i++){
            int m = i+ 1;
            stand2LeftSet[i] = new GreenfootImage("bruce_walk_" + m +".gif");
        }
        walk2LeftSet = new GreenfootImage[2];
        for(int i=0; i<walk2LeftSet.length;i++){
            int m = i+ 1;
            walk2LeftSet[i] = new GreenfootImage("bruce_walk_" + m +".gif");
        }
        this.currentMotionSet = stand2RightSet;
        this.setCurrentPose(Figure.POSE_STAND);
    }
    /**
     * Act - do whatever the BruceLee wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeypress();
        traverseMotionSet();
        
    }
    private void setStand2Right(){
        //if(this.getCurrentPose() == Figure.POSE_STAND && this.getCurrentMotionSet.equal(stand2Right))
        this.current_motion_index = 0;
        this.setDirection(Figure.DIRECTION_RIGHT);
        this.setCurrentMotionSet(stand2RightSet);
    }
    private void setStand2Left(){
        this.setDirection(Figure.DIRECTION_LEFT);
        this.setCurrentMotionSet(stand2RightSet);
    }
    public void setWalk2Right(){
        /*
         * this condition means this stroke continues previous motion
         */
        if(this.getCurrentPose() == Figure.POSE_WALK &&
        this.currentMotionSet.equals(walk2RightSet)&&
        this.getDirection()== Figure.DIRECTION_RIGHT){
            System.out.println("the same movement, one more step.");
            this.current_motion_index++;
        }else{//this is a new stroke(command)
            System.out.println("the new movement, first step.");
            this.setDirection(Figure.DIRECTION_RIGHT);
            this.setCurrentMotionSet(walk2RightSet);
            this.setCurrentPose(Figure.POSE_WALK);
            this.current_motion_index=0;
        }
        setLocation(getX()+moveStepLength,getY());
        
    }
    public void setWalk2Left(){
        setLocation(getX()+moveStepLength,getY());
        this.setDirection(Figure.DIRECTION_LEFT);
        this.setCurrentMotionSet(walk2LeftSet);
    }
    private void traverseMotionSet(){
        //slow donw the motion
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
    public void printState(){
        System.out.println("currentMotionSet:"+this.getCurrentMotionSet().toString());
        System.out.println("current Direction:"+this.getDirection());
        System.out.println("current motion index:"+this.current_motion_index);
        System.out.println("current Pose:"+this.getCurrentPose()+"\n");
    }
    public void checkKeypress()
   {
        if(Greenfoot.isKeyDown("right")) 
        {
            //setImage("walk.gif");
            System.out.println("---------printing starts-----------");
            printState();
            setWalk2Right();
            System.out.println("---------after setting-----------");
            printState();
            System.out.println("---------printing ends-----------");
        }
        else if(Greenfoot.isKeyDown("left"))
        {
            //setImage("standflip.gif");
            setLocation(getX()-moveStepLength,getY());
            direction = 2;
        }
        if(Greenfoot.isKeyDown("down")){
            System.out.println("x:"+getX()+", y:"+getY());
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
