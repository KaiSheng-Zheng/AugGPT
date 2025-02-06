import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols){
        this.shapes = new ArrayList<>();
        this.canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int i1 = 0; i1 < cols; i1++) {
                canvas[i][i1]=' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location l = new Location(x,y);
        if(params.length==1){



            Circle c = new Circle(l, pattern, params[0]);
            c.fillGrids();
            char[][] grids = c.getGrids();
            int in = 0;
            for (int i = 0; i < params[0]*2; i++) {
                for (int j = 0; j < params[0]*2; j++) {
                    if(grids[i][j] == pattern){
                        if(x+i<=canvas.length-1&x+i>=0&y+j<=canvas[0].length-1&y+j>=0){
                            in++;
                        }
                    }
                }
            }
            if(in == 0){return false;}

            for (int i = 0; i < params[0]*2; i++) {
                for (int j = 0; j < params[0]*2; j++) {
                    if(x+i<=canvas.length-1&x+i>=0&y+j<=canvas[0].length-1&y+j>=0){
                        if(grids[i][j] == pattern) {
                            canvas[x + i][y + j] = pattern;
                        }
                    }
                }
            }
            shapes.add(c);

        }else{



            RightTriangle rt = new RightTriangle(l,pattern,params[0],params[1],Direction.values()[params[2]]);
            rt.fillGrids();
            char[][] grids = rt.getGrids();
            int in = 0;
            for (int i = 0; i < params[1]; i++) {
                for (int j = 0; j < params[0]; j++) {
                    if(grids[i][j] == pattern){
                        if(x+i<=canvas.length-1&x+i>=0&y+j<=canvas[0].length-1&y+j>=0){
                            in++;
                        }
                    }
                }
            }
            if(in == 0){return false;}

            for (int i = 0; i < params[1]; i++) {
                for (int j = 0; j < params[0]; j++) {
                    if(x+i<=canvas.length-1&x+i>=0&y+j<=canvas[0].length-1&y+j>=0){

                        if(grids[i][j] == pattern) {
                            canvas[x + i][y + j] = pattern;
                        }
                    }
                }
            }
            shapes.add(rt);
        }



        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int sum = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0;  j < canvas[0].length; j++) {
                if(canvas[i][j] == ' '){
                    sum++;
                }
            }
        }
        return sum;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        Shape temp;
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = 1; j < (shapes.size() - i); j++) {
                if (shapes.get(j - 1).area() > shapes.get(j).area()) {
                    temp = shapes.get(j - 1);
                    shapes.set(j-1, shapes.get(j));
                    shapes.set(j,temp);
                } else if (shapes.get(j - 1).area() == shapes.get(j).area()) {
                    if(shapes.get(j-1).pattern>shapes.get(j).pattern){
                        temp = shapes.get(j - 1);
                        shapes.set(j-1, shapes.get(j));
                        shapes.set(j,temp);
                    }
                }
            }
        }
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Shape temp;
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = 1; j < (shapes.size() - i); j++) {
                if (shapes.get(j - 1).location.getX() > shapes.get(j).location.getX()) {
                    temp = shapes.get(j - 1);
                    shapes.set(j-1, shapes.get(j));
                    shapes.set(j,temp);
                } else if (shapes.get(j - 1).location.getX() == shapes.get(j).location.getX()) {
                    if(shapes.get(j-1).location.getY()>shapes.get(j).location.getY()){
                        temp = shapes.get(j - 1);
                        shapes.set(j-1, shapes.get(j));
                        shapes.set(j,temp);
                    } else if (shapes.get(j-1).location.getY()==shapes.get(j).location.getY()) {
                        if(shapes.get(j-1).pattern>shapes.get(j).pattern){
                            temp = shapes.get(j - 1);
                            shapes.set(j-1, shapes.get(j));
                            shapes.set(j,temp);
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
