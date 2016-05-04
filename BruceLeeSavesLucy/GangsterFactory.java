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
    public IFighter generate(String name){
        if(name.equals("Joe")){
            return new Joe();
        }else if(name.equals("boss")){
            return new boss();
        }else if(name.equals("Goro")){
            return new boss();
        }
        return null;
    }
}
