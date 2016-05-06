import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Floor2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor3 extends BaseFloor
{

    /**
     * Constructor for objects of class Floor2.
     * 
     */
    public Floor3(IFighter mainCharacter , Transition transition)
    {
        super(mainCharacter,transition);
        System.out.println("constructing..");
        this.scenarioName = "The First Floor";
        // add Bruce Lee to this scenario
        objectsLocationMap.put((Actor)mainCharacter,new int[]{this.activeAreaXLeft+20,
        this.activeAreaYBottom-((Actor)mainCharacter).getImage().getHeight()});
        
        // add Bruce Joe to this scenario
        IFighter g1 = gangsterFactory.generate("Joe");
        gangsters.add(g1);
        objectsLocationMap.put((Actor)g1,new int[]{this.activeAreaXRight - 50,
        this.activeAreaYBottom - ((Actor)g1).getImage().getHeight() + 88});
       
        
        IObserver healthBarBruce = new HealthBar("Bruce Lee: ", "", 100, 100);
        IObserver healthBarBoss = new HealthBar("Joe: ", "",100, 100);
        
        //attach observers
        ((Figure)mainCharacter).attachObserver(healthBarBoss);
        ((Figure)g1).attachObserver(healthBarBoss);
        
        objectsLocationMap.put((Actor)healthBarBruce,new int[]{150,50});
        objectsLocationMap.put((Actor)healthBarBoss, new int[]{650, 50});   
          
        System.out.println("constructed.");
    }
}
