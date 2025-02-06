import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas  {
    private List<Shape> shapes;
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols)
    {
        canvas = new char[rows][cols];
        for(int i = 0;i<rows;i++){
        for(int j =0;j<cols;j++){
            this.canvas[i][j]=' ';
        }
    }
        this.shapes = new ArrayList<>();
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        char[][] copy = new char[this.canvas.length][this.canvas[0].length] ;
        for(int i = 0;i<canvas.length;i++){
            for(int j =0;j<canvas[0].length;j++){
                copy[i][j]=this.canvas[i][j];
            }
        }
        boolean o = true;
        if(params.length==1){
            Circle circle = new Circle(new Location(x,y),pattern,params[0]);
            for (int i = 0; i <circle.grids.length; i++) {
                for (int j = 0; j <circle.grids[0].length; j++) {
                    try{boolean b = canvas[i+x][j+y]==' ';}
                    catch (ArrayIndexOutOfBoundsException e){
                        o = false;
                        j=circle.grids[0].length;
                        canvas = copy;
                        break;
                    }
                    if(canvas[i+x][j+y]==' '){
                        canvas[i+x][j+y]=circle.grids[i][j];
                    }
                    else if(canvas[i+x][j+y]!=' '&&circle.grids[i][j]==' '){
                    }
                    else{
                        o = false;
                        i=circle.grids.length;
                        canvas = copy;
                        break;
                    }
                }
            }
            if(o){
                shapes.add(circle);
            }
        }
        else{
            RightTriangle rightTriangle = new RightTriangle(new Location(x,y),pattern,params[0],params[1],Direction.values()[params[2]]);
            for (int i = 0; i <rightTriangle.grids.length; i++) {
                for (int j = 0; j <rightTriangle.grids[0].length; j++) {
                    try{boolean b = canvas[i+x][j+y]==' ';}
                    catch (ArrayIndexOutOfBoundsException e){
                        o = false;
                        j=rightTriangle.grids[0].length;
                        canvas = copy;
                        break;
                    }
                    if(canvas[i+x][j+y]==' '){
                        canvas[i+x][j+y]=rightTriangle.grids[i][j];
                    }else if(canvas[i+x][j+y]!=' '&&rightTriangle.grids[i][j]==' '){
                    }
                    else{
                        o = false;
                        i=rightTriangle.grids.length;
                        canvas = copy;
                        break;
                    }
                }
            }
            if(o){
                shapes.add(rightTriangle);
            }

        }
        return o;
    }

    @Override
    public int getSpaceGridCount() {
        int count1 = 0;
        for(int i = 0;i<canvas.length;i++){
            for(int j =0;j<canvas[0].length;j++){
                if(canvas[i][j]!=0){
                    count1++;
                }
            }
        }
        return count1;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        int n = shapes.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (shapes.get(j).area()>shapes.get(j+1).area()) {
                    Shape temp = shapes.get(j);
                    shapes.set(j,shapes.get(j+1));
                    shapes.set(j+1,temp);
                }
                else if(shapes.get(j).area()==shapes.get(j+1).area()){
                    if(shapes.get(j).pattern>shapes.get(j+1).pattern){
                        Shape temp = shapes.get(j);
                        shapes.set(j,shapes.get(j+1));
                        shapes.set(j+1,temp);
                    }
                }
            }
        }
        return shapes;
    }

    @Override
        public List<Shape> getShapesByLocation() {
            int n = shapes.size();
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (shapes.get(j).location.getX()>shapes.get(j+1).location.getX()) {
                        Shape temp = shapes.get(j);
                        shapes.set(j,shapes.get(j+1));
                        shapes.set(j+1,temp);
                    }
                    else if(shapes.get(j).location.getX()==shapes.get(j+1).location.getX()){
                        if(shapes.get(j).location.getY()>shapes.get(j+1).location.getY()){
                            Shape temp = shapes.get(j);
                            shapes.set(j,shapes.get(j+1));
                            shapes.set(j+1,temp);
                        }
                        else if(shapes.get(j).location.getY()==shapes.get(j+1).location.getY()){
                            if(shapes.get(j).pattern>shapes.get(j+1).pattern){
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

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}