package Figures.Line;


import Coordinates.Coord3d;
import Interfaces.Drawable;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;

public class Line3d extends Line2d {
    private Coord3d start;
    private Coord3d end;

    public Line3d(float xStart, float yStart, float zStart, float xEnd, float yEnd, float zEnd) {
        super(xStart, yStart, xEnd, yEnd);
        start = new Coord3d(super.getStart(), zStart);
        end = new Coord3d(super.getEnd(), zEnd);
    }

    @Override
    public Coord3d getStart() {
        return start;
    }

    public void setStart(Coord3d start) {
        this.start = start;
    }

    @Override
    public Coord3d getEnd() {
        return end;
    }

    public void setEnd(Coord3d end) {
        this.end = end;
    }

    @Override
    public void draw() {
        glBegin(GL11.GL_LINES);
        glVertex3f(start.getX(), start.getY(), start.getZ());
        glVertex3f(end.getX(), end.getY(), end.getZ());
        glEnd();
    }


    @Override
    public Drawable setScale(float scale) {
        start.setZ(scale * start.getZ());
        end.setZ(scale * end.getZ());

        return new Line3d(start.getX(), start.getY(), start.getZ(), end.getX(), end.getY(), end.getZ());
    }

    public void move(float zStep) {
        start.setZ(start.getZ() + zStep);
        end.setZ(end.getZ() + zStep);
    }
}
