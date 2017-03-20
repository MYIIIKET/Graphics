package Figures.Dot;

import Coordinates.Coord3d;
import Interfaces.Drawable;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;

public class Dot3d extends Dot2d {
    private Coord3d coord;

    public Dot3d(float x, float y, float z) {
        super(x, y);
        coord = new Coord3d(super.getCoord(), z);
    }

    public void draw() {

        glColor3f(getColor().getRed(), getColor().getGreen(), getColor().getBlue());
        glBegin(GL11.GL_POINTS);
        glVertex3f(coord.getX(), coord.getY(), coord.getZ());
        glEnd();
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

    @Override
    public Drawable setScale(float scale) {
        coord.setZ(scale * coord.getZ());
        return new Dot3d(coord.getX(), coord.getY(), coord.getZ());
    }

    public void move(float zStep) {
        coord.setZ(coord.getZ() + zStep);
    }
}
