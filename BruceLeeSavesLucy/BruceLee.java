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
    int moveStepLength = 10, kickMoveLength = 1;
    // state of death
    private int dead = 0;              
    private int damage = 0;    
    private int Lhit = 0;
    private int Rhit = 0;
    
    private int xPlayer;
    private int yPlayer;
    private int feet;
    
    private Scene level;
    
   private GreenfootImage[] DRight = {
                                          new GreenfootImage("rightblood0.png"),
                                          new GreenfootImage("rightblood1.png"),
                                          new GreenfootImage("rightblood2.png"),
                                          new GreenfootImage("rightblood3.png"),
                                          new GreenfootImage("rightblood4.png"),
                                          new GreenfootImage("rightblood5.png"),
                                          new GreenfootImage("rightblood6.png"),
                                          new GreenfootImage("rightblood7.png")
                                      };
                                                                                                                    
    private GreenfootImage[] DLeft = {
                                         new GreenfootImage("rightblood0.png"),
                                         new GreenfootImage("rightblood1.png"),
                                         new GreenfootImage("rightblood2.png"),
                                         new GreenfootImage("rightblood3.png"),
                                         new GreenfootImage("rightblood4.png"),
                                         new GreenfootImage("rightblood5.png"),
                                         new GreenfootImage("rightblood6.png"),
                                         new GreenfootImage("rightblood7.png")
                                     };
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
        /*for(int i=0; i<kick2RightSet.length; i++){
            int m = i+ 1;
            kick2RightSet[i]=new GreenfootImage("bruce_kick_" + m +".gif");
        }*/
        this.currentMotionSet = stand2RightSet;
        this.setCurrentPose(Figure.POSE_STAND);
        this.setDirection(Figure.DIRECTION_RIGHT);
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
        if(current_motion_index>=walk2RightSet.length){
            current_motion_index = 0;
        }
        this.setCurrentMotionSet(walk2RightSet);        
        current_motion_index++;
        setLocation(getX()+moveStepLength,getY());
    }
    
    public void setKick2Right(){
        this.setDirection(Figure.DIRECTION_RIGHT);
        this.setCurrentPose(Figure.POSE_KICK);
        if(current_motion_index>=kick2RightSet.length){
            current_motion_index = 0;
        }
        this.setCurrentMotionSet(kick2RightSet);        
        current_motion_index++;
        setLocation(getX()+kickMoveLength,getY());
        Greenfoot.playSound("bruce_punch_2.mp3");
    }
    public void setPunch2Right(){
        this.setDirection(Figure.DIRECTION_RIGHT);
        this.setCurrentPose(Figure.POSE_PUNCH);
        if(current_motion_index>=punch2RightSet.length){
            current_motion_index = 0;
        }
        this.setCurrentMotionSet(punch2RightSet);        
        current_motion_index++;
        setLocation(getX()+kickMoveLength,getY());
        Greenfoot.playSound("bruce_punch_2.mp3");
    }
    public void setWalk2Left(){
        setLocation(getX()+moveStepLength,getY());
        this.setDirection(Figure.DIRECTION_LEFT);
        this.setCurrentMotionSet(walk2LeftSet);
    }
    private void traverseMotionSet(){
        if(this.getCurrentPose() != Figure.POSE_STAND){
            this.setCurrentPose(Figure.POSE_STAND);
            return;
        }
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
            this.setCurrentMotionSet(stand2RightSet);
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
    
 
    
    public void onAttacked(int damage)
    {
        for(int i = 0; i < 13; i++)
        {
            if(direction == 0)    
            {
                switch(Lhit)               
                {
                    case 0 :
                        setImage(DLeft[Lhit]);
                        Lhit++;
                        Greenfoot.delay(1);
                    break;
                    case 1 :
                        setImage(DLeft[Lhit]);
                        Lhit++;
                        Greenfoot.delay(2);
                    break;
                    case 2 :
                        setImage(DLeft[Lhit]);
                        Lhit++;
                        Greenfoot.delay(3);
                    break;
                    case 3 :
                        setImage(DLeft[Lhit]);
                        Lhit++;
                        Greenfoot.delay(1);
                    break;
                    case 4 :
                        setImage(DLeft[Lhit]);
                        Lhit++;
                        Greenfoot.delay(2);
                    break;
                    case 5 :
                        setImage(DLeft[Lhit]);
                        Lhit++;
                        Greenfoot.delay(3);
                    break;
                    case 6 :
                        setImage(DLeft[Lhit]);
                        Lhit++;
                   //     Greenfoot.playSound("ahhhuuuh.mp3");
                        Greenfoot.delay(1);
                    break;
                    case 7 :
                        setImage(DLeft[Lhit]);
                        Lhit++;
                        Greenfoot.delay(2);
                    break;
                    case 8 :
                        setImage(walk2LeftSet[0]);
                        Lhit = 0;
                    //    Greenfoot.playSound("stab1.mp3");
                    //    Greenfoot.playSound("die1.mp3");
                        Greenfoot.delay(0);
                    break;                
                }
                
            }
            
        }
        
        if(direction == 1) 
        {
            for(int i = 0; i < 13; i++)
            {
                switch(Rhit)           
                {
                    case 0 :
                        setImage(DRight[Rhit]);
                        Rhit++;
                        Greenfoot.delay(1);
                    break;
                    case 1 :
                        setImage(DRight[Rhit]);
                        Rhit++;
                        Greenfoot.delay(2);
                    break;
                    case 2 :
                        setImage(DRight[Rhit]);
                        Rhit++;
                        Greenfoot.delay(1);
                    break;
                    case 3 :
                        setImage(DRight[Rhit]);
                        Rhit++;
                        Greenfoot.delay(2);
                    break;
                    case 4 :
                        setImage(DRight[Rhit]);
                        Rhit++;
                        Greenfoot.delay(1);
                    break;
                    case 5 :
                        setImage(DRight[Rhit]);
                        Rhit++;
                        Greenfoot.delay(2);
                    break;
                    case 6 :
                        setImage(DRight[Rhit]);
                        Rhit++;
                        Greenfoot.playSound("ahhhuuuh.mp3");
                        Greenfoot.delay(1);
                    break;
                    case 7 :
                        setImage(DRight[Rhit]);
                        Rhit++;
                        Greenfoot.delay(2);
                    break;
                    case 8 :
                        setImage(walk2RightSet[0]);
                        Rhit = 0;
                        Greenfoot.delay(0);
                   //     Greenfoot.playSound("stab1.mp3");
                   //     Greenfoot.playSound("die1.mp3");
                        break;            
                }
                    
            }   
                
        }
        damage++; 
        death();
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
        return 0;
    }
    
    public void die(){
    }
    
    /**
    * This method death, It checks to see if liu is above 3 hits,
    *                    then it moves the liu out of harms way.
    */
    public void death()
    {
    //    LiuExploding();
    //    int currentPosition = (int)level.getScrollPosition();
        if(damage >= 3)
        {
            Greenfoot.playSound("ahhhuuuh.mp3");
            xPlayer = 40;
            yPlayer = 270;
    //        vSpeed = 0;
            direction = 1;
            damage = 0;

          setLocation(xPlayer, yPlayer); 
        }
            
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
    //composite pattern
    public IKeyCommandReceiver getKeyCommandReceiverSuccessor(){
        return null;
    }
    public void addKeyCommandReceiverSuccessor(IKeyCommandReceiver rec){
    }
    public void removeKeyCommandReceiverSuccessor(){
    }
}
