import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    private int barWidth = 100;
    private int barHeight = 10;
    private int breakPercent = 20; // where to indicate the character is in low hp
    private int breakValue = 20;
    private boolean usingBreakValue = false;
    private boolean breakLow = true;
    private Color safeColor = Color.GREEN;
    private Color dangerColor = Color.RED;
    private Color transColor = Color.YELLOW;
    private Color backgroundColor = new Color(0, 0, 0, 0);
    private Color textColor = Color.BLACK;
    private int value = 0; // current bar value
    private int maxValue = 0;
    private int minValue = 0;
    
    public HealthBar(int initValue, int maximumValue)
    {
        maxValue = maximumValue;
        add(initValue);
    }
    
    public void add (int number)
    {
        value += number;
        //checkValue();
        barImage();
    }
    
    private void barImage()
    {
        int barValue = (int) (barWidth * (value - minValue) / (maxValue - minValue));
        GreenfootImage barImg = new GreenfootImage(barWidth + 4, barHeight + 4);
        barImg.setColor(backgroundColor);
        barImg.fill();
        barImg.setColor(textColor);
        barImg.drawRect(0, 0, barImg.getWidth() - 1, barImg.getHeight() - 1);
        
        if (value > minValue)
        {
            if (breakLow)
            {
                if (value > (usingBreakValue ? breakValue : (int) (breakPercent * (maxValue - minValue) / 100 + minValue))) barImg.setColor(safeColor);
                else barImg.setColor(dangerColor);
            }
            else
            {
                if (value < (usingBreakValue ? breakValue : (int) (breakPercent * (maxValue - minValue) / 100 + minValue))) barImg.setColor(safeColor);
                else barImg.setColor(dangerColor);
            }
            if (value == (usingBreakValue ? breakValue : (int) (breakPercent * (maxValue - minValue) / 100 + minValue)))
            {
                int r = (int) ((safeColor.getRed() + dangerColor.getRed()) / 2);
                int g = (int) ((safeColor.getGreen() + dangerColor.getGreen()) / 2);
                int b = (int) ((safeColor.getBlue() + dangerColor.getBlue()) / 2);
                barImg.setColor(new Color(r, g, b));
            }
            barImg.fillRect(2, 2, barValue, barHeight);
        }
        int sumX = barImg.getWidth();
        int maxY = 0;
        //if (barImg.getHeight() > maxY) maxY = barImg.getHeight();
        GreenfootImage image = new GreenfootImage(sumX, maxY);
        image.setColor(backgroundColor);
        image.fill();
        setImage(image);
    }
    
    public int getValue()
    {
        return value;
    }
    
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
       
    }    
}
