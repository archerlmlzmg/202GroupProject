import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Transition2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Transition2 extends Transition
{  
    public Transition2(World nextWorld){
        super(nextWorld);
        images = new GreenfootImage[12];
        for(int i=0; i<images.length;i++){
            int m = i+ 1;
            images[i] = new GreenfootImage("transition_2_" + m +".gif");
        }
    }
}
