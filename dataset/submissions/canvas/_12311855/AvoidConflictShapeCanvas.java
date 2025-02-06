import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static java.lang.Math.abs;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    int rows;
    int cols;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        shapes = new ArrayList<>();

        canvas = new char[rows][cols];
        for (int i=0;i<rows; i++) {
            for(int j=0;j<cols;j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x,y);

        if(params.length ==1) {
            Circle circle = new Circle(location,pattern,params[0]);
            return addCircleShape(circle);
        }
        else if(params.length == 3){
            RightTriangle rightTriangle = new RightTriangle(location,pattern, params[0], params[1], Direction.values()[params[2]]);
            return addRightTriangleShape(rightTriangle);

        }else {
            //do nothing
        }
        return false;
    }

    @Override
    public int getSpaceGridCount() {
        int count=0;
        for(int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if(canvas[i][j]!=' ') {
                    count+=1;
                }
            }
        }
        return rows*cols-count;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        List<Shape> sortedShapes = new ArrayList<>();

        shapes.forEach(shape -> {
            if(sortedShapes.size()==0) {
                sortedShapes.add(shape);
            }
            else {
                int i=0;
                while (i<sortedShapes.size()) {
                    Shape curShape = sortedShapes.get(i);
                    if(shape.area()<curShape.area()) {
                        sortedShapes.add(i, shape);
                        break;
                    }
                    if(i==sortedShapes.size()-1) {
                        sortedShapes.add(shape);
                        break;
                    }
                    i++;
                }
            }
        });
        return sortedShapes;
        //return List.of();
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>();

        shapes.forEach(shape -> {
            if(sortedShapes.size()==0) {
                sortedShapes.add(shape);
            }
            else {
                int i=0;
                while (i<sortedShapes.size()) {
                    Shape curShape = sortedShapes.get(i);
                    if(shape.getLocation().getX()<curShape.getLocation().getX()) {
                        sortedShapes.add(i, shape);
                        break;
                    }
                    else if(shape.getLocation().getX()==curShape.getLocation().getX()) {
                        if(shape.getLocation().getY()<curShape.getLocation().getY()) {
                            sortedShapes.add(i, shape);
                            break;
                        }
                        else if (shape.getLocation().getY()==curShape.getLocation().getY()) {
                            if(shape.getPattern()<curShape.getPattern()) {
                                sortedShapes.add(i, shape);
                                break;
                            }
                        }
                    }
                    else {}

                    if(i==sortedShapes.size()-1) {
                        sortedShapes.add(shape);
                        break;
                    }

                    i++;
                }
            }
        });

        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }


    private boolean addCircleShape(Circle circle) {
        int Xmax=circle.getLocation().getX()+circle.getRadius()*2;
        int Ymax=circle.getLocation().getY()+circle.getRadius()*2;

        if(Xmax>cols) {
            return false;
        }
        if(Ymax>rows) {
            return false;
        }

        for(int y=0; y<circle.getRadius()*2; y++) {
            for (int x=0; x<circle.getRadius()*2; x++) {
                if( (circle.getGrids()[y][x]!=' ') && (canvas[y+circle.getLocation().getY()][x+circle.getLocation().getX()] != ' '))  {
                    return false;
                }
            }
        }

//        for (Shape shape : shapes) {
//            if ((abs(circle.getLocation().getX() - shape.getLocation().getX()) < 2*circle.getRadius())
//                    && (abs(circle.getLocation().getY() - shape.getLocation().getY()) < 2*circle.getRadius())
//            ) {
//                return false;
//            }
//        }
        shapes.add(circle);
        for(int y=0; y<circle.getRadius()*2; y++) {
            for (int x=0; x<circle.getRadius()*2; x++) {
                if(canvas[y+circle.getLocation().getY()][x+circle.getLocation().getX()] == ' ') {
                    canvas[y+circle.getLocation().getY()][x+circle.getLocation().getX()] = circle.getGrids()[y][x];
                }

            }
        }

        return true;
    }

    private boolean addRightTriangleShape(RightTriangle rightTriangle) {
        if(rightTriangle.getLocation().getX()+rightTriangle.getWidth()>cols) {
            return false;
        }
        if(rightTriangle.getLocation().getY()+rightTriangle.getHeight()>rows) {
            return false;
        }
        for(int y=0; y<rightTriangle.getHeight(); y++) {
            for (int x=0; x<rightTriangle.getWidth(); x++) {
                if( (rightTriangle.getGrids()[y][x]!=' ') && (canvas[y+rightTriangle.getLocation().getY()][x+rightTriangle.getLocation().getX()] != ' '))  {
                    return false;
                }
            }
        }
//        for (Shape shape : shapes) {
//            if ((abs(rightTriangle.getLocation().getX() - shape.getLocation().getX()) < rightTriangle.getWidth())
//                    && (abs(rightTriangle.getLocation().getY() - shape.getLocation().getY()) < rightTriangle.getHeight())
//            )
//            {
//                return false;
//            }
//        }
        shapes.add(rightTriangle);
        for(int y=0; y<rightTriangle.getHeight(); y++) {
            for (int x=0; x<rightTriangle.getWidth(); x++) {
                if(canvas[y+rightTriangle.getLocation().getY()][x+rightTriangle.getLocation().getX()] == ' ') {
                    canvas[y+rightTriangle.getLocation().getY()][x+rightTriangle.getLocation().getX()] = rightTriangle.getGrids()[y][x];
                }

            }
        }
        return true;
    }
}
