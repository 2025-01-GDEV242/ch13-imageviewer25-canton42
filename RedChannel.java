import java.awt.Color;

/**
 * An image filter that removes color from an image, but high red pixel values 
 * appear lighter in color.
 *
 * @author Nolan Canto
 * @version 2025.04.21
 */
public class RedChannel extends Filter
{
    /**
     * Constructor for objects of class RedChannel Filter.
     * @param name The name of the filter.
     */
    public RedChannel(String name)
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
                int redPixelVal = pix.getRed();
                image.setPixel(x, y, new Color(redPixelVal, redPixelVal, redPixelVal));
            }
        }
    }
}
