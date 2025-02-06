import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    private int rows;
    private int cols;
    private int Shapecount = 0;
    private Comparator<Shape> areaAndPatternComparator = new Comparator<Shape>() {
        @Override
        public int compare(Shape o1, Shape o2) {
            int area1 = o1.getArea();
            int area2 = o2.getArea();
            String pattern1=String.valueOf(o1.getPattern());
            String pattern2=String.valueOf(o2.getPattern());
            if (o1.getArea()!=o2.getArea()){
                return Integer.compare(area1, area2);
            }else
                return pattern1.compareTo(pattern2);
        }
    };
    private Comparator<Shape> locationAndPatternComparator = new Comparator<Shape>(){
        public int compare(Shape o3, Shape o4) {
            int x1 = o3.location.getX();
            int x2 = o4.location.getX();
            int y1 = o3.location.getY();
            int y2 = o4.location.getY();
            String pattern1=String.valueOf(o3.getPattern());
            String pattern2=String.valueOf(o4.getPattern());
            if (o3.location.getX()!=o4.location.getX()){
                return Integer.compare(x1, x2);
            }else if (o3.location.getY()!=o4.location.getY()){
                return Integer.compare(y1,y2);
            }else
                return pattern1.compareTo(pattern2);
        }
    };
    public List<Shape> getSortedShapes1() {
        List<Shape> sortedShapes1 = new ArrayList<>(shapes);
        Collections.sort(sortedShapes1, areaAndPatternComparator);
        return sortedShapes1;
    }

    public List<Shape> getSortedShapes2() {
        List<Shape> sortedShapes2 = new ArrayList<>(shapes);
        Collections.sort(sortedShapes2, locationAndPatternComparator);
        return sortedShapes2;
    }

    public OverLapShapeCanvas(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            canvas = new char[rows][cols];
            shapes = new ArrayList<>();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    canvas[i][j] = ' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        boolean jieguo = false;
        Location start = new Location(x, y);
        if (params.length == 1) {
            int count = 0;
            Shape yuan = new Circle(start, pattern, params[0]);
            yuan.fillGrids();
            for (int i = 0; i < 2 * params[0]; i++) {
                for (int j = 0; j < 2 * params[0]; j++) {
                    if (x + i >= 0 && x + i < rows && y + j >= 0 && y + j < cols) {
                        if (yuan.getGrids()[i][j] != ' ') {
                            count++;
                        }
                    }
                }
            }
            if (count == 0) {
                jieguo = false;
            } else {
                for (int i = 0; i < 2 * params[0]; i++) {
                    for (int j = 0; j < 2 * params[0]; j++) {
                        if (yuan.getGrids()[i][j] != ' ') {
                            if(x+i<rows&&y+j<cols){
                            canvas[x + i][y + j] = yuan.getGrids()[i][j];}
                        }
                    }
                }
                Shapecount++;
                shapes.add(yuan);
                jieguo = true;
            }
        }


        if (params.length == 3) {
            Shape sanjiao = new RightTriangle(start, pattern, params[0], params[1], Direction.values()[params[2]]);
            sanjiao.fillGrids();
            int count = 0;
            for (int i = 0; i < params[1]; i++) {
                for (int j = 0; j < params[0]; j++) {
                    if (x + i >= 0 && x + i < rows && y + j >= 0 && y + j < cols) {
                        if (sanjiao.getGrids()[i][j] != ' ') {
                            count++;
                        }
                    }
                }
            }
            if (count == 0) {
                jieguo = false;
            } else {
                for (int i = 0; i < params[1]; i++) {
                    for (int j = 0; j < params[0]; j++) {
                        if (sanjiao.getGrids()[i][j] != ' ') {
                            if(x+i<rows&&y+j<cols){
                            canvas[x + i][y + j] = sanjiao.getGrids()[i][j];}
                        }
                    }
                }
                Shapecount++;
                shapes.add(sanjiao);
                jieguo = true;
            }
        }
        return jieguo;
    }

    @Override
    public int getSpaceGridCount() {
        int kongge = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canvas[i][j] == ' ') {
                    kongge = kongge + 1;
                }
            }
        }
        return kongge;
    }
    @Override
    public int getShapeCount() {
        return Shapecount;
    }
    @Override
    public List<Shape> getShapesByArea() {
        return getSortedShapes1();
    }
    @Override
    public List<Shape> getShapesByLocation() {
        return getSortedShapes2();
    }
    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
