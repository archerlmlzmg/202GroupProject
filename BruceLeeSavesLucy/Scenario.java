/**
 * Write a description of class Scenario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Scenario  
{
    // instance variables - replace the example below with your own
    String backgroundPath;
    Fighter[] enemies;
    Fighter mainCharacter;
    int gameTime;
    String scenarioName;
    IKeyCommandReceiver commandSuccessor;
    public IKeyCommandReceiver getCommandSuccessor(){
        return this.commandSuccessor;
    }
    /**
     * Constructor for objects of class Floor
     */
    public Scenario(){
        
    }
    public void init(){
        
    }
    public Fighter[] getEnemies(){
        return this.enemies;
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
    public boolean executeBKey(){
    
        return true;
    }
}
