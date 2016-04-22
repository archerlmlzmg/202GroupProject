import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class boss extends Figure
{
    int current_motion_index = 0;
    int moveSpeed = 3;
    int moveVariable = 0;
    int moveStepLength = 10;
    public GreenfootImage[] fallSet, hitSet, crushSet, highkickSet, jumpSet, runSet, spinkickSet, currentMotionSet;
    public boss(){
        //initialize falling
        fallSet = new GreenfootImage[4];
        for(int i=0; i<fallSet.length;i++){
            int m = i+ 1;
            fallSet[i] = new GreenfootImage("boss_fall_" + m +".gif");
        }
        //initialize being hit
        hitSet = new GreenfootImage[6];
        for(int i=0; i<hitSet.length;i++){
            int m = i+ 1;
            hitSet[i] = new GreenfootImage("boss_hit_" + m +".gif");
        }
        //initialize being crushed
        crushSet = new GreenfootImage[4];
        for(int i=0; i<crushSet.length;i++){
            int m = i+ 1;
            crushSet[i] = new GreenfootImage("boss_crush_" + m +".gif");
        }
        //initialize highkick
        highkickSet = new GreenfootImage[8];
        for(int i=0; i<highkickSet.length;i++){
            int m = i+ 1;
            highkickSet[i] = new GreenfootImage("boss_highkick_" + m +".gif");
        }
        //initialize jump
        jumpSet = new GreenfootImage[18];
        for(int i=0; i<jumpSet.length;i++){
            int m = i+ 1;
            jumpSet[i] = new GreenfootImage("boss_jump_" + m +".gif");
        }
        //initialize run
        runSet = new GreenfootImage[8];
        for(int i=0; i<runSet.length;i++){
            int m = i+ 1;
            runSet[i] = new GreenfootImage("boss_run_" + m +".gif");
        }
        //initialize spinkick
        spinkickSet = new GreenfootImage[13];
        for(int i=0; i<spinkickSet.length;i++){
            int m = i+ 1;
            spinkickSet[i] = new GreenfootImage("boss_spinkick_" + m +".gif");
        }
        
        this.currentMotionSet = fallSet;
        this.setCurrentPose(Figure.POSE_STAND);
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
    /**
     * Act - do whatever the BruceLee wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        traverseMotionSet();
    }
    
}
