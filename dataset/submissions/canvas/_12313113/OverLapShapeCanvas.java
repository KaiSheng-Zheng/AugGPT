import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public OverLapShapeCanvas(int rows, int cols){
        this.canvas = new char[rows][cols];
        shapes = new ArrayList<>();
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params){
        boolean b = true;
        boolean c = false;
        if (params.length == 1) {
            Shape temp = new Circle(new Location(x, y), pattern, params[0]);
            if ((x+params[0]*2)>canvas.length||(y+params[0]*2)>canvas[0].length){
                for (int i1=0;i1+x<canvas.length&&i1<temp.getGrids().length;i1++){
                    for (int j1 = 0; j1+y<canvas[0].length&&j1<temp.getGrids()[0].length; j1++){
                        if (temp.getGrids()[i1][j1]==temp.pattern){
                            c=true;
                            break;
                        }
                    }
                }
                if (!c){
                    b=false;
                }
            }
            if (b){
                this.shapes.add(temp);
                for (int i = 0; x+i<this.canvas.length&&i<temp.getGrids().length; i++) {
                    for (int j = 0;y+j<this.canvas.length&&j<temp.getGrids()[0].length; j++) {
                        if (temp.getGrids()[i][j]==temp.pattern){
                            this.canvas[x+i][j+y] = temp.pattern;
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
            for (int i1=0;i1+x<canvas.length&&i1<temp.getGrids().length;i1++){
                for (int j1 = 0; j1+y<canvas[0].length&&j1<temp.getGrids()[0].length; j1++){
                    if (temp.getGrids()[i1][j1]==temp.pattern){
                        c=true;
                        break;
                    }
                }
            }
                if (!c){
                    b=false;

                }

            if (b) {
                this.shapes.add(temp);
                for (int i = 0; x+i<this.canvas.length&&i<temp.getGrids().length; i++) {
                    for (int j = 0;y+j<this.canvas[0].length&&j<temp.getGrids()[0].length; j++) {
                        if (temp.getGrids()[i][j]==temp.pattern){
                            this.canvas[x+i][j+y] = temp.pattern;
                        }
                    }
                }
            }
        }
        return b;
    }


    @Override
    public int getSpaceGridCount() {
        int temp=0;
        for (int i = 0;i<this.canvas.length;i++){
            for (int j = 0;j<this.canvas[0].length;j++)
                if (this.canvas[i][j]!='\u0000'){
                    temp++;
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

    public List<Shape> getShapesByLocation() {
        //shapes.sort(Comparator.naturalOrder());
        ArrayList<Shape> shapes1 = new ArrayList<>();
        shapes1 = (ArrayList<Shape>) shapes;
        for (int j = 100000 ; j >= 0; j--) {
            for (int i = 0; i <this.shapes.size()-1; i++) {
                Shape a, b;
                if (shapes1.get(i).location.getX() > shapes1.get(i + 1).location.getX()) {
                    a = shapes1.get(i);
                    b = shapes1.get(i + 1);
                    shapes1.set(i, b);
                    shapes1.set(i + 1, a);
                } else if (shapes1.get(i).location.getY() > shapes1.get(i + 1).location.getY()&&shapes1.get(i).location.getX() == shapes1.get(i + 1).location.getX()) {
                    a = shapes1.get(i);
                    b = shapes1.get(i + 1);
                    shapes1.set(i, b);
                    shapes1.set(i + 1, a);
                } else if (shapes1.get(i).location.getY() == shapes1.get(i + 1).location.getY()&&shapes1.get(i).location.getY() == shapes1.get(i + 1).location.getY()) {
                    if (shapes1.get(i).pattern > shapes1.get(i + 1).pattern) {
                        a = shapes1.get(i);
                        b = shapes1.get(i + 1);
                        shapes1.set(i, b);
                        shapes1.set(i + 1, a);
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
