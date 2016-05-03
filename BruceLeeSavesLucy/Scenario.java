/**
 * Write a description of class Scenario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scenario  
{
    // instance variables - replace the example below with your own
    private int x;
    String backgroundPath;
    Fighter[] enemies;
    int gameTime;
    String scenarioName;
    /**
     * Constructor for objects of class Floor
     */
    public Scenario()
    {
    }

    public Fighter[] getEnemies(){
        return this.enemies;
    }
}
