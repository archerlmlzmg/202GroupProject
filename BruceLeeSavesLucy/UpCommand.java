/**
 * Write a description of class UpCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UpCommand implements IKeyCommand
{
    private Scenario receiver;
    public UpCommand(Scenario r){
        this.receiver = r;
    }
    public void execute(){
        if(!receiver.executeUpKey())
            receiver.getCommandSuccessor().executeUpKey();
    }
}
