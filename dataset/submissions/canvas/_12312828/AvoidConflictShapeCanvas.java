import java.util.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas{


    private List<Shape> shapes;

    private char[][] canvas;

    private List<Shape> shapefake=new ArrayList<>();


    public AvoidConflictShapeCanvas(int rows, int cols){
        canvas=new char[rows][cols];
        for (int i=0;i<=rows-1;i++){
            for (int j=0;j<=cols-1;j++){
                canvas[i][j]=' ';
            }
        }
    }


    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        int paramslength=params.length;
        if (paramslength==1) {
            if (checkCircle(x, y, pattern, params[0])) {
                Circle circle = new Circle(new Location(x, y), pattern, params[0]);
                for (int i = x; i <= x + 2 * params[0] - 1; i++) {
                    for (int j = y; j <= y + 2 * params[0] - 1; j++) {
                        if (circle.grids[i-x][j-y]!=' ') {
                            canvas[i][j] = circle.grids[i - x][j - y];
                        }
                    }
                }
                shapefake.add(circle);
                return true;
            }
            return false;
        }else{
            if (checkRightTriangle(x,y,pattern,params)){
                Direction d=Direction.RIGHT_UP;
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
                }

                RightTriangle rightTriangle=new RightTriangle(new Location(x,y),pattern,params[0],params[1],d);
                for (int i=x;i<=x+params[1]-1;i++){
                    for (int j=y;j<=y+params[0]-1;j++){
                        if (rightTriangle.grids[i-x][j-y]!=' ') {
                            canvas[i][j] = rightTriangle.grids[i - x][j - y];
                        }
                    }
                }
                shapefake.add(rightTriangle);
                return true;
            }
            return false;
        }

    }

    @Override
    public int getSpaceGridCount() {
        int num=0;
        for (int i=0;i<=canvas.length-1;i++){
            for (int j=0;j<=canvas[0].length-1;j++){
                if (canvas[i][j]==0){ // space is not 0 in ASCII, is 32
                    num++;
                }
            }
        }
        return num;

    }

    @Override
    public int getShapeCount() {
        return shapefake.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        Collections.sort(shapefake, new Comparator<Shape>(){


            @Override
            public int compare(Shape o1, Shape o2) {
                if (o1.area!=o2.area){
                    return Integer.compare(o1.area,o2.area);
                }
                return Integer.compare((int)o1.pattern,(int)o2.pattern);

            }
        });
        return shapefake;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapefake, new Comparator<Shape>(){


            @Override
            public int compare(Shape o1, Shape o2) {
                if (o1.location.getX()!=o2.location.getX()){
                    return Integer.compare(o1.location.getX(), o2.location.getX());
                }
                if (o1.location.getY()!=o2.location.getY()){
                    return Integer.compare(o1.location.getY(), o2.location.getY());
                }
                return Integer.compare((int)o1.pattern,(int)o2.pattern);



            }
        });
        return shapefake;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

    public boolean  checkCircle(int x,int y,char pattern,int params){
        Circle circle=new Circle(new Location(x,y),pattern,params);
        int rows=canvas.length;
        int cols=canvas[0].length;
        char[][]experiment=new char[rows][cols];
        for (int i=0;i<=rows-1;i++) {
            for (int j=0;j<=cols-1;j++){
                experiment[i][j]=canvas[i][j];
            }
        }




        int originnum =0;
        int actualnum =0;
        if (x+2*params>rows||y+2*params>cols){
            return false;
        }
        for (int i=x;i<=x+2*params-1;i++){
            for (int j=y;j<=y+2*params-1;j++){
                if (canvas[i][j]==' '){
                    originnum++;
                }
            }
        }
        for (int i=x;i<=x+2*params-1;i++){
            for (int j=y;j<=y+2*params-1;j++){
                if(experiment[i][j]==' ') {
                    experiment[i][j] = circle.grids[i-x][j-y];
                }
            }
        }
        for (int i=x;i<=x+2*params-1;i++){
            for (int j=y;j<=y+2*params-1;j++){
                if (experiment[i][j]==' '){
                    actualnum++;
                }
            }
        }


        int circlearea=circle.area;
        if (originnum-circlearea!=actualnum){
            return false;
        }else{
            return true;
        }
    }

    Direction d;
    public boolean checkRightTriangle(int x,int y,char pattern,int... params){
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
        }

        RightTriangle rightTriangle=new RightTriangle(new Location(x,y),pattern,params[0],params[1],d);
        int rows=canvas.length;
        int cols=canvas[0].length;
        char[][]experiment=new char[rows][cols];
        for (int i=0;i<=rows-1;i++) {
            for (int j=0;j<=cols-1;j++){
                experiment[i][j]=canvas[i][j];
            }
        }
        int originnum1 =0;
        int actualnum1 =0;
        if (x+params[1]>rows||y+params[0]>cols){
            return false;
        }

        for (int i=x;i<=x+params[1]-1;i++){
            for (int j=y;j<=y+params[0]-1;j++){
                if (canvas[i][j]==' '){
                    originnum1++;
                }
            }
        }
        for (int i=x;i<=x+params[1]-1;i++){
            for (int j=y;j<=y+params[0]-1;j++){
                if (experiment[i][j]==' '){
                    experiment[i][j]=rightTriangle.grids[i-x][j-y];
                }
            }
        }
        for (int i=x;i<=x+params[1]-1;i++){
            for (int j=y;j<=y+params[0]-1;j++){
                if (experiment[i][j]==' '){
                    actualnum1++;
                }
            }
        }
        int Trianglearea=rightTriangle.area;
        if (originnum1-Trianglearea!=actualnum1){
            return false;
        }else{
            return true;
        }


    }
}
