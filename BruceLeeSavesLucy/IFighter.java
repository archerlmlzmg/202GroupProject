/**
 * this is the interface for all the figures that can fight in the game
 * it includes the basic attack movement
 * 
 * @author (Ming Tang) 
 * @version (a version number or a date)
 */
public interface IFighter  
{
    public int punch();
    public int kick();
    /**
     * when this method is being used, the damage will be weakened
     */
    public int defend();
    /*
     * when a figure is attected by someone, this method will be called, and given the certain damage every
     * time when this figure is attacked.
     */
    public void onAttacked(int damage);
    public void die();
    public boolean getIsDied();
    public boolean getIsDying();
}
