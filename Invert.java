import java.awt.image.BufferedImage;

public class Invert extends Converter {

    @Override
    protected void processImage(BufferedImage input, BufferedImage output) {

        int width = input.getWidth();
        int height = input.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                int pixel = input.getRGB(x, y);
                ARGB color = new ARGB(pixel);

                int r = 255 - color.red;
                int g = 255 - color.green;
                int b = 255 - color.blue;

                ARGB newColor = new ARGB(color.alpha, r, g, b);
                output.setRGB(x, y, newColor.toInt());
            }
        }
    }
}

