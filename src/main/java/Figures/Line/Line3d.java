package Figures.Line;


import Position.Position2d;
import Position.Position3d;
import org.lwjgl.opengl.GL11;

public class Line3d extends Line2d {

    private GL11 line;

    private Position3d position;

    public Line3d(float xStart, float yStart, float zStart, float xEnd, float yEnd, float zEnd) {
        super(xStart, yStart, xEnd, yEnd);
        position = new Position3d(super.getPosition(), zStart, zEnd);
    }

    public void setPosition(float xStart, float yStart, float zStart, float xEnd, float yEnd, float zEnd) {
        position.setxStart(xStart);
        position.setyStart(yStart);
        position.setzStart(zStart);
        position.setxEnd(xEnd);
        position.setyEnd(yEnd);
        position.setzEnd(zEnd);
    }

    public void setPosition(Position2d position2d, float zStart, float zEnd) {
        this.setPosition(position2d);
        position.setzStart(zStart);
        position.setzEnd(zEnd);
    }

    public void setPosition(Position3d position) {
        this.position = position;
    }

    public Position3d getPosition() {
        return position;
    }


    @Override
    public void draw() {
        line.glBegin(GL11.GL_LINES);
        line.glVertex3f(position.getxStart(), position.getyStart(), position.getzStart());
        line.glVertex3f(position.getxEnd(), position.getyEnd(), position.getzEnd());
        line.glEnd();
    }

    @Override
    public GL11 getLine() {
        return line;
    }

    @Override
    public void setLine(GL11 line) {
        this.line = line;
    }
}
