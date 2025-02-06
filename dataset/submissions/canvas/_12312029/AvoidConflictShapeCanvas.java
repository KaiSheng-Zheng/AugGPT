import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public  class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    private int rows;
    private  int cols;
    public AvoidConflictShapeCanvas(int rows, int cols){
        canvas = new char[rows][cols];
        this.cols = cols;
        this.rows = rows;
        for( int i = 0;i<rows;i++ ){
            for( int j = 0 ;j<cols;j++ ){
                canvas[i][j] = ' ';
            }
        }

    }
    public boolean addShape(int x, int y, char pattern, int param){
        Location p = new Location(x,y);
        Circle cir = new Circle(p,pattern,param);
        char[][] map = cir.getGrids();
        char[][] ans = new char[rows][cols];
        for( int i=0;i<rows;i++ ){
            for( int j=0;j<cols;j++ ) ans[i][j] = canvas[i][j];
        }
        if( x + 2 * param <= rows && y + 2 * param <= cols ){
            for( int i = x;i <x+param+param;i++ ){
                for( int j = y;j<y+param+param;j++ ){
                    if( ans[i][j] != ' ' && map[i-x][j-y] == pattern){
                        return false;
                    }else if( map[i-x][j-y] == pattern ){
                        ans[i][j] = pattern;
                    }
                }
            }
            if(shapes == null) {
                shapes = new ArrayList<>();
            }
            canvas = ans;
            shapes.add( cir );
            return true;
        }else return false;

    }
    public boolean addShape(int x, int y, char pattern, int param1,int param2,int param3){
        Location p = new Location(x,y);

        Direction[] arr = Direction.values();
        RightTriangle rtg = new RightTriangle(p,pattern,param1,param2,arr[param3]);
        char[][] map = rtg.getGrids();
        char[][] ans = new char[rows][cols];
        for( int i=0;i<rows;i++ ){
            for( int j=0;j<cols;j++ ) ans[i][j] = canvas[i][j];
        }
        if( check( x+param2 , y ) && check( x , y+param1 )  ){
            for( int i =x;i<=x+param2-1;i++ ){
                for( int j = y ;j<=y+param1-1;j++){
                    if( ans[i][j] != ' ' && map[i-x][j-y] == pattern ){
                        return false;
                    }else if( map[i -x][j-y] == pattern ){
                        ans[i][j] = pattern;
                    }

                }
            }
            if(shapes == null) {
                shapes = new ArrayList<>();
            }
            canvas = ans;
            shapes.add( rtg );
            return true;
        }else return false;

    }

    public boolean check( int a , int b ){
        if( a >=0 && b >= 0 && a <=rows && b <=cols ) return true;
        return false;
    }
    public int getSpaceGridCount() {
        int count = 0;
        for(int i = 0;i < rows ;i++) {
            for(int j = 0;j < cols;j++) {
                if(canvas[i][j] == ' ') {
                    count++;
                }
            }
        }
        return count;
    }
    public int getShapeCount() {
        return shapes.size();
    }
    public List<Shape> getShapesByArea() {
        shapes.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                if (s1.area() != s2.area())
                    return Integer.compare(s1.area(), s2.area());
                else
                    return Character.compare(s1.getPattern(), s2.getPattern());
            }
        });
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                if (s1.location.getX() != s2.location.getX())
                    return Integer.compare(s1.location.getX(), s2.location.getX());
                else if (s1.location.getY() != s2.location.getY())
                    return Integer.compare(s1.location.getY(), s2.location.getY());
                else
                    return Character.compare(s1.getPattern(), s2.getPattern());
            }
        });
        return shapes;
    }
    public char[][] getCanvas() {return canvas;}



}
