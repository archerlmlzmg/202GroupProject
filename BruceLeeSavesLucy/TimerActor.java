import greenfoot.*;
public class TimerActor extends Actor {
    private boolean running = false, isSuspended = false, isTimeUp= false;
    private int millisElapsed = 1000*60*3;//*3;
    private long lastTime = 0;
    private int amount = 1000*60*3;;
    boolean isAddedToWorld = false;
    public void addedToWorld(World world){
        isAddedToWorld = true;
    }
    public TimerActor() {
        updateImage();
    }
    
    public void start() {
        millisElapsed = amount;
        lastTime = 0;
        running = true;
    }
    
    public void gamePaused() {
        lastTime = 0;
    }
    public void pause(){
        this.isSuspended = true;
    }
    public void resume(){
        this.isSuspended = false;
    }
    public void setAmount(int time){
        this.amount = time;
    }
    public boolean getIsTimeUp(){
        System.out.println("time left:"+millisElapsed+this.isTimeUp);
        return this.isTimeUp;
    }
    public void act() {
        if(!running || isTimeUp)
            return;
        long time = System.currentTimeMillis();
        if(lastTime != 0) {
            long diff = time - lastTime;
            if(!isSuspended){
                millisElapsed -= diff;
                if(millisElapsed <= 0){
                   System.out.println("=======================>time is up.");
                   isTimeUp = true;
                   millisElapsed = 0;
                }
            }
        }
        lastTime = time;
        
        updateImage();
    
    }
    
    public void updateImage() {
        
        System.out.println("update time..");
        // Calculate minutes & seconds elapsed
        int millis = millisElapsed % 1000;
        int secs = (millisElapsed / 1000) % 60;
        int mins = millisElapsed / 60000;
        // Convert these into text
        String millisText = String.format("%02d", millis);
        String secsText = String.format("%02d", secs);
        String minsText = "" + mins;
        String text = minsText + ":" + secsText+"."+millisText;
        // Update the image
        GreenfootImage img ;
        if(millisElapsed >= 1000*30)
            img= new GreenfootImage(text, 25, java.awt.Color.WHITE, java.awt.Color.BLACK);
        else
            img= new GreenfootImage(text, 25, java.awt.Color.RED, java.awt.Color.BLACK);
        setImage(img);
    }
}
