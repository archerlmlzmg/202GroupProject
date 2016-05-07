import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BruceLee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BruceLee extends Figure implements IFighter, IKeyCommandReceiver
{

    int current_motion_index = 0;
    int moveSpeed = 3;
    int moveVariable = 0;
    int moveStepLength = 10, kickMoveLength = 0;
    Context context;
    GreenfootImage[] defenceMotionSet;
    // state of death
 
    //Ming is workin on this part
    public BruceLee(){
        //initialte walking
        stand2RightSet = new GreenfootImage[18];
        for(int i=0; i<stand2RightSet.length;i++){
            int m = i+ 1;
            stand2RightSet[i] = new GreenfootImage("bruce_" + m +".gif");
        }
        walk2RightSet = new GreenfootImage[2];
        walk2RightSet[0] = new GreenfootImage("bruce_walk_1.gif");
        walk2RightSet[1] = new GreenfootImage("bruce_walk_2.gif");

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
        //kick
        kick2RightSet = new GreenfootImage[8];
        kick2RightSet[0]=new GreenfootImage("bruce_kick_1.gif");
        kick2RightSet[1]=new GreenfootImage("bruce_kick_2.gif");
        kick2RightSet[2]=new GreenfootImage("bruce_kick_2.gif");
        kick2RightSet[3]=new GreenfootImage("bruce_kick_2.gif");
        kick2RightSet[4]=new GreenfootImage("bruce_kick_3.gif");
        kick2RightSet[5]=new GreenfootImage("bruce_kick_3.gif");
        kick2RightSet[6]=new GreenfootImage("bruce_kick_3.gif");
        kick2RightSet[7]=new GreenfootImage("bruce_kick_3.gif");
        
        punch2RightSet = new GreenfootImage[8];
        punch2RightSet[0]=new GreenfootImage("bruce_punch_1.gif");
        punch2RightSet[1]=new GreenfootImage("bruce_punch_2.gif");
        punch2RightSet[2]=new GreenfootImage("bruce_punch_2.gif");
        punch2RightSet[3]=new GreenfootImage("bruce_punch_2.gif");
        punch2RightSet[4]=new GreenfootImage("bruce_punch_3.gif");
        punch2RightSet[5]=new GreenfootImage("bruce_punch_3.gif");
        punch2RightSet[6]=new GreenfootImage("bruce_punch_3.gif");
        punch2RightSet[7]=new GreenfootImage("bruce_punch_3.gif");
        
        defenceMotionSet = new GreenfootImage[8];
        defenceMotionSet[0]=new GreenfootImage("bruce_defend_2.gif");
        defenceMotionSet[1]=new GreenfootImage("bruce_defend_2.gif");
        defenceMotionSet[2]=new GreenfootImage("bruce_defend_2.gif");
        defenceMotionSet[3]=new GreenfootImage("bruce_defend_2.gif");
        defenceMotionSet[4]=new GreenfootImage("bruce_defend_2.gif");
        defenceMotionSet[5]=new GreenfootImage("bruce_defend_2.gif");
        defenceMotionSet[6]=new GreenfootImage("bruce_defend_2.gif");
        defenceMotionSet[7]=new GreenfootImage("bruce_defend_2.gif");
        this.currentMotionSet = stand2RightSet;
        this.setCurrentPose(Figure.POSE_STAND);
        this.setDirection(Figure.DIRECTION_RIGHT);
        this.setAttackPoint(10);
        this.setFigureRadius(100);
        this.setName("Bruce Lee");
        this.setInitHP(100);
        this.setCurrentHP(100);
    }
    
     /**
    * This method addedToWorld, Assigns the level and returns the x and y positions
    *                           to the world and sets the feet parameter.
    */
    public void addedToWorld(World world)
    {
        /*level = (Scene) world;                
        xPlayer = getX();                        
        yPlayer = getY();                       
        feet = getImage().getHeight() / 1;
        */
    }
    
    /**
     * Act - do whatever the BruceLee wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        traverseMotionSet();
        if(this.getIsDying()){
            this.setIsDied(true);
        }
        
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
        this.setDirection(Figure.DIRECTION_RIGHT);
        this.setCurrentPose(Figure.POSE_WALK);
        if(isRightMovable()){
            setLocation(getX()+moveStepLength,getY());
        }
        if(current_motion_index>=walk2RightSet.length){
            current_motion_index = 0;
        }
        this.setCurrentMotionSet(walk2RightSet);        
      
    }
    
    public void setKick2Right(){
        this.setDirection(Figure.DIRECTION_RIGHT);
        this.setCurrentPose(Figure.POSE_KICK);
        if(current_motion_index>=kick2RightSet.length){
            current_motion_index = 0;
        }
        this.setCurrentMotionSet(kick2RightSet);        
        setLocation(getX()+kickMoveLength,getY());
        
    }
    public void setPunch2Right(){
        this.setDirection(Figure.DIRECTION_RIGHT);
        this.setCurrentPose(Figure.POSE_PUNCH);
        if(current_motion_index>=punch2RightSet.length){
            current_motion_index = 0;
        }
        this.setCurrentMotionSet(punch2RightSet);        
        setLocation(getX()+kickMoveLength,getY());
    }
    public void setWalk2Left(){
        this.setDirection(Figure.DIRECTION_LEFT);
        this.setCurrentMotionSet(walk2LeftSet);
        setLocation(getX()+moveStepLength,getY());
    }
    public void setDefend2Right(){
        this.setDirection(Figure.DIRECTION_LEFT);
        this.setCurrentPose(Figure.POSE_DEFENCE);
        this.setCurrentMotionSet(defenceMotionSet);
    }
    private void traverseMotionSet(){
        //if(this.getCurrentPose() != Figure.POSE_STAND){
        //    this.setCurrentPose(Figure.POSE_STAND);
         //   return;
        //}
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
        /* HERE, this is very important, the thought is to do all the
         * actual behavoir after the last frame of a motion set.
         */
        if(current_motion_index == motionSet.length - 1){
            current_motion_index = 0;
            doActualBehavior();
            this.setCurrentPose(Figure.POSE_STAND);
            this.setCurrentMotionSet(stand2RightSet);
        }else{
            current_motion_index++;
        }

    }
    private void doActualBehavior(){
        System.out.println("do actual behavior..");
        switch (getCurrentPose()){
        case Figure.POSE_PUNCH:
           System.out.println("do actual punch behavior..");
           if(getTargetFighter()!=null){
               if(getCurrentHP()>50){
                   context = new Context(new NormalDamageStrategy());
              
                }else{
                    context = new Context(new RageDamageStrategy());
                }
               
                getTargetFighter().onAttacked(context.action());
                Greenfoot.playSound("bruce_punch_2.mp3");
                System.out.println("attacked ["+((Figure)getTargetFighter()).getName()+"] by "+getAttackPoint()+" point.");
                break;
           }
           break;
        case Figure.POSE_KICK:
            System.out.println("do actual kick behavior..");
           if(getTargetFighter()!=null){
                getTargetFighter().onAttacked(getAttackPoint()+2);
                Greenfoot.playSound("bruce_punch_2.mp3");
                System.out.println("attacked ["+((Figure)getTargetFighter()).getName()+"] by "+getAttackPoint()+2+" point.");
                break;
           }
           break;
        }
    }
    public void printState(){
        System.out.println("currentMotionSet:"+this.getCurrentMotionSet().toString());
        System.out.println("current Direction:"+this.getDirection());
        System.out.println("current motion index:"+this.current_motion_index);
        System.out.println("current Pose:"+this.getCurrentPose()+"\n");
    }
    GreenfootSound musicDying = new GreenfootSound("Ahh.mp3");
    public void onAttacked(int damage)
    {
        // do being attacked animotion
        if(getCurrentPose() == Figure.POSE_DEFENCE){
        System.out.println("Bruce is defending..No damage!");
        return;
        }
        // deduct HP
        System.out.println("Bruce Lee is being faught.....");
        this.setCurrentHP(this.getCurrentHP()-damage+getDefencePoint());
        this.notifyObserver();
        if(this.getCurrentHP() <= 0){//is died
            if(!musicDying.isPlaying()){
              musicDying.play();
              }
            this.setIsDying(true);
        }
    }
    
    public int punch(){
        if(this.getDirection()==Figure.DIRECTION_RIGHT){
            this.setPunch2Right();
        }
        return 0;
    }
    
    public int kick(){
        if(this.getDirection() == Figure.DIRECTION_RIGHT){
            this.setKick2Right();
        }else{
        
        }
        return 0;
    }  
    
    public int defend(){
        setDefend2Right();
        return 0;
    }
    
    public void die(){
    }
    
    public boolean executeLeftKey(){
        setLocation(getX()-moveStepLength,getY());
        direction = 2;
        return true;
    }
    public boolean executeRightKey(){
        this.setDirection(Figure.DIRECTION_RIGHT);
        setWalk2Right();
        return true;
    }
    public boolean executeUpKey(){
        return true;
    }
    public boolean executeDownKey(){
        defend();
        return true;
    }
    public boolean executeAKey(){
        this.punch();
        return true;
    }
    public boolean executeSKey(){
        this.kick();
        return true;
    }
    public boolean executeEnterKey(){
 
        return false;
    }
    //composite pattern
    public IKeyCommandReceiver getKeyCommandReceiverSuccessor(){
        return null;
    }

}
