import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor implements IObserver
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
    private Color textColor = Color.WHITE;
    private int value = 0; // current bar value
    private int maxValue = 0;
    private int minValue = 0;
    private String referenceText = "";
    private float fontSize = 18.0f;
    private String unitOfMeasure = "";
    private boolean showTextualUnits = true;
    
    /**
     * Bar Constructor: saves the initial values that are brought in and creates the bar image through the 'add(int)' call,
     * which sets the initial value of the bar and calls the 'newImage' method to build and set a new image for the bar.
     *
     * @param 'refText': a text string to specify what the bar is for (be specific enough so that all bars can be distinguished one from another)
     * @param 'unitType': a text string to specify what measure is being used in the bar ("percentage", "points", "frames per second", or whatever)
     * @param 'initValue': the value the bar should be initially set to
     * @param 'maxValue': the highest value the bar is allowed to hold
     */
    public HealthBar(String ref, String unit, int initValue, int maximumValue)
    {
        referenceText = ref;
        unitOfMeasure = unit;
        maxValue = maximumValue;
        add(initValue);
    }
    
    public void add (int number)
    {
        value += number;
        checkValue();
        barImage();
    }
    
    public void subtract (int number)
    {
        value -= number;
        checkValue();
        barImage();
    }
    
    private void checkValue()
    {
        if (value < minValue) value = minValue;
        if (value > maxValue) value = maxValue;
    }
    
    private void barImage()
    {
        int barValue = (int) (barWidth * (value - minValue) / (maxValue - minValue));
        GreenfootImage leftImg = new GreenfootImage(referenceText + " ", (int) fontSize, textColor, backgroundColor);
        GreenfootImage rightImg = (showTextualUnits) ? new GreenfootImage(" " + value + " " + unitOfMeasure, (int) fontSize, textColor, backgroundColor) : new GreenfootImage(1, 1);
        int maxX = (leftImg.getWidth() > rightImg.getWidth()) ? leftImg.getWidth() : rightImg.getWidth();
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
        int sumX = 2 * maxX + barImg.getWidth();
        int maxY = 0;
        if (leftImg.getHeight() > maxY) maxY = leftImg.getHeight();
        if (barImg.getHeight() > maxY) maxY = barImg.getHeight();
        if (rightImg.getHeight() > maxY) maxY = rightImg.getHeight();
        GreenfootImage image = new GreenfootImage(sumX, maxY);
        image.setColor(backgroundColor);
        image.fill();
        image.drawImage(leftImg, maxX - leftImg.getWidth(), (image.getHeight() - leftImg.getHeight()) / 2);
        image.drawImage(barImg, maxX, (image.getHeight() - barImg.getHeight()) / 2);
        image.drawImage(rightImg, maxX + barImg.getWidth(), (image.getHeight() - rightImg.getHeight()) / 2);
        setImage(image);
    }
    
    public int getValue()
    {
        return value;
    }
    
    public int getBarWidth()
    {
        return barWidth;
    }
    
    public int getBarHeight()
    {
        return barHeight;
    }
    
    public int getBreakPercent()
    {
        return breakPercent;
    }
    
    public int getBreakValue()
    {
        return breakValue;
    }
    
    public boolean getBreakLow()
    {
        return breakLow;
    }
    
    public Color getBackgroundColor()
    {
        return backgroundColor;
    }
    
    public Color getTextColor()
    {
        return textColor;
    }
    
    public Color getSafeColor()
    {
        return safeColor;
    }
    
    public Color getDangerColor()
    {
        return dangerColor;
    }
    
    public int getMaxValue()
    {
        return maxValue;
    }
    
    public int getMinValue()
    {
        return minValue;
    }
    
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
       
    }    
    public void update(Figure f){
        //update the figure's state
        //this mehtod will be invoked when a figure calls notifyObserver()
        value = f.getCurrentHP();
        checkValue();
        barImage();
    };
}
