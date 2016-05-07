import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class About here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class About extends World
{

    BackButton backButton;
    Pointer pointer;
    int[] pointerPos1 = new int[]{630,440};
    int menuIndex = 1;
    boolean needsCheckKey = true;
    GreenfootSound musicBackground = new GreenfootSound("menu_bg_m.mp3");
    /**
     * Constructor for objects of class About.
     * 
     */
    public About()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 500, 1); 
        backButton = new BackButton();
        pointer = new Pointer();
        addObject(backButton,714,440);
        addObject(pointer,pointerPos1[0],pointerPos1[1]);
    }
    public void act(){
        if(!musicBackground.isPlaying())
        musicBackground.play();
        if(needsCheckKey){
            checkKeyPress();
            checkMouseClick();
        }
        
    }
    private void checkKeyPress(){
        if(Greenfoot.isKeyDown("enter")){
            System.out.println("enter");
            startNextWorld();
            
        }
    }
        private void checkMouseClick(){
        if(Greenfoot.mouseClicked(backButton)){
            startNextWorld();
        }
    }
    private void startNextWorld(){
        musicBackground.stop();
        needsCheckKey = false;
        Greenfoot.setWorld(new Menu());
    }
}
