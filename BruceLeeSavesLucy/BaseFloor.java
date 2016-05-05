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
public class BaseFloor extends World implements IKeyCommandReceiver,ISecnarioTemplate
{
    ArrayList<IFighter> gangsters = new ArrayList<>();;
    IFighter mainCharacter;
    int gameTime;
    String scenarioName;
    private IKeyCommandReceiver commandSuccessor;
    boolean hasTakenOverKeyCommand = false;
    HashMap<Actor,int[]> objectsLocationMap = new HashMap<Actor,int[]>();
    World world;
    GangsterFactory gangsterFactory  = new GangsterFactory();
    static final int horizonLine = 350;
    static final int activeAreaXLeft = 10;
    static final int activeAreaXRight = 700;
    static final int activeAreaYTop = 10;
    static final int activeAreaYBottom = 500;
    static final int worldWidth = 800;
    static final int worldHeight = 500;
    boolean isInitiated = false,
    isGameStarted = false;
    KeyCommandInvoker keyCommandInvoker = new KeyCommandInvoker();
    /**
     * Constructor for objects of class BaseFloor.
     * 
     */
    public BaseFloor(IFighter mainCharacter)
    {    
        super(worldWidth, worldHeight, 1); 
        this.mainCharacter = mainCharacter;
        keyCommandInvoker.setCommandReceiver(this);
        this.addKeyCommandReceiverSuccessor((IKeyCommandReceiver)mainCharacter);
    }
    public void act(){
        if(!isInitiated){
            onCreate();
        }
        onAct();
        
    }
    public void initElementsToWorld(){
        System.out.println("This floor has ["+this.objectsLocationMap.size()+"] actors");
        for(Actor o : this.objectsLocationMap.keySet()){
            int[] location = objectsLocationMap.get(o);
            System.out.println("add an object x:"+location[0]+", "+location[1]);
            this.addObject(o,location[0],location[1]);
        }
        this.isInitiated = true;
        onStart();
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
            System.out.println("pass key A");
            return false;
        }
    }
    public boolean executeSKey(){
        if(hasTakenOverKeyCommand){
            //handle command
            System.out.println("pass key B");
            return true;
        }else{
            return false;
        }
    }
    public IKeyCommandReceiver getKeyCommandReceiverSuccessor(){
        return this.commandSuccessor;
    };
    public void addKeyCommandReceiverSuccessor(IKeyCommandReceiver rec){
        this.commandSuccessor = rec;
    };
    public void removeKeyCommandReceiverSuccessor(){
        this.commandSuccessor = null;
    };
    public void onCreate(){
        initElementsToWorld();
    } 
    public void onStart(){
        // pass the key control to main character
        this.hasTakenOverKeyCommand = false;
        this.isGameStarted = true;
    }
    public void onAct(){
        keyCommandInvoker.checkKeyPress();
    }
    public void onPause(){
    }
    public void onEnd(){
    }
    public boolean isOver(){
        return false;
    }
}
