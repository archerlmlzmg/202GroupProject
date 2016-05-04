/**
 * Write a description of class SCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SCommand extends BaseCommand
{
    public SCommand(IKeyCommandReceiver r){
        super(r);
    }
    public void execute(){
        super.execute();
        if(!this.receiver.executeSKey()){
            IKeyCommandReceiver r = receiver.getKeyCommandReceiverSuccessor();
            if(r!=null)
                r.executeSKey();
        }
    }
}
