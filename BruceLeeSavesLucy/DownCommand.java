/**
 * Write a description of class DownCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DownCommand extends BaseCommand
{
    public DownCommand(IKeyCommandReceiver r){
        super(r);
    }
    public void execute(){
        if(!this.receiver.executeDownKey()){
            IKeyCommandReceiver r = receiver.getKeyCommandReceiverSuccessor();
            if(r!=null)
                r.executeDownKey();
        }
    }
}
