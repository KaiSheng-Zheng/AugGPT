import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class sortbyarea implements Comparator<Shape>{
    @Override
    public int compare(Shape o1, Shape o2) {
        if(o1.area()!=o2.area()) {
            return o1.area() - o2.area();
        }
        else{
            return o1.pattern-o2.pattern;
        }
    }
}
class sortbyLocation implements Comparator<Shape>{
    @Override
    public int compare(Shape o1, Shape o2) {
        if(o1.location.getX()!=o2.location.getX()){
            return o1.location.getX()-o2.location.getX();
        }
        else if(o1.location.getY()!=o2.location.getY()){
            return o1.location.getY()-o2.location.getY();
        }
        else{
            return o1.pattern-o2.pattern;
        }
    }
}
public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private char[][] canvas;
    private List<Shape> shapes=new ArrayList<>();
    private int shapecount;

    public AvoidConflictShapeCanvas(int row,int col) {
        canvas=new char[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                canvas[i][j]=' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        int row=canvas.length;
        int col=canvas[0].length;
        if(params.length==1){
            int radius=params[0];
            Circle circle=new Circle(new Location(x,y),pattern,radius);
            if(x+2*radius>row-1||x<0||y<0||y+2*radius>col-1){
                return false;
            }
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(circle.inside(i,j,x,y,radius)&&(canvas[i][j]!=' ')){
                        return false;
                    }
                }
            }
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(circle.inside(i,j,x,y,radius)){
                        canvas[i][j]=pattern;
                    }
                }
            }
            shapecount+=1;
            shapes.add(circle);
            return true;
        }
        if(params.length==3){
            int width=params[0];
            int height=params[1];
            final Direction d;
            switch (params[2]){
                case 0:
                    d=Direction.LEFT_UP;
                    break;
                case 1:
                    d=Direction.LEFT_DOWN;
                    break;
                case 2:
                    d=Direction.RIGHT_UP;
                    break;
                case 3:
                    d=Direction.RIGHT_DOWN;
                    break;
                default:d=Direction.LEFT_UP;
            }
            if(d==Direction.LEFT_UP&&(x+height>row||y+width>col||x<0||y<0)){return false;}
            if(d==Direction.LEFT_DOWN&&(x+height>row||y+width>col||y<0||x>row)){return false;}
            if(d==Direction.RIGHT_UP&&(x+height>row||y-width<0||x<0||y>col)){return false;}
            if(d==Direction.RIGHT_DOWN&&(x+height>row||y+width>col||x>row||y>col||x<0||y<0)){return false;}
            for (int i = 1+x; i <= x+height; i++) {
                if (d == Direction.LEFT_UP || d == Direction.LEFT_DOWN) {
                    if((i-1<0)||(i-1>=row)||y<0||y>=col||canvas[i - 1][y] !=' '){
                        return false;
                    }
                } else {
                    if((i-1<0)||(i-1>=row)||width+y-1<0||width+y-1>=col||canvas[i - 1][width+y-1] !=' '){
                        return false;
                    }
                }
                for (int column = 1+y; column < y+width; column++) {
                    if ((i-x) * 1.0 / (column-y) > ((double)height/width)) {
                        int ROW = i - 1;
                        int COL=column-1;
                        if (d == Direction.LEFT_DOWN) {
                            if(canvas[ROW][column]!=' '){
                                return false;
                            }
                        } else if (d == Direction.LEFT_UP) {
                            if(canvas[height-1-ROW+2*x][column] !=' '){
                                return false;
                            }
                        } else if (d == Direction.RIGHT_DOWN) {
                            if(canvas[ROW][width-2-COL+2*y] != ' '){
                                return false;
                            }
                        } else {
                            if(canvas[height-1-ROW+2*x][width-2-COL+2*y] !=' '){
                                return false;
                            }
                        }
                    } else {
                        break;
                    }
                }
            }
            for (int i = 1+x; i <= x+height; i++) {
                if (d == Direction.LEFT_UP || d == Direction.LEFT_DOWN) {
                    canvas[i - 1][y] = pattern;
                } else {
                    canvas[i - 1][width+y - 1] = pattern;
                }
                for (int column = 1+y; column < y+width; column++) {
                    if ((i-x) * 1.0 / (column-y) > ((double)height/width)) {
                        int ROW = i - 1;
                        int COL=column-1;
                        if (d == Direction.LEFT_DOWN) {
                            canvas[ROW][column] = pattern;
                        } else if (d == Direction.LEFT_UP) {
                            canvas[height-1-ROW+2*x][column] = pattern;
                        } else if (d == Direction.RIGHT_DOWN) {
                            canvas[ROW][width-2-COL+2*y] = pattern;
                        } else {
                            canvas[height-1-ROW+2*x][width-2-COL+2*y] = pattern;
                        }
                    } else {
                        break;
                    }
                }
            }
            shapecount+=1;
            shapes.add(new RightTriangle(new Location(x, y),pattern,width,height,d));
            return true;
        }
        return true;
    }
    @Override
    public int getSpaceGridCount() {
        int cnt=0;
        int row=canvas.length;
        int col=canvas[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!(canvas[i][j]==' ')){
                    cnt+=1;
                }
            }
        }
        return cnt;
    }
    @Override
    public int getShapeCount() {
        return shapecount;
    }
    @Override
    public List<Shape> getShapesByArea() {
        sortbyarea sort1=new sortbyarea();
        shapes.sort(sort1);
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        sortbyLocation sort2=new sortbyLocation();
        shapes.sort(sort2);
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
