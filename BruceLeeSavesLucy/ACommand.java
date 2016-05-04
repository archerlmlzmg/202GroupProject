/**
 * Write a description of class ACommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ACommand implements IKeyCommand
{
    private Scenario receiver;
    public ACommand(Scenario r){
        this.receiver = r;
    }
    public void execute(){
        if(!receiver.executeAKey())
            receiver.getCommandSuccessor().executeAKey();
    }
}
