package Figures.Line;


import Coordinates.Coord2d;
import Color.Color;
import Interfaces.Drawable;
import org.lwjgl.opengl.*;

public class Line2d implements Drawable {
    private GL11 line;

    private Coord2d start;
    private Coord2d end;
    private Color color;

    public Line2d(float xStart, float yStart, float xEnd, float yEnd) {
        start = new Coord2d();
        end = new Coord2d();
        start.setX(xStart);
        start.setY(yStart);
        end.setX(xEnd);
        end.setY(yEnd);
        color = new Color(0, 0, 0);
    }

    @Override
    public void draw() {
        line.glBegin(GL11.GL_LINES);
        line.glVertex2f(start.getX(), start.getY());
        line.glVertex2f(end.getX(), end.getY());
        line.glEnd();
    }


    @Override
    public void setColor(int red, int green, int blue) {
        color.setRed(red);
        color.setGreen(green);
        color.setBlue(blue);
        line.glColor3f(color.getRed(), color.getGreen(), color.getBlue());
    }

    @Override
    public Drawable setScale(float scale) {
        start.setX(scale * start.getX());
        start.setY(scale * start.getY());

        end.setX(scale * end.getX());
        end.setY(scale * end.getY());

        return new Line2d(start.getX(), start.getY(), end.getX(), end.getY());
    }

    public void setColor(Color color) {
        this.color = color;
        line.glColor3f(color.getRed(), color.getGreen(), color.getBlue());
    }

    public Coord2d getStart() {
        return start;
    }

    public void setStart(Coord2d start) {
        this.start = start;
    }

    public Coord2d getEnd() {
        return end;
    }

    public void setEnd(Coord2d end) {
        this.end = end;
    }

    public Color getColor() {
        return color;
    }

    public GL11 getLine() {
        return line;
    }

    public void setLine(GL11 line) {
        this.line = line;
    }

    public void setThickness(float thickness) {
        line.glLineWidth(thickness);
    }
}
