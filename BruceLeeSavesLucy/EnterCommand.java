/**
 * Write a description of class EnterCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnterCommand extends BaseCommand
{
    public EnterCommand(IKeyCommandReceiver r){
        super(r);
    }
    public void execute(){
        if(!this.receiver.executeEnterKey()){
            IKeyCommandReceiver r = receiver.getKeyCommandReceiverSuccessor();
            if(r!=null)
                r.executeEnterKey();
        }
    }
}
