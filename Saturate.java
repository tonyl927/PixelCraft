import java.awt.image.BufferedImage;

public class Saturate extends Converter {

    @Override
    protected void processImage(BufferedImage input, BufferedImage output) {

        int width = input.getWidth();
        int height = input.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                int pixel = input.getRGB(x, y);
                ARGB color = new ARGB(pixel);

                int r = color.red;
                int g = color.green;
                int b = color.blue;

                if (r >= g && r >= b) {
                    r = Math.min(255, (int)(r * 1.5));
                } else if (g >= r && g >= b) {
                    g = Math.min(255, (int)(g * 1.5));
                } else {
                    b = Math.min(255, (int)(b * 1.5));
                }

                ARGB newColor = new ARGB(color.alpha, r, g, b);
                output.setRGB(x, y, newColor.toInt());
            }
        }
    }
}