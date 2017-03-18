package Position;

public class Position3d extends Position2d {
    private Coord2d zCoord;

    public Position3d(float xStart, float yStart, float zStart, float xEnd, float yEnd, float zEnd) {
        super(xStart, yStart, xEnd, yEnd);
        zCoord.setX(zStart);
        zCoord.setY(zEnd);
    }

    public Position3d(Position2d position2d, float zStart, float zEnd) {
        super(position2d.getxStart(), position2d.getyStart(), position2d.getxEnd(), position2d.getyEnd());
        zCoord.setX(zStart);
        zCoord.setY(zEnd);
    }

    public Coord2d getzCoord() {
        return zCoord;
    }

    public void setzCoord(Coord2d zCoord) {
        this.zCoord = zCoord;
    }
}
