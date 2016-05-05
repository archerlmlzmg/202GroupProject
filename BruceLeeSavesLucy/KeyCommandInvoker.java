import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KeyCommandInvoker here.
 * 
 * @author (Ming Tang) 
 * @version (a version number or a date)
 */
public class KeyCommandInvoker
{
    private IKeyCommand leftCommand,rightCommand,upCommand,downCommand,aCommand,sCommand,enterCommand;
    /**
     * Act - do whatever the KeyCommandInvoker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */ 
    public void setCommandReceiver(IKeyCommandReceiver r){
        leftCommand = new LeftCommand(r);
        rightCommand = new RightCommand(r);
        upCommand = new UpCommand(r);
        downCommand = new DownCommand(r);
        aCommand = new ACommand(r);
        sCommand = new SCommand(r);
        enterCommand = new EnterCommand(r);
    }
    public void checkKeyPress(){
        if(Greenfoot.isKeyDown("right")){
            rightCommand.execute();
        }else if(Greenfoot.isKeyDown("left")){
            leftCommand.execute();
        }else if(Greenfoot.isKeyDown("up")){
            upCommand.execute();
        }else if(Greenfoot.isKeyDown("down")){
            downCommand.execute();
        }else if(Greenfoot.isKeyDown("a")){
            aCommand.execute();
        }else if(Greenfoot.isKeyDown("s")){
            sCommand.execute();
        }else if(Greenfoot.isKeyDown("enter")){
            enterCommand.execute();
        }
    }
}
