/**
 * Write a description of class ISubject here.
 * 
 * @author (Ming Tang) 
 * @version (a version number or a date)
 */
public interface ISubject  
{
    public void attachObserver(IObserver ob);
    public void detachObserver();
    public void notifyObserver();
    public String getName();
}
