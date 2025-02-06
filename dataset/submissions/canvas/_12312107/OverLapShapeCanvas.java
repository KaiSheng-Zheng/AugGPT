import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas extends Canvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    public OverLapShapeCanvas(int rows, int cols) {
        this.setSize(rows,cols);
        shapes=new ArrayList<Shape>();
        canvas=new char[rows][cols];
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                canvas[i][j]=' ';
            }
        }

    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if(params.length==1){
        Circle circle=new Circle(new Location(x,y),pattern,params[0]);
        int num=-1;
        for (int i = 0; i <2*params[0] ; i++) {
            for (int j = 0; j < 2*params[0]; j++) {
                if(circle.grids[i][j]!=' '&&i+x>=0&&i+x<canvas.length&&j+y>=0&&j+y<canvas.length){
                    num=1;break;
                }
            }
            if(num==1)break;
        }
        if(num==-1)return false;
        shapes.add(circle);
        for (int i = 0; i <2*params[0] ; i++) {
            for (int j = 0; j < 2*params[0]; j++) {
                if(i+x>=0&&i+x<canvas.length&&j+y>=0&&j+y<canvas.length&&circle.grids[i][j]!=' '){
                    canvas[i+x][y+j]=circle.grids[i][j];
                }
            }
        }return true;
        }
        else {
            int num=-1;
            Direction d=Direction.LEFT_UP;
            switch (params[2]){
                case 0: d=Direction.LEFT_UP;break;
                case 1: d=Direction.LEFT_DOWN;break;
                case 2:d=Direction.RIGHT_UP;break;
                case 3: d=Direction.RIGHT_DOWN;break;
            }
            RightTriangle rightTriangle=new RightTriangle(new Location(x,y),pattern,params[0],params[1],d);
            for (int i = 0; i <params[1] ; i++) {
                for (int j = 0; j <params[0] ; j++) {
                    if(rightTriangle.grids[i][j]!=' '&&i+x>=0&&i+x<canvas.length&&j+y>=0&&j+y<canvas[0].length){num=1;break;}
                }
                if(num==1){break;}
            }
            if(num==-1)return false;
            for (int i = 0; i <params[1] ; i++) {
                for (int j = 0; j <params[0] ; j++) {
                    if(rightTriangle.grids[i][j]!=' '&&i+x>=0&&i+x<canvas.length&&j+y>=0&&j+y<canvas[0].length){canvas[i+x][j+y]=rightTriangle.grids[i][j];}
                }

            }
            shapes.add(rightTriangle);
            return true;
        }

    }

    @Override
    public int getSpaceGridCount() {
        int num=0;
        for (int i = 0; i <canvas.length ; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if(canvas[i][j]==' '){num++;}
            }
        }
        return num;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        Comparator<Shape>comparator=new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if(o1.area()==o2.area()){
                    if(o1.pattern>=o2.pattern){return 1;}
                    else return -1;
                }
                if(o1.area()> o2.area()){return 1;}
                else return -1;
            }};
        shapes.sort(comparator);
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Comparator<Shape> comparator=new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if(o1.location.getX()==o2.location.getX()){
                    if(o1.location.getY()==o2.location.getY()){if(o1.pattern>=o2.pattern){return 1;}
                        if(o1.pattern<o2.pattern)return -1;}
                    if(o1.location.getY()>o2.location.getY()){return 1;}
                    if(o1.location.getY()<o2.location.getY()){return -1;}
                }
                if(o1.location.getX()>o2.location.getX()){return 1;}
                return -1;
            }
        };
        shapes.sort(comparator);
        return shapes;
    }



    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
