/**
 * Write a description of class GangsterFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GangsterFactory  
{
    /**
     * Constructor for objects of class GangsterFactory
     */
    public GangsterFactory()
    {
    }
    public Fighter generate(String name){
        if(name.equals("Joe"))
            return new Joe();
        return null;
    }
}
