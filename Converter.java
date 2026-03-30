
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Converter {

    public void convert(String inputFileName, String outputFileName) throws IOException {
        // This method should be overridden by subclasses to implement specific conversion logic.
        // For example, a GrayScale converter would read the input image, convert it to grayscale, and save it as the output image.

        BufferedImage inputImage = ImageIO.read(new File(inputFileName));

        int width = inputImage.getWidth();
        int height = inputImage.getHeight();

        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        processImage(inputImage, outputImage);

        ImageIO.write(outputImage, "PNG", new File(outputFileName));

    }

    protected abstract void processImage(BufferedImage input, BufferedImage output);
}


