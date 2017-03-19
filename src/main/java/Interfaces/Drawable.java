package Interfaces;

public interface Drawable {
    public void draw();

    default public void setColor(float red, float green, float blue) {
    }

    public Drawable setScale(float scale);
}
