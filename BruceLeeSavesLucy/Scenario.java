import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Scenario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Scenario extends Actor implements IKeyCommandReceiver  
{
    String backgroundPath;
    ArrayList<IFighter> gangsters = new ArrayList<>();;
    IFighter mainCharacter;
    int gameTime;
    String scenarioName;
    private IKeyCommandReceiver commandSuccessor;
    boolean hasTakenOverKeyCommand = false;
    Map<Object,int[2]> objectsLocationMap = new HashMap<Object,int[2]>();
    World world;
    GangsterFactory gangsterFactory  = new GangsterFactory();
    int horizonLine = 350;
    int activeAreaXLeft = 10;
    int activeAreaXRight = 700;
    int activeAreaYTop = 10;
    int activeAreaYBottom = 500;
    /**
     * Constructor for objects of class Floor
     */
    public Scenario(World world, IFighter mainCharacter){
        this.world = world;
        this.mainCharacter = mainCharacter;
    }
    public void initElementsToWorld(){
        
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
