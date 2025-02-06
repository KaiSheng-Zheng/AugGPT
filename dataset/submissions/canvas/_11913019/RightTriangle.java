import java.util.Arrays;

public class RightTriangle extends Shape {
  private int width;
  private int height;
  private Direction direction;

  public RightTriangle(Location location, char pattern, int base, int height, Direction direction) {
    super(location, pattern);
    this.width = base;
    this.height = height;
    this.direction = direction;
    this.grids = new char[height][base];
    fillGrids();
  }

  @Override
  public void fillGrids() {
    double k = 1.0 * this.height / this.width;
    for (char[] grid : grids) {
      Arrays.fill(grid, ' ');
    }
    for (int i = 1; i <= grids.length; i++) {
      if (this.direction == Direction.LEFT_UP || this.direction == Direction.LEFT_DOWN) {
        grids[i - 1][0] = this.pattern;
      } else {
        grids[i - 1][width - 1] = this.pattern;
      }
      for (int col = 1; col < grids[0].length; col++) {
        if (i * 1.0 / col > k) {
          int row = i - 1;
          if (null == this.direction) {
            grids[height - 1 - row][width - 1 - col] = this.pattern;
          } else
            switch (this.direction) {
              case LEFT_DOWN:
                grids[row][col] = this.pattern;
                break;
              case LEFT_UP:
                grids[height - 1 - row][col] = this.pattern;
                break;
              case RIGHT_DOWN:
                grids[row][width - 1 - col] = this.pattern;
                break;
              default:
                grids[height - 1 - row][width - 1 - col] = this.pattern;
                break;
            }
        } else {
          break;
        }
      }
    }
  }

  private boolean isInTriangle(int i, int j) {
    return switch (direction) {
      case LEFT_UP -> ((double) i) / height + ((double) j) / width <= 1;
      case LEFT_DOWN -> ((double) i) / height >= ((double) j) / width;
      case RIGHT_UP -> ((double) i) / height <= ((double) j) / width;
      case RIGHT_DOWN -> ((double) i) / height + ((double) j) / width >= 1;
      default -> false;
    };
  }

  @Override
  public void enlarge() {
    width++;
    height++;
    grids = new char[height][width];
    fillGrids();
  }

  @Override
  public void shrink() {
    if (width > 1 && height > 1) {
      width--;
      height--;
      grids = new char[height][width];
      fillGrids();
    }
  }
}