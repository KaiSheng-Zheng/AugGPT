import java.util.ArrayList;
public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private ArrayList<Shape> shapes = new ArrayList<>();
    private ArrayList<Shape> sort = new ArrayList<>();
    private Shape a;
    private char[][] canvas;
    private char[][] before = new char[1000][1000];
    private char[][] save;
    int m,check = 0;
    public AvoidConflictShapeCanvas(int rows, int cols){
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params){
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                before[i][j] = canvas[i][j];
            }
        }
        Location p1 = new Location(x, y);
        int w = 0,h = 0;
        Shape s1 = null;
        if(params.length == 3) {
            if (params[2] == 0) {
                s1 = new RightTriangle(p1, pattern, params[0], params[1], Direction.LEFT_UP);
                w = params[0];
                h = params[1];
            } else if (params[2] == 1) {
                s1 = new RightTriangle(p1, pattern, params[0], params[1], Direction.LEFT_DOWN);
                w = params[0];
                h = params[1];
            } else if (params[2] == 2) {
                s1 = new RightTriangle(p1, pattern, params[0], params[1], Direction.RIGHT_UP);
                w = params[0];
                h = params[1];
            } else if (params[2] == 3) {
                s1 = new RightTriangle(p1, pattern, params[0], params[1], Direction.RIGHT_DOWN);
                w = params[0];
                h = params[1];
            }
        }else{
            s1 = new Circle(p1, pattern, params[0]);
            w = 2*params[0];
            h = 2*params[0];
        }
        m = 0;
        check = 0;
        save = s1.getGrids();
        for (int i = x; i < before.length; i++) {
            for (int j = y; j < before[i].length; j++) {
                if(i-x < h && j-y < w && save[i - x][j - y] == pattern && before[i][j] == ' '){
                    before[i][j] = save[i - x][j - y];
                    m++;
                }else if(i-x < h && j-y < w && save[i - x][j - y] != ' ' && before[i][j] != ' '){
                    check = 1;
                    break;
                }
            }
            if(check == 1){
                break;
            }
        }
        if(m == s1.area()){
            System.out.println(m + " " + s1.area());
            shapes.add(s1);
            for (int i = 0; i < canvas.length; i++) {
                for (int j = 0; j < canvas[i].length; j++) {
                    canvas[i][j] = before[i][j];
                }
            }
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }
    public int getSpaceGridCount(){
        int k = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if(canvas[i][j] != ' '){
                    k++;
                }
            }
        }
        return k;
    }
    public ArrayList<Shape> getShapesByArea(){
        sort = shapes;
        for (int i = 0; i < sort.size(); i++) {
            for (int j = 0; j < sort.size() - 1; j++) {
                if(sort.get(j).area() > sort.get(j + 1).area()){
                    a = sort.get(j);
                    sort.remove(j);
                    sort.add(j + 1, a);
                }
            }
        }
        for (int i = 0; i < sort.size(); i++) {
            for (int j = 0; j < sort.size() - 1; j++) {
                if (sort.get(j).area() == sort.get(j + 1).area() && sort.get(j).getPattern() > sort.get(j + 1).getPattern()) {
                    System.out.println((int)sort.get(j).pattern);
                    a = sort.get(j);
                    sort.remove(j);
                    sort.add(j + 1, a);
                }
            }
        }
        return sort;
    }

    public ArrayList<Shape> getShapesByLocation(){
        sort = shapes;
        for (int i = 0; i < sort.size(); i++) {
            for (int j = 0; j < sort.size() - 1; j++) {
                if(sort.get(j).getX() > sort.get(j + 1).getX()){
                    a = sort.get(j);
                    sort.remove(j);
                    sort.add(j + 1, a);
                }
                if (sort.get(j).getX() == sort.get(j + 1).getX() && sort.get(j).getY() > sort.get(j + 1).getY()) {
                    a = sort.get(j);
                    sort.remove(j);
                    sort.add(j + 1, a);
                }
            }
        }
        for (int i = 0; i < sort.size(); i++) {
            for (int j = 0; j < sort.size() - 1; j++) {
                if (sort.get(j).getX() == sort.get(j + 1).getX() && sort.get(j).getY() == sort.get(j + 1).getY() && sort.get(j).getPattern() > sort.get(j + 1).getPattern()) {
                    a = sort.get(j);
                    sort.remove(j);
                    sort.add(j + 1, a);
                }
            }
        }
        return sort;
    }
    public char[][] getCanvas(){
        return canvas;
    }
}

