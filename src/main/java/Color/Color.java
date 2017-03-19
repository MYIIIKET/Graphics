package Color;

public class Color {

    private float red;
    private float green;
    private float blue;
    private static final int base = 255;


    public Color(int red, int green, int blue) {
        if (red > base) {
            red = red % base;
        }
        if (green > base) {
            green = green % base;
        }
        if (blue > base) {
            blue = blue % base;
        }
        setRed((float) red / 255);
        setGreen((float) green / 255);
        setBlue((float) blue / 255);
    }

    public float getRed() {
        return red;
    }

    public float getGreen() {
        return green;
    }

    public float getBlue() {
        return blue;
    }

    public void setRed(float red) {
        this.red = red;
    }

    public void setGreen(float green) {
        this.green = green;
    }

    public void setBlue(float blue) {
        this.blue = blue;
    }
}
