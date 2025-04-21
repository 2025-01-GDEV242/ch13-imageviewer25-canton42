import java.awt.Color;

/**
 * Write a description of class BlueChannel here.
 *
 * @author Nolan Canto
 * @version 2025.04.21
 */
public class BlueChannel extends Filter
{
    /**
     * Constructor for objects of class BlueChannel Filter.
     * @param name The name of the filter.
     */
    public BlueChannel(String name)
    {
        super(name);
    }

    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pix = image.getPixel(x, y);
                int bluePixelVal = pix.getBlue();
                image.setPixel(x, y, new Color(bluePixelVal, bluePixelVal, bluePixelVal));
            }
        }
    }
}
