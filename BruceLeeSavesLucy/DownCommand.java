/**
 * Write a description of class DownCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DownCommand implements IKeyCommand
{
    private Scenario receiver;
    public DownCommand(Scenario r){
        this.receiver = r;
    }
    public void execute(){
        if(!receiver.executeDownKey())
            receiver.getCommandSuccessor().executeDownKey();
    }
}
