import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.*;
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
    private BruceLee bruce;
    public GreenfootImage[] fallSet, hitSet, crushSet, highkickSet, jumpSet, runSet, spinkickSet, currentMotionSet;
    public boss(){
        //initialize falling
        fallSet = new GreenfootImage[4];
        for(int i=0; i<fallSet.length;i++){
            int m = i+ 1;
            GreenfootImage img = new GreenfootImage("boss_fall_" + m +".gif");
            img.scale(img.getWidth() - 50,img.getHeight() - 70);
            fallSet[i] = img;
        }
        //initialize being hit
        hitSet = new GreenfootImage[6];
        for(int i=0; i<hitSet.length;i++){
            int m = i+ 1;
            GreenfootImage img = new GreenfootImage("boss_hit_" + m +".gif");
            img.scale(img.getWidth() - 50,img.getHeight() - 70);
            hitSet[i] = img;
        }
        //initialize being crushed
        crushSet = new GreenfootImage[4];
        for(int i=0; i<crushSet.length;i++){
            int m = i+ 1;
            GreenfootImage img = new GreenfootImage("boss_crush_" + m +".gif");
            img.scale(img.getWidth() - 50,img.getHeight() - 70);
            crushSet[i] = img;
        }
        //initialize highkick
        highkickSet = new GreenfootImage[8];
        for(int i=0; i<highkickSet.length;i++){
            int m = i+ 1;
            GreenfootImage img = new GreenfootImage("boss_highkick_" + m +".gif");
            img.scale(img.getWidth() - 50,img.getHeight() - 70);
            highkickSet[i] = img;
        }
        //initialize jump
        jumpSet = new GreenfootImage[18];
        for(int i=0; i<jumpSet.length;i++){
            int m = i+ 1;
            GreenfootImage img = new GreenfootImage("boss_jump_" + m +".gif");
            img.scale(img.getWidth() - 50,img.getHeight() - 70);
            jumpSet[i] = img;
        }
        //initialize run
        runSet = new GreenfootImage[8];
        for(int i=0; i<runSet.length;i++){
            int m = i+ 1;
            GreenfootImage img = new GreenfootImage("boss_run_" + m +".gif");
            img.scale(img.getWidth() - 50,img.getHeight() - 70);
            runSet[i] = img;
        }
        //initialize spinkick
        spinkickSet = new GreenfootImage[13];
        for(int i=0; i<spinkickSet.length;i++){
            int m = i+ 1;
            GreenfootImage img = new GreenfootImage("boss_spinkick_" + m +".gif");
            img.scale(img.getWidth() - 50,img.getHeight() - 70);
            spinkickSet[i] = img;
        }
        
        this.currentMotionSet = runSet;
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
            Greenfoot.delay(5);
            current_motion_index++;
            //setLocation(this.getX()-moveStepLength,this.getY());
        }
    }
    private void runToBruceLee(){
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
            Greenfoot.delay(5);
            current_motion_index++;
            setLocation(this.getX()-moveStepLength,this.getY());
        }
    }
    /**
     * Act - do whatever the BruceLee wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //traverseMotionSet();
        lookForBruceLee();
        runToBruceLee();
        //spinkickBruceLee();
    }
    private void lookForBruceLee(){
       if(moveVariable < moveSpeed){
            moveVariable++;
            return;
       }else{
            moveVariable = 0;
       }
       if(bruce == null){
           bruce= this.getWorld().getObjects(BruceLee.class).get(0);
       }
   
       if(this.getX()>bruce.getX()){
            //setLocation(this.getX()-moveStepLength,this.getY());
            //Greenfoot.delay(1);
            //traverseMotionSet();
            runToBruceLee();
       }
       
       System.out.println(bruce.toString());
    }
    private void spinkickBruceLee(){
        if(moveVariable < moveSpeed){
            moveVariable++;
            return;
       }else{
            moveVariable = 0;
       }
       if(bruce == null){
           bruce= this.getWorld().getObjects(BruceLee.class).get(0);
       }
       if(Math.abs(this.getX()-bruce.getX())<10){
           this.currentMotionSet = spinkickSet;
       }
    }
    private void highkickBruceLee(){
        
    }
}
