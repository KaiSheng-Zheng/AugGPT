import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;
    public OverLapShapeCanvas(int rows, int cols){
        canvas = new char[rows][cols];
        for (int a = 0; a < rows; a++) {
            for (int b = 0; b < cols; b++) {
                canvas[a][b] = ' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length == 1) {
            var location = new Location(x, y);
            Circle circle = new Circle(location, pattern, params[0]);
            if (x >= canvas[0].length || y >= canvas.length) {
                return false;
            }
            /*for (int a = 0; a < circle.getGrids().length; a++) {
                for (int b = 0; b < circle.getGrids()[0].length; b++) {
                    if (circle.getGrids()[a][b] != ' ') {
                        if (canvas[a + x][b + y] != ' ') {
                            return false;
                        }
                    }
                }
            }*/
            int middle = 0;
            for (int a = 0; a < circle.getGrids().length; a++) {
                for (int b = 0; b < circle.getGrids()[0].length; b++) {
                    if(a+x>=canvas.length||b+y>=canvas[0].length){
                        continue;
                    }
                    if (circle.getGrids()[a][b] !=' ') {
                        middle = 1;
                    }
                }
            }
            if (middle == 0){
                return false;
            }
            shapes.add(circle);
            for (int a = 0; a < circle.getGrids().length; a++) {
                for (int b = 0; b < circle.getGrids()[0].length; b++) {
                    if(a+x>=canvas.length||b+y>=canvas[0].length){
                        continue;
                    }
                    if (circle.getGrids()[a][b] != ' ') {
                        canvas[a + x][b + y] = pattern;
                    }
                }
            }
            return true;
        }else {
            //System.out.println('l');
            var location = new Location(x, y);
            Direction d = Direction.LEFT_UP;
            switch (params[2]) {
                case 0: {
                    d = Direction.LEFT_UP;
                    break;
                }
                case 1: {
                    d = Direction.LEFT_DOWN;
                    break;
                }
                case 2: {
                    d = Direction.RIGHT_UP;
                    break;
                }
                case 3: {
                    d = Direction.RIGHT_DOWN;
                    break;
                }
            }
            RightTriangle rightTriangle = new RightTriangle(location, pattern, params[0], params[1], d);
            //System.out.println("''");
            /*System.out.println(x);//11
            System.out.println(canvas[0].length);//20
            System.out.println(y);//17
            System.out.println(canvas.length);//15*/
            //w3 h2
            if (x >= canvas.length || y >= canvas[0].length/* || x + params[1] - 1 >= canvas.length || y + params[0] - 1 >= canvas[0].length*/) {
                return false;
            }
            /*
            for (int a = 0; a < rightTriangle.getGrids().length; a++) {
                //System.out.println(a);
                for (int b = 0; b < rightTriangle.getGrids()[0].length; b++) {
                    //System.out.println(b);
                    //System.out.println('b');
                    if (rightTriangle.getGrids()[a][b] != ' ') {
                        if (canvas[a + x][b + y] != ' ') {
                            return false;
                        }
                    }
                    //System.out.println('a');
                }
            }*/
            int middle = 0;
            for (int a = 0; a < rightTriangle.getGrids().length; a++) {
                for (int b = 0; b < rightTriangle.getGrids()[0].length; b++) {
                    if(a+x>=canvas.length||b+y>=canvas[0].length){
                        continue;
                    }
                    if (rightTriangle.getGrids()[a][b] !=' ') {
                        middle = 1;
                    }
                }
            }
            if (middle == 0){
                return false;
            }
            shapes.add(rightTriangle);
            for (int a = 0; a < rightTriangle.getGrids().length; a++) {
                for (int b = 0; b < rightTriangle.getGrids()[0].length; b++) {
                    if(a+x>=canvas.length||b+y>=canvas[0].length){
                        continue;
                    }
                    if (rightTriangle.getGrids()[a][b] != ' ') {
                        canvas[a + x][b + y] = pattern;
                    }
                }
            }
            return true;
        }//RightTriangle
    }


    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (int a = 0; a < canvas.length; a++) {
            for (int b = 0; b < canvas[0].length; b++) {
                if (canvas[a][b] == ' ') {
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
        Shape [] a = new  Shape [shapes.size()];
        for (int i = 0;i<shapes.size();i++){
            a[i]=shapes.get(i);
        }
        List<Shape> shapeOverride= new ArrayList<>();
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].area() < a[minIndex].area()) {
                    minIndex = j;
                }
                if(a[j].area() == a[minIndex].area()){
                    if(a[j].getPattern() <a[minIndex].getPattern()){
                        minIndex = j;
                    }
                }
            }
            if (i != minIndex) {
                Shape temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }

        for (int i = 0;i<shapes.size();i++){
            shapeOverride.add(a[i]);
        }
        return shapeOverride;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Shape [] a = new  Shape [shapes.size()];
        for (int i = 0;i<shapes.size();i++){
            a[i]=shapes.get(i);
        }
        List<Shape> shapeOverride= new ArrayList<>();
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].getLocation().getX() < a[minIndex].getLocation().getX()) {
                    minIndex = j;
                }
                if(a[j].getLocation().getX() == a[minIndex].getLocation().getX()){
                    if (a[j].getLocation().getY() < a[minIndex].getLocation().getY()) {
                        minIndex = j;
                    }
                }
                if(a[j].getLocation().getX() == a[minIndex].getLocation().getX()&&a[j].getLocation().getY() == a[minIndex].getLocation().getY()){
                    if(a[j].getPattern() <a[minIndex].getPattern()){
                        minIndex = j;
                    }
                }
            }
            if (i != minIndex) {
                Shape temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }

        for (int i = 0;i<shapes.size();i++){
            shapeOverride.add(a[i]);
        }
        return shapeOverride;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
