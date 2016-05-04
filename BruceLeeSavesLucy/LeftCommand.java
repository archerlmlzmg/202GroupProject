/**
 * Write a description of class LeftCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LeftCommand implements IKeyCommand
{
    private Scenario receiver;
    public LeftCommand(Scenario r){
        this.receiver = r;
    }
    public void execute(){
        if(!receiver.executeLeftKey())
            receiver.getCommandSuccessor().executeLeftKey();
    }
}
