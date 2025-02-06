import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AvoidConflictShapeCanvas implements ShapeCanvas {

  private List<Shape> shapes;
  private char[][] canvas;

  public AvoidConflictShapeCanvas(int rows, int cols) {
    shapes = new ArrayList<>();
    canvas = new char[rows][cols];
    for (int i = 0; i < canvas.length; i++) {
      Arrays.fill(canvas[i], ' ');
    }
  }

  @Override
  public boolean addShape(int x, int y, char pattern, int... params) {
    Location location = new Location(x, y);
    if (params.length == 1) {
      int radius = params[0];
      Circle circle = new Circle(location, pattern, radius);
      return addShape(circle);
    } else if (params.length == 3) {
      int width = params[0];
      int height = params[1];
      Direction direction = Arrays.stream(Direction.values()).filter(e -> e.ordinal() == params[2]).findFirst().orElse(null);
      RightTriangle triangle = new RightTriangle(location, pattern, width, height, direction);
      return addShape(triangle);
    }
    return false;
  }

  private boolean addShape(Shape shape) {
    Location location = shape.location;
    char[][] grids = shape.grids;
    for (int i = 0; i < grids.length; i++) {
      for (int j = 0; j < grids[i].length; j++) {
        int x = i + location.getX();
        int y = j + location.getY();
        if (x >= canvas.length || y >= canvas[x].length) {
          return false;
        } else if (canvas[x][y] != ' ' && grids[i][j] != ' ') {
          return false;
        }
      }
    }
    shapes.add(shape);
    for (int i = 0; i < grids.length; i++) {
      for (int j = 0; j < grids[i].length; j++) {
        int x = i + location.getX();
        int y = j + location.getY();
        if (canvas[x][y] == ' ' && grids[i][j] != ' ') {
          canvas[x][y] = grids[i][j];
        }
      }
    }
    return true;
  }

  @Override
  public int getSpaceGridCount() {
    int count = 0 ;
    for (int i = 0; i < canvas.length; i++) {
      for (int j = 0; j < canvas[i].length; j++) {
        count += canvas[i][j] == ' '?1:0;
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
    return shapes.stream().sorted(Comparator.comparingInt(Shape::area)
        .thenComparing(o -> o.pattern)
    ).collect(Collectors.toList());
  }

  @Override
  public List<Shape> getShapesByLocation() {
    return shapes.stream().sorted(Comparator.comparingInt((Shape o) -> o.location.getX())
        .thenComparingInt(o -> o.location.getY())
        .thenComparing(o -> o.pattern)
    ).collect(Collectors.toList());
  }


  @Override
  public char[][] getCanvas() {
    return canvas;
  }
}