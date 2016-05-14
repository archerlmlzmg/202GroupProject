import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Floor1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor1 extends BaseFloor
{

    /**
     * Constructor for objects of class Floor1.
     * 
     */
    public Floor1(IFighter mainCharacter , StateTransition transition)
    {
        super(mainCharacter,transition);
        System.out.println("constructing..");
        this.scenarioName = "The First Floor";
        this.timer.setAmount(1000*60*2);
        // add Bruce Lee to this scenario
        objectsLocationMap.put((Actor)mainCharacter,new int[]{this.activeAreaXLeft+20,
        this.activeAreaYBottom-((Actor)mainCharacter).getImage().getHeight() - 20});
        
        // add Bruce Joe to this scenario
        //IFighter g1 = gangsterFactory.generate("Joe");
        //gangsters.add(g1);
        //objectsLocationMap.put((Actor)g1,new int[]{this.activeAreaXRight -50,
        //this.activeAreaYBottom-((Actor)g1).getImage().getHeight()});
        //add boss
        IFighter newJoe = fighterFactory.generate("Joe");
        gangsters.add(newJoe);
        objectsLocationMap.put((Actor)newJoe,new int[]{this.activeAreaXRight - 70,
        this.activeAreaYBottom-((Actor)newJoe).getImage().getHeight() + 58});
        
        
        IObserver healthBarBruce = new HealthBar("Bruce Lee: ", "", ((Figure)mainCharacter).getInitHP(),
        ((Figure)mainCharacter).getInitHP());
        IObserver healthBarJoe = new HealthBar("Joe: ", "",100, 100);
        //attach observers
        ((Figure)mainCharacter).attachObserver(healthBarBruce);
        ((Figure)newJoe).attachObserver(healthBarJoe);
        
        objectsLocationMap.put((Actor)healthBarBruce,new int[]{150,50});
        objectsLocationMap.put((Actor)healthBarJoe, new int[]{650,50});   
        System.out.println("constructed.");
    }
}
