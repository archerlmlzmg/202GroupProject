import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scenario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Scenario extends Actor implements IKeyCommandReceiver  
{
    String backgroundPath;
    IFighter[] gangsters;
    IFighter mainCharacter;
    int gameTime;
    String scenarioName;
    private IKeyCommandReceiver commandSuccessor;
    private boolean hasTakenOverKeyCommand = false;
    public IKeyCommandReceiver getCommandSuccessor(){
        return this.commandSuccessor;
    }
    public void setCommandSuccessor(IKeyCommandReceiver r){
        this.commandSuccessor = r;
    }
    /**
     * Constructor for objects of class Floor
     */
    public Scenario(World world, IFighter mainCharacter){
       
    }
    public void init(){
        
    }
    public IFighter[] getGangsters(){
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
