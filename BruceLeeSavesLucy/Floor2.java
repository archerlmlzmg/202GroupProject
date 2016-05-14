import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Floor2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor2 extends BaseFloor
{

    /**
     * Constructor for objects of class Floor2.
     * 
     */
    public Floor2(IFighter mainCharacter, StateTransition transition)
    {
        super(mainCharacter,transition);
        System.out.println("constructing..");
        this.scenarioName = "The First Floor";
        // add Bruce Lee to this scenario
        objectsLocationMap.put((Actor)mainCharacter,new int[]{this.activeAreaXLeft+20,
        this.activeAreaYBottom-((Actor)mainCharacter).getImage().getHeight()+15});
        
      //add Goro
        IFighter g3 = fighterFactory.generate("Goro");
        gangsters.add(g3);
        objectsLocationMap.put((Actor)g3,new int[]{this.activeAreaXRight,
        this.activeAreaYBottom - 120});
        
        IObserver healthBarBruce = new HealthBar("Bruce Lee: ", "", 100, 100);
        IObserver healthBarGoro = new HealthBar("Goro: ", "",100, 100);
        //attach observers
        ((Figure)mainCharacter).attachObserver(healthBarBruce);
        ((Figure)g3).attachObserver(healthBarGoro);
        
        objectsLocationMap.put((Actor)healthBarBruce,new int[]{150,50});
        objectsLocationMap.put((Actor)healthBarGoro, new int[]{650, 50}); 
          
        System.out.println("constructed.");
    }
}
