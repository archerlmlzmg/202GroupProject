import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Transition2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StateTransitionLast extends StateTransition
{  
    public StateTransitionLast(World lossWorld,World nextWorld){
        super(lossWorld,nextWorld);
        images = new GreenfootImage[8];
        for(int i=0; i<images.length;i++){
            int m = i+ 1;
            images[i] = new GreenfootImage("transition_win_" + m +".gif");
        }
    }
    public void act() 
    {
        if(!needsWork)
            return;
                //slow donw the motion
        if(moveVariable < moveSpeed){
            moveVariable++;
            return;
        }else{
            moveVariable = 0;
        }
        this.setImage(currentMotionSet[motion_index]);
        if(motion_index>=2 && motion_index<=8){//
            Greenfoot.delay(10);
        }
        //if(!isGoingToNext && motion_index == (currentMotionSet.length-1)){
        //    Greenfoot.delay(10);
        //}
        if(motion_index >= currentMotionSet.length-1){
            needsWork = false;
            Greenfoot.setWorld(nextWorld);
        }else
            motion_index++;
    }
}
