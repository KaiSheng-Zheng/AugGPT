import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class AvoidConflictShapeCanvas implements ShapeCanvas {
    ArrayList<Shape> shapes = new ArrayList<>();

   char[][] canvas;

   int rows;
    int cols;








    public AvoidConflictShapeCanvas(int rows, int cols)
    {  Shape shape = null;
        this.rows = rows;
        this.cols = cols;
        canvas = new char[rows][cols];
        shapes = new ArrayList<>();
        char[][] pcanvas = new char[rows][cols];
        this.shapes = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }

            }



    public boolean addShape(int x,int y,char pattern, int... params){
        char[][]pcanvas=new char[rows][cols];
        Shape shape = null;

        for (int i = 0; i < rows; i++) {
            for (int m=0;m<cols;m++)
                pcanvas[i][m]=canvas[i][m];
        }
        if(params.length==1)
        {int radius=params[0];
            int v=radius*radius;
            for(int i= 0;i< radius*2;i++){
                for(int m= 0;m< radius*2;m++){
                    if(i+x>=0&&i+x<rows&&m+y>=0&&m+y<cols)

                    {int a=(i-radius)*(i-radius)+(m-radius)*(m-radius);
                    int b=(i-radius+1)*(i-radius+1)+(m-radius)*(m-radius);
                    int c=(i-radius)*(i-radius)+(m-radius+1)*(m-radius+1);
                    int d=(i-radius+1)*(i-radius+1)+(m-radius+1)*(m-radius+1);
                    int s=0;
                    if(a<=v){s++;}
                    if(b<=v){s++;}
                    if(c<=v){s++;}
                    if(d<=v){s++;}
                    if(s>=2){
                        if (pcanvas[i+x][m+y]==' ')
                        { pcanvas[i+x][m+y]=pattern;}
                        else {return false;}

                    }
                    else if (s==1&&a!=v&&b!=v&&c!=v&&d!=v)
                    {if (pcanvas[i+x][m+y]==' ')
                    { pcanvas[i+x][m+y]=pattern;}
                    else{
                       return false;}
                    }

                }
                else {
                    return false;
                    }}

            }
        }
        if(params.length==3){
            int width=params[0];
            int height=params[1];
            for(int m=0;m<height;m++) {
                for (int i = 0; i < width; i++) {
                    if(m+x>=0&&m+x<rows&&i+y>=0&&i+y<cols){
                    if (params[2] == 0) {
                        int f = 0;
                        float a = (float)m - (-(float) height * i / (float)width + (float)height);
                        float b = (float)(m + 1) - (-(float) height * i / width + (float)height);
                        float c = (float)m - (-(float) height * (i + 1) / width + (float)height);
                        float d = (float)(m + 1) - (-(float) height * (i + 1) / width +(float) height);
                        if (a <= 0) {
                            f++;
                        }
                        if (b <= 0) {
                            f++;
                        }
                        if (c <= 0) {
                            f++;
                        }
                        if (d <= 0) {
                            f++;
                        }
                        if (f >= 2) {
                            if(pcanvas[m+x][i+y]==' '){
                                pcanvas[m+ x][i+ y] = pattern;}
                            else {return false;}
                        } else if (f == 1 && a != 0 && b != 0 && c != 0 && d != 0) {
                            if(pcanvas[m+x][i+y]==' '){
                                pcanvas[m+ x][i+ y] = pattern;}
                            else {return false;}
                        }
                    }

                    if (params[2] == 2) {
                        int f = 0;
                        float a = (float) (m ) - ((float)height * (i) / (float)width);
                        float b = (float) (m + 1) - ((float)height * (i ) / (float)width);
                        float c = (float) (m ) - ((float)height * (i + 1) / (float)width);
                        float d = (float) (m + 1) - ((float)height * (i + 1) / (float)width);
                        if (a <= 0) {
                            f++;
                        }
                        if (b <= 0) {
                            f++;
                        }
                        if (c <= 0) {
                            f++;
                        }
                        if (d <= 0) {
                            f++;
                        }
                        if (f >= 2) {
                            if(pcanvas[m+x][i+y]==' '){
                            pcanvas[m+ x][i+ y] = pattern;}
                            else {return false;}
                        } else if (f == 1 && a != 0 && b != 0 && c != 0 && d != 0) {
                            if(pcanvas[m+x][i+y]==' '){
                                pcanvas[m+ x][i+ y] = pattern;}
                            else {return false;}
                        }

                    }


                if (params[2] == 1) {
                    int f = 0;
                    float a = (float) (m ) - ((float)height * (i) / (float)width);
                    float b = (float) (m + 1) - ((float)height * (i ) / (float)width);
                    float c = (float) (m ) - ((float)height * (i + 1) / (float)width);
                    float d = (float) (m + 1) - ((float)height * (i + 1) / (float)width);
                    ;
                    if (a >= 0) {
                        f++;
                    }
                    if (b >= 0) {
                        f++;
                    }
                    if (c >= 0) {
                        f++;
                    }
                    if (d >= 0) {
                        f++;
                    }
                    if (f >= 2) {
                        if(pcanvas[m+x][i+y]==' '){
                            pcanvas[m+ x][i+ y] = pattern;}
                        else {return false;}
                        }
                    else if (f == 1 && a != 0 && b != 0 && c != 0 && d != 0) {
                        if(pcanvas[m+x][i+y]==' '){
                            pcanvas[m+ x][i+ y] = pattern;}
                        else {return false;}
                        }
                    }


                if (params[2] == 3) {
                    int f = 0;
                    float a = (float)m - (-(float) height * i / (float)width + (float)height);
                    float b = (float)(m + 1) - (-(float) height * i / width + (float)height);
                    float c = (float)m - (-(float) height * (i + 1) / width + (float)height);
                    float d = (float)(m + 1) - (-(float) height * (i + 1) / width +(float) height);
                    if (a >= 0) {
                        f++;
                    }
                    if (b >= 0) {
                        f++;
                    }
                    if (c >= 0) {
                        f++;
                    }
                    if (d >= 0) {
                        f++;
                    }
                    if (f >= 2) {
                        if(pcanvas[m+x][i+y]==' '){
                            pcanvas[m+ x][i+ y] = pattern;}
                        else {return false;}
                        }
                     else if (f == 1 && a != 0 && b != 0 && c != 0 && d != 0) {
                        if(pcanvas[m+x][i+y]==' '){
                            pcanvas[m+ x][i+ y] = pattern;}
                        else {return false;}

                    }
                }
            }
               else {return false;} }}}



        if(params.length==1){
            shape=new Circle(x,y,pattern,params[0]);
        }
        if(params.length==3){
            shape=new RightTriangle(x,y,pattern,params[0],params[1],Direction.RIGHT_DOWN);
        }
        for (int i = 0; i < rows; i++) {
            System.arraycopy(pcanvas[i], 0, canvas[i], 0, cols);
        }
        shapes.add(shape);
        return true;}



    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (canvas[i][j] == ' ') {
                    count++;
                }
            }
        }
        return count;
    }



        public int getShapeCount(){
            int count = shapes.size();
            return count;
        }
    public List<Shape> getShapesByArea(){
        shapes.sort(Comparator.comparingInt(Shape::area)
                .thenComparing(Comparator.comparingInt(shape -> shape.pattern)));
        return shapes;
    }


    public List<Shape> getShapesByLocation(){
        shapes.sort(Comparator.comparingInt(Shape::getX)
                .thenComparingInt(Shape::getY)
                .thenComparing(Comparator.comparingInt(shape -> shape.pattern)));

        return shapes;
    }
    public char[][] getCanvas(){
        return canvas;
    }}