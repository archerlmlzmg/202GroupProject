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
}
