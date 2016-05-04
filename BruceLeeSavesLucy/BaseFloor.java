import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.HashMap; 
import java.util.Collections;
/**
 * Write a description of class BaseFloor here.
 * 
 * @author (Ming Tang) 
 * @version (a version number or a date)
 */
public class BaseFloor extends World implements IKeyCommandReceiver
{
    ArrayList<IFighter> gangsters = new ArrayList<>();;
    IFighter mainCharacter;
    int gameTime;
    String scenarioName;
    private IKeyCommandReceiver commandSuccessor;
    boolean hasTakenOverKeyCommand = false;
    HashMap<Object,int[]> objectsLocationMap = new HashMap<Object,int[]>();
    World world;
    GangsterFactory gangsterFactory  = new GangsterFactory();
    static final int horizonLine = 350;
    static final int activeAreaXLeft = 10;
    static final int activeAreaXRight = 700;
    static final int activeAreaYTop = 10;
    static final int activeAreaYBottom = 500;
    static final int worldWidth = 800;
    static final int worldHeight = 500;
    KeyCommandInvoker keyCommandInvoker = new KeyCommandInvoker();
    /**
     * Constructor for objects of class BaseFloor.
     * 
     */
    public BaseFloor(IFighter mainCharacter)
    {    
        super(worldWidth, worldHeight, 1); 
        this.mainCharacter = mainCharacter;
    }
    public void act(){
        keyCommandInvoker.checkKeyPress();
    }
    public void initElementsToWorld(){
        
    }
    private void checkKeyPress(){
    
    }
    public IKeyCommandReceiver getCommandSuccessor(){
        return this.commandSuccessor;
    }
    public void setCommandSuccessor(IKeyCommandReceiver r){
        this.commandSuccessor = r;
    }
    public ArrayList<IFighter> getGangsters(){
        return this.gangsters;
    }
    
    public boolean executeLeftKey(){
        if(hasTakenOverKeyCommand){
            //handle command
            return true;
        }else{
            return false;
        }
    }
    public boolean executeRightKey(){
        if(hasTakenOverKeyCommand){
            //handle command
            return true;
        }else{
            return false;
        }
    }
    public boolean executeUpKey(){
        if(hasTakenOverKeyCommand){
            //handle command
            return true;
        }else{
            return false;
        }
    }
    public boolean executeDownKey(){
        if(hasTakenOverKeyCommand){
            //handle command
            return true;
        }else{
            return false;
        }
    }
    public boolean executeAKey(){
        if(hasTakenOverKeyCommand){
            //handle command
            return true;
        }else{
            return false;
        }
    }
    public boolean executeSKey(){
        if(hasTakenOverKeyCommand){
            //handle command
            return true;
        }else{
            return false;
        }
    }
}
