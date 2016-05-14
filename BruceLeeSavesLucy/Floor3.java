import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Floor1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor3 extends BaseFloor
{

    /**
     * Constructor for objects of class Floor1.
     * 
     */
    public Floor3(IFighter mainCharacter , StateTransition transition)
    {
        super(mainCharacter,transition);
        System.out.println("constructing..");
        this.scenarioName = "The First Floor";
        // add Bruce Lee to this scenario
        objectsLocationMap.put((Actor)mainCharacter,new int[]{this.activeAreaXLeft+20,
        this.activeAreaYBottom-((Actor)mainCharacter).getImage().getHeight()});
        
        // add Bruce Joe to this scenario
        //IFighter g1 = gangsterFactory.generate("Joe");
        //gangsters.add(g1);
        //objectsLocationMap.put((Actor)g1,new int[]{this.activeAreaXRight -50,
        //this.activeAreaYBottom-((Actor)g1).getImage().getHeight()});
        //add boss
        IFighter newBoss = fighterFactory.generate("boss");
        gangsters.add(newBoss);
        objectsLocationMap.put((Actor)newBoss,new int[]{this.activeAreaXRight -70,
        this.activeAreaYBottom-((Actor)newBoss).getImage().getHeight()});
        
        
        IObserver healthBarBruce = new HealthBar("Bruce Lee: ", "", ((Figure)mainCharacter).getInitHP(),
        ((Figure)mainCharacter).getInitHP());
        IObserver healthBarBoss = new HealthBar("Boss: ", "",100, 100);
        //attach observers
        ((Figure)mainCharacter).attachObserver(healthBarBruce);
        ((Figure)newBoss).attachObserver(healthBarBoss);
        
        objectsLocationMap.put((Actor)healthBarBruce,new int[]{150,50});
        objectsLocationMap.put((Actor)healthBarBoss, new int[]{650,50});   
  
        
        System.out.println("constructed.");
    }
}
