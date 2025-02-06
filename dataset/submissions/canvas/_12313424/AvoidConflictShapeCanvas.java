
import java.util.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas{

    private List<Shape> shapes;

    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols){
        canvas=new char[rows][cols];
        shapes=new ArrayList<>();
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                canvas[i][j]=' ';
            }
        }



    }


    @Override
    public boolean addShape(int x, int y, char pattern, int... params){

        if (params.length==1){
            Location center=new Location(x,y);
            Circle circle=new Circle(center,pattern,params[0]);
            circle.fillGrids();
                if (y+2*params[0]-1>canvas[0].length-1 || x+2*params[0]-1>canvas.length-1){
                    return false;
                }
                for (int i=0;i<params[0]*2;i++){
                    for (int j=0;j<params[0]*2;j++){
                        if (circle.grids[i][j]!=' ' && canvas[i+x][j+y]!=' '){
                            return false;
                        }
                    }
                }
            for (int i=0;i<params[0]*2;i++){
                for (int j=0;j<params[0]*2;j++){
                    if (circle.grids[i][j]!=' '){
                        canvas[i+x][j+y]=pattern;
                    }
                }
            }
            shapes.add(circle);
                return true;

            }

            else {
                if (y+params[0]-1>canvas[0].length-1 || x+params[1]-1>canvas.length-1){
                    return false;
                }
                if (params[2]==0){
                    Location center=new Location(x,y);
                    RightTriangle triangle=new RightTriangle(center,pattern,params[0],params[1],Direction.LEFT_UP);
                    triangle.fillGrids();
                    for (int i = 0; i < params[1]; i++) {
                        for (int j = 0; j < params[0]; j++) {
                                if (triangle.grids[i][j]!=' ' && canvas[i+x][j+y]!=' ' ){
                                    return false;
                                }
                        }
                    }
                    for (int i=0;i<params[1];i++){
                        for (int j=0;j<params[0];j++){
                            if (triangle.grids[i][j]!=' '){
                                canvas[i+x][j+y]=pattern;
                            }
                        }
                    }
                    shapes.add(triangle);
                    return true;

                }
                else if (params[2]==1){
                    Location center=new Location(x,y);
                    RightTriangle triangle=new RightTriangle(center,pattern,params[0],params[1],Direction.LEFT_DOWN);
                    triangle.fillGrids();
                    for (int i = 0; i < params[1]; i++) {
                        for (int j = 0; j < params[0]; j++) {
                            if (triangle.grids[i][j]!=' ' && canvas[i+x][j+y]!=' ' ){
                                return false;
                            }
                        }
                    }
                    for (int i=0;i<params[1];i++){
                        for (int j=0;j<params[0];j++){
                            if (triangle.grids[i][j]!=' '){
                                canvas[i+x][j+y]=pattern;
                            }
                        }
                    }
                    shapes.add(triangle);
                    return true;
                }
                else if (params[2]==2){
                    Location center=new Location(x,y);
                    RightTriangle triangle=new RightTriangle(center,pattern,params[0],params[1],Direction.RIGHT_UP);
                    triangle.fillGrids();
                    for (int i = 0; i < params[1]; i++) {
                        for (int j = 0; j < params[0]; j++) {
                            if (triangle.grids[i][j]!=' ' && canvas[i+x][j+y]!=' ' ){
                                return false;
                            }
                        }
                    }
                    for (int i=0;i<params[1];i++){
                        for (int j=0;j<params[0];j++){
                            if (triangle.grids[i][j]!=' '){
                                canvas[i+x][j+y]=pattern;
                            }
                        }
                    }
                    shapes.add(triangle);
                    return true;
                }
                else {
                    Location center=new Location(x,y);
                    RightTriangle triangle=new RightTriangle(center,pattern,params[0],params[1],Direction.RIGHT_DOWN);
                    triangle.fillGrids();
                    for (int i = 0; i < params[1]; i++) {
                        for (int j = 0; j < params[0]; j++) {
                            if (triangle.grids[i][j]!=' ' && canvas[i+x][j+y]!=' ' ){
                                return false;
                            }
                        }
                    }
                    for (int i=0;i<params[1];i++){
                        for (int j=0;j<params[0];j++){
                            if (triangle.grids[i][j]!=' '){
                                canvas[i+x][j+y]=pattern;
                            }
                        }
                    }
                    shapes.add(triangle);
                    return true;
                }

            }
    }

    @Override
    public int getSpaceGridCount() {
        int a=0;
        for (int i=0;i<canvas.length;i++) {
            for (int j=0;j<canvas[0].length;j++) {
                if (canvas[i][j]==' '){
                    a+=1;
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
//        Collections.sort(shapes, new Comparator<Shape>() {
//            @Override
//            public int compare(Shape s1, Shape s2) {
//                return s1.area()-s2.area();
//            }
//        }.thenComparing(new Comparator<Shape>()));
        shapes.sort(Comparator.comparing((Shape s) -> s.area())
                .thenComparing(s -> s.pattern));

        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort(Comparator.comparing((Shape s) -> s.location.getX())
                .thenComparing(s -> s.location.getY()).thenComparing(s -> s.pattern));

        return shapes;
    }

    @Override
    public char[][] getCanvas() {

        return canvas;
    }
}
