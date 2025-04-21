import java.awt.Color;

/**
 * An image filter that pixelates the image and applies a green
 * color palette similar to that seen on the original Gameboy. 
 *
 * @author Nolan Canto
 * @version 2025.04.21
 */
public class GameboyDmg extends Filter
{
    /**
     * Constructor for objects of class GameboyDmg Filter.
     * @param name The name of the filter.
     */
    public GameboyDmg(String name)
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
                Color dmgColor = getDmgColor(gray);
                
                for(int dy = y; dy < y + PIXEL_SIZE; dy++) {
                    for(int dx = x; dx < x + PIXEL_SIZE; dx++) {
                        if( dx < width && dy < height )
                            image.setPixel(dx, dy, dmgColor);
                    }
                }
            }
        }
    }
    
    /**
     * getDmgColor gets a color pallete similar to what the Gameboy had.
     * 
     * @param brightness the brightness of the image
     * @return new color
     */
    public Color getDmgColor(int brightness) {
        if (brightness > 192)
            return new Color(155, 188, 15); 
        else if (brightness > 128)
            return new Color(139, 172, 15); 
        else if (brightness > 64)
            return new Color(48, 98, 48);   
        else
            return new Color(15, 56, 15);  
    }
}
