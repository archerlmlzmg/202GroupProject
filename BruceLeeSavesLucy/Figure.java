// WARNING: This file is auto-generated and any changes to it will be overwritten
import java.util.*;
import greenfoot.*;
import java.awt.Color;

/**
 * 
 */
public class Figure extends Actor
{
    /* the health point*/
    private int hp = 0;
    private String name;
    /* the denfence ability indicates the point that can be deducted from every attack*/
    private int walkingSpeed = 5;
    /* ever attack a figure gets should be deducted by this attribute */
    private int basicDenfence = 10;
    private int currentPose = 0;
    public final static int POSE_STAND = 0, POSE_WALK = 1, WALK = 2;
    public final static int DIRECTION_RIGHT = 0, DIRECTION_LEFT = 1;
    public GreenfootImage[] stand2RightSet, stand2LeftSet,walk2LeftSet,walk2RightSet,
    currentMotionSet;
    public int direction = 0;
    /**
     * 
     */
    public void act()
    {
    }

    /**
     * 
     */
    public void walkLeft()
    {
    }
    public void stand(){
    
    }
    public int getCurrentPose(){
        return this.currentPose;
    }
    public void setCurrentPose(int pose){
        this.currentPose = pose;
    }
    public int getDirection(){
        return this.direction;
    }
    public void setDirection(int direction){
        this.direction = direction;
    }
    public void setCurrentMotionSet(GreenfootImage[] set){
        this.currentMotionSet = set;
    }
    public GreenfootImage[] getCurrentMotionSet(){
        return this.currentMotionSet;
    }
    public void setPoseStandRight(){
    }
    public void setPoseStandLeft(){
    }
    public void setPoseWalkRight(){
    }
    public void setPoseWalkLeft(){
    }
}
