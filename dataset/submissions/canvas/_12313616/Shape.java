import java.util.Comparator;

public abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;

    public Shape(Location location, char pattern) {
        this.location = location;
        this.pattern = pattern;
    }

    public char[][] getGrids() {
        return grids;
    }

    public abstract void fillGrids();

    public abstract void enlarge();

    public abstract void shrink();

    public abstract int area();

    @Override
    public abstract String toString();

    public static double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public static double calculateSlope(int x1, int y1, int x2, int y2) {
        double slope;
        if (x1 == x2) {
            return 1000000000.0;
        } else {
            slope = ((double) y2 - (double) y1) / ((double) x2 - (double) x1);
            return slope;
        }
    }
}

class AreaCompare implements Comparator<Shape> {
    @Override
    public int compare(Shape shapeOne, Shape shapeTwo) {
        if (shapeOne.area() < shapeTwo.area()) {
            return -1;
        }
        if (shapeOne.area() > shapeTwo.area()) {
            return 1;
        }
        if (shapeOne.pattern < shapeTwo.pattern) {
            return -1;
        }
        if (shapeOne.pattern > shapeTwo.pattern) {
            return 1;
        }
        return 0;
    }
}

class LocationCompare implements Comparator<Shape> {
    @Override
    public int compare(Shape shapeOne, Shape shapeTwo) {
        if (shapeOne.location.getX() < shapeTwo.location.getX()) {
            return -1;
        }
        if (shapeOne.location.getX() > shapeTwo.location.getX()) {
            return 1;
        }
        if (shapeOne.location.getY() < shapeTwo.location.getY()) {
            return -1;
        }
        if (shapeOne.location.getY() > shapeTwo.location.getY()) {
            return 1;
        }
        if (shapeOne.pattern < shapeTwo.pattern) {
            return -1;
        }
        if (shapeOne.pattern > shapeTwo.pattern) {
            return 1;
        }
        return 0;
    }
}


