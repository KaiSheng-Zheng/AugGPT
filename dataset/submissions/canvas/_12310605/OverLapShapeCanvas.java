import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
class sortbyarea2 implements Comparator<Shape>{
    @Override
    public int compare(Shape o1, Shape o2) {
        if((o1.area()-o1.getreduction())!=(o2.area()-o2.getreduction())) {
            return o1.area() - o2.area();
        }
        else{
            return o1.pattern-o2.pattern;
        }
    }
}
public class OverLapShapeCanvas implements ShapeCanvas{
    private char[][] canvas;
    private List<Shape> shapes=new ArrayList<>();
    private int shapecount;
    public OverLapShapeCanvas(int row,int col) {
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
        boolean ifFill=false;
        if(params.length==1){
            int radius=params[0];
            Circle circle=new Circle(new Location(x,y),pattern,radius);
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(circle.inside(i,j,x,y,radius)){
                        ifFill=true;
                    }
                }
            }
            if(!ifFill){return false;}
            circle.reduction= circle.area();
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(circle.inside(i,j,x,y,radius)){
                        canvas[i][j]=pattern;
                        circle.reduction-=1;
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
            boolean iffill=false;
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
            RightTriangle rec=new RightTriangle(new Location(x, y),pattern,width,height,d);
            rec.reduction=rec.area();
            for (int i = 1+x; i <= x+height; i++) {
                if (d == Direction.LEFT_UP || d == Direction.LEFT_DOWN) {
                    if((0<=i-1)&&(i-1<row)&&(0<=y)&&(y<col)) {
                        canvas[i - 1][y] = pattern;
                        rec.reduction-=1;
                        iffill=true;
                    }
                } else {
                    if((0<=i-1)&&(i-1<row)&&(0<=(width+y-1))&&((width+y-1)<col)) {
                        canvas[i - 1][width + y - 1] = pattern;
                        rec.reduction-=1;
                        iffill=true;
                    }
                }
                for (int column = 1+y; column < y+width; column++) {
                    if ((i-x) * 1.0 / (column-y) > ((double)height/width)) {
                        int ROW = i - 1;
                        int COL=column-1;
                        if (d == Direction.LEFT_DOWN) {
                            if((0<=ROW)&&(ROW<row)&&(0<=column)&&(column<col)){
                                canvas[ROW][column] = pattern;
                                rec.reduction-=1;
                                iffill=true;
                            }
                        }
                        else if (d == Direction.LEFT_UP) {
                            if((0<=height - 1 - ROW + 2 * x)&&((height - 1 - ROW + 2 * x)<row)&&(0<=column)&&(column<col)) {
                                canvas[height - 1 - ROW + 2 * x][column] = pattern;
                                rec.reduction-=1;
                                iffill=true;
                            }
                        } else if (d == Direction.RIGHT_DOWN) {
                            if((0<=ROW)&&(ROW<row)&&(0<=width - 2 - COL + 2 * y)&&(width - 2 - COL + 2 * y<col)) {
                                canvas[ROW][width - 2 - COL + 2 * y] = pattern;
                                rec.reduction-=1;
                                iffill=true;
                            }
                        } else {
                            if((0<=height - 1 - ROW + 2 * x)&&((height - 1 - ROW + 2 * x)<row)&&(0<=width - 2 - COL + 2 * y)&&(width - 2 - COL + 2 * y<col)) {
                                canvas[height - 1 - ROW + 2 * x][width - 2 - COL + 2 * y] = pattern;
                                rec.reduction-=1;
                                iffill=true;
                            }
                        }
                    } else {
                        break;
                    }
                }
            }
            if(!iffill){return false;}
            shapecount+=1;
            shapes.add(rec);
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
        sortbyarea2 sort1=new sortbyarea2();
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
