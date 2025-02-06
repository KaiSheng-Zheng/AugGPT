import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes=new ArrayList<>();
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }

    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length == 1) {
            Circle circle = new Circle(new Location(x, y), pattern, params[0]);
            if (OverLap(circle)) {
                shapes.add(circle);
                return true;
            } else {
                return false;
            }

        } else {
            Direction direction = null;
            switch (params[2]) {
                case 0:
                    direction = Direction.LEFT_UP;
                    break;
                case 1:
                    direction = Direction.LEFT_DOWN;
                    break;
                case 2:
                    direction = Direction.RIGHT_UP;
                    break;
                case 3:
                    direction = Direction.RIGHT_DOWN;
                    break;
            }
            RightTriangle rightTriangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], direction);
            if (OverLap(rightTriangle)) {
                shapes.add(rightTriangle);
                return true;
            } else {
                return false;
            }
        }
    }

    private boolean OverLap(Shape shape) {
        boolean condition= false;
        char[][] ch= shape.getGrids();
        for (int i = 0; i <ch.length ; i++) {
            for (int j = 0; j <ch[0].length ; j++) {
                if (ch[i][j]!=' ') {
                    int x=shape.location.getX()+i;int y=shape.location.getY()+j;
                    if(x >= 0 && x <= canvas.length-1 && y >= 0 && y <= canvas[0].length-1){
                        condition=true;
                        break;
                    }
                }
            }

        }
        if(condition){
            for (int i = 0; i <ch.length ; i++) {
                for (int j = 0; j <ch[0].length ; j++) {
                    int x=shape.location.getX()+i;int y=shape.location.getY()+j;
                        if(x >= 0 && x <= canvas.length-1 && y >= 0 && y <= canvas[0].length-1 &&ch[i][j]!=' '){
                            canvas[x][y]=ch[i][j];
                        }

                }

            }

        }
        return condition;
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i <canvas.length; i++) {
            for(int j =0;j<canvas[0].length;j++){
                if(canvas[i][j]==' '){
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
        ComparableShape COMparator = new ComparableShape();
        shapes.sort(COMparator);
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        ComparableLocation location = new ComparableLocation();
        shapes.sort(location);
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }


}