import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.HashMap; 
import java.util.Collections;
/**
 * Write a description of class BaseFloor here.
 * 
 * @author (Ming Tang) 
 * @version (a version number or a date)
 */
public class BaseFloor extends World implements IKeyCommandReceiver,IScenarioTemplate
{
    ArrayList<IFighter> gangsters = new ArrayList<>();
    IFighter mainCharacter;
    int gameTime;
    String scenarioName;
    private IKeyCommandReceiver commandSuccessor;
    boolean hasTakenOverKeyCommand = false;
    HashMap<Actor,int[]> objectsLocationMap = new HashMap<Actor,int[]>();
    World world;
    GangsterFactory gangsterFactory  = new GangsterFactory();
    static final int horizonLine = 350;
    static final int activeAreaXLeft = 10;
    static final int activeAreaXRight = 700;
    static final int activeAreaYTop = 10;
    static final int activeAreaYBottom = 500;
    static final int worldWidth = 800;
    static final int worldHeight = 500;
    boolean isInitiated = false,
    isGameStarted = false;
    boolean isPaused = false, isOver = false;
    KeyCommandInvoker keyCommandInvoker = new KeyCommandInvoker();
    Window window = new Window();
    ResumeButton resumeBtn = new ResumeButton();
    ExitButton exitBtn = new ExitButton();
    Pointer pointer = new Pointer();
    Transition nextTransition;
    int[] pointerPos1 = new int[]{340,250},
        pointerPos2 = new int[]{340,322};
    int menuIndex = 1;
    /**
     * Constructor for objects of class BaseFloor.
     * 
     */
    public BaseFloor(IFighter mainCharacter, Transition nextTransition)
    {    
        super(worldWidth, worldHeight, 1); 
        this.mainCharacter = mainCharacter;
        keyCommandInvoker.setCommandReceiver(this);
        this.addKeyCommandReceiverSuccessor((IKeyCommandReceiver)mainCharacter);
        this.nextTransition = nextTransition;
    }
    public void act(){
        if(!isInitiated){
            onCreate();
        }
        onAct();
        
    }
    public void initElementsToWorld(){
        System.out.println("This floor has ["+this.objectsLocationMap.size()+"] actors");
        for(Actor o : this.objectsLocationMap.keySet()){
            int[] location = objectsLocationMap.get(o);
            System.out.println("add an object x:"+location[0]+", "+location[1]);
            this.addObject(o,location[0],location[1]);
        }
        this.isInitiated = true;
        onStart();
    }

 
    public ArrayList<IFighter> getGangsters(){
        return this.gangsters;
    }
    
    public boolean executeLeftKey(){
        if(hasTakenOverKeyCommand){
            //handle command
            return true;
        }else{
            return false;
        }
    }
    public boolean executeRightKey(){
        if(hasTakenOverKeyCommand){
            //handle command
            return true;
        }else{
            return false;
        }
    }
    public boolean executeUpKey(){
        if(hasTakenOverKeyCommand){
            //handle command
            if(isPaused){
                pointer.setLocation(pointerPos1[0],pointerPos1[1]);
                menuIndex = 1;
            }
            return true;
        }else{
            return false;
        }
    }
    public boolean executeDownKey(){
        if(hasTakenOverKeyCommand){
            //handle command
            if(isPaused){
                pointer.setLocation(pointerPos2[0],pointerPos2[1]);
                menuIndex = 2;
            }
            return true;
        }else{
            return false;
        }
    }
    public boolean executeAKey(){
        if(hasTakenOverKeyCommand){
            //handle command
            return true;
        }else{
            System.out.println("pass key A");
            return false;
        }
    }
    public boolean executeSKey(){
        if(hasTakenOverKeyCommand){
            //handle command
            System.out.println("pass key B");
            return true;
        }else{
            return false;
        }
    }
    // always takes over this key event 
    public boolean executeEnterKey(){
            if(isGameStarted &&!isPaused){
             onPause();
            }else if(isPaused && hasTakenOverKeyCommand){
                if(menuIndex == 1){ // resume
                    hasTakenOverKeyCommand = false;
                    isPaused = false;
                    closePauseWindow();
                }else{
                    Greenfoot.setWorld(new Menu());
                }
            }
            return true;
    }    
    public IKeyCommandReceiver getKeyCommandReceiverSuccessor(){
        return this.commandSuccessor;
    };
    public void addKeyCommandReceiverSuccessor(IKeyCommandReceiver rec){
        this.commandSuccessor = rec;
    };
    public void removeKeyCommandReceiverSuccessor(){
        this.commandSuccessor = null;
    };
    public void onCreate(){
        initElementsToWorld();
    } 
    public void onStart(){
        // pass the key control to main character
        this.hasTakenOverKeyCommand = false;
        this.isGameStarted = true;
    }
    public void onAct(){
        if(isOver)
            return;
        keyCommandInvoker.checkKeyPress();
        checkMouseClick();
    }
    public void onPause(){
        isPaused = true;
        hasTakenOverKeyCommand = true;
        //add window and buttons
        showPauseWindow();
    }
    private void checkMouseClick(){
        if(Greenfoot.mouseClicked(resumeBtn)){
            executeUpKey();
            executeEnterKey();
            
        }else if (Greenfoot.mouseClicked(exitBtn)){
            executeDownKey();
            executeEnterKey();
        }
    }
    private void showPauseWindow(){
        addObject(window,402,276);
        addObject(resumeBtn,450,250);
        addObject(exitBtn,415,322);
        addObject(pointer,pointerPos1[0],pointerPos1[1]);
    }
    private void closePauseWindow(){
        removeObject(window);
        removeObject(resumeBtn);
        removeObject(exitBtn);
        removeObject(pointer);
    }
    public void onEnd(){
        isOver = true;
        addObject(nextTransition,400,250);
    }
    public boolean isOver(){
        return false;
    }
}
