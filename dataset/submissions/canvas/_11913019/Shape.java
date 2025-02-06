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

  @Override
  public String toString() {
    return ShapeUtils.toString(this);
  }

  public int area() {
    return ShapeUtils.area(this);
  }
}