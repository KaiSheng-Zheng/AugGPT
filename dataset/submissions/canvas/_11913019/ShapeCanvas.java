import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShapeCanvas implements IShapeCanvas {
  private List<Shape> shapes = new ArrayList<>();
  private int width;
  private int height;
  private char[][] canvas;

  public ShapeCanvas(int width, int height) {
    this.width = width;
    this.height = height;
    this.canvas = new char[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        canvas[i][j] = ' ';
      }
    }
  }

  @Override
  public boolean addShape(int x, int y, char pattern, int... params) {
    Location location = new Location(x, y);
    Shape shape;

    switch (params.length) {
      case 1 -> shape = new Circle(location, pattern, params[0]);
      case 4 -> shape = new RightTriangle(location, pattern, params[0], params[1], Direction.values()[params[2]]);
      default -> {
        return false; 
      }
    }

    shapes.add(shape);
    drawShape(shape);
    return true;
  }

  @Override
  public int getSpaceGridCount() {
    int count = 0;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (canvas[i][j] == ' ') {
          count++;
        }
      }
    }
    return count;
  }

  @Override
  public int getShapeCount() {
    return shapes.size();
  }

  @Override
  public List<Shape> getShapesByArea() {
    shapes.sort(Comparator.comparingInt(ShapeUtils::area)
        .thenComparing(shape -> shape.pattern));
    return new ArrayList<>(shapes);
  }

  @Override
  public List<Shape> getShapesByLocation() {
    shapes.sort(Comparator.comparingInt((Shape shape) -> shape.location.getX())
        .thenComparingInt(shape -> shape.location.getY())
        .thenComparing(shape -> shape.pattern));
    return new ArrayList<>(shapes);
  }

  @Override
  public char[][] getCanvas() {
    return canvas;
  }

  private void drawShape(Shape shape) {
    char[][] grids = shape.getGrids();
    Location loc = shape.location;
    for (int i = 0; i < grids.length; i++) {
      for (int j = 0; j < grids[i].length; j++) {
        int canvasX = loc.getX() + i;
        int canvasY = loc.getY() + j;
        if (canvasX < height && canvasY < width && grids[i][j] != ' ') {
          canvas[canvasX][canvasY] = grids[i][j];
        }
      }
    }
  }
}