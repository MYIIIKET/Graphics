package Figures.Triangle;

import Color.Color;
import Coordinates.Coord3d;
import Interfaces.Drawable;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;

public class Triangle3d implements Drawable {

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

    @Override
    public void draw() {
        glBegin(GL11.GL_TRIANGLES);

        glColor3f(colorA.getRed(), colorA.getGreen(), colorA.getBlue());
        glVertex3f(vertexA.getX(), vertexA.getY(), vertexA.getZ());
        glVertex3f(vertexB.getX(), vertexB.getY(), vertexB.getZ());
        glVertex3f(vertexC.getX(), vertexC.getY(), vertexC.getZ());

        glColor3f(colorB.getRed(), colorB.getGreen(), colorB.getBlue());
        glVertex3f(vertexB.getX(), vertexB.getY(), vertexB.getZ());
        glVertex3f(vertexD.getX(), vertexD.getY(), vertexD.getZ());
        glVertex3f(vertexC.getX(), vertexC.getY(), vertexC.getZ());

        glColor3f(colorC.getRed(), colorC.getGreen(), colorC.getBlue());
        glVertex3f(vertexD.getX(), vertexD.getY(), vertexD.getZ());
        glVertex3f(vertexA.getX(), vertexA.getY(), vertexA.getZ());
        glVertex3f(vertexC.getX(), vertexC.getY(), vertexC.getZ());

        glColor3f(colorD.getRed(), colorD.getGreen(), colorD.getBlue());
        glVertex3f(vertexA.getX(), vertexA.getY(), vertexA.getZ());
        glVertex3f(vertexB.getX(), vertexB.getY(), vertexB.getZ());
        glVertex3f(vertexD.getX(), vertexD.getY(), vertexD.getZ());

        glEnd();

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

    public void move(float xStep, float yStep, float zStep) {
        vertexA.setX(vertexA.getX() + xStep);
        vertexA.setY(vertexA.getY() + yStep);
        vertexA.setZ(vertexA.getZ() + zStep);

        vertexB.setX(vertexB.getX() + xStep);
        vertexB.setY(vertexB.getY() + yStep);
        vertexB.setZ(vertexB.getZ() + zStep);

        vertexC.setX(vertexC.getX() + xStep);
        vertexC.setY(vertexC.getY() + yStep);
        vertexC.setZ(vertexC.getZ() + zStep);

        vertexD.setX(vertexD.getX() + xStep);
        vertexD.setY(vertexD.getY() + yStep);
        vertexD.setZ(vertexD.getZ() + zStep);
    }
}
