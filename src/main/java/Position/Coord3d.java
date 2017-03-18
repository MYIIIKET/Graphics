package Position;

public class Coord3d extends Coord2d {
    private float z;

    public Coord3d() {
    }

    public Coord3d(Coord2d coord2d, float z) {
        super(coord2d.getX(), coord2d.getY());
        setZ(z);
    }

    public Coord3d(float x, float y, float z) {
        super(x, y);
        setZ(z);
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
}
