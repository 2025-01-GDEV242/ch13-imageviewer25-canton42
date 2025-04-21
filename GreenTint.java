import java.awt.Color;

/**
 * An image filter that applies shades of green to an image.
 * 
 * @author Nolan Canto
 * @version 2025.04.21
 */
public class GreenTint extends Filter
{
    /**
     * Constructor for objects of class GreenTint Filter.
     * @param name The name of the filter.
     */
    public GreenTint(String name)
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
                int greenPixelVal = pix.getGreen();
                image.setPixel(x, y, new Color(0, greenPixelVal, 0));
            }
        }
    }
}