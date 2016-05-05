/**
 * Write a description of class IKeyCommandReceiver here.
 * 
 * @author (Ming Tang) 
 * @version (a version number or a date)
 */
public interface IKeyCommandReceiver  
{
    public boolean executeLeftKey();
    public boolean executeRightKey();
    public boolean executeUpKey();
    public boolean executeDownKey();
    public boolean executeAKey();
    public boolean executeSKey();
    public boolean executeEnterKey();
    //composite pattern
    public IKeyCommandReceiver getKeyCommandReceiverSuccessor();
    public void addKeyCommandReceiverSuccessor(IKeyCommandReceiver rec);
    public void removeKeyCommandReceiverSuccessor();
}
