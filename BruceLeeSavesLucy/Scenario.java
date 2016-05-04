/**
 * Write a description of class Scenario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Scenario implements IKeyCommandReceiver  
{
    String backgroundPath;
    IFighter[] gangsters;
    IFighter mainCharacter;
    int gameTime;
    String scenarioName;
    private IKeyCommandReceiver commandSuccessor;
    public IKeyCommandReceiver getCommandSuccessor(){
        return this.commandSuccessor;
    }
    public void setCommandSuccessor(IKeyCommandReceiver r){
        this.commandSuccessor = r;
    }
    /**
     * Constructor for objects of class Floor
     */
    public Scenario(){
       
    }
    public void init(){
        
    }
    public IFighter[] getGangsters(){
        return this.gangsters;
    }
    
    public boolean executeLeftKey(){
    
        return true;
    }
    public boolean executeRightKey(){
    
        return true;
    }
    public boolean executeUpKey(){
    
        return true;
    }
    public boolean executeDownKey(){
    
        return true;
    }
    public boolean executeAKey(){
    
        return true;
    }
    public boolean executeSKey(){
    
        return true;
    }
}
