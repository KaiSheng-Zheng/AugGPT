import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public OverLapShapeCanvas(int rows, int cols){
        this.canvas=new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (shapes == null) {
            shapes = new ArrayList<>();
        }
        Location location=new Location(x,y);
        int col=canvas[0].length;
        int row=canvas.length;
        if(params.length==1){//circle
            Circle circle = new Circle(location,pattern,params[0]);
            circle.fillGrids();
            int t=0;
            int wm= Math.min(( 2 * params[0]), (canvas[0].length-y));
            int hm=Math.min(( 2 * params[0]), (canvas.length-x));
            for(int i=0;i<wm;i++){
                for(int j=0;j<hm;j++){
                    if(circle.grids[j][i]==pattern){
                        t++;
                    }
                }
            }
            if(t==0){return false;}
            for(int i=0;i<wm;i++){
                for(int j=0;j<hm;j++){
                    if(circle.grids[j][i]==pattern){
                        canvas[j+x][i+y]=circle.grids[j][i];
                    }
                }
            }
            shapes.add(circle);
        }
        if(params.length==3){//triangle
            Direction d=Direction.LEFT_UP;
            if(params[2]==1){d=Direction.LEFT_DOWN;}
            if(params[2]==2){d=Direction.RIGHT_UP;}
            if(params[2]==3){d=Direction.RIGHT_DOWN;}
            RightTriangle triangle=new RightTriangle(location,pattern,params[0],params[1],d);
            triangle.fillGrids();
            int t=0;
            int wm= Math.min((params[0]), (canvas[0].length-y));
            int hm=Math.min(( params[1]), (canvas.length-x));
            for(int i=0;i<wm;i++){
                for(int j=0;j<hm;j++){
                    if(triangle.grids[j][i]==pattern){t++;}
                }
            }
            if (t==0){return false;}
            for(int i=0;i<wm;i++){
                for(int j=0;j<hm;j++){
                    if(triangle.grids[j][i]==pattern){
                        canvas[j+x][i+y]=triangle.grids[j][i];
                    }
                }
            }
            shapes.add(triangle);
        }
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int total = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] == ' ') {
                    total++;
                }
            }
        }
        return total;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        List<Shape> shapeA=new ArrayList<Shape>();
        int [] cask=new int[canvas.length*canvas[0].length];
        List<Shape> store=new ArrayList<Shape>();
        for (Shape value : shapes) {
            cask[value.area()]++;
        }
        for (int i=0;i<canvas.length*canvas[0].length;i++){
            if(cask[i]==0){continue;}
            if(cask[i]==1){
                for (Shape shape : shapes) {
                    if (shape.area() == i) {
                        shapeA.add(shape);
                        break;
                    }
                }
            }
            if(cask[i]>1){
                char[] B=new char[cask[i]];
                int t=0;
                for (Shape shape : shapes) {
                    if (shape.area() == i) {
                        store.add(shape);
                        B[t]=shape.pattern;
                        t=t+1;
                    }
                }
                Arrays.sort(B);
                for (char c : B) {
                    for (Shape shape : store) {
                        if (c == shape.pattern) {
                            shapeA.add(shape);
                        }
                    }
                }
            }
        }
        return shapeA;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> shapeL=new ArrayList<Shape>();
        int []caskx=new int [canvas.length];
        for (Shape shape : shapes) {
            caskx[shape.location.getX()]++;
        }
        for(int i=0;i<canvas.length;i++){
            if(caskx[i]==0){continue;}
            if (caskx[i]==1) {
                for (Shape value : shapes) {
                    if (value.location.getX() == i) {
                        shapeL.add(value);
                        break;
                    }
                }
            }
            if (caskx[i]>1){
                int []casky=new int [canvas[0].length];
                for (Shape shape : shapes) {
                    if (shape.location.getX() == i) {
                        casky[shape.location.getY()]++;
                    }
                }
                for(int j=0;j<canvas[0].length;j++){
                    if (casky[j]==0){continue;}
                    if(casky[j]==1){
                        for (Shape value : shapes) {
                            if (value.location.getX() == i&&value.location.getY()==j) {
                                shapeL.add(value);
                                break;
                            }
                        }
                    }
                    if (casky[j]>1){
                        char[] B=new char[casky[j]];
                        int t=0;
                        for(int m=0;m<shapes.size();m++){
                                if(shapes.get(m).location.getX()==i&&shapes.get(m).location.getY()==j){
                                    B[t]=shapes.get(m).pattern;
                                    t=t+1;
                                }
                            }
                        Arrays.sort(B);
                        for (char c : B) {
                            for (int n=0;n<shapes.size();n++) {
                                if (c == shapes.get(n).pattern&&shapes.get(n).location.getX()==i&&shapes.get(n).location.getY()==j) {
                                    shapeL.add(shapes.get(n));
                                }
                            }
                        }
                    }
                }
            }
        }
        return shapeL;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
