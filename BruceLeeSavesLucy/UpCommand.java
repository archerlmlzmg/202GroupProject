/**
 * Write a description of class UpCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UpCommand extends BaseCommand
{
    public UpCommand(IKeyCommandReceiver r){
        super(r);
    }
    public void execute(){
        super.execute();
        if(!this.receiver.executeUpKey()){
            IKeyCommandReceiver r = receiver.getKeyCommandReceiverSuccessor();
            if(r!=null)
                r.executeUpKey();
        }
    }
}
