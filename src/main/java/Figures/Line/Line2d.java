package Figures.Line;


import Position.Position2d;
import Color.Color;
import Interfaces.Drawable;
import org.lwjgl.opengl.*;

public class Line2d implements Drawable {
    private GL11 line;

    private Position2d position;
    private Color color;

    public Line2d(float xStart, float yStart, float xEnd, float yEnd) {
        position = new Position2d(xStart, yStart, xEnd, yEnd);
        color = new Color(0, 0, 0);
    }

    @Override
    public void draw() {
        line.glBegin(GL11.GL_LINES);
        line.glVertex2f(position.getxStart(), position.getyStart());
        line.glVertex2f(position.getxEnd(), position.getyEnd());
        line.glEnd();
    }


    @Override
    public void setColor(float red, float green, float blue) {
        color.setRed(red);
        color.setGreen(green);
        color.setBlue(blue);
        line.glColor3f(color.getRed(), color.getGreen(), color.getBlue());
    }

    public void setPosition(float xStart, float yStart, float xEnd, float yEnd) {
        position.setxStart(xStart);
        position.setyStart(yStart);
        position.setxEnd(xEnd);
        position.setyEnd(yEnd);
    }

    public void setPosition(Position2d position) {
        this.position = position;
    }

    public Position2d getPosition() {
        return position;
    }

    public void setColor(Color color) {
        this.color = color;
        line.glColor3f(color.getRed(), color.getGreen(), color.getBlue());
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
