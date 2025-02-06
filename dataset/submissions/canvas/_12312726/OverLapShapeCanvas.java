import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes=new ArrayList<>();
    private char[][] canvas;

    @Override
    public char[][] getCanvas() {
        return canvas;
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
        temp.sort(AvoidConflictShapeCanvas.Comparators.Area);

        return temp;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> temp = new ArrayList<>();
        for (int a=0;a<shapes.size();a++){
            temp.add(shapes.get(a));
        }
        temp.sort(AvoidConflictShapeCanvas.Comparators.Location);


        return temp;
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
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location=new Location(x,y);
        if (params.length == 1) {
            Shape circle=new Circle(location,pattern,params[0]);
            char[][] temp=circle.getGrids();
            if(x>=canvas.length||y>=canvas[0].length){
                return false;
            }
            if(x >= 0 && y >= 0){
                boolean result=false;
                for (int a = 0; a < temp.length; a++) {
                    for (int b = 0; b < temp[a].length; b++) {
                        if (x+a>=canvas.length||y+b>=canvas[0].length){
                            continue;
                        }
                        if (temp[a][b] == ' ') {
                            continue;
                        }
                        canvas[x + a][y + b] = temp[a][b];
                        result=true;
                    }
                }
                if (result){
                    shapes.add(circle);
                }
                return result;
            }else{
                int diffX=-x;
                int diffY=-y;
                boolean result=false;
                for (int a = 0; a < temp.length; a++) {
                    for (int b = 0; b < temp[a].length; b++) {
                        if (a+diffX<0||b+diffY<0){
                            continue;
                        }
                        if (temp[a][b] != ' ') {
                            continue;
                        }
                        if (diffX+a>=canvas.length||diffY+b>=canvas[0].length){
                            continue;
                        }
                        canvas[x + a][y + b] = temp[a][b];
                        result=true;
                    }
                }
                if (result){
                    shapes.add(circle);
                }
                return result;
            }


        }
        if (params.length == 3) {
            Direction d = Direction.values()[params[2]];
            Shape triangle = new RightTriangle(location, pattern, params[0], params[1], d);
            char[][] temp = triangle.getGrids();

            if(x>=canvas.length||y>=canvas[0].length){
                return false;
            }
            if(x >= 0 && y >= 0){
                boolean result=false;
                for (int a = 0; a < temp.length; a++) {
                    for (int b = 0; b < temp[a].length; b++) {
                        if (x+a>=canvas.length||y+b>=canvas[0].length){
                            continue;
                        }
                        if (temp[a][b] == ' ') {
                            continue;
                        }
                        canvas[x + a][y + b] = temp[a][b];
                        result=true;
                    }
                }
                if (result){
                    shapes.add(triangle);
                }
                return result;
            }else{
                int diffX=-x;
                int diffY=-y;
                boolean result=false;
                for (int a = 0; a < temp.length; a++) {
                    for (int b = 0; b < temp[a].length; b++) {
                        if (a+diffX<0||b+diffY<0){
                            continue;
                        }
                        if (temp[a][b] != ' ') {
                            continue;
                        }
                        if (diffX+a>=canvas.length||diffY+b>=canvas[0].length){
                            continue;
                        }
                        canvas[x + a][y + b] = temp[a][b];
                        result=true;
                    }
                }
                if (result){
                    shapes.add(triangle);
                }
                return result;
            }
        }
        if (params.length != 1 && params.length != 3) {
            return false;
        }
        return true;

    }
    public OverLapShapeCanvas(int rows,int cols){
        canvas=new char[rows][cols];
        for(int x=0;x<rows;x++){
            for (int y=0;y<cols;y++){
                canvas[x][y]=' ';
            }
        }
    }
    public static void main(String[] args) {
        Location p1 = new Location(0, 1);
        Shape s1 = new RightTriangle(p1, 'X', 7, 3, Direction.RIGHT_UP);
        char[][] grids = s1.getGrids();
        for (char[] line : grids) {
            System.out.println(line);
        }
        System.out.printf("Grids height = %d, width = %d\n", grids.length, grids[0].length);
        System.out.println(s1);
        s1.enlarge();
        grids = s1.getGrids();
        for (char[] line : grids) {
            System.out.println(line);
        }
        System.out.printf("Grids height = %d, width = %d\n", grids.length, grids[0].length);
        System.out.println(s1);
    }
}
