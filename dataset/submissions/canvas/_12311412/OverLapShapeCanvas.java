import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public OverLapShapeCanvas(int rows, int cols){
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
        shapes = new ArrayList<>();
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x, y);
        if (params.length == 1) {
            Circle circle = new Circle(location, pattern, params[0]);
            int count=0;
            for (int i = 0; i < circle.grids.length && x+i<canvas.length; i++) {
                for (int j = 0; j < circle.grids[i].length && y+j<canvas[i].length; j++) {
                    if (circle.grids[i][j] != ' ')
                        count++;
                }
            }
            if(count==0) return false;
            for (int i = 0; i < circle.grids.length && x+i<canvas.length; i++) {
                for (int j = 0; j < circle.grids[i].length && y+j<canvas[i].length; j++) {
                    if (circle.grids[i][j] != ' ')
                        canvas[x+i][y+j]=circle.grids[i][j];
                }
            }
            shapes.add(circle);
            return true;
        }

        if (params.length == 3) {
            Direction d = switch (params[2]) {
                case 0 -> Direction.LEFT_UP;
                case 1 -> Direction.LEFT_DOWN;
                case 2 -> Direction.RIGHT_UP;
                case 3 -> Direction.RIGHT_DOWN;
                default -> null;
            };
            RightTriangle rightTriangle = new RightTriangle(location, pattern, params[0], params[1], d);
            int count=0;
            for (int i = 0; i < rightTriangle.grids.length && x+i<canvas.length; i++) {
                for (int j = 0; j < rightTriangle.grids[i].length && y+j<canvas[i].length; j++) {
                    if (rightTriangle.grids[i][j] != ' ')
                        count++;
                }
            }
            if(count==0) return false;
            for (int i = 0; i < rightTriangle.grids.length && x+i<canvas.length; i++) {
                for (int j = 0; j < rightTriangle.grids[i].length && y+j<canvas[i].length; j++) {
                    if (rightTriangle.grids[i][j] != ' ')
                        canvas[x+i][y+j]=rightTriangle.grids[i][j];
                }
            }
            shapes.add(rightTriangle);
            return true;
        }
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] != ' ') {
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
        shapes.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                Integer a1=o1.area();
                Integer a2=o2.area();
                if(!a1.equals(a2))
                    return a1.compareTo(a2);
                Character c1=o1.getPattern();
                Character c2=o2.getPattern();
                return c1.compareTo(c2);
            }
        });
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                Integer a1=o1.getLocation().getX();
                Integer a2=o2.getLocation().getX();
                if(!a1.equals(a2))
                    return a1.compareTo(a2);
                Integer b1=o1.getLocation().getY();
                Integer b2=o2.getLocation().getY();
                if(!b1.equals(b2))
                    return b1.compareTo(b2);
                Character c1=o1.getPattern(),c2=o2.getPattern();
                return c1.compareTo(c2);
            }
        });
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}