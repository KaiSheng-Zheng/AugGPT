import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{

    private List<Shape> shapes;

    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols){
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
        if (x>=canvas.length || y>=canvas[0].length){
            return false;
        }
        if (params.length==1){
            Location center=new Location(x,y);
            Circle circle=new Circle(center,pattern,params[0]);
            circle.fillGrids();

                     for (int i=0;i<params[0]*2;i++){
                         for (int j=0;j<params[0]*2;j++){
                             if (i+x<canvas.length & j+y<canvas[0].length & circle.grids[i][j]!=' ' ){
                                 for (int k=x;k<canvas.length;k++){
                                     for (int l=y;l<canvas[0].length;l++){
                                         if (k-x<params[0]*2 && l-y<params[0]*2 && circle.grids[k-x][l-y]!=' '){
                                             canvas[k][l]=pattern;
                                         }
                                     }
                                 }
                                 shapes.add(circle);
                                 return true;
                             }
                         }
                     }
                     return false;
        }

        else {

            if (params[2]==0){
                Location center=new Location(x,y);
                RightTriangle triangle=new RightTriangle(center,pattern,params[0],params[1],Direction.LEFT_UP);
                triangle.fillGrids();

                for (int i=0;i<params[1];i++){
                    for (int j=0;j<params[0];j++){
                        if (i+x<canvas.length & j+y<canvas[0].length & triangle.grids[i][j]!=' ' ){
                            for (int k=x;k<canvas.length;k++){
                                for (int l=y;l<canvas[0].length;l++){
                                    if (k-x<params[1] && l-y<params[0] && triangle.grids[k-x][l-y]!=' '){
                                        canvas[k][l]=pattern;
                                    }
                                }
                            }
                            shapes.add(triangle);
                            return true;
                        }
                    }
                }
                return false;


            }
            else if (params[2]==1){
                Location center=new Location(x,y);
                RightTriangle triangle=new RightTriangle(center,pattern,params[0],params[1],Direction.LEFT_DOWN);
                triangle.fillGrids();

                for (int i=0;i<params[1];i++){
                    for (int j=0;j<params[0];j++){
                        if (i+x<canvas.length & j+y<canvas[0].length & triangle.grids[i][j]!=' ' ){
                            for (int k=x;k<canvas.length;k++){
                                for (int l=y;l<canvas[0].length;l++){
                                    if (k-x<params[1] && l-y<params[0] && triangle.grids[k-x][l-y]!=' '){
                                        canvas[k][l]=pattern;
                                    }
                                }
                            }
                            shapes.add(triangle);
                            return true;
                        }
                    }
                }
                return false;

            }
            else if (params[2]==2){
                Location center=new Location(x,y);
                RightTriangle triangle=new RightTriangle(center,pattern,params[0],params[1],Direction.RIGHT_UP);
                triangle.fillGrids();

                for (int i=0;i<params[1];i++){
                    for (int j=0;j<params[0];j++){
                        if (i+x<canvas.length & j+y<canvas[0].length & triangle.grids[i][j]!=' ' ){
                            for (int k=x;k<canvas.length;k++){
                                for (int l=y;l<canvas[0].length;l++){
                                    if (k-x<params[1] && l-y<params[0] && triangle.grids[k-x][l-y]!=' '){
                                        canvas[k][l]=pattern;
                                    }
                                }
                            }
                            shapes.add(triangle);
                            return true;
                        }
                    }
                }
                return false;

            }
            else {
                Location center=new Location(x,y);
                RightTriangle triangle=new RightTriangle(center,pattern,params[0],params[1],Direction.RIGHT_DOWN);
                triangle.fillGrids();

                for (int i=0;i<params[1];i++){
                    for (int j=0;j<params[0];j++){
                        if (i+x<canvas.length & j+y<canvas[0].length & triangle.grids[i][j]!=' ' ){
                            for (int k=x;k<canvas.length;k++){
                                for (int l=y;l<canvas[0].length;l++){
                                    if (k-x<params[1] && l-y<params[0] && triangle.grids[k-x][l-y]!=' '){
                                        canvas[k][l]=pattern;
                                    }
                                }
                            }
                            shapes.add(triangle);
                            return true;
                        }
                    }
                }
                return false;

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
