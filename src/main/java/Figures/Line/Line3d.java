package Figures.Line;


import Coordinates.Coord3d;
import org.lwjgl.opengl.GL11;

public class Line3d extends Line2d {

    private GL11 line;

    private Coord3d start;
    private Coord3d end;

    public Line3d(float xStart, float yStart, float zStart, float xEnd, float yEnd, float zEnd) {
        super(xStart, yStart, xEnd, yEnd);
        start = new Coord3d();
        end = new Coord3d();
        start.setX(xStart);
        start.setY(yStart);
        start.setZ(zStart);
        end.setX(xEnd);
        end.setY(yEnd);
        end.setZ(zEnd);
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
        line.glBegin(GL11.GL_LINES);
        line.glVertex3f(start.getX(), start.getY(), start.getZ());
        line.glVertex3f(end.getX(), end.getY(), end.getZ());
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
