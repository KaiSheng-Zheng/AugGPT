import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes=new ArrayList<Shape>();
    private char[][] canvas;



    public AvoidConflictShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        for(int x=0;x<rows;x++){
            for (int y=0;y<cols;y++){
                canvas[x][y]=' ';
            }
        }
    }


    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x, y);
        if (params.length == 1) {
            if (x + params[0]*2-1 > canvas[0].length - 1) {
                return false;
            }
            if (x < 0) {
                return false;
            }
            if (y + params[0] *2-1 > canvas.length - 1) {
                return false;
            }
            if (y  < 0) {
                return false;
            }
            Shape circle = new Circle(location, pattern, params[0]);
            char[][] temp = circle.getGrids();
            for (int a = 0; a < temp.length; a++) {
                for (int b = 0; b < temp[a].length; b++) {
                    if (canvas[x + a][y + b] != ' ' && temp[a][b] != ' ') {
                        return false;
                    }
                }
            }
            for (int a = 0; a < temp.length; a++) {
                for (int b = 0; b < temp[a].length; b++) {
                    if (temp[a][b] == ' ') {
                        continue;
                    }
                    canvas[x + a][y + b] = temp[a][b];
                }
            }
            shapes.add(circle);
            return true;

        }
        if (params.length == 3) {
            Direction d = Direction.values()[params[2]];
            Shape triangle = new RightTriangle(location, pattern, params[0], params[1], d);
            if (x + params[1] -1> canvas.length - 1) {
                return false;
            }
            if (x < 0) {
                return false;
            }
            if (y + params[0] -1 > canvas[0].length - 1) {
                return false;

            }
            if (y  < 0) {
                return false;
            }
            char[][] temp = triangle.getGrids();
            for (int a = 0; a < temp.length; a++) {
                for (int b = 0; b < temp[a].length; b++) {
                    if (canvas[x + a][y + b] != ' ' && temp[a][b] != ' ') {
                        return false;
                    }
                }
            }
            for (int a = 0; a < temp.length; a++) {
                for (int b = 0; b < temp[a].length; b++) {
                    if (temp[a][b] == ' ') {
                        continue;
                    }
                    canvas[x + a][y + b] = temp[a][b];
                }
            }
            shapes.add(triangle);
            return true;
        }
        if (params.length != 1 && params.length != 3) {
            return false;
        }
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int a=0;
        for (int x = 0; x<canvas.length; x++){
            for (int y=0;y<canvas[x].length;y++){
                if(canvas[x][y]==' '){
                    a++;
                }
            }
        }
        return a;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        List<Shape> temp = new ArrayList<>();
        for (int a=0;a<shapes.size();a++){
            temp.add(shapes.get(a));
        }
        temp.sort(Comparators.Area);

        return temp;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> temp =new ArrayList<>();
        for (int a=0;a<shapes.size();a++){
            temp.add(shapes.get(a));
        }
        temp.sort(Comparators.Location);


        return temp;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

    public static class Comparators{

        public static Comparator<Shape> Area = new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                int i=o1.area-o2.area;
                Character pattern1=o1.pattern;
                Character pattern2=o2.pattern;
                if (i==0){
                    i=pattern1.compareTo(pattern2);
                }
                return i;
            }
        };
        public static Comparator<Shape> Location=new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                int i=o1.location.getX()-o2.location.getX();
                if (i==0){
                    i=o1.location.getY()-o2.location.getY();
                }
                Character pattern1=o1.pattern;
                Character pattern2=o2.pattern;
                if (i==0){
                    i=pattern1.compareTo(pattern2);
                }
                return i;
            }
        };



    }
}

