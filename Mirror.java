import java.awt.image.BufferedImage;

public class Mirror extends Converter {

    @Override
    protected void processImage(BufferedImage input, BufferedImage output) {

        int width = input.getWidth();
        int height = input.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                int pixel = input.getRGB(x, y);

                // flip horizontally
                output.setRGB(width - 1 - x, y, pixel);
            }
        }
    }
}
