package Figures.Dot;

import Coordinates.Coord3d;
import org.lwjgl.opengl.GL11;

public class Dot3d extends Dot2d {
    private GL11 dot;
    private Coord3d coord;

    public Dot3d(float x, float y, float z) {
        super(x, y);
        coord = new Coord3d(super.getCoord(), z);
    }

    public void draw() {

        dot.glColor3f(getColor().getRed(), getColor().getGreen(), getColor().getBlue());
        dot.glBegin(GL11.GL_POINTS);
        dot.glVertex3f(coord.getX(), coord.getY(), coord.getZ());
        dot.glEnd();
    }

    @Override
    public GL11 getDot() {
        return dot;
    }

    @Override
    public void setDot(GL11 dot) {
        this.dot = dot;
    }

    public Coord3d getCoord() {
        return coord;
    }

    public void setCoord(Coord3d coord) {
        this.coord = coord;
    }

    public void setCoord(float x, float y, float z) {
        coord.setX(x);
        coord.setY(y);
        coord.setZ(z);
    }
}
