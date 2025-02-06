import java.util.*;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public  OverLapShapeCanvas (int rows, int cols){
        canvas = new char[rows][cols];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                canvas[i][j] = ' ';
            }
        }
        shapes = new ArrayList<Shape>();
    }
    public boolean addShape(int x, int y, char pattern, int... params){
        boolean result = false;
        if (params.length==1){
            int radius = params[0];
            Location location = new Location(x,y);
            Circle circle = new Circle(location,pattern,radius);
            char[][] grids = circle.getGrids();
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[i].length; j++) {
                    if (grids[i][j]==' '){continue;}
                    if (x+i>=0&&x+i<=canvas.length-1&&y+j>=0&&y+j<=canvas[0].length-1){
                        result = true;
                        canvas[x+i][y+j] = pattern;
                    }
                }
            }
            if(result){shapes.add(circle);}
        }
        if (params.length==3){
            Location location = new Location(x,y);
            int width = params[0];
            int height = params[1];
            Direction d = null;
            switch (params[2]){
                case 0-> { d = Direction.LEFT_UP;}
                case 1-> { d = Direction.LEFT_DOWN;}
                case 2-> { d = Direction.RIGHT_UP;}
                case 3-> { d = Direction.RIGHT_DOWN;}
            }
            RightTriangle triangle = new RightTriangle(location,pattern,width,height,d);
            char[][] grids = triangle.getGrids();
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[i].length; j++) {
                    if (grids[i][j]==' '){continue;}
                    if (x+i>=0&&x+i<=canvas.length-1&&y+j>=0&&y+j<=canvas[0].length-1){
                        result = true;
                        canvas[x+i][y+j] = pattern;
                    }
                }
            }
            if(result){shapes.add(triangle);}
        }
        return result;
    }

    public int getSpaceGridCount(){
        int space = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (canvas[i][j]==0){
                    space++;
                }
            }
        }
        return space;
    }
    public int getShapeCount(){
        return shapes.size();
    }
    public List<Shape> getShapesByArea(){
        ComparatorByArea comparator= new ComparatorByArea();
        Collections.sort(shapes,comparator);
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        ComparatorByLocation comparator= new ComparatorByLocation();
        Collections.sort(shapes,comparator);
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
class ComparatorByArea implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        if (o1.area() > o2.area()) {
            return 1;
        } else if (o1.area() < o2.area()) {
            return -1;
        } else if (o1.pattern > o2.pattern) {
            return 1;
        } else if (o1.pattern < o2.pattern) {
            return -1;
        } else {
            return 0;
        }
    }
}
class ComparatorByLocation implements Comparator<Shape>{

    @Override
    public int compare(Shape o1, Shape o2) {
        if (o1.location.getX() != o2.location.getX()){
            return  o1.location.getX()-o2.location.getX();
        }else if (o1.location.getY() != o2.location.getY()){
            return o1.location.getY()-o2.location.getY();
        }else {
            return o1.pattern - o2.pattern;
        }
    }
}
