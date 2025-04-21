import java.awt.Color;

/**
 * An image filter that pixelates the image and applies a grey
 * color palette similar to that seen on the Gameboy Pocket. 
 *
 * @author Nolan Canto
 * @version 2025.04.21
 */
public class GameboyPocket extends Filter
{
    /**
     * Constructor for objects of class GameboyPocket Filter.
     * @param name The name of the filter.
     */
    public GameboyPocket(String name)
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
        final int PIXEL_SIZE = 5;
        int width = image.getWidth();
        int height = image.getHeight();
        
        for(int y = 0; y < height; y += PIXEL_SIZE) {
            for(int x = 0; x < width; x += PIXEL_SIZE) {
                Color pix = image.getPixel(x, y);
                int gray = (int)((pix.getRed() + pix.getGreen() + pix.getBlue()) / 3.0);
                Color pocketColor = getPocketColor(gray);
                
                for(int dy = y; dy < y + PIXEL_SIZE; dy++) {
                    for(int dx = x; dx < x + PIXEL_SIZE; dx++) {
                        if( dx < width && dy < height )
                            image.setPixel(dx, dy, pocketColor);
                    }
                }
            }
        }
    }
    
    /**
     * getPocketColor gets a color pallete similar to what the Gameboy Pocket had.
     * 
     * @param brightness the brightness of the image
     * @return new color
     */
    public Color getPocketColor(int brightness) {
        if (brightness > 192)
            return new Color(196, 207, 161); 
        else if (brightness > 128)
            return new Color(139, 149, 109); 
        else if (brightness > 64)
            return new Color(77, 83, 60);   
        else
            return new Color(31, 31, 31);
    }
}
