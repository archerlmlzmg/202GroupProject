/**
 * Write a description of class RightCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RightCommand extends BaseCommand
{
    public RightCommand(IKeyCommandReceiver r){
        super(r);
    }
    public void execute(){
        super.execute();
        if(!this.receiver.executeRightKey()){
            IKeyCommandReceiver r = receiver.getKeyCommandReceiverSuccessor();
            if(r!=null)
                r.executeRightKey();
        }
    }
}
