import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes=new ArrayList<>();
    private char[][] canvas;
    private int ShapeCount=0;
    private int SumCircle=0;
    private int SumRightTriangle=0;
    public AvoidConflictShapeCanvas(int rows, int cols){
        canvas=new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j]=' ';
            }
        }
    }
    public boolean addShape(int x, int y, char pattern, int... params){
        if(params.length==1){
            if(x+2*params[0]>canvas[0].length){
                return false;
            }else if(y+2*params[0]>canvas.length){
                return false;
            }else {
                for (int i = 0; i < canvas.length; i++) {
                    for (int j = 0; j < canvas[0].length; j++) {
                        if(((i-x+1-params[0])*(i-x+1-params[0])+(j-y+1-params[0])*(j-y+1-params[0]))<params[0]*params[0]){
                            if(canvas[i][j]!=' '){
                                return false;
                            }else if (canvas[i][2*(params[0]+y)-1-j]!=' '){
                                return false;
                            }else if (canvas[2*(params[0]+x)-1-i][j]!=' '){
                                return false;
                            }else if(canvas[2*(params[0]+x)-1-i][2*(params[0]+y)-1-j]!=' '){
                                return false;
                            }
                        }
                    }
                }
                for (int i = 0; i < canvas.length; i++) {
                    for (int j = 0; j < canvas[0].length; j++) {
                        if(((i-x+1-params[0])*(i-x+1-params[0])+(j-y+1-params[0])*(j-y+1-params[0]))<params[0]*params[0]){
                            canvas[i][j]=pattern;
                            canvas[i][2*(params[0]+y)-1-j]=pattern;
                            canvas[2*(params[0]+x)-1-i][j]=pattern;
                            canvas[2*(params[0]+x)-1-i][2*(params[0]+y)-1-j]=pattern;
                            SumCircle++;
                        }
                    }
                }
                shapes.add(new Circle(new Location(x,y),pattern,params[0]));
                ShapeCount++;
                return true;
            }
        }else{
            if(x+params[1]>canvas.length){
                return false;
            }else if(y+params[0]>canvas[0].length){
                return false;
            }else {
                if(params[2] == 0){
                    double k= (double) params[1] /params[0];
                    for (int i = x; i < x+params[1]; i++) {
                        for (int j = y; j < y+params[0]; j++) {
                            if((double)(i-x) /(params[0]-j+y)<k){
                                if(canvas[i][j]!=' '){
                                    return false;
                                }
                            }
                        }
                    }
                }
                if(params[2] == 2){
                    double k= (double) params[1] /params[0];
                    for (int i = x; i < x+params[1]; i++) {
                        for (int j = y; j < y+params[0]; j++) {
                            if((double)(i-x) /(j-y+1)<k){
                                if(canvas[i][j]!=' '){
                                    return false;
                                }
                            }
                        }
                    }
                }
                if(params[2] == 1) {
                    double k = (double) params[1] / params[0];
                    for (int i = x; i < x+params[1]; i++) {
                        for (int j = y; j < y+params[0]; j++) {
                            if ((double) (params[1] - i + x - 1) / (params[0] - j + y) < k) {
                                if (canvas[i ][j ] != ' ') {
                                    return false;
                                }
                            }
                        }
                    }
                }
                if (params[2] == 3) {
                    double k = (double) params[1] / params[0];
                    for (int i = x; i < x+params[1]; i++) {
                        for (int j = y; j < y+params[0]; j++) {
                           if ((double) (params[1] - i + x - 1) / (j - y + 1) < k) {
                               if (canvas[i][j] != ' ') {
                                  return false;
                               }
                           }
                        }
                    }
                }
                if (params[2] == 0) {
                    double k = (double) params[1] / params[0];
                    for (int i = x; i < x+params[1]; i++) {
                        for (int j = y; j < y+params[0]; j++) {
                            if ((double) (i - x) / (params[0] - j + y) < k) {
                               canvas[i ][j ] = pattern;
                               SumRightTriangle++;
                            }
                        }
                    }
                    shapes.add(new RightTriangle(new Location(x,y),pattern,params[0],params[1],Direction.LEFT_UP));
                }
                if (params[2] == 2) {
                    double k = (double) params[1] / params[0];
                    for (int i = x; i < x+params[1]; i++) {
                        for (int j = y; j < y+params[0]; j++) {
                            if ((double) (i - x) / (j - y + 1) < k) {
                                canvas[i ][j ] = pattern;
                                SumRightTriangle++;
                            }
                        }
                    }
                    shapes.add(new RightTriangle(new Location(x,y),pattern,params[0],params[1],Direction.RIGHT_UP));
                }
                if (params[2] == 1) {
                    double k = (double) params[1] / params[0];
                    for (int i = x; i <x+ params[1]; i++) {
                        for (int j = y; j < y+params[0]; j++) {
                             if ((double) (params[1] - i + x - 1) / (params[0] - j + y) < k) {
                                 canvas[i ][j ] = pattern;
                                 SumRightTriangle++;
                             }
                        }
                    }
                    shapes.add(new RightTriangle(new Location(x,y),pattern,params[0],params[1],Direction.LEFT_DOWN));
                }
                if (params[2] == 3) {
                    double k = (double) params[1] / params[0];
                    for (int i = x; i < x+params[1]; i++) {
                        for (int j = y; j < y+params[0]; j++) {
                            if ((double) (params[1] - i + x - 1) / (j - y + 1) < k) {
                                canvas[i ][j ] = pattern;
                                SumRightTriangle++;
                            }
                        }
                    }
                    shapes.add(new RightTriangle(new Location(x,y),pattern,params[0],params[1],Direction.RIGHT_DOWN));
                }
                ShapeCount++;
                return true;
            }
        }
    }

    @Override
    public int getShapeCount() {
        return ShapeCount;
    }

    @Override
    public int getSpaceGridCount() {
        return 4*SumCircle+SumRightTriangle;
    }

    @Override
    public List<Shape> getShapesByArea() {
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = i+1; j < shapes.size(); j++) {
                if(shapes.get(i).area()>shapes.get(j).area()){
                    Shape a=shapes.get(j);
                    shapes.set(j,shapes.get(i));
                    shapes.set(i,a);
                }
            }
        }
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = 1+i; j < shapes.size(); j++) {
                if(shapes.get(i).area()==shapes.get(j).area()){
                    if(shapes.get(i).pattern>shapes.get(j).pattern){
                        Shape a=shapes.get(j);
                        shapes.set(j,shapes.get(i));
                        shapes.set(i,a);
                    }
                }
            }
        }
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = i+1; j < shapes.size(); j++) {
                if(shapes.get(i).location.getX()>shapes.get(j).location.getX()){
                    Shape a=shapes.get(j);
                    shapes.set(j,shapes.get(i));
                    shapes.set(i,a);
                }
            }
        }
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = i+1; j < shapes.size(); j++) {
                if(shapes.get(i).location.getX()==shapes.get(j).location.getX()){
                    if(shapes.get(i).location.getY()>shapes.get(j).location.getY()){
                        Shape a=shapes.get(j);
                        shapes.set(j,shapes.get(i));
                        shapes.set(i,a);
                    }
                }
            }
        }
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = i+1; j < shapes.size(); j++) {
                if(shapes.get(i).location.getX()==shapes.get(j).location.getX()){
                    if(shapes.get(i).location.getY()==shapes.get(j).location.getY()){
                        if(shapes.get(i).pattern>shapes.get(j).pattern){
                            Shape a=shapes.get(j);
                            shapes.set(j,shapes.get(i));
                            shapes.set(i,a);
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
