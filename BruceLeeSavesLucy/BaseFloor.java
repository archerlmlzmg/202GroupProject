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
    FighterFactory fighterFactory  = new FighterFactory();
    static final int horizonLine = 350;
    static final int activeAreaXLeft = 10;
    static final int activeAreaXRight = 700;
    static final int activeAreaYTop = 10;
    static final int activeAreaYBottom = 500;
    static final int worldWidth = 800;
    static final int worldHeight = 500;
    boolean isInitiated = false,
    isGameStarted = false,
    isPaused = false,
    isOver = false,// fighting is over, but the game is ongoing
    isStopped = false, 
    isEnded = false,
    isMainCharacterWon = false;
    KeyCommandInvoker keyCommandInvoker = new KeyCommandInvoker();
    Window window = new Window();
    ResumeButton resumeBtn = new ResumeButton();
    ExitButton exitBtn = new ExitButton();
    Pointer pointer = new Pointer();
    StateTransition nextTransition;
    int[] pointerPos1 = new int[]{340,250},
        pointerPos2 = new int[]{340,322};
    int menuIndex = 1;
    TimerActor timer = new TimerActor();
    GreenfootSound musicBackground = new GreenfootSound("floor1_m.mp3");
    /**
     * Constructor for objects of class BaseFloor.
     * 
     */
    public BaseFloor(IFighter mainCharacter, StateTransition transition)
    {    
        super(worldWidth, worldHeight, 1); 
        this.mainCharacter = mainCharacter;
        keyCommandInvoker.setCommandReceiver(this);
        this.addKeyCommandReceiverSuccessor((IKeyCommandReceiver)mainCharacter);
        this.nextTransition = transition;
    }
    public void act(){
        if(!isInitiated){
            onCreate();
        }else
        if(isInitiated && !isGameStarted){
            onStart();
        }else
        if(isGameStarted && !isOver){
            onAct();
        }else
        if(isOver && !isStopped){//fighting is over
            onStop();
        }else
        if(isStopped && !isEnded){
            onEnd();
        }
        
        
    }
    public void initElementsToWorld(){
        System.out.println("This floor has ["+this.objectsLocationMap.size()+"] actors");
        for(Actor o : this.objectsLocationMap.keySet()){
            int[] location = objectsLocationMap.get(o);
            System.out.println("add an object x:"+location[0]+", "+location[1]);
            this.addObject(o,location[0],location[1]);
        }
        this.addObject(timer,400,50);
        this.isInitiated = true;
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
                    timer.resume();
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
        if(!musicBackground.isPlaying()){
            musicBackground.playLoop();
            timer.start();
        }
        // pass the key control to main character
        System.out.println("Starting...");
        this.hasTakenOverKeyCommand = false;
        this.isGameStarted = true;
    }
    public void onAct(){

        //checkTakingOverControl();
        keyCommandInvoker.checkKeyPress();
        checkMouseClick();
        if(checkIsFightingOver())
            isOver = true;
        if(timer.getIsTimeUp()){
            isMainCharacterWon = false;
            isOver = true;
            isStopped = true;
            //nextTransition.goToBackState();
        }    

    }
    public void onPause(){
        isPaused = true;
        hasTakenOverKeyCommand = true;
        timer.pause();
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
        musicBackground.stop();
        System.out.println("its endding....");
        if(isMainCharacterWon && !isEndingMotionOver){
            palyEnding();
        }else{
            addObject(nextTransition,400,250);
            if(isMainCharacterWon)
                nextTransition.goToNextState();
            else
                nextTransition.goToBackState();
            isEnded = true;
        }

    }
    private boolean isPalyingStarted =false,isEndingMotionOver = false;
    private int endX = 790;
    private int endingMovieSpeed = 5;
    
    private void palyEnding(){
        if(!isPalyingStarted){
            //((Actor)mainCharacter).setLocation(objectsLocationMap.get(mainCharacter)[0],objectsLocationMap.get(mainCharacter)[1]);
            this.removeObject((Actor)gangsters.get(0));
            isPalyingStarted = true;
        }
        if(((Actor)mainCharacter).getX()<= endX){
            ((Actor)mainCharacter).setLocation( ((Actor)mainCharacter).getX()+endingMovieSpeed,((Actor)mainCharacter).getY());
        }else{
            isEndingMotionOver = true;
        }
    }
    /*
     * is fighting stopped
     */
    private boolean checkIsFightingOver(){
        System.out.println("==> checkIsFightingOver.....");
        if(mainCharacter.getIsDying()){
            isMainCharacterWon = false;
            return true;
        }
        boolean allGangsterDying = true;
        for(IFighter f : gangsters){
            System.out.println("==>"+((Figure)f).getName()+" is dying?:"+f.getIsDying());
            if (!f.getIsDying()){
                allGangsterDying = false;
            }
        }
        if(allGangsterDying){
            isMainCharacterWon = true;
        }
        return allGangsterDying;
    }
    private boolean checkIsStopped(){
        System.out.println("==>checkIsStopped.....");
        if(mainCharacter.getIsDied()){
            isMainCharacterWon = false;
            return true;
        }
        boolean allGangsterDied = true;
        for(IFighter f : gangsters){
            System.out.println("==>"+((Figure)f).getName()+" is died?:"+f.getIsDied());
            if (!f.getIsDied())
                allGangsterDied = false;
        }
        if(allGangsterDied){
            isMainCharacterWon = true;
        }
        return allGangsterDied;
    }
    public void onStop(){
        if(checkIsStopped())
            isStopped = true;
    }
    public void checkTakingOverControl(){
        if(mainCharacter.getIsDying() || mainCharacter.getIsDied()){
            this.hasTakenOverKeyCommand = true;
        }
        boolean allGangsterDied = false;
        for(IFighter f : gangsters){
            if (!f.getIsDying() || !f.getIsDied()){
                allGangsterDied = false;
            }
        }
        if(allGangsterDied)
            this.hasTakenOverKeyCommand = true;
    }
}
