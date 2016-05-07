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
        needsCheckKey = false;
        Greenfoot.setWorld(new Menu());
    }
}
