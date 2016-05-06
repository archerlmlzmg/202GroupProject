import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    StartButton startButton;
    AboutButton aboutButton;
    Pointer pointer;
    int[] pointerPos1 = new int[]{320,266};
    int[] pointerPos2 = new int[]{320,327};
    int menuIndex = 1;
    boolean needsCheckKey = true;
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 500, 1); 
        startButton = new StartButton();
        aboutButton = new AboutButton();
        pointer = new Pointer();
        addObject(startButton,392,261);
        addObject(aboutButton,405,322);
        addObject(pointer,pointerPos1[0],pointerPos1[1]);
    }
    public void act(){
        if(needsCheckKey){
            checkKeyPress();
            checkMouseClick();
        }
        
    }
    private void checkKeyPress(){
        if(Greenfoot.isKeyDown("up")){
            pointer.setLocation(pointerPos1[0],pointerPos1[1]);
            menuIndex = 1;
        }else if(Greenfoot.isKeyDown("down")){
            pointer.setLocation(pointerPos2[0],pointerPos2[1]);
            menuIndex = 2;
        }else if(Greenfoot.isKeyDown("enter")){
            System.out.println("enter");
            if(menuIndex == 1){
                System.out.println(" new Floor1(new BruceLee())");
                startNextWorld();
            }
        }
    }
        private void checkMouseClick(){
        if(Greenfoot.mouseClicked(startButton)){
            pointer.setLocation(pointerPos1[0],pointerPos1[1]);
            menuIndex = 1;
            startNextWorld();
        }else if (Greenfoot.mouseClicked(aboutButton)){
            pointer.setLocation(pointerPos2[0],pointerPos2[1]);
            menuIndex = 2;
        }
    }
    private void startNextWorld(){
        needsCheckKey = false;
        Menu menu = new Menu();
        Floor3 floor3= new Floor3(new BruceLee(), null);
        StateTransition3 t3= new StateTransition3(menu,floor3); 
        Floor2 floor2 = new Floor2(new BruceLee(),t3);
        StateTransition2 t2= new StateTransition2(menu,floor2); 
        Floor1 floor1 = new Floor1(new BruceLee(),t2);
        StateTransition1 t1 = new StateTransition1(menu,floor1);
        addObject(t1,400,250);
        t1.goToNextState();
    }
}
