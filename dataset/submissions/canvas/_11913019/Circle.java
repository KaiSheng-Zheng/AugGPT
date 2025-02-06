import java.util.Arrays;

public class Circle extends Shape {
  private int radius;

  public Circle(Location location, char pattern, int radius) {
    super(location, pattern);
    this.radius = radius;
    this.fillGrids();
  }

  @Override
  public void fillGrids() {
    super.grids = new char[radius * 2][radius * 2];
    for (char[] grid : grids) {
      Arrays.fill(grid, this.pattern);
    }
    for (int i = 1; i < radius; i++) {
      for (int j = 1; j < radius; j++) {
        double length = Math.pow(radius - i, 2) + Math.pow(radius - j, 2);
        int row = i - 1;
        int col = j - 1;
        if (length >= radius * radius) {
          grids[row][col] = ' ';
          grids[grids.length - row - 1][col] = ' ';
          grids[row][grids.length - col - 1] = ' ';
          grids[grids.length - row - 1][grids.length - col - 1] = ' ';
        } else {
          break;
        }
      }
    }
  }

  @Override
  public void enlarge() {
    this.radius += 1;
    fillGrids();
  }

  @Override
  public void shrink() {
    this.radius -= 1;
    fillGrids();
  }
}
