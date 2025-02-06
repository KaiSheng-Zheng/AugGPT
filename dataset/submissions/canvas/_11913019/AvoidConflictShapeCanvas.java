import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements IShapeCanvas {
  private List<Shape> shapes;
  private char[][] canvas;
  private int rows;
  private int cols;

  public AvoidConflictShapeCanvas(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    this.shapes = new ArrayList<>();
    this.canvas = new char[rows][cols];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
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
      case 3 -> shape = new RightTriangle(location, pattern, params[0], params[1], Direction.values()[params[2]]);
      default -> {
        return false;
      }
    }

    if (isConflict(shape)) {
      return false;
    }

    shapes.add(shape);
    drawShape(shape);
    return true;
  }

  private boolean isConflict(Shape shape) {
    char[][] grids = shape.getGrids();
    Location loc = shape.location;
    for (int i = 0; i < grids.length; i++) {
      for (int j = 0; j < grids[i].length; j++) {
        int canvasX = loc.getX() + i;
        int canvasY = loc.getY() + j;
        if (canvasX >= rows || canvasY >= cols || canvasX < 0 || canvasY < 0) {
          return true; 
        }
        if (grids[i][j] != ' ' && canvas[canvasX][canvasY] != ' ') {
          return true; 
        }
      }
    }
    return false;
  }

  private void drawShape(Shape shape) {
    char[][] grids = shape.getGrids();
    Location loc = shape.location;
    for (int i = 0; i < grids.length; i++) {
      for (int j = 0; j < grids[i].length; j++) {
        int canvasX = loc.getX() + i;
        int canvasY = loc.getY() + j;
        if (grids[i][j] != ' ') {
          canvas[canvasX][canvasY] = grids[i][j];
        }
      }
    }
  }

  @Override
  public int getSpaceGridCount() {
    int count = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
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
}
