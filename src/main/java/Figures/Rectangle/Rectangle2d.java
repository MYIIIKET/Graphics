package Figures.Rectangle;

import Color.Color;
import Coordinates.Coord2d;
import Interfaces.Drawable;
import org.lwjgl.opengl.GL11;

public class Rectangle2d implements Drawable {

    private GL11 rectangle;

    private Color colorA;
    private Color colorB;
    private Color colorC;
    private Color colorD;

    private Coord2d vertexA;
    private Coord2d vertexB;
    private Coord2d vertexC;
    private Coord2d vertexD;

    public Rectangle2d(Coord2d vertexA, Coord2d vertexB, Coord2d vertexC, Coord2d vertexD) {
        setVertexA(vertexA);
        setVertexB(vertexB);
        setVertexC(vertexC);
        setVertexD(vertexD);
    }

    public GL11 getRectangle() {
        return rectangle;
    }

    public void setRectangle(GL11 rectangle) {
        this.rectangle = rectangle;
    }

    public Color getColorA() {
        return colorA;
    }

    public void setColorA(Color colorA) {
        this.colorA = colorA;
    }

    public Color getColorB() {
        return colorB;
    }

    public void setColorB(Color colorB) {
        this.colorB = colorB;
    }

    public Color getColorC() {
        return colorC;
    }

    public void setColorC(Color colorC) {
        this.colorC = colorC;
    }

    public Color getColorD() {
        return colorD;
    }

    public void setColorD(Color colorD) {
        this.colorD = colorD;
    }

    public Coord2d getVertexA() {
        return vertexA;
    }

    public void setVertexA(Coord2d vertexA) {
        this.vertexA = vertexA;
    }

    public Coord2d getVertexB() {
        return vertexB;
    }

    public void setVertexB(Coord2d vertexB) {
        this.vertexB = vertexB;
    }

    public Coord2d getVertexC() {
        return vertexC;
    }

    public void setVertexC(Coord2d vertexC) {
        this.vertexC = vertexC;
    }

    public Coord2d getVertexD() {
        return vertexD;
    }

    public void setVertexD(Coord2d vertexD) {
        this.vertexD = vertexD;
    }

    @Override
    public void draw() {
        rectangle.glBegin(GL11.GL_QUADS);

        rectangle.glColor3f(colorA.getRed(), colorA.getGreen(), colorA.getBlue());
        rectangle.glVertex2f(vertexA.getX(), vertexA.getY());

        rectangle.glColor3f(colorB.getRed(), colorB.getGreen(), colorB.getBlue());
        rectangle.glVertex2f(vertexB.getX(), vertexB.getY());

        rectangle.glColor3f(colorC.getRed(), colorC.getGreen(), colorC.getBlue());
        rectangle.glVertex2f(vertexC.getX(), vertexC.getY());

        rectangle.glColor3f(colorD.getRed(), colorD.getGreen(), colorD.getBlue());
        rectangle.glVertex2f(vertexD.getX(), vertexD.getY());

        rectangle.glEnd();
    }

    @Override
    public Drawable setScale(float scale) {
        return null;
    }
}
