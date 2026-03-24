import java.io.IOException;

public class Converter {
    
    
    public Converter(){

    }

    public void convert(String inputFileName, String outputFileName) throws IOException {
        // This method should be overridden by subclasses to implement specific conversion logic.
        // For example, a GrayScale converter would read the input image, convert it to grayscale, and save it as the output image.
    }
}
