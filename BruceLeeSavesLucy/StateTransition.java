import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Transition here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StateTransition extends Actor implements IState
{
    GreenfootImage[] images,lossImages,currentMotionSet;
    int motion_index = 0;
    World nextWorld,backWorld;
    int moveSpeed = 12;
    int moveVariable = 0;
    public StateTransition(World lossWorld,World nextWorld){
        this.nextWorld = nextWorld;
        this.backWorld = lossWorld;
        lossImages = new GreenfootImage[6];
        lossImages[0] = new GreenfootImage("transition_loss_1.gif");
        lossImages[1] = new GreenfootImage("transition_loss_2.gif");
        lossImages[2] = new GreenfootImage("transition_loss_2.gif");
        lossImages[3] = new GreenfootImage("transition_loss_3.gif");
        lossImages[4] = new GreenfootImage("transition_loss_3.gif");
        lossImages[5] = new GreenfootImage("transition_loss_3.gif");
    }
    boolean needsWork = false;
    boolean isGoingToNext = true;
    boolean isLost = false;
    /**
     * Act - do whatever the Transition wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
        if(isGoingToNext && motion_index==2){
            
            Greenfoot.delay(100);
            Greenfoot.playSound("woda.mp3");
        }
        if(!isGoingToNext && motion_index==2){
            Greenfoot.playSound("lost.mp3");
        }
        if(!isGoingToNext && motion_index==4){
            Greenfoot.delay(100);
        }
        if(!isGoingToNext && motion_index == (currentMotionSet.length-1)){
            Greenfoot.delay(10);
        }
        if(motion_index >= currentMotionSet.length-1){
            needsWork = false;
            Greenfoot.setWorld(nextWorld);
        }else
            motion_index++;
    }  
    public void goToBackState(){
        this.isGoingToNext = false;       
        currentMotionSet = lossImages;
        this.needsWork = true;
        this.nextWorld = backWorld;
        isLost = true;
    }
    public void goToNextState(){
        this.isGoingToNext = true;        
        currentMotionSet = images;
        this.needsWork = true;
       
    }
}
