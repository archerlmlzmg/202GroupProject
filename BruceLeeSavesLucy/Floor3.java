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
    public Floor3(IFighter mainCharacter , StateTransition transition)
    {
        super(mainCharacter,transition);
        System.out.println("constructing..");
        this.scenarioName = "The First Floor";
        // add Bruce Lee to this scenario
        objectsLocationMap.put((Actor)mainCharacter,new int[]{this.activeAreaXLeft+20,
        this.activeAreaYBottom-((Actor)mainCharacter).getImage().getHeight()});
        
        // add Bruce Joe to this scenario
<<<<<<< HEAD
        //IFighter g1 = gangsterFactory.generate("Joe");
        //gangsters.add(g1);
        //objectsLocationMap.put((Actor)g1,new int[]{this.activeAreaXRight -50,
        //this.activeAreaYBottom-((Actor)g1).getImage().getHeight()});
        //add boss
        IFighter newBoss = gangsterFactory.generate("boss");
        gangsters.add(newBoss);
        objectsLocationMap.put((Actor)newBoss,new int[]{this.activeAreaXRight -70,
        this.activeAreaYBottom-((Actor)newBoss).getImage().getHeight()});
=======
        IFighter g1 = gangsterFactory.generate("Joe");
        gangsters.add(g1);
        objectsLocationMap.put((Actor)g1,new int[]{this.activeAreaXRight - 50,
        this.activeAreaYBottom - ((Actor)g1).getImage().getHeight() + 88});
       
>>>>>>> parent of bf17ed0... add
        
        IObserver healthBarBruce = new HealthBar("Bruce Lee: ", "", 100, 100);
        IObserver healthBarBoss = new HealthBar("Joe: ", "",100, 100);
        
<<<<<<< HEAD
        IObserver healthBarBruce = new HealthBar("Bruce Lee: ", "", ((Figure)mainCharacter).getInitHP(),
        ((Figure)mainCharacter).getInitHP());
        IObserver healthBarBoss = new HealthBar("Paul: ", "",100, 100);
        //attach observers
        ((Figure)mainCharacter).attachObserver(healthBarBruce);
        ((Figure)newBoss).attachObserver(healthBarBoss);
        
        objectsLocationMap.put((Actor)healthBarBruce,new int[]{150,50});
        objectsLocationMap.put((Actor)healthBarBoss, new int[]{650,50});   
  
        
=======
        //attach observers
        ((Figure)mainCharacter).attachObserver(healthBarBoss);
        ((Figure)g1).attachObserver(healthBarBoss);
        
        objectsLocationMap.put((Actor)healthBarBruce,new int[]{150,50});
        objectsLocationMap.put((Actor)healthBarBoss, new int[]{650, 50});   
          
>>>>>>> parent of bf17ed0... add
        System.out.println("constructed.");
    }
}
