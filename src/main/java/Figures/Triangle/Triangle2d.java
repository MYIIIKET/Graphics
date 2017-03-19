package Figures.Triangle;

import Color.Color;
import Coordinates.Coord2d;
import Interfaces.Drawable;
import org.lwjgl.opengl.GL11;

public class Triangle2d implements Drawable {
    private GL11 triangle;

    private Color colorA;
    private Color colorB;
    private Color colorC;

    private Coord2d vertexA;
    private Coord2d vertexB;
    private Coord2d vertexC;

    public Triangle2d(Coord2d vertexA, Coord2d vertexB, Coord2d vertexC) {
        setVertexA(vertexA);
        setVertexB(vertexB);
        setVertexC(vertexC);
        Color color = new Color(0, 0, 0);
        setColorA(color);
        setColorB(color);
        setColorC(color);
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

    public GL11 getTriangle() {
        return triangle;
    }

    public void setTriangle(GL11 triangle) {
        this.triangle = triangle;
    }

    public Coord2d getVertexC() {
        return vertexC;
    }

    public void setVertexC(Coord2d vertexC) {
        this.vertexC = vertexC;
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

    @Override
    public void draw() {
        triangle.glBegin(GL11.GL_TRIANGLES);

        triangle.glColor3f(colorA.getRed(), colorA.getGreen(), colorA.getBlue());
        triangle.glVertex2f(vertexA.getX(), vertexA.getY());

        triangle.glColor3f(colorB.getRed(), colorB.getGreen(), colorB.getBlue());
        triangle.glVertex2f(vertexB.getX(), vertexB.getY());

        triangle.glColor3f(colorC.getRed(), colorC.getGreen(), colorC.getBlue());
        triangle.glVertex2f(vertexC.getX(), vertexC.getY());

        triangle.glEnd();
    }

    @Override
    public void setColor(float red, float green, float blue) {
    }

    @Override
    public Drawable setScale(float scale) {
        vertexA.setX(scale * vertexA.getX());
        vertexA.setY(scale * vertexA.getY());

        vertexB.setX(scale * vertexB.getX());
        vertexB.setY(scale * vertexB.getY());

        vertexC.setX(scale * vertexC.getX());
        vertexC.setY(scale * vertexC.getY());
        return new Triangle2d(vertexA, vertexB, vertexC);
    }
}
