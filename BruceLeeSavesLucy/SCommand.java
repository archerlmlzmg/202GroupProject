/**
 * Write a description of class SCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SCommand implements IKeyCommand
{
    private Scenario receiver;
    public SCommand(Scenario r){
        this.receiver = r;
    }
    public void execute(){
        if(!receiver.executeSKey())
            receiver.getCommandSuccessor().executeSKey();
    }
}
