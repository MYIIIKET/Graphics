package Position;

public class Position2d extends Coord2d {
    private Coord2d start;
    private Coord2d end;

    public Position2d(float xStart, float yStart, float xEnd, float yEnd) {
        start = new Coord2d();
        end = new Coord2d();
        start.setX(xStart);
        start.setY(yStart);
        end.setX(xEnd);
        end.setY(yEnd);
    }

    public Coord2d getStart() {
        return start;
    }

    public void setStart(Coord2d start) {
        this.start = start;
    }

    public Coord2d getEnd() {
        return end;
    }

    public void setEnd(Coord2d end) {
        this.end = end;
    }

    public float getxStart() {
        return start.getX();
    }

    public float getyStart() {
        return start.getY();
    }

    public float getxEnd() {
        return end.getX();
    }

    public float getyEnd() {
        return end.getY();
    }

    public void setxStart(float xStart) {
        start.setX(xStart);
    }

    public void setyStart(float yStart) {
        start.setY(yStart);
    }

    public void setxEnd(float xEnd) {
        end.setX(xEnd);
    }

    public void setyEnd(float yEnd) {
        end.setY(yEnd);
    }
}
