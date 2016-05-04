/**
 * Write a description of class RightCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RightCommand implements KeyCommand
{
    private Scenario receiver;
    public RightCommand(Scenario r){
        this.receiver = r;
    }
    public void execute(){
        receiver.executeLeftKeyPress();
    }
}
