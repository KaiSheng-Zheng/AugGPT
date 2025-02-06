

import java.util.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas() {

    }
    public AvoidConflictShapeCanvas(int rows, int cols){
        canvas=new char[rows][cols];
        for (char[] canvas : canvas) {
            Arrays.fill(canvas, ' ');
        } shapes=new ArrayList<>();
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location p = new Location(x, y);
        boolean hasFilled = false;
        if (params.length==3){
            Shape s = new RightTriangle(p, pattern, params[0], params[1], Direction.values()[params[2]]);
            shapes.add(s);
            s.fillGrids();
        for (int i = 0; i < s.getGrids().length; i++) {
           for (int j = 0; j <s.getGrids()[i].length; j++) {
                int canvasX = x+i;
                int canvasY = y + j;
                if (canvasX >= 0 && canvasX <canvas.length && canvasY >= 0 && canvasY < canvas[0].length ) {
                  if (s.getGrids()[i][j]!=' '&&canvas[canvasX][canvasY]!=' ') {shapes.remove(s);
                      return false;}
                  else{ hasFilled = true;}
                }else  {
                    shapes.remove(s);
                    return false;}
            }
        }for (int i = 0; i < s.getGrids().length; i++) {
                for (int j = 0; j <s.getGrids()[i].length; j++) {
                    int canvasX = x+i;
                    int canvasY = y + j;
                    if (hasFilled==true)
                    {if (s.getGrids()[i][j]!=' ')canvas [canvasX][canvasY] = s.getGrids()[i][j];}}}
        return hasFilled;
          }
        else {
            Shape s = new Circle(p, pattern, params[0]);
            shapes.add(s);
            s.fillGrids();
            for (int i = 0; i < s.getGrids().length; i++) {
                for (int j = 0; j <s.getGrids()[i].length; j++) {
                    int canvasX = x+i;
                    int canvasY = y + j;
                    if (canvasX >= 0 && canvasX <canvas.length && canvasY >= 0 && canvasY < canvas[0].length ) {
                        if (s.getGrids()[i][j]!=' '&&canvas[canvasX][canvasY]!=' ')
                        {shapes.remove(s);
                            return false;}
                        else{ hasFilled = true;}
                    }else {shapes.remove(s);
                        return false;}
                }
            }
            for (int i = 0; i < s.getGrids().length; i++) {
                for (int j = 0; j <s.getGrids()[i].length; j++) {
                    int canvasX = x+i;
                    int canvasY = y + j;
                    if (hasFilled==true){if (s.getGrids()[i][j]!=' ')canvas [canvasX][canvasY] = s.getGrids()[i][j];}}}
            return hasFilled;}
    }
    @Override
    public int getSpaceGridCount() {
        int count=0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (canvas[i][j]==' '){
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        Collections.sort(shapes, new AreaComparator());
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes, new LocationComparator());
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

    static class AreaComparator implements Comparator<Shape> {
        @Override
        public int compare(Shape s1, Shape s2) {
            int areaComparison = Double.compare(s1.area(), s2.area());
            if (areaComparison == 0) {
                return Character.compare(s1.pattern, s2.pattern);
            }
            return areaComparison;
        }
    }
    static class LocationComparator implements Comparator<Shape>{

        @Override
        public int compare(Shape s1, Shape s2) {
            int xComparison=Integer.compare(s1.location.getX(),s2.location.getX());
            if (xComparison==0){
                int yComparison = Integer.compare(s1.location.getY(), s2.location.getY());
                if (yComparison == 0) {
                    return Character.compare(s1.pattern, s2.pattern);
                }
                return yComparison;
            }
            return xComparison;
          }
        }
    }

