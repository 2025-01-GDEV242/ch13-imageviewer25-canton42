import java.awt.Color;

/**
 * An image filter that applies a filter that imitates Andy Warhol's
 * Marilyn Monroe screenprints.
 *
 * @author Nolan Canto
 * @version 2025.04.21
 */
public class Warhol extends Filter
{
    /**
     * Constructor for objects of class Warhol Filter.
     * @param name The name of the filter.
     */
    public Warhol(String name)
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
        int width = image.getWidth();
        int height = image.getHeight();
        OFImage originalImage = new OFImage(image);
        OFImage warholImage = new OFImage(width, height);

        int halfWidth = width / 2;
        int halfHeight = height / 2;

        for (int y = 0; y < halfHeight; y++) {
            for (int x = 0; x < halfWidth; x++) {
                Color pix = originalImage.getPixel(x * 2, y * 2);
                warholImage.setPixel(x, y, pix);
            }
            
            for (int x = halfWidth; x < width; x++) {
                Color pix = originalImage.getPixel((x - halfWidth) * 2, y * 2);
                int redPixelVal = pix.getRed();
                warholImage.setPixel(x, y, new Color(redPixelVal, 0, 0));
            }
        }

        for (int y = halfHeight; y < height; y++) {
            for (int x = 0; x < halfWidth; x++) {
                Color pix = originalImage.getPixel(x * 2, (y - halfHeight) * 2);
                int greenPixelVal = pix.getGreen();
                warholImage.setPixel(x, y, new Color(0, greenPixelVal, 0));
            }
 
            for (int x = halfWidth; x < width; x++) {
                Color pix = originalImage.getPixel((x - halfWidth) * 2, (y - halfHeight) * 2);
                int bluePixelVal = pix.getBlue();
                warholImage.setPixel(x, y, new Color(0, 0, bluePixelVal));
            }
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                image.setPixel(x, y, warholImage.getPixel(x, y));
            }
        }
    }
}
