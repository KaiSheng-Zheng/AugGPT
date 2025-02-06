import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes = new ArrayList<Shape>();
    private char[][] canvas;
    public Direction[]directions ={Direction.LEFT_UP,Direction.RIGHT_UP,Direction.RIGHT_DOWN,Direction.LEFT_DOWN};


    public AvoidConflictShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        for (int i = 0 ; i < rows ; i++){
            for (int j = 0 ; j < cols ; j++){
                canvas[i][j] = ' ';
            }
        }
    }
    public boolean addShape(int x, int y, char pattern, int... params) {
        getCanvas();
        if (params.length == 1) {
            int radius = params[0];
            if ((x + radius * 2) > canvas.length) {
                return false;
            }
            if ((y + radius * 2) > canvas[0].length) {
                return false;
            }
            for (int i = x; i < radius + x; i++) {
                for (int j = y; j < radius + y; j++) {
                    if (Math.sqrt((x + radius - i - 1) * (x + radius - i - 1) + (y + radius - j - 1) * (y + radius - j - 1) + 0.0) < radius) {
                        if (!(canvas[i][j] == ' ' & canvas[radius +x - i - 1][j] == ' ' & canvas[i][radius +y - j - 1] == ' ' & canvas[radius +x - i - 1][radius +y - j - 1] == ' ')) {
                            return false;
                        }
                    }
                }
            }
            for (int i = x; i < x+radius; i++) {
                for (int j = y; j < radius+y; j++) {
                    if (Math.sqrt((x+radius - i - 1) * (x+radius - i - 1) + (y+radius - j - 1) * (y+radius - j - 1) + 0.0) < radius) {
                        canvas[i][j] = pattern;
                        canvas[radius+x - i - 1][j] = pattern;
                        canvas[i][radius+y - i - 1] = pattern;
                        canvas[radius+x - i - 1][radius+y - j - 1] = pattern;
                    }
                }
            }
            Location location = new Location(x,y);
            Circle circle = new Circle(location,pattern,radius);
            shapes.add(circle);
        }
            if (params.length == 3) {
                int width = params[0];
                int height = params[1];
                int d = params[2];
                if ((x + height) > canvas.length) {
                    return false;
                }
                if ((y + width) > canvas[0].length) {
                    return false;
                }
                double tan = (0.0 + height) / width;
                if (d == 3) {
                    for (int i = y; i < width + y; i++) {
                        if (i == y) {
                            for (int j = x; j < height + x; j++) {
                                if (!(canvas[j][0] == ' ')) {
                                    return false;
                                }
                            }
                        }
                        for (int j = x; j < height + x; j++) {
                            if ((j + 1 - x) / (i + 0.0 - y) > tan) {
                                if (!(canvas[j][i] == ' ')) {
                                    return false;
                                }
                            }
                        }
                    }
                }
                if (d == 2) {
                    for (int i = y; i < width + y; i++) {
                        if (i == y + width - 1) {
                            for (int j = x; j < height + x; j++) {
                                if (!(canvas[j][y + width - 1] == ' ')) {
                                    return false;
                                }
                            }
                        }
                        for (int j = x; j < height + x; j++) {
                            if (-(j + 1.0 - x) / (width - i - 1 - y) > tan) {
                                if (!(canvas[j][i] == ' ')) {
                                    return false;
                                }
                            }
                        }
                    }
                }

                if (d == 0) {
                    for (int i = y; i < width + y; i++) {
                        if (i == y) {
                            for (int j = x; j < height + x; j++) {
                                if (!(canvas[j][y] == ' ')) {
                                    return false;
                                }
                            }
                        }
                        for (int j = x; j < height + x; j++) {
                            if ((j + 1.0 - x) / (i - y) > tan) {
                                if (!(canvas[height - 1 - j][i] == ' ')) {
                                    return false;
                                }
                            }
                        }
                    }
                }
                Location location = new Location(x, y);
                RightTriangle rightTriangle = new RightTriangle(location, pattern, params[0], params[1], directions[params[2]]);
                shapes.add(rightTriangle);
                if (d == 3) {
                    for (int i = 0; i < width; i++) {
                        if (i == 0) {
                            for (int j = 0; j < height; j++) {
                                canvas[j][0] = pattern;
                            }
                        }
                        for (int j = 0; j < height; j++) {
                            if ((j + 1) / (i + 0.0) > tan) {
                                canvas[j][i] = pattern;
                            }
                            if ((j + 1) / (i + 0.0) <= tan) {
                                canvas[j][i] = ' ';
                            }
                        }
                    }
                }

                if (d == 2) {
                    for (int i = 0; i < width; i++) {
                        if (i == width - 1) {
                            for (int j = 0; j < height; j++) {
                                canvas[j][width - 1] = pattern;
                            }
                        }
                        for (int j = 0; j < height; j++) {
                            if ((j + 1.0) / (width - i - 1) > tan) {
                                canvas[j][i] = pattern;
                            }
                            if ((j + 1.0) / (width - i - 1) <= tan) {
                                canvas[j][i] = ' ';
                            }
                        }
                    }
                }

                if (d == 0) {
                    for (int i = 0; i < width; i++) {
                        if (i == 0) {
                            for (int j = 0; j < height; j++) {
                                canvas[j][0] = pattern;
                            }
                        }
                        for (int j = 0; j < height; j++) {
                            if ((j + 1.0) / i > tan) {
                                canvas[height - 1 - j][i] = pattern;
                            }
                            if ((j + 1.0) / i <= tan) {
                                canvas[height - 1 - j][i] = ' ';
                            }
                        }
                    }
                }
                if (d == 1) {
                    for (int i = 0; i < width; i++) {
                        if (i == width - 1) {
                            for (int j = 0; j < height; j++) {
                                canvas[j][width - 1] = pattern;
                            }
                        }
                        for (int j = 0; j < height; j++) {
                            if ((j + 1.0) / (width - i - 1) > tan) {
                                canvas[height - 1 - j][i] = pattern;
                            }
                            if ((j + 1.0) / (width - i - 1) <= tan) {
                                canvas[height - 1 - j][i] = ' ';
                            }
                        }
                    }
                }
            }return true;
    }
    @Override
    public int getSpaceGridCount() {
        getCanvas();
        int area = 0;
        for (int i = 0 ; i < canvas.length ; i++){
            for (int j = 0 ; j < canvas[0].length ; j++){
                if (!(canvas[i][j]==' ')){
                    area += 1;
                }
            }
        }
        return area;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        for (int i = 0; i < shapes.size();i++){
            for (int j = 0; j < shapes.size();j++){
                if (shapes.get(j).area()>shapes.get(j+1).area()){
                    Shape s = shapes.get(j+1);
                    shapes.set(j+1,shapes.get(j));
                    shapes.set(j,s);
                }
                if (shapes.get(j).area()==shapes.get(j+1).area()){
                    if (shapes.get(j).pattern<shapes.get(j+1).pattern){
                        Shape s = shapes.get(j+1);
                        shapes.set(j+1,shapes.get(j));
                        shapes.set(j,s);
                    }
                }
            }
        }
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        for (int i = 0; i < shapes.size()-1;i++){
            for (int j = 0; j < shapes.size()-1;j++){
                if (shapes.get(j).location.getX()>shapes.get(j+1).location.getX()){
                    Shape s = shapes.get(j+1);
                    shapes.set(j+1,shapes.get(j));
                    shapes.set(j,s);
                }
                if (shapes.get(j).location.getX()==shapes.get(j+1).location.getX()){
                    if (shapes.get(j).location.getY()>shapes.get(j+1).location.getY()){
                        Shape s = shapes.get(j+1);
                        shapes.set(j+1,shapes.get(j));
                        shapes.set(j,s);
                    }
                }
                if (shapes.get(j).location.getX()==shapes.get(j+1).location.getX()){
                    if (shapes.get(j).location.getY()==shapes.get(j+1).location.getY()){
                        if (shapes.get(j).pattern<shapes.get(j+1).pattern){
                            Shape s = shapes.get(j+1);
                            shapes.set(j+1,shapes.get(j));
                            shapes.set(j,s);
                        }
                    }
                }
            }
        }
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
