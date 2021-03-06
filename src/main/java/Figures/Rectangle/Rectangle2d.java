package Figures.Rectangle;

import Color.Color;
import Coordinates.Coord2d;
import Interfaces.Drawable;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE;

public class Rectangle2d implements Drawable {

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
        glBegin(GL11.GL_QUADS);

        glColor3f(colorA.getRed(), colorA.getGreen(), colorA.getBlue());
        glTexCoord2f(0.0f, 0.0f);
        glVertex2f(vertexA.getX(), vertexA.getY());

        glColor3f(colorB.getRed(), colorB.getGreen(), colorB.getBlue());
        glTexCoord2f(1.0f, 0.0f);
        glVertex2f(vertexB.getX(), vertexB.getY());

        glColor3f(colorC.getRed(), colorC.getGreen(), colorC.getBlue());
        glTexCoord2f(1.0f, 1.0f);
        glVertex2f(vertexC.getX(), vertexC.getY());

        glColor3f(colorD.getRed(), colorD.getGreen(), colorD.getBlue());
        glTexCoord2f(0.0f, 1.0f);
        glVertex2f(vertexD.getX(), vertexD.getY());


        glEnd();
        glFlush();
    }

    public void setTexture(int texture, BufferedImage bufferedImage, ByteBuffer buffer) {
        glBindTexture(GL_TEXTURE_2D, texture);

        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL12.GL_CLAMP_TO_EDGE);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL12.GL_CLAMP_TO_EDGE);

        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);

        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, bufferedImage.getWidth(),
                bufferedImage.getHeight(), 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);
    }

    @Override
    public Drawable setScale(float scale) {
        return null;
    }
}
