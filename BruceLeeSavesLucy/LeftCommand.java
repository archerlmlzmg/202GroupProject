/**
 * Write a description of class LeftCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LeftCommand extends BaseCommand
{
    public LeftCommand(IKeyCommandReceiver r){
       super(r);
    }
    public void execute(){
        super.execute();
        if(!this.receiver.executeLeftKey()){
            IKeyCommandReceiver r = receiver.getKeyCommandReceiverSuccessor();
            if(r!=null)
                r.executeLeftKey();
        }
    }
}
