import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Transition here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Transition extends Actor
{
    GreenfootImage[] images;
    int motion_index = 0;
    World nextWorld;
    int moveSpeed = 12;
    int moveVariable = 0;
    public Transition(World nextWorld){
        this.nextWorld = nextWorld;
    }
    boolean needsWork = true;
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
        this.setImage(images[motion_index]);
        if(motion_index >= images.length-1){
            needsWork = false;
            Greenfoot.setWorld(nextWorld);
            
        }else
            motion_index++;
    }    
}
