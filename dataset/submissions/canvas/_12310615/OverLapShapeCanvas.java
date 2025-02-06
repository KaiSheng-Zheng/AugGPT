import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes=new ArrayList<>();
    private char[][] canvas;
    private int constents=0;

    public OverLapShapeCanvas(int rows, int cols) {
        canvas=new char[rows][cols];
        for (int i=0;i<rows;i++){
            for (int n=0;n<cols;n++){
                canvas[i][n]=' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location locations=new Location(x,y);
        if (params.length==1){
            Circle circle=new Circle(locations,pattern,params[0]);
            for (int m=x;m<x+2*params[0];m++){
                int i=m-x;
                for (int n=y;n<y+2*params[0];n++){
                    int p=n-y;
                    if (m<canvas.length&&n<canvas[m].length){
                        if (circle.getGrids()[i][p]!=' '){
                            constents=1;
                            canvas[m][n]=circle.getGrids()[i][p];
                        }
                    }
                }
            }
            if (constents==0){
                return false;
            }
            else {
                shapes.add(circle);
                constents=0;
                return true;
            }
        }
        if (params.length==3){
                if (params[2]==0) {
                    RightTriangle rightTriangle=new RightTriangle(locations,pattern,params[0],params[1],Direction.LEFT_UP);
                    for (int m=x;m<x+params[1];m++){
                        int i=m-x;
                        for (int n=y;n<y+params[0];n++){
                            int p=n-y;
                            if (m<canvas.length&&n<canvas[m].length){
                                if (rightTriangle.getGrids()[i][p]!=' '){
                                    constents=1;
                                    canvas[m][n]=rightTriangle.getGrids()[i][p];
                                }
                            }
                        }
                    }
                    if (constents==0){
                        return false;
                    }
                    else {
                        shapes.add(rightTriangle);
                        constents=0;
                        return true;
                    }
                }
                if (params[2]==1){
                    RightTriangle rightTriangle=new RightTriangle(locations,pattern,params[0],params[1],Direction.LEFT_DOWN);
                    for (int m=x;m<x+params[1];m++){
                        int i=m-x;
                       for (int n=y;n<y+params[0];n++){
                           int p=n-y;
                           if (m<canvas.length&&n<canvas[m].length){
                               if (rightTriangle.getGrids()[i][p]!=' '){
                                   constents=1;
                                   canvas[m][n]=rightTriangle.getGrids()[i][p];
                               }
                           }
                        }
                    }
                    if (constents==0){
                        return false;
                    }
                    else {
                        shapes.add(rightTriangle);
                        constents=0;
                        return true;
                    }
                }
                if (params[2]==2) {
                    RightTriangle rightTriangle=new RightTriangle(locations,pattern,params[0],params[1],Direction.RIGHT_UP);
                    for (int m=x;m<x+params[1];m++){
                        int i=m-x;
                        for (int n=y;n<y+params[0];n++){
                            int p=n-y;
                            if (m<canvas.length&&n<canvas[m].length){
                                if (rightTriangle.getGrids()[i][p]!=' '){
                                    constents=1;
                                    canvas[m][n]=rightTriangle.getGrids()[i][p];
                                }
                            }
                        }
                    }
                    if (constents==0){
                        return false;
                    }
                    else {
                        shapes.add(rightTriangle);
                        constents=0;
                        return true;
                    }
                }
                if (params[2]==3) {
                    RightTriangle rightTriangle=new RightTriangle(locations,pattern,params[0],params[1],Direction.RIGHT_DOWN);
                    for (int m=x;m<x+params[1];m++){
                        int i=m-x;
                        for (int n=y;n<y+params[0];n++){
                            int p=n-y;
                            if (m<canvas.length&&n<canvas[m].length){
                                if (rightTriangle.getGrids()[i][p]!=' '){
                                    constents=1;
                                    canvas[m][n]=rightTriangle.getGrids()[i][p];
                                }
                            }
                        }
                    }
                    if (constents==0){
                        return false;
                    }
                    else {
                        shapes.add(rightTriangle);
                        constents=0;
                        return true;
                    }
                }
        }
        return false;
    }

    @Override
    public int getSpaceGridCount() {
        int space=0;
        for (int m=0;m<canvas.length;m++){
            for (int n=0;n<canvas[m].length;n++){
                if (canvas[m][n]==' '){
                    space++;
                }
            }
        }
        return space;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        Shape[] order=new Shape[shapes.size()];
        for (int m=0;m<shapes.size();m++){order[m]=shapes.get(m);}
        for (int i=0;i<order.length-1;i++){
            for (int n=i+1;n<order.length;n++){
                if (order[i].area()==order[n].area()){
                    if (order[i].pattern>order[n].pattern){
                        Shape save=order[i];
                        order[i]=order[n];
                        order[n]=save;
                    }
                }
                if (order[i].area()>order[n].area()){
                    Shape save=order[i];
                    order[i]=order[n];
                    order[n]=save;
                }
            }
        }
        List<Shape> out=new ArrayList<>();
        for (int o=0;o<shapes.size();o++){out.add(order[o]);}
        return out;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Shape[] order=new Shape[shapes.size()];
        for (int m=0;m<shapes.size();m++){order[m]=shapes.get(m);}
        for (int i=0;i<order.length-1;i++){
            for (int n=i+1;n<order.length;n++){
                if (order[i].location.getX()==order[n].location.getX()){
                    if (order[i].location.getY()>order[n].location.getY()){
                        Shape save=order[i];
                        order[i]=order[n];
                        order[n]=save;
                    }
                    if (order[i].location.getY()==order[n].location.getY()){
                        if (order[i].pattern>order[n].pattern){
                            Shape save=order[i];
                            order[i]=order[n];
                            order[n]=save;
                        }
                    }
                }
                if (order[i].location.getX()>order[n].location.getX()){
                    Shape save=order[i];
                    order[i]=order[n];
                    order[n]=save;
                }
            }
        }
        List<Shape> out=new ArrayList<>();
        for (int o=0;o<shapes.size();o++){out.add(order[o]);}
        return out;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
