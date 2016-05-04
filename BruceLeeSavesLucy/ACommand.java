/**
 * Write a description of class ACommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ACommand extends BaseCommand
{
    public ACommand(IKeyCommandReceiver r){
        super(r);
    }
    public void execute(){
        super.execute();
        if(!this.receiver.executeAKey()){
            IKeyCommandReceiver r = receiver.getKeyCommandReceiverSuccessor();
            if(r!=null)
                r.executeAKey();
        }
            
    }
}
