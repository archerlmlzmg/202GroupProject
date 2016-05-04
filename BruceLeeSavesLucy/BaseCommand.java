/**
 * Write a description of class BaseCommand here.
 * 
 * @author (Ming Tang) 
 * @version (a version number or a date)
 */
public class BaseCommand implements IKeyCommand
{

    public IKeyCommandReceiver receiver;
    public BaseCommand(IKeyCommandReceiver r){
        this.receiver = r;
    }
    
    public void execute(){
        if(true){
            System.out.println(this.getClass().getName()+" executing...");
        }
    }
}
