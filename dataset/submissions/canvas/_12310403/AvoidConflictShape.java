import java.util.Collections;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{

    private List<Shape> shapes;
    private char[][] canvas;
    private int row;
    private int col;




    public AvoidConflictShapeCanvas(int rows, int cols){
        this.row=rows;
        this.col=cols;
        canvas=new char[row][col];
        for(char[] row :canvas ){
            for (char value : row ){
                value=' ';
            }
        }
    }



//    @Override
//    public boolean addShape(int x, int y, char pattern, int... params) {
//        if (params.length == 1) {
//            int radius = params[0];
//            boolean inCanvas = (x >= 0 && x + 2 * radius < row && y >= 0 && y + 2 * radius < col);
//            if (!inCanvas) {
//                return false;
//            }
//            Location location = new Location(x, y);
//            Circle circle = new Circle(location, pattern, params[0]);
//            char[][] grids = circle.getGrids();
//            for (int i = 0; i < grids.length; i++) {
//                for (int j = 0; j < grids[0].length; j++) {
//                    if (canvas[i + x][j + y] != 0) return false;
//                    canvas[i + x][j + y] = pattern;
//                }
//            }
//            shapes.add(circle);
//            return true;
//        } else if (params.length == 3) {
//            int width = params[0];
//            int height = params[1];
//            Direction direction = Direction.values()[params[2]];
//            Location location = new Location(x, y);
//            RightTriangle rightTriangle = new RightTriangle(location, pattern, width, height, direction);
//            char[][] grids = rightTriangle.getGrids();
//            for (int i = 0; i < grids.length; i++) {
//                for (int j = 0; j < grids[0].length; j++) {
//                    if (grids[i][j] != 0 && i + x >= 0 && i + x < canvas.length && j + y >= 0 && j + y < canvas[i].length) {
//                        canvas[i + x][j + y] = pattern;
//                    } else {
//                        return false;
//                    }
//                }
//            }
//            shapes.add(rightTriangle);
//            return true;
//        }
//        return false;
//    }
public boolean addShape(int x,int y ,char pattern,int... arrgs){
    if(arrgs.length==1){
        Location location = new Location(x, y);
        Circle circle = new Circle (location,pattern,arrgs[0]);
        char[][] shapeGrids = circle.getGrids();
        int h=x;
        int l = y;
        int r =(y+2*arrgs[0]);
        int b = (x+ 2*arrgs[0]);
        if(b>canvas.length||h<0){
            return false;
        }
        if(r>canvas[1].length||l<0){
            return false;
        }
        for(int i=0;i<shapeGrids.length;i++){
            for(int j=0;j<shapeGrids[i].length;j++){
                if(shapeGrids[i][j]==pattern&&canvas[i+x][j+y]!=' '){
                    return false;
                }
            }
        }
        for(int i=0;i<shapeGrids.length;i++){
            for(int j=0;j<shapeGrids[i].length;j++){
                if(shapeGrids[i][j]==pattern){
                    canvas[i+x][j+y]=pattern;
                }
            }
        }
        shapes.add(circle);
    }else {
        Direction direction =Direction.values()[arrgs[2]];
        Location location =new Location(x,y);
        RightTriangle rightTriangle = new RightTriangle(location,pattern,arrgs[0],arrgs[1],direction);
        char[][] shapeGrids = rightTriangle.getGrids();
        int l=y;
        int r=y+arrgs[0];
        int b=x+arrgs[1];
        int h=x;
        if(b>canvas.length||h<0){
            return false;
        }
        if(r>canvas[1].length||l<0){
            return false;
        }
        for(int i=0;i<shapeGrids.length;i++){
            for(int j=0;j<shapeGrids[i].length;j++){
                if(shapeGrids[i][j]==pattern&&canvas[i+x][j+y]!=' '){
                    return false;
                }
            }
        }
        for(int i=0;i<shapeGrids.length;i++){
            for(int j=0;j<shapeGrids[i].length;j++){
                if(shapeGrids[i][j]==pattern){
                    canvas[i+x][j+y]=pattern;
                }
            }
        }
        shapes.add(rightTriangle);
    }
    return true;
}









    @Override
    public int getSpaceGridCount() {
        int count=0;
            for (char[] row : canvas) {
                for (char value : row) {
                    if (value == ' ') {
                        count++;
                    }
                }
            }
        return count;
    }

    @Override
    public int getShapeCount() {
        int shapeNum =0;
        for (Shape shape : shapes){
            shapeNum++;
        }
        return shapeNum;
    }


    @Override
    public List<Shape> getShapesByArea() {

        Collections.sort(shapes,new ShapeAreaComparator());

        return shapes;
    }

    class ShapeAreaComparator implements java.util.Comparator<Shape> {
        @Override
        public int compare(Shape a,Shape b) {
            return a.area - b.area;
        }
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes,new ShapeLocationComparator());
        return null;
    }

    class ShapeLocationComparator implements java.util.Comparator<Shape> {
        @Override
        public int compare(Shape a,Shape b) {
            if (a.location.getX() - b.location.getX()!=0){
                return a.location.getX() - b.location.getX();
            }
            if (a.location.getY()-b.location.getY()!=0){
                return a.location.getY()-b.location.getY();
            }
            return (int)a.pattern-(int)b.pattern;
        }
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
