package Color;

public class Color {

    float red;
    float green;
    float blue;

    public Color(float red, float green, float blue) {
        setRed(red);
        setGreen(green);
        setBlue(blue);
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
