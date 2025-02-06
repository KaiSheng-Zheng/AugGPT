public abstract class Shape {
    protected Location location;
    protected char pattern;

    public Shape(Location location, char pattern) {
        this.location = location;
        this.pattern = pattern;
    }

    public Location getLocation() {
        return location;
    }

    public char getPattern() {
        return pattern;
    }

    public abstract int getArea();
    public abstract char[][] draw();

    @Override
    public String toString() {
        return String.format("%s: (%d,%d) area=%d pattern=%c",
                this.getClass().getSimpleName(),
                location.getX(), location.getY(),
                getArea(), pattern);
    }
}
