package Position;

public class Position3d extends Position2d {
    private float zStart;
    private float zEnd;

    public Position3d(float xStart, float yStart, float zStart, float xEnd, float yEnd, float zEnd) {
        super(xStart, yStart, xEnd, yEnd);
        setzStart(zStart);
        setzEnd(zEnd);
    }

    public Position3d(Position2d position2d, float zStart, float zEnd) {
        super(position2d.getxStart(), position2d.getyStart(), position2d.getxEnd(), position2d.getyEnd());
        setzStart(zStart);
        setzEnd(zEnd);
    }

    public float getzStart() {
        return zStart;
    }

    public void setzStart(float zStart) {
        this.zStart = zStart;
    }

    public float getzEnd() {
        return zEnd;
    }

    public void setzEnd(float zEnd) {
        this.zEnd = zEnd;
    }
}
