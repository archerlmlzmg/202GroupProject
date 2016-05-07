// WARNING: This file is auto-generated and any changes to it will be overwritten
import java.util.*;
import greenfoot.*;
import java.awt.Color;
import java.util.List;

/**
 * 
 */
public abstract class Figure extends Actor implements ISubject
{
    /* the current health point*/
    private int hp = 100;
    private int initHp = 100;
    private String name = "name me :(";
    /* the denfence ability indicates the point that can be deducted from every attack*/
    private int walkingSpeed = 5;
    /* ever attack a figure gets should be deducted by this attribute */
    private int basicDenfence = 1;
    private int attackPoint = 10;
    private boolean isDied = false, isDying = false;
    public final static int POSE_STAND = 0, POSE_WALK = 1, POSE_PUNCH = 2, POSE_KICK=3,POSE_DEFENCE = 4;
    public final static int DIRECTION_RIGHT = 0, DIRECTION_LEFT = 1;
    private IFighter targetFighter;
    private int currentPose = POSE_STAND, figureRadius = 50;
    public GreenfootImage[] stand2RightSet,
    stand2LeftSet,
    walk2LeftSet,
    walk2RightSet,
    kick2RightSet,
    punch2RightSet,
    currentMotionSet;
    IObserver observer;
    public int direction = DIRECTION_RIGHT ;
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
    public boolean isRightMovable(){
        List<Figure> fs = getObjectsInRange(figureRadius,Figure.class);
        System.out.println("intersected:"+fs.size());
        if(fs.size()==0){
            targetFighter = null;
            return true;
        }else if (fs.get(0).getX() >= this.getX()){
            Figure f =fs.get(0);
            if(isEnemy(fs.get(0)))
                targetFighter = (IFighter)f;
            else
                 targetFighter = null;
            return false;
        }
        return true;
    }
    public boolean isLeftMovable(){
        List<Figure> fs = getObjectsInRange(figureRadius,Figure.class);
        if(fs.size()==0){
            targetFighter = null;
            return true;
        }
        if (fs.get(0).getX() <= this.getX()){
            Figure f =fs.get(0);
            if(isEnemy(fs.get(0)))
                targetFighter = (IFighter)f;
            else
                 targetFighter = null;
            return false;
        }
        return true;
    }
    private boolean isEnemy(Figure target){
        boolean isCurrentMainCharacter = false, isTargetGangster = false;
        if(this instanceof IGangster){ // current gangster,
            isCurrentMainCharacter = false;
            isTargetGangster = false; 
        }
        
        if(target instanceof IGangster){
            isTargetGangster = true;
            isCurrentMainCharacter = true;
        }
        
        if(isCurrentMainCharacter && isTargetGangster)
            return true;
        else if(!isCurrentMainCharacter && !isTargetGangster)
            return true;
        else 
            return false;
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
    public void addKeyCommandReceiverSuccessor(IKeyCommandReceiver rec){
    }
    public void removeKeyCommandReceiverSuccessor(){
    }
    public void attachObserver(IObserver ob){
        this.observer = ob;
    }
    public void detachObserver(){
        this.observer = null;
    }
    public void notifyObserver(){
        this.observer.update(this);
    }
    public String getName(){
        return this.name;
    }
    public void setName(String n){
        this.name = n;
    }
    public IFighter getTargetFighter(){
        return this.targetFighter;
    }
    public void setTargetFighter(IFighter f){
        this.targetFighter = f;
    }
    public int getCurrentHP(){
        return this.hp;
    }
    public void setCurrentHP(int h){
        this.hp = h;
    }
    public int getInitHP(){
        return this.initHp;
    }
    public void setInitHP(int h){
        this.initHp = h;
    }
    public void setDefencePoint(int d){
        this.basicDenfence = d;
    }
    public int getDefencePoint(){
        return this.basicDenfence;
    }
    public void setFigureRadius(int r){
        this.figureRadius = r;
    }
    public void setAttackPoint(int a){
        this.attackPoint = a;
    }
    public int getAttackPoint(){
        return this.attackPoint;
    }
    public void setIsDied(boolean b){
        this.isDied = b;
    }
    public boolean getIsDied(){
        return this.isDied;
    }
    public void setIsDying(boolean b){
        this.isDying = b;
    }
    public boolean getIsDying(){
        return this.isDying;
    }
}
