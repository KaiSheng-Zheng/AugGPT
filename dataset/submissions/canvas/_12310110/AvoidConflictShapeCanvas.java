import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols){
        canvas = new char[rows][cols];
        this.shapes = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    private int count = 0;
    public boolean addShape(int x, int y, char pattern, int... params){
        Location location = new Location(x,y);
        if(params.length==1){
            Circle circle =new  Circle(location,pattern,params[0]);
            if(x+2*params[0]>canvas.length||y+2*params[0]>canvas[0].length){
                return false;
            }else {
                for (int i = x; i < 2*params[0]+x; i++) {
                    for (int j = y; j < 2*params[0]+y; j++) {
                        if((i-params[0])*(i-params[0])+(j-params[0])*(j-params[0])<=params[0]*params[0]){
                            if (canvas[i][j]!=' '){
                                return false;
                            }
                        }
                        else if (circle.check(i-x,j-y)){
                            if (canvas[i][j]!=' '){
                                return false;
                            }
                        }
//                        if (i>params[0]-1&j>params[0]-1&(i-params[0])*(i-params[0])+(j-params[0])*(j-params[0])==params[0]*params[0]){
//                                canvas[i][j] = ' ';
//                        }
                    }
                }
                for (int i = x; i < 2*params[0]+x; i++) {
                    for (int j = y; j < 2*params[0]+y; j++) {
                if((i-params[0])*(i-params[0])+(j-params[0])*(j-params[0])<=params[0]*params[0]){
                    canvas[i][j] = pattern;
                } else if (circle.check(i-x,j-y)){
                    canvas[i][j] = pattern;
                }}}
                count++;
                shapes.add(circle);
                return true;
            }
        }
        if(params.length==3){
            if (x+params[1]>canvas.length||y+params[0]>canvas[0].length){
                return false;
            }else {
            switch (params[2]) {
                case 0:
                    RightTriangle rightTriangle0 = new RightTriangle(location, pattern, params[0], params[1], Direction.LEFT_UP);
                    rightTriangle0.fillGrids();
                    for (int i = x; i < params[1]+x; i++) {
                        for (int j = y; j < params[0]+y; j++) {
                            if (rightTriangle0.grids[i-x][j-y]!=' '&&canvas[i][j]!=' '){
                                return false;
                            }
                        }
                    }
                    rightTriangle0.fillGrids(canvas,x,y);
                    count++;
                    shapes.add(rightTriangle0);
                    return true;
                case 1:
                    RightTriangle rightTriangle1 = new RightTriangle(location, pattern, params[0], params[1], Direction.LEFT_DOWN);
                    rightTriangle1.fillGrids();
                    for (int i = x; i < params[1]+x; i++) {
                        for (int j = y; j < params[0]+y; j++) {
                            if (rightTriangle1.grids[i-x][j-y]!=' '&&canvas[i][j]!=' '){
                                return false;
                            }
                        }
                    }
                    rightTriangle1.fillGrids(canvas,x,y);
                    count++;
                    shapes.add(rightTriangle1);
                    return true;
                case 2:
                    RightTriangle rightTriangle2 = new RightTriangle(location, pattern, params[0], params[1], Direction.RIGHT_UP);
                    rightTriangle2.fillGrids();
                    for (int i = x; i < params[1]+x; i++) {
                        for (int j = y; j < params[0]+y; j++) {
                            if (rightTriangle2.grids[i-x][j-y]!=' '&&canvas[i][j]!=' '){
                                return false;
                            }
                        }
                    }
                    rightTriangle2.fillGrids(canvas,x,y);
                    count++;
                    shapes.add(rightTriangle2);
                    return true;
                case 3:
                    RightTriangle rightTriangle3 = new RightTriangle(location, pattern, params[0], params[1], Direction.RIGHT_DOWN);
                    rightTriangle3.fillGrids();
                    for (int i = x; i < params[1]+x; i++) {
                        for (int j = y; j < params[0]+y; j++) {
                            if (rightTriangle3.grids[i-x][j-y]!=' '&&canvas[i][j]!=' '){
                                return false;
                            }
                        }
                    }
                    rightTriangle3.fillGrids(canvas,x,y);
                    count++;
                    shapes.add(rightTriangle3);
                    return true;
                default:
                    return false;
            } }
        }
        return false;
    }

    @Override
    public int getSpaceGridCount() {
        int count1 = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j]==' '){
                    count1++;
                }
            }
        }
        return count1;
    }

    @Override
    public int getShapeCount() {
        return count;
    }

    @Override
    public List<Shape> getShapesByArea() {
        int[] areas = new int[shapes.size()];
        for (int i = 0; i < shapes.size(); i++) {
            areas[i] = shapes.get(i).area();
        }
        for (int i = 0; i < areas.length; i++) {
            for (int j = i+1; j < areas.length; j++) {
                if (areas[i]>areas[j]){
                    int temp = areas[i];
                    areas[i] = areas[j];
                    areas[j] = temp;
                    Shape temp1 = shapes.get(i);
                    shapes.set(i,shapes.get(j));
                    shapes.set(j,temp1);
                }
            }
        }
        for (int i = 0; i < areas.length; i++) {
            if (i+1==areas.length){
                break;
            }
            if (areas[i]==areas[i+1]){
                ArrayList<Shape> temp = new ArrayList<>();
                temp.add(shapes.get(i));
                temp.add(shapes.get(i+1));
                for (int j = i+2; j < areas.length; j++) {
                    if (areas[i]==areas[j]){
                        temp.add(shapes.get(j));
                    }
                }
                for (int i1 = 0; i1 < temp.size(); i1++) {
                    for (int j = i1+1; j < temp.size(); j++) {
                        if (temp.get(i1).pattern>temp.get(j).pattern){
                            Shape temp3 = temp.get(i1);
                            temp.set(i1,temp.get(j));
                            temp.set(j,temp3);
                        }
                    }
                }
                for (int j = 0; j < temp.size(); j++) {
                    shapes.set(i+j,temp.get(j));
                }
            }
        }
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        int[] x = new int[shapes.size()];
        int[] y = new int[shapes.size()];
        int[] chars = new int[shapes.size()];
        for (int i = 0; i < shapes.size(); i++) {
            x[i] = shapes.get(i).location.getX();
            y[i] = shapes.get(i).location.getY();
            chars[i] = shapes.get(i).pattern;
        }
        for (int i = 0; i < x.length; i++) {
            for (int j = i+1; j < x.length; j++) {
                if (x[i]>x[j]){
                    int temp = x[i];
                    x[i] = x[j];
                    x[j] = temp;
                    int temp1 = y[i];
                    y[i] = y[j];
                    y[j] = temp1;
                    int temp2 = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp2;
                    Shape temp3 = shapes.get(i);
                    shapes.set(i,shapes.get(j));
                    shapes.set(j,temp3);
                }
            }
        }
        for (int i = 0; i < shapes.size(); i++) {
            if (i==shapes.size()-1){
                break;
            }
            if (x[i]==x[i+1]){
                if (y[i]>y[i+1]){
                    int temp = y[i];
                    y[i] = y[i+1];
                    y[i+1] = temp;
                    int temp1 = chars[i];
                    chars[i] = chars[i+1];
                    chars[i+1] = temp1;
                    Shape temp2 = shapes.get(i);
                    shapes.set(i,shapes.get(i+1));
                    shapes.set(i+1,temp2);
                }
            }
        }
        for (int i = 0; i < shapes.size(); i++) {
            if (i==shapes.size()-1){
                break;
            }
            if (x[i]==x[i+1]&&y[i]==y[i+1]){
                if (chars[i]>chars[i+1]){
                    int temp = chars[i];
                    chars[i] = chars[i+1];
                    chars[i+1] = temp;
                    Shape temp1 = shapes.get(i);
                    shapes.set(i,shapes.get(i+1));
                    shapes.set(i+1,temp1);
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




