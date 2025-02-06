import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    private int space;

    public OverLapShapeCanvas(int rows, int cols) {
        this.canvas = new char[rows][cols];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvas[i][j] = ' ';
            }
        }
        this.shapes =new ArrayList<>();
        this.space = rows * cols;
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length == 1) {
            //circle
            int inCanvas=0;
            Location location = new Location(x, y);
            Circle circle = new Circle(location, pattern, params[0]);
            for (int i = 0; i < circle.grids.length; i++) {
                for (int j = 0; j < circle.grids[0].length; j++) {
                    if (circle.grids[i][j] != ' ') {
                        if ((i + x <= canvas.length - 1) && (y + j <= canvas[0].length - 1)) {
                            inCanvas++;
                        }
                    }
                }
            }
            if(inCanvas==0){
                return false;
            }
            for (int i = 0; i < circle.grids.length; i++) {
                for (int j = 0; j < circle.grids[0].length; j++) {
                    if (circle.grids[i][j] != ' ') {
                        if ((i + x <= canvas.length - 1) && (y + j <= canvas[0].length - 1)){
                            canvas[x + i][y + j] = pattern;
                            space--;
                        }
                    }
                }
            }
            shapes.add(circle);
            return true;
        } else {
            //right triangle
            int inCanvas=0;
            Location location = new Location(x, y);
            if (params[2] == 0) {
                RightTriangle rightTriangle = new RightTriangle(location, pattern, params[0], params[1], Direction.LEFT_UP);
                for (int i = 0; i < rightTriangle.grids.length; i++) {
                    for (int j = 0; j < rightTriangle.grids[0].length; j++) {
                        if (rightTriangle.grids[i][j] != ' ') {
                            if ((i + x <= canvas.length - 1) && (y + j <= canvas[0].length - 1)) {
                                inCanvas++;
                            }
                        }
                    }
                }
                if(inCanvas==0){
                    return false;
                }
                for (int i = 0; i < rightTriangle.grids.length; i++) {
                    for (int j = 0; j < rightTriangle.grids[0].length; j++) {
                        if (rightTriangle.grids[i][j] != ' ') {
                            if ((i + x <= canvas.length - 1) && (y + j <= canvas[0].length - 1)){
                                canvas[x + i][y + j] = pattern;
                                space--;
                            }
                        }
                    }
                }
                shapes.add(rightTriangle);
                return true;
            }
            if (params[2] == 1) {
                RightTriangle rightTriangle = new RightTriangle(location, pattern, params[0], params[1], Direction.LEFT_DOWN);
                for (int i = 0; i < rightTriangle.grids.length; i++) {
                    for (int j = 0; j < rightTriangle.grids[0].length; j++) {
                        if (rightTriangle.grids[i][j] != ' ') {
                            if ((i + x <= canvas.length - 1) && (y + j <= canvas[0].length - 1)) {
                                inCanvas++;
                            }
                        }
                    }
                }
                if(inCanvas==0){
                    return false;
                }
                for (int i = 0; i < rightTriangle.grids.length; i++) {
                    for (int j = 0; j < rightTriangle.grids[0].length; j++) {
                        if (rightTriangle.grids[i][j] != ' ') {
                            if ((i + x <= canvas.length - 1) && (y + j <= canvas[0].length - 1)){
                                canvas[x + i][y + j] = pattern;
                                space--;
                            }
                        }
                    }
                }
                shapes.add(rightTriangle);
                return true;
            }
            if (params[2] == 2) {
                RightTriangle rightTriangle = new RightTriangle(location, pattern, params[0], params[1], Direction.RIGHT_UP);
                for (int i = 0; i < rightTriangle.grids.length; i++) {
                    for (int j = 0; j < rightTriangle.grids[0].length; j++) {
                        if (rightTriangle.grids[i][j] != ' ') {
                            if ((i + x <= canvas.length - 1) && (y + j <= canvas[0].length - 1)) {
                                inCanvas++;
                            }
                        }
                    }
                }
                if(inCanvas==0){
                    return false;
                }
                for (int i = 0; i < rightTriangle.grids.length; i++) {
                    for (int j = 0; j < rightTriangle.grids[0].length; j++) {
                        if (rightTriangle.grids[i][j] != ' ') {
                            if ((i + x <= canvas.length - 1) && (y + j <= canvas[0].length - 1)){
                                canvas[x + i][y + j] = pattern;
                                space--;
                            }
                        }
                    }
                }
                shapes.add(rightTriangle);
                return true;
            }
            if (params[2] == 3) {
                RightTriangle rightTriangle = new RightTriangle(location, pattern, params[0], params[1], Direction.RIGHT_DOWN);
                for (int i = 0; i < rightTriangle.grids.length; i++) {
                    for (int j = 0; j < rightTriangle.grids[0].length; j++) {
                        if (rightTriangle.grids[i][j] != ' ') {
                            if ((i + x <= canvas.length - 1) && (y + j <= canvas[0].length - 1)) {
                                inCanvas++;
                            }
                        }
                    }
                }
                if(inCanvas==0){
                    return false;
                }
                for (int i = 0; i < rightTriangle.grids.length; i++) {
                    for (int j = 0; j < rightTriangle.grids[0].length; j++) {
                        if (rightTriangle.grids[i][j] != ' ') {
                            if ((i + x <= canvas.length - 1) && (y + j <= canvas[0].length - 1)){
                                canvas[x + i][y + j] = pattern;
                                space--;
                            }
                        }
                    }
                }
                shapes.add(rightTriangle);
                return true;
            }
        }
        return false;
    }


    @Override
    public int getSpaceGridCount() {
        return space;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        ShapesComparator shapesComparator = new ShapesComparator();
        Collections.sort(shapes, shapesComparator);
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        LocationComparator locationComparator = new LocationComparator();
        Collections.sort(shapes, locationComparator);
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

    class ShapesComparator implements Comparator<Shape> {
        @Override
        public int compare(Shape o1, Shape o2) {
            if (o1.area() < o2.area()) {
                return -1;
            } else if (o1.area() > o2.area()) {
                return 1;
            } else {
                if (o1.getPattern() < o2.getPattern()) {
                    return -1;
                } else if (o1.getPattern() > o2.getPattern()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

    class LocationComparator implements Comparator<Shape> {
        @Override
        public int compare(Shape o1, Shape o2) {
            if (o1.location.getX() < o2.location.getX()) {
                return -1;
            } else if (o1.location.getX() > o2.location.getX()) {
                return 1;
            } else {
                if (o1.location.getY() < o2.location.getY()) {
                    return -1;
                } else if (o1.location.getY() > o2.location.getY()) {
                    return 1;
                } else {
                    if (o1.getPattern() < o2.getPattern()) {
                        return -1;
                    } else if (o1.getPattern() > o2.getPattern()) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        }
    }
}