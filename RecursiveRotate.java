import java.awt.image.BufferedImage;

public class RecursiveRotate extends Converter {
    
    @Override
    protected void processImage(BufferedImage input, BufferedImage output) {
        processRecursive(input, output, 0);
    }

    private void processRecursive(BufferedImage input, BufferedImage output, int index) {

        int width = input.getWidth();
        int height = input.getHeight();

        // base case
        if (index >= width * height)
            return;

        // convert index -> (x, y)
        int x = index % width;
        int y = index / width;

        int pixel = input.getRGB(x, y);

        // rotate 90° clockwise
        output.setRGB(height - 1 - y, x, pixel);

        // recurse
        processRecursive(input, output, index + 1);
    }
}
