import java.util.ArrayList;
import java.util.List;
public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes=new ArrayList<>();
    private char[][] canvas;
    private int rows;
    private int cols;
    private int shapecount;



    public AvoidConflictShapeCanvas(int rows, int cols){
        canvas = new char[rows][cols];
        this.rows=rows;
        this.cols=cols;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j]=' ';
            }

        }
    }

    public boolean addShape(int x, int y, char pattern, int... params){
        boolean f = true;
        if(params.length==1){
            Location location = new Location(x,y);
            Circle circle = new Circle(location,pattern,params[0]);
            for (int i = 0; i < params[0]*2; i++) {
                for (int j = 0; j < params[0]*2; j++) {
                    if(x+i+1>rows || y+j+1>cols){
                        if(circle.getGrids()[i][j]!=' '){
                            f=false;
                        }

                    }else if(canvas[x+i][y+j]!=' ' && circle.getGrids()[i][j]!=' '){
                        f=false;
                    }
                }

            }
            if(f){
                shapecount++;
                shapes.add(circle);
                for (int i = 0; i < params[0]*2; i++) {
                    for (int j = 0; j < params[0]*2; j++) {
                        if(circle.getGrids()[i][j]!=' '){
                            canvas[x + i][y + j] =circle.getGrids()[i][j];
                        }

                    }
                }
            }

        }else if(params.length==3){
            Location location = new Location(x,y);
            Direction direction;
            if(params[2]==0){
                direction=Direction.LEFT_UP;
            }else if(params[2]==1){
                direction=Direction.LEFT_DOWN;
            } else if (params[2]==2) {
                direction=Direction.RIGHT_UP;
            } else{
                direction=Direction.RIGHT_DOWN;
            }
            RightTriangle rightTriangle=new RightTriangle(location,pattern,params[0],params[1],direction);
            for (int i = 0; i < params[1]; i++) {
                for (int j = 0; j < params[0]; j++) {
                    if(x+i+1>rows  || y+j+1>cols ){
                        if(rightTriangle.getGrids()[i][j]!=' '){
                            f=false;
                        }
                    }else if(canvas[x+i][y+j]!=' ' && rightTriangle.getGrids()[i][j]!=' '){
                        f=false;
                    }
                }
            }
            if(f){
                shapecount++;
                shapes.add(rightTriangle);
                for (int i = 0; i < params[1]; i++) {
                    for (int j = 0; j < params[0]; j++) {
                        if(rightTriangle.getGrids()[i][j]!=' '){
                            canvas[x + i][y + j] =rightTriangle.getGrids()[i][j];
                        }
                    }
                }
            }
        }
        return f;
    }

    public int getSpaceGridCount(){
        int count=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(canvas[i][j]!=' '){
                    count+=1;
                }
            }

        }
        return count;
    }
    public int getShapeCount(){
        return shapecount;
    }


    public List<Shape> getShapesByArea(){
        for (int i = 1; i < shapes.size(); i++) {
            for (int j = i; j>0 ; j--) {
                if(shapes.get(j).area() < shapes.get(j-1).area()){
                    Shape a = shapes.get(j-1);
                    shapes.set(j-1,shapes.get(j));
                    shapes.set(j,a);
                }else if(shapes.get(j).area() == shapes.get(j-1).area()){
                    if(shapes.get(j).pattern < shapes.get(j-1).pattern){
                        Shape a = shapes.get(j-1);
                        shapes.set(j-1,shapes.get(j));
                        shapes.set(j,a);
                    }
                }
            }
        }
        return shapes;
    }

    public List<Shape> getShapesByLocation(){
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = i; j>0 ; j--) {
                if(shapes.get(j).location.getX()< shapes.get(j-1).location.getX()){
                    Shape a = shapes.get(j-1);
                    shapes.set(j-1,shapes.get(j));
                    shapes.set(j,a);
                }else if(shapes.get(j).location.getX() == shapes.get(j-1).location.getX()){
                    if(shapes.get(j).location.getY() < shapes.get(j-1).location.getY()){
                        Shape a = shapes.get(j-1);
                        shapes.set(j-1,shapes.get(j));
                        shapes.set(j,a);
                    }else if(shapes.get(j).location.getY() == shapes.get(j-1).location.getY()){
                        if(shapes.get(j).pattern < shapes.get(j-1).pattern){
                            Shape a = shapes.get(j-1);
                            shapes.set(j-1,shapes.get(j));
                            shapes.set(j,a);
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


}
