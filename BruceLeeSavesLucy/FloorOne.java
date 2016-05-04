import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FloorOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FloorOne extends Scenario
{
    public FloorOne(World world, IFighter mainCharacter){
        super(world, mainCharacter);
        this.scenarioName = "The First Floor";
        IFighter g1 = gangsterFactory.generate("Joe");
        gangsters.add(g1);
        objectsLocationMap.put(g1,new int[this.activeAreaXRight -50,
        this.activeAreaYBottom-((Actor)g1]).getImage().getHeight());
    }
    public void initElementsToWorld(){
        for(IFighter g : this.gangsters){
            this.world.addObject()
        }
    }
    /**
     * Act - do whatever the FloorOne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
