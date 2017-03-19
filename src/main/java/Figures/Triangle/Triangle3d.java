package Figures.Triangle;

import Color.Color;
import Coordinates.Coord2d;
import Coordinates.Coord3d;
import Interfaces.Drawable;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glVertex3f;

public class Triangle3d implements Drawable {

    private GL11 triangle;

    private Coord3d vertexA;
    private Coord3d vertexB;
    private Coord3d vertexC;
    private Coord3d vertexD;

    private Color colorA;
    private Color colorB;
    private Color colorC;
    private Color colorD;

    public Triangle3d(Coord3d vertexA, Coord3d vertexB, Coord3d vertexC, Coord3d vertexD) {
        setVertexA(vertexA);
        setVertexB(vertexB);
        setVertexC(vertexC);
        setVertexD(vertexD);
    }

    public void setColorA(Color colorA) {
        this.colorA = colorA;
    }

    public Color getColorA() {
        return colorA;
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

    public Coord3d getVertexA() {
        return vertexA;
    }

    public void setVertexA(Coord3d vertexA) {
        this.vertexA = vertexA;
    }

    public Coord3d getVertexB() {
        return vertexB;
    }

    public void setVertexB(Coord3d vertexB) {
        this.vertexB = vertexB;
    }

    public Coord3d getVertexC() {
        return vertexC;
    }

    public void setVertexC(Coord3d vertexC) {
        this.vertexC = vertexC;
    }

    public Coord3d getVertexD() {
        return vertexD;
    }

    public void setVertexD(Coord3d vertexD) {
        this.vertexD = vertexD;
    }

    public GL11 getTriangle() {
        return triangle;
    }

    public void setTriangle(GL11 triangle) {
        this.triangle = triangle;
    }

    @Override
    public void draw() {
        triangle.glBegin(GL11.GL_TRIANGLES);

        triangle.glColor3f(colorA.getRed(), colorA.getGreen(), colorA.getBlue());
        triangle.glVertex3f(vertexA.getX(), vertexA.getY(), vertexA.getZ());
        triangle.glVertex3f(vertexB.getX(), vertexB.getY(), vertexB.getZ());
        triangle.glVertex3f(vertexC.getX(), vertexC.getY(), vertexC.getZ());

        triangle.glColor3f(colorB.getRed(), colorB.getGreen(), colorB.getBlue());
        triangle.glVertex3f(vertexB.getX(), vertexB.getY(), vertexB.getZ());
        triangle.glVertex3f(vertexD.getX(), vertexD.getY(), vertexD.getZ());
        triangle.glVertex3f(vertexC.getX(), vertexC.getY(), vertexC.getZ());

        triangle.glColor3f(colorC.getRed(), colorC.getGreen(), colorC.getBlue());
        triangle.glVertex3f(vertexD.getX(), vertexD.getY(), vertexD.getZ());
        triangle.glVertex3f(vertexA.getX(), vertexA.getY(), vertexA.getZ());
        triangle.glVertex3f(vertexC.getX(), vertexC.getY(), vertexC.getZ());

        triangle.glColor3f(colorD.getRed(), colorD.getGreen(), colorD.getBlue());
        triangle.glVertex3f(vertexA.getX(), vertexA.getY(), vertexA.getZ());
        triangle.glVertex3f(vertexB.getX(), vertexB.getY(), vertexB.getZ());
        triangle.glVertex3f(vertexD.getX(), vertexD.getY(), vertexD.getZ());

        triangle.glEnd();

    }

    @Override
    public Drawable setScale(float scale) {
        vertexA.setX(scale * vertexA.getX());
        vertexA.setY(scale * vertexA.getY());
        vertexA.setZ(scale * vertexA.getZ());

        vertexB.setX(scale * vertexB.getX());
        vertexB.setY(scale * vertexB.getY());
        vertexB.setZ(scale * vertexB.getZ());

        vertexC.setX(scale * vertexC.getX());
        vertexC.setY(scale * vertexC.getY());
        vertexC.setZ(scale * vertexC.getZ());

        vertexD.setX(scale * vertexD.getX());
        vertexD.setY(scale * vertexD.getY());
        vertexD.setZ(scale * vertexD.getZ());
        return new Triangle3d(vertexA, vertexB, vertexC, vertexD);
    }
}
