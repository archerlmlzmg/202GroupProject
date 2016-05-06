import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Transition2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StateTransition2 extends StateTransition
{  
    public StateTransition2(World lossWorld,World nextWorld){
        super(lossWorld,nextWorld);
        images = new GreenfootImage[12];
        for(int i=0; i<images.length;i++){
            int m = i+ 1;
            images[i] = new GreenfootImage("transition_2_" + m +".gif");
        }
    }
}
