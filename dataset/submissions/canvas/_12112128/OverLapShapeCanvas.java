import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private ArrayList<Shape> shapes = new ArrayList<>();
    private char[][] canvas;
    public OverLapShapeCanvas(int rows, int cols){
        canvas=new char[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                canvas[i][j]=' ';
            }
        }
    }//constructor
    public int getSpaceGridCount(){
        int n=0;
        for(int i=0;i< canvas.length;i++){
            for(int j=0;j< canvas[0].length;j++){
                if(canvas[i][j]==' '){
                    n++;
                }else;
            }
        }
        return n;
    }
    public int getShapeCount(){
        return shapes.size();
    }
    public List<Shape> getShapesByArea(){
        int n = shapes.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (shapes.get(j).area() > shapes.get(j+1).area()) {
                    Shape temp = shapes.get(j);
                    shapes.set(j,shapes.get(j+1));
                    shapes.set(j+1,temp);
                } else if (shapes.get(j).area() == shapes.get(j+1).area()) {
                    if (shapes.get(j).pattern>shapes.get(j+1).pattern) {
                        Shape temp = shapes.get(j);
                        shapes.set(j,shapes.get(j+1));
                        shapes.set(j+1,temp);
                    }
                }
            }
        }
        return shapes;
    }
    public List<Shape> getShapesByLocation(){
        int n = shapes.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (shapes.get(j).location.getX() > shapes.get(j+1).location.getX()) {
                    Shape temp = shapes.get(j);
                    shapes.set(j,shapes.get(j+1));
                    shapes.set(j+1,temp);
                } else if (shapes.get(j).location.getX() == shapes.get(j+1).location.getX()) {
                    if(shapes.get(j).location.getY() > shapes.get(j+1).location.getY()){
                        Shape temp = shapes.get(j);
                        shapes.set(j,shapes.get(j+1));
                        shapes.set(j+1,temp);
                    }else if(shapes.get(j).location.getY() == shapes.get(j+1).location.getY()){
                        if (shapes.get(j).pattern>shapes.get(j+1).pattern) {
                            Shape temp = shapes.get(j);
                            shapes.set(j,shapes.get(j+1));
                            shapes.set(j+1,temp);
                        }
                    }
                }
            }
        }
        return shapes;

    }
    public char[][] getCanvas(){
        return canvas;
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params){
        var location=new Location(x,y);
        Shape shape=null;
        if(params.length==1){
            shape= new Circle(location, pattern, params[0]);
        }else if(params.length==3){
            Direction d;
            if(params[2]==0){
                d=Direction.LEFT_UP;
            } else if (params[2]==1) {
                d=Direction.LEFT_DOWN;
            } else if (params[2]==2) {
                d=Direction.RIGHT_UP;
            } else {
                d=Direction.RIGHT_DOWN;
            }
            shape= new RightTriangle(location, pattern, params[0], params[1], d);
        }

        char[][] grids=shape.grids;

        boolean G=true;
        for(int a=0;a<grids.length;a++){
            for(int b=0;b<grids[0].length;b++){
                if(y+b<canvas[0].length&&x+a<canvas.length&&grids[a][b]!=' '){
                    G=false;
                }
            }
        }
        if(G==true){
            return false;
        }

        for(int i=0;i<grids.length;i++){
            for(int j=0;j<grids[0].length;j++){
                if(y+j<canvas[0].length&&x+i<canvas.length&&grids[i][j]!=' ') {
                    canvas[x + i][y + j] = grids[i][j];
                }
            }
        }
        shapes.add(shape);
        return true;
    }

}
