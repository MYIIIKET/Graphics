package Interfaces;

public interface Drawable {
    public void draw();

    default public void setColor(int red, int green, int blue) {
    }

    public Drawable setScale(float scale);
}
