import java.util.*;
public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes = new ArrayList<>();
    private List<Integer> areaList;
    private List<Integer> locationList;
    int rows;
    int cols;
    int shapeCount=0;
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x,y);

        if (params.length == 1){//circle
            int radius = params[0];
            int height = radius*2;
            int width = radius*2;
            Circle circle = new Circle(location,pattern,radius);
            if (x+radius*2 > rows || y+radius*2 > cols ||x<0||y<0){
                return false;//out of bound false
            }

            else {//add pattern
                for (int i = x; i < x+height; i++) {
                    for (int j = y; j < y+width; j++) {
                        if (canvas[i][j]!=' ' && circle.grids[i-x][j-y]!=' '){
                            return false;//overlapping false
                        }
                    }
                }
            }
            for (int i = x; i < x+height; i++) {
                for (int j = y; j < y+width; j++) {
                    if (canvas[i][j]==' ') {
                        canvas[i][j] = circle.grids[i-x][j-y];
                    }
                }
            }
            shapes.add(circle);
            return true;
        }


        if(params.length == 3){//rightTriangle
            int width = params[0];
            int height =params[1];
            Direction d = null ;
            if (params[2]==0) d = Direction.LEFT_UP;
            if (params[2]==1) d = Direction.LEFT_DOWN;
            if (params[2]==2) d = Direction.RIGHT_UP;
            if (params[2]==3) d = Direction.RIGHT_DOWN;
            RightTriangle rightTriangle = new RightTriangle(location,pattern,width,height,d);

            if (x+height > rows || y+width > cols||x<0||y<0){
                return false;//out of bound false
            }

            else {//add pattern
                for (int i = x; i < x+height; i++) {
                    for (int j = y; j < y+width; j++) {
                        if (canvas[i][j]!=' ' && rightTriangle.grids[i-x][j-y]!=' '){
                            return false;//overlapping false
                        }
                    }
                }
            }
            for (int i = x,p=0; i < x+height; i++,p++) {
                for (int j = y,q=0; j < y+width; j++,q++) {
                    if (canvas[i][j]==' ') {
                        canvas[i][j] = rightTriangle.grids[p][q];
                    }
                }
            }
            shapes.add(rightTriangle);
            return true;
        }
        return false;
    }

    @Override
    public int getSpaceGridCount() {
        int num = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (canvas[i][j]==' '){
                    num++;
                }
            }
        }
        return canvas.length*canvas[0].length - num;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                if (s1.area()!=s2.area()) {
                    return Integer.compare(s1.area(), s2.area());
                }
                else {
                    return Integer.compare(s1.pattern, s2.pattern);
                }
            }
        });
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                if (s1.location.getX() != s2.location.getX()){
                    return Integer.compare(s1.location.getX(),s2.location.getX());
                } else if (s1.location.getX() == s2.location.getX()&&s1.location.getY() != s2.location.getY()) {
                    return Integer.compare(s1.location.getY(),s2.location.getY());
                }else {
                    return Integer.compare(s1.pattern, s2.pattern);
                }
            }
        });
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
