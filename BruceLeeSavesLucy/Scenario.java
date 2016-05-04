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
}
