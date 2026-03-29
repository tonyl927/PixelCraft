public class ARGB {

    public int alpha, red, green, blue;

    public ARGB(int pixel) {
        this.alpha = (pixel >> 24) & 255;
        this.red = (pixel >> 16) & 255;
        this.green = (pixel >> 8) & 255;
        this.blue = pixel & 255;
    }

    public ARGB(int a, int r, int g, int b) {
        this.alpha = a;
        this.red = r;
        this.green = g;
        this.blue = b;
    }

    public int toInt() {
        return (alpha << 24) | (red << 16) | (green << 8) | blue;
    }
}
