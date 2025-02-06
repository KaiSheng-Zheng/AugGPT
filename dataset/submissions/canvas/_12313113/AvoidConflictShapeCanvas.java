import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols){
        this.canvas = new char[rows][cols];
        this.shapes = new ArrayList<>();
    }
    public boolean addShape(int x, int y, char pattern, int... params) {
        boolean b = true;
        if (params.length == 1) {
            Shape temp = new Circle(new Location(x, y), pattern, params[0]);
            if (x+params[0]*2>=this.canvas.length||y+params[0]*2>=this.canvas.length){
                b = false;
            }
            for (int i = 0; i < params[0] * 2&&b; i++) {
                for (int j = 0; j < params[0] * 2; j++) {
                    if (!(temp.getGrids()[i][j] == pattern && this.canvas[x + i][y + j] == '\u0000' )) {
                        b = false;
                    }
                }
            }
            if (b) {
                this.shapes.add(temp);
                for (int i = 0; i < params[0]*2; i++) {
                    for (int j = 0; j < params[0]*2; j++) {
                        if (temp.getGrids()[i][j]==pattern){
                            this.canvas[x+i][y+j]=pattern;
                        }
                    }
                }
            }
        }
        else{
                int a = params[2];
                Direction d;
                if (a == 0) {
                    d = Direction.LEFT_UP;
                } else if (a == 1) {
                    d = Direction.LEFT_DOWN;
                } else if (a == 2) {
                    d = Direction.RIGHT_UP;
                } else {
                    d = Direction.RIGHT_DOWN;
                }

                Shape temp = new RightTriangle(new Location(x, y), pattern, params[0], params[1], d);
                for (int i = 0; i < params[1]; i++) {
                    for (int j = 0; j < params[0]; j++) {
                        if ((x+i>=this.canvas.length||y+j>=this.canvas[0].length)&&temp.getGrids()[i][j]==pattern){
                            b = false;
                            break;
                        } else if (temp.getGrids()[i][j] == pattern && this.canvas[x + i][y + j] != '\u0000' ) {
                            b = false;
                        }
                    }
                }
                if (b) {
                    this.shapes.add(temp);
                    for (int i = 0; i < params[1]; i++) {
                        for (int j = 0; j < params[0]; j++) {
                            if (temp.getGrids()[i][j]==pattern){
                                this.canvas[x+i][y+j]=pattern;
                            }
                        }
                    }
                }
            }
            return b;

        }

    public int getSpaceGridCount(){
        int temp =0;
        for (int i=0; i<this.canvas.length;i++){
            for (int j = 0; j<this.canvas[0].length;j++){
                if (this.canvas[i][j]== '\u0000'){
                    temp++;
                }
            }
        }
        return temp;
    }

    public int getShapeCount(){
        return shapes.size();
    }

    public List<Shape> getShapesByArea(){
        Collections.sort(this.shapes);
        return this.shapes;
    }

    public List<Shape> getShapesByLocation(){
        //shapes.sort(Comparator.naturalOrder());
        ArrayList<Shape> shapes1=new ArrayList<>();
        ArrayList<Integer> temp =new ArrayList<>();
        for (int i=0; i<shapes.size();i++){
            temp.add(shapes.get(i).location.getX());
        }
        temp.sort(Comparator.naturalOrder());
        for (int i=0; i<shapes.size();i++){
            for (int j = 0; j<shapes.size();j++){
                if (shapes.get(j).location.getX()==temp.get(i)){
                    shapes1.add(shapes.get(j));
                }
            }
        }
        for (int i=0; i<(shapes1.size()-1);i++){
            Shape a;
            if(shapes1.get(i)==shapes1.get(i+1)){
                if(shapes1.get(i).location.getY()>shapes1.get(i+1).location.getY()){
                    a = shapes1.get(i);
                    shapes1.set(i,shapes1.get(i+1));
                    shapes1.set(i+1,a);
                }else if(shapes1.get(i).location.getY()==shapes1.get(i+1).location.getY()){
                    if (shapes1.get(i).pattern>shapes1.get(i+1).pattern){
                        a = shapes1.get(i);
                        shapes1.set(i,shapes1.get(i+1));
                        shapes1.set(i+1,a);
                    }
                }
            }
        }
        return shapes1;
    }


    public char[][] getCanvas(){
        for(int i=0;i<this.canvas.length;i++){
            for (int j=0;j<this.canvas[0].length;j++){
                if (this.canvas[i][j]=='\u0000'){
                    this.canvas[i][j]=' ';
                }
            }
        }
        return canvas;
    }
}