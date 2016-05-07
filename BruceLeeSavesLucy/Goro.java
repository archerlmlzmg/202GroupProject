import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goro extends Figure implements IFighter, IGangster
{
  
    int current_motion_index = 0;
    int moveSpeed = 6;
    int moveVariable = 0;
    int moveStepLength = 3;
    private boolean opening = true;
    public GreenfootImage[] openingSet, punchSet, hitSet, crushSet;
    private BruceLee bruce;
    private boolean isHit = false;
    private boolean death = false;
    private boolean finishing = false;
      
    
    public Goro()
    {
         openingSet = new GreenfootImage[15];
         for (int i = 0; i < openingSet.length; i++)
        {
            int m = i + 1;
            
            GreenfootImage img = new GreenfootImage("Gorosprite_f" + m + ".gif");
          //  System.out.println("Gorosprite x is: " + img.getWidth() + "Gorosprite y is: " + img.getHeight());
            img.scale(img.getWidth() - 100, img.getHeight() - 143);
            openingSet[i] = img;
           
        }
        
        walk2LeftSet = new GreenfootImage[6];
        for (int i = 0; i < walk2LeftSet.length; i++)
        {
                 
            GreenfootImage img = new GreenfootImage("goroRunLeft_" + i +".gif");
            walk2LeftSet[i] = img;
           
        }
        
        walk2RightSet = new GreenfootImage[6];
        for (int i = 0; i < walk2RightSet.length; i++)
        {
                 
            GreenfootImage img = new GreenfootImage("Gororun_" + i +".gif");
            walk2RightSet[i] = img;
           
        }
        
        punchSet = new GreenfootImage[10];
        for (int i = 0; i < punchSet.length; i++)
        {
            
            GreenfootImage img = new GreenfootImage("goroPunchToLeft_" + i +".gif");
            img.scale(img.getWidth() - 120,img.getHeight() - 160);
            punchSet[i] = img;
           
        }
        
        hitSet = new GreenfootImage[7];
        for(int i = 0; i < hitSet.length; i++)
        {
            GreenfootImage img = new GreenfootImage("gorolefthit" + i + ".png");
            hitSet[i] = img;
        }
        
        crushSet = new GreenfootImage[8];
        for(int i = 0; i < crushSet.length; i++)
        {
            GreenfootImage img = new GreenfootImage("rightblood" + i + ".png");
            crushSet[i]=img;
        }
        
        this.currentMotionSet = openingSet;
        this.setCurrentPose(Figure.POSE_STAND);
  /*      for(int i = 0; i < 7; i++)
        {  
            Blood[i] = new GreenfootImage("rightblood" + i +".png");
        }
     
        for(int i = 0; i < 6; i++)
        {
            Left[i] = new GreenfootImage("goroRunLeft_" + i +".gif");
            Right[i] = new GreenfootImage("Gororun_" + i +".gif");
            DRight[i] = new GreenfootImage("Gororighthit_" + i +".gif");
            DLeft[i] = new GreenfootImage("Gororighthit_" + i +".gif");
        }
        
        for(int i = 0; i < 10; i++){
            PRight[i] = new GreenfootImage("goroPunchToRight_" + i +".gif");
            PLeft[i] = new GreenfootImage("goroPunchToLeft_" + i +".gif"); 
        }*/
    this.setName("Goro");
    }
      
    /**
     * Act - do whatever the Goro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    /*    move();
        bruceLee();
        death(die);
        */
       goroShowup();
       goroHitted();
       if(this.getIsDying()){
           die();
        }
    }
    
    private void goroShowup(){
       if (opening)
        {
            goroInit();
        }
        else
        {
            lookForMainCharacter();
        }
    }
    
    public void goroInit()
    {
        
        for(int i=0; i<15; i++){
            if(moveVariable < moveSpeed){
                moveVariable++;
                return;
            }else{
                moveVariable = 0;
            }
            
            if(current_motion_index >= currentMotionSet.length) {
                    current_motion_index = 0;
            }
                    setImage(currentMotionSet[current_motion_index]); 
            if(current_motion_index == currentMotionSet.length - 1){
                    current_motion_index = 0;
            }else{
                    current_motion_index++;
            }
            if(current_motion_index>=14){
                opening = false;  
                break;
            }
        }
    } 
    
    
    public void runToMainCharacter(){
        if(moveVariable < moveSpeed){
            moveVariable++;
            return;
        }else{
            moveVariable = 0;
        }
        
        //step to next motion
        this.currentMotionSet = walk2LeftSet;
        if(current_motion_index >= currentMotionSet.length)
        {
            current_motion_index = 0;
        }
        setImage(currentMotionSet[current_motion_index]);
        if(current_motion_index == currentMotionSet.length - 1)
        {
            current_motion_index = 0;
        }
        else
        {
            current_motion_index++;
            setLocation(this.getX()-moveStepLength,this.getY());
        }
    }
    
    public void runAwayMainCharacter()
    {
        if(moveVariable < moveSpeed)
        {
            moveVariable++;
            return;
        }
        else
        {
            moveVariable = 0;
        }
        //step to next motion
        this.currentMotionSet = walk2RightSet;
        if(current_motion_index >= currentMotionSet.length)
        {
            current_motion_index = 0;
        }
        setImage(currentMotionSet[current_motion_index]);
        if(current_motion_index == currentMotionSet.length - 1)
        {
            current_motion_index = 0;
        }
        else
        {
            current_motion_index++;
            setLocation(this.getX()+moveStepLength,this.getY());
        }
    }
    
    public void lookForMainCharacter(){
    
        setLocation(this.getX(),390);
        if(bruce == null)
        {
           bruce = this.getWorld().getObjects(BruceLee.class).get(0);
        }
        
        if (this.getX() < 400) this.setDirection(0);
        if (this.getX() > 690) this.setDirection(1);
        
        if (this.getDirection() == 1)
        {
            if (this.getX() > bruce.getX() + 70)
            {
                runToMainCharacter(); 
            }
            else
            {
                punch();
            }
        }
        else
        {
            if (this.getX() > bruce.getX() + 70)
            {
                runAwayMainCharacter(); 
            }
            else
            {
                punch();
            }
        }
    }
    
    public void onAttacked(int damage){
    
        isHit = true;       
        setCurrentHP(getCurrentHP()-damage+getDefencePoint());
        this.notifyObserver();
        if(getCurrentHP()<=0){
            death=true;
            setIsDying(true);
            System.out.println("Gore is dying......");
            die();
        }
    }
    
    public int punch(){
        if(moveVariable < moveSpeed){
            moveVariable++;
            return 0;
        }else{
            moveVariable = 0;
        }
        //step to next motion
        this.currentMotionSet = punchSet;
        if(current_motion_index >= currentMotionSet.length){
            current_motion_index = 0;
        }
        setImage(currentMotionSet[current_motion_index]);
        if(current_motion_index == currentMotionSet.length - 1){
            current_motion_index = 0;
            Greenfoot.playSound("punch.mp3");
            
            bruce = (BruceLee) getOneIntersectingObject(BruceLee.class);  
            if(bruce != null){
                bruce.onAttacked(getAttackPoint());
            }
        }else{
            current_motion_index++;
            setLocation(this.getX(),this.getY());
        }
        
        return 0;
    }
    
    
    private void goroHitted(){
        if(isHit){
            hit();
            isHit = false;
        }
    }
    
    
    /**
    * This method hit, It checks if goro is attacked.
    */   
    public void hit()
    {
        //step to next motion
        System.out.println("Enter goro's hit function");
        this.currentMotionSet = hitSet;
        System.out.println("hitSet length is: " + hitSet.length);
        for(int i= 0; i < hitSet.length; i++){
            Greenfoot.delay(2);
            if(current_motion_index >= currentMotionSet.length)
            {
                current_motion_index = 0;
            }
            setImage(currentMotionSet[current_motion_index]);
            if(current_motion_index == currentMotionSet.length - 1)
            {
                current_motion_index = 0;
            }
            else
            {
                current_motion_index++;
                setLocation(this.getX(),this.getY());
            }
        }
    }
    
    
     /**
    * This method death, It checks to see if the damage to goro is
    *                    above 6 hits, and calls to GoroExploding.
    */
    public void die()
    { 
       //Greenfoot.delay(5);
        if(!finishing){
            crush();
            //JOptionPane.showMessageDialog(null, "Game Over! Bruce Lee saved Lucy!");
        }else{
            //getWorld().removeObject(this);
            finishing=true;
            if(!getIsDied()){
                setIsDied(true);
                System.out.println("boss is died...............");
            }
        }
    }
    
    private void crush(){
        for(int i=0; i<8; i++)
        {
            //step to next motion
            this.currentMotionSet = crushSet;
            if(current_motion_index >= currentMotionSet.length)
            {
                current_motion_index = 0;
            }
            setImage(currentMotionSet[current_motion_index]);
            if(current_motion_index == currentMotionSet.length - 1)
            {
                current_motion_index = 0;
            }
            else
            {
                current_motion_index++;
                Greenfoot.delay(5);
                setLocation(this.getX(),this.getY());
            }
            if (current_motion_index >= 2)
                {  
                    finishing=true;
                    break;
                }
        }
    }
    
    public int kick(){
        return 0;
    }
    public int defend(){
        return 0;
    }

}
