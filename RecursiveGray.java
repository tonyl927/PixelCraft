import java.awt.image.BufferedImage;

public class RecursiveGray extends Converter {

    @Override
    protected void processImage(BufferedImage input, BufferedImage output) {
        processRecursive(input, output, 0);
    }

    private void processRecursive(BufferedImage input, BufferedImage output, int index) {

        int width = input.getWidth();
        int height = input.getHeight();

        int total = width * height;

        // the base case
        if (index >= total)
            return;

        // convert index -> (x, y)
        int x = index % width;
        int y = index / width;
        int pixel = input.getRGB(x, y);
        ARGB color = new ARGB(pixel);

        int gray = (color.red + color.green + color.blue) / 3;

        ARGB newColor = new ARGB(color.alpha, gray, gray, gray);
        output.setRGB(x, y, newColor.toInt());

        // next pixel
        processRecursive(input, output, index + 1);

    }
}
