import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    int rows;
    int cols;

    public OverLapShapeCanvas(int rows, int cols) {
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
                    if(shape.area()<=curShape.area()) {
                        if(shape.area()<curShape.area()) {
                            sortedShapes.add(i, shape);
                        }else {
                            if(shape.getPattern()<curShape.getPattern()) {
                                sortedShapes.add(i, shape);
                            }else {
                                int j=1;
                                curShape = sortedShapes.get(i+j);
                                while(shape.area()==curShape.area()) {
                                    if(shape.getPattern()<curShape.getPattern()) {
                                        sortedShapes.add(i+j, shape);
                                        break;
                                    }
                                    else {
                                        j++;
                                        curShape = sortedShapes.get(i+j);
                                    }
                                }
                                sortedShapes.add(i+j, shape);
                                //i+=j;
                            }
                        }
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
        boolean result =false;
        if(circle.getLocation().getX()>cols) {
            return false;
        }
        if(circle.getLocation().getY()>rows) {
            return false;
        }


        int Ymax= (circle.getLocation().getY()+2*circle.getRadius())>rows ? rows: (circle.getLocation().getY()+2*circle.getRadius());
        int Xmax= (circle.getLocation().getX()+2*circle.getRadius())>cols ? cols: (circle.getLocation().getX()+2*circle.getRadius());
        for(int y=circle.getLocation().getY();y<Ymax;y++){
            for (int x=circle.getLocation().getX();x<Xmax;x++) {
                if(circle.getGrids()[y-circle.getLocation().getY()][x-circle.getLocation().getX()]!=' ') {
                    result = true;
                    break;
                }
            }
        }
        if(result) {
            shapes.add(circle);
            for(int y=circle.getLocation().getY();y<Ymax;y++){
                for (int x=circle.getLocation().getX();x<Xmax;x++) {
                    if(circle.getGrids()[y-circle.getLocation().getY()][x-circle.getLocation().getX()]!=' ') {
                        canvas[y][x] = circle.getGrids()[y-circle.getLocation().getY()][x-circle.getLocation().getX()];
//                        if(canvas[y][x]!=' ') {
//                            // do nothing
//                        }
//                        else {
//                            canvas[y][x] = circle.getGrids()[y-circle.getLocation().getY()][x-circle.getLocation().getX()];
//                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean addRightTriangleShape(RightTriangle rightTriangle) {
        boolean result =false;
        if(rightTriangle.getLocation().getX()>cols) {
            return false;
        }
        if(rightTriangle.getLocation().getY()>rows) {
            return false;
        }

        int Ymax= (rightTriangle.getLocation().getY()+rightTriangle.getHeight())>rows ? rows: (rightTriangle.getLocation().getY()+rightTriangle.getHeight());
        int Xmax= (rightTriangle.getLocation().getX()+rightTriangle.getWidth())>cols ? cols: (rightTriangle.getLocation().getX()+rightTriangle.getWidth());
        for(int y=rightTriangle.getLocation().getY();y<Ymax;y++){
            for (int x=rightTriangle.getLocation().getX();x<Xmax;x++) {
                if(rightTriangle.getGrids()[y-rightTriangle.getLocation().getY()][x-rightTriangle.getLocation().getX()]!=' ') {
                    result = true;
                    //return true;
                }
            }
        }
        if(result) {
            shapes.add(rightTriangle);
            for(int y=rightTriangle.getLocation().getY();y<Ymax;y++){
                for (int x=rightTriangle.getLocation().getX();x<Xmax;x++) {
                    if(rightTriangle.getGrids()[y-rightTriangle.getLocation().getY()][x-rightTriangle.getLocation().getX()]!=' ') {
                        canvas[y][x] = rightTriangle.getGrids()[y-rightTriangle.getLocation().getY()][x-rightTriangle.getLocation().getX()];
//                        if(canvas[y][x]!=' ') {
//                            // do nothing
//                        }
//                        else {
//                            canvas[y][x] = rightTriangle.getGrids()[y-rightTriangle.getLocation().getY()][x-rightTriangle.getLocation().getX()];
//                        }
                    }
                }
            }
            return result;
        }

        return false;
    }
}
