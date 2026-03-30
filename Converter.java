import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class Converter {

    public void convert(String inputFileName, String outputFileName) throws IOException {

        BufferedImage inputImage = ImageIO.read(new File(inputFileName));

        int width = inputImage.getWidth();
        int height = inputImage.getHeight();

        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        processImage(inputImage, outputImage);

        ImageIO.write(outputImage, "PNG", new File(outputFileName));

    }

    protected abstract void processImage(BufferedImage input, BufferedImage output);
}


