public abstract class Shape {
    protected char pattern;
    protected Location location;
    // missing method: shrink(), enlarge()
    public Shape(Location location, char pattern){
        this.location = location;
        this.pattern = pattern;
    }
    public char getPattern() {
        return pattern;
    }
    public void setPattern(char pattern) {
        this.pattern = pattern;
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public abstract int area();
}
