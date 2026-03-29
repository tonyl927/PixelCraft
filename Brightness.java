import java.awt.image.BufferedImage;

public class Brightness extends Converter {

    @Override
    protected void processImage(BufferedImage input, BufferedImage output) {

        int width = input.getWidth();
        int height = input.getHeight();

        int factor = 40; // increase brightness

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                int pixel = input.getRGB(x, y);
                ARGB color = new ARGB(pixel);

                int r = Math.min(255, color.red + factor);
                int g = Math.min(255, color.green + factor);
                int b = Math.min(255, color.blue + factor);

                ARGB newColor = new ARGB(color.alpha, r, g, b);
                output.setRGB(x, y, newColor.toInt());
            }
        }
    }
}
