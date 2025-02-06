import java.util.ArrayList;
import java.util.List;

public class RightTriangle extends Shape {

  private Direction d;
  private int width;
  private int height;

  public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
    super(location, pattern);
    this.width = width;
    this.height = height;
    this.d = d;
    fillGrids();
  }

  @Override
  public int area() {
    var tmp = 0;
    for (int i = 0; i < grids.length; i++) {
      for (int j = 0; j < grids[i].length; j++) {
        tmp += grids[i][j] == pattern ? 1 : 0;
      }
    }
    return tmp;
  }

  private static class Parameter {
    private final double a;
    private final double k;

    private Parameter(double a, double k) {
      this.a = a;
      this.k = k;
    }
  }

  private static class Line {
    private final Point start;
    private final Point end;
    private final Parameter para;

    private Line(Point p1, Point p2) {
      this.start = p1.x < p2.x ? p1 : (p1.y < p2.y ? p1 : p2);
      this.end = this.start == p1 ? p2 : p1;
      if (isVertical()) {
        this.para = new Parameter(start.x, Double.POSITIVE_INFINITY);
      } else {
        double k = (start.y - end.y) / (start.x - end.x);
        this.para = new Parameter(start.y - k * start.x, k);
      }
    }

    public boolean isVertical() {
      return isEquals(start.x, end.x);
    }

    private Object intersect(Line other) {
      if (isEquals(length(), 0)) {
        return other.contains(start) ? start : null;
      } else if (isEquals(other.length(), 0)) {
        return this.contains(other.start) ? other.start : null;
      }
      if (isEquals(para.k, other.para.k)) {
        if (!isEquals(para.a, other.para.a) || other.start.x > end.x || other.end.x < start.x) {
          return null;
        }
        Point p1 = contains(other.start) ? other.start : start;
        Point p2 = contains(other.end) ? other.end : end;
        return makeLine(p1, p2);
      }
      Line vertical = null;
      if (isVertical()) {
        vertical = this;
      } else if (other.isVertical()) {
        vertical = other;
      }
      if (vertical != null) {
        Line o = vertical == this ? other : this;
        double x = vertical.start.x;
        double y = o.para.a + o.para.k * x;
        return makePoint(x, y);
      }
      double x = (para.a - other.para.a) / (other.para.k - para.k);
      double y = para.a + para.k * x;
      return makePoint(x, y);
    }


    private boolean contains(Point p) {
      double distance1 = start.distance(p);
      double distance2 = end.distance(p);
      double segmentLength = start.distance(end);
      return isEquals(distance1 + distance2, segmentLength);
    }

    private double length() {
      return start.distance(end);
    }

    @Override
    public String toString() {
      return String.format("<%s, %s>", start, end);
    }
  }

  private static class Point {
    private final double x;
    private final double y;

    private Point(double x, double y) {
      this.x = x;
      this.y = y;
    }

    public double distance(Point o) {
      return Math.sqrt(Math.pow(x - o.x, 2) + Math.pow(y - o.y, 2));
    }

    @Override
    public String toString() {
      return String.format("(%.1f,%.1f)", x, y);
    }
  }


  private List<Line> intersectHorizontalLines() {
    List<Line> res = new ArrayList<>();
    var lines = getLines();
    for (int i = 0; i < height + 1; i++) {
      List<Object> intersectList = new ArrayList<>();
      Line horizontal = makeLine(makePoint(0, i), makePoint(width, i));
      for (Line line : lines) {
        Object intersect = horizontal.intersect(line);
        if (intersect != null) {
          intersectList.add(intersect);
        }
      }
      if (intersectList.isEmpty()) {
        continue;
      }
      Object o = intersectList.stream().filter(v -> v instanceof Line).findFirst().orElse(null);
      if (o != null) {
        res.add((Line) o);
      } else if (intersectList.size() == 2) {
        res.add(makeLine((Point) intersectList.get(0), (Point) intersectList.get(1)));
      }
    }
    return res;
  }

  private static boolean isEquals(double d1, double d2) {
    return d1 == d2 || Math.abs(d1 - d2) < 1e-7;
  }


  private static Point makePoint(double x, double y) {
    return new Point(x, y);
  }

  private static Line makeLine(Point p1, Point p2) {
    return new Line(p1, p2);
  }

  private Line[] getLines() {
    var points = getPoints();
    return new Line[]{
        makeLine(points[0], points[1]), makeLine(points[1], points[2]), makeLine(points[0], points[2])
    };
  }

  private Point[] getPoints() {
    switch (d) {
      case LEFT_DOWN -> {
        return new Point[]{makePoint(0, 0), makePoint(0, height), makePoint(width, height)};
      }
      case RIGHT_UP -> {
        return new Point[]{makePoint(0, 0), makePoint(width, 0), makePoint(width, height)};
      }
      case RIGHT_DOWN -> {
        return new Point[]{makePoint(width, 0), makePoint(0, height), makePoint(width, height)};
      }
      case LEFT_UP -> {
        return new Point[]{makePoint(0, 0), makePoint(width, 0), makePoint(0, height)};
      }
    }
    return null;
  }

  @Override
  public void fillGrids() {
    grids = new char[height][width];
    List<Line> lines = intersectHorizontalLines();
    for (int i = 0; i < grids.length; i++) {
      Line top = lines.get(i);
      Line bottom = lines.get(i + 1);
      for (int j = 0; j < grids[i].length; j++) {
        Line h1 = makeLine(makePoint(j, i), makePoint(j + 1, i));
        Line h2 = makeLine(makePoint(j, i + 1), makePoint(j + 1, i + 1));
        boolean flag = false;
        Object o1 = top.intersect(h1);
        Object o2 = bottom.intersect(h2);
        if (o1 != null && o1 instanceof Line && ((Line) o1).length() > 0) {
          flag = true;
        } else if (o2 != null && o2 instanceof Line && ((Line) o2).length() > 0) {
          flag = true;
        }
        grids[i][j] = flag ? pattern : ' ';
      }
    }
  }


  @Override
  public void enlarge() {
    width += 1;
    height += 1;
    fillGrids();
  }

  @Override
  public void shrink() {
    width -= 1;
    height -= 1;
    fillGrids();
  }
}