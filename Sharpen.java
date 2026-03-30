import java.awt.image.BufferedImage;

public class Sharpen extends Converter {
    @Override
    protected void processImage(BufferedImage input, BufferedImage output) {

        int width = input.getWidth();
        int height = input.getHeight();
        
        // copy original image first
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                output.setRGB(x, y, input.getRGB(x, y));
            }
        }

        for (int y = 1; y < height-1; y++) {
            for (int x = 1; x < width-1; x++) {

                int sumR = 0, sumG = 0, sumB = 0;

                for (int j = -1; j <= 1; j++) {
                    for (int i = -1; i <= 1; i++) {
                        int pixel = input.getRGB(x + i, y + j);
                        ARGB c = new ARGB(pixel);

                        sumR += c.red;
                        sumG += c.green;
                        sumB += c.blue;
                    }
                }

                int detailR = sumR/9;
                int detailG = sumG/9;
                int detailB = sumB/9;

                int pixel = input.getRGB(x, y);
                ARGB color = new ARGB(pixel);

                int r = Math.max(0, Math.min(255, color.red + (color.red - detailR)));
                int g = Math.max(0, Math.min(255, color.green + (color.green - detailG)));
                int b = Math.max(0, Math.min(255, color.blue + (color.blue - detailB)));

                ARGB newColor = new ARGB(color.alpha, r, g, b);
                output.setRGB(x, y, newColor.toInt());
            }
        }
    }
}