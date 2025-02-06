import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                canvas[i][j] = ' ';
            }
        }
        shapes=new ArrayList<>();
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape sp;
        if (params.length == 1) {
            sp = new Circle(new Location(x, y), pattern, params[0]);
        } else {
            Direction d = switch (params[2]) {
                case 0 -> Direction.LEFT_UP;
                case 1 -> Direction.LEFT_DOWN;
                case 2 -> Direction.RIGHT_UP;
                default -> Direction.RIGHT_DOWN;
            };
            sp = new RightTriangle(new Location(x, y), pattern, params[0], params[1], d);
        }
        char[][] spgrids = sp.getGrids();
        int cnt=0;
        for (int i = 0; i < spgrids.length&&x+i<canvas.length; i++) {
            for (int j = 0; j < spgrids[i].length&&y+j<canvas[i].length; j++) {
                if (spgrids[i][j] != ' ') cnt++;
            }
        }
        if(cnt==0) return false;
        for (int i = 0; i < spgrids.length&&x+i<canvas.length; i++) {
            for (int j = 0; j < spgrids[i].length&&y+j<canvas[i].length; j++) {
                if (spgrids[i][j] != ' ') canvas[x+i][y+j]=spgrids[i][j];
            }
        }
        shapes.add(sp);
        return true;
    }

    public int getSpaceGridCount() {
        int cnt = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                cnt += ((canvas[i][j] == ' ') ? 1 : 0);
            }
        }
        return cnt;
    }

    public int getShapeCount() {
        return shapes.size();
    }

    public List<Shape> getShapesByArea()
    {
        shapes.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                Integer i1=o1.area(),i2=o2.area();
                if(!i1.equals(i2))return i1.compareTo(i2);
                Character c1=o1.getPattern(),c2=o2.getPattern();
                return c1.compareTo(c2);
            }
        });
        return shapes;
    }
    public List<Shape> getShapesByLocation()
    {
        shapes.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                Integer i1=o1.getLocation().getX(), i2=o2.getLocation().getX();
                if(!i1.equals(i2))return i1.compareTo(i2);
                i1=o1.getLocation().getY(); i2=o2.getLocation().getY();
                if(!i1.equals(i2))return i1.compareTo(i2);
                Character c1=o1.getPattern(),c2=o2.getPattern();
                return c1.compareTo(c2);
            }
        });
        return shapes;
    }
    public char[][] getCanvas()
    {
        return canvas;
    }
}
