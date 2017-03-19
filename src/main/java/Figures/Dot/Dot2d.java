package Figures.Dot;

import Color.Color;
import Interfaces.Drawable;
import Coordinates.Coord2d;
import org.lwjgl.opengl.GL11;


public class Dot2d implements Drawable {

    private GL11 dot;
    private Coord2d coord;
    private Color color;

    public Dot2d(float x, float y) {
        coord = new Coord2d(x, y);
        color = new Color(0, 0, 0);
    }

    public GL11 getDot() {
        return dot;
    }

    public void setDot(GL11 dot) {
        this.dot = dot;
    }

    public Coord2d getCoord() {
        return coord;
    }

    public void setCoord(Coord2d position) {
        this.coord = position;
    }

    public void setCoord(float x, float y) {
        coord.setX(x);
        coord.setY(y);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void draw() {
        dot.glColor3f(getColor().getRed(), getColor().getGreen(), getColor().getBlue());
        dot.glBegin(GL11.GL_POINTS);
        dot.glVertex2f(coord.getX(), coord.getY());
        dot.glEnd();
    }

    @Override
    public void setColor(int red, int green, int blue) {
        color.setRed(red);
        color.setGreen(green);
        color.setBlue(blue);
    }

    @Override
    public Drawable setScale(float scale) {
        coord.setX(scale * coord.getX());
        coord.setY(scale * coord.getY());
        return new Dot2d(coord.getX(), coord.getY());
    }

    public void move(float xStep, float yStep) {
        coord.setX(coord.getX() + xStep);
        coord.setY(coord.getY() + yStep);
    }
}
