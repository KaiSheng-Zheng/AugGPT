import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {

    private List<Shape> shapes;

    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {

        this.canvas = new char[rows][cols];

        for (int i = 0; i < this.canvas.length; i++) {
            for (int j = 0; j < this.canvas[0].length; j++) {
                this.canvas[i][j] = ' ';
            }
        }

        this.shapes = new ArrayList<>();

    }


    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {

        Location location = new Location(x, y);

        if (params.length == 1) {
            Circle newCircle = new Circle(location, pattern, params[0]);
            newCircle.fillGrids();

            int outCanvasBoundaryCount = 0;
            for (int i = 0; i < newCircle.grids.length; i++) {
                for (int j = 0; j < newCircle.grids[0].length; j++) {
                    if (newCircle.grids[i][j] == pattern) {
                        if (x + i >= canvas.length || y + j >= canvas[0].length) {
                            outCanvasBoundaryCount++;
                        }
                    }
                }
            }

            int overlappingGridsCount = 0;
            if (outCanvasBoundaryCount == 0) {
                for (int i = 0; i < newCircle.grids.length; i++) {
                    for (int j = 0; j < newCircle.grids[0].length; j++) {
                        if (newCircle.grids[i][j] == pattern) {
                            if (canvas[x + i][y + j] != ' ') {
                                overlappingGridsCount++;
                            }
                        }
                    }
                }
            }

            if (outCanvasBoundaryCount > 0 || overlappingGridsCount > 0) {
                return false;
            } else {
                for (int i = 0; i < newCircle.grids.length; i++) {
                    for (int j = 0; j < newCircle.grids[0].length; j++) {
                        if (newCircle.grids[i][j] == pattern) {
                            canvas[x + i][y + j] = pattern;
                        }
                    }
                }
                shapes.add(newCircle);
            }

        }


        if (params.length == 3) {
            RightTriangle newRightTriangle = new RightTriangle(location, pattern, params[0], params[1], Direction.class.getEnumConstants()[params[2]]);
            newRightTriangle.fillGrids();


            int outCanvasBoundaryCount = 0;
            for (int i = 0; i < newRightTriangle.grids.length; i++) {
                for (int j = 0; j < newRightTriangle.grids[0].length; j++) {
                    if (newRightTriangle.grids[i][j] == pattern) {
                        if (x + i >= canvas.length || y + j >= canvas[0].length) {
                            outCanvasBoundaryCount++;
                        }
                    }
                }
            }


            int overlappingGridsCount = 0;
            if (outCanvasBoundaryCount == 0) {


                for (int i = 0; i < newRightTriangle.grids.length; i++) {
                    for (int j = 0; j < newRightTriangle.grids[0].length; j++) {
                        if (newRightTriangle.grids[i][j] == pattern) {
                            if (canvas[x + i][y + j] != ' ') {
                                overlappingGridsCount++;
                            }
                        }
                    }
                }
            }

            if (outCanvasBoundaryCount > 0 || overlappingGridsCount > 0) {
                return false;
            } else {
                for (int i = 0; i < newRightTriangle.grids.length; i++) {
                    for (int j = 0; j < newRightTriangle.grids[0].length; j++) {
                        if (newRightTriangle.grids[i][j] == pattern) {
                            canvas[x + i][y + j] = pattern;
                        }
                    }
                }
                shapes.add(newRightTriangle);
            }

        }

        return true;
    }


    @Override
    public int getSpaceGridCount() {
        int spaceGridCount = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] == ' ') {
                    spaceGridCount++;
                }
            }
        }
        return spaceGridCount;
    }



    @Override
    public int getShapeCount() {
        int shapeCount = shapes.size();
        return shapeCount;
    }



    @Override
    public List<Shape> getShapesByArea() {

        ArrayList<Shape> shapeListByArea = new ArrayList<>();

        int[] areaArr = new int[shapes.size()];
        int[] ASCLLarr = new int[shapes.size()];
        Shape[] shapeArr = new Shape[shapes.size()];

        for (int i = 0; i < shapes.size(); i++) {
            areaArr[i] = shapes.get(i).area();
            shapeArr[i] = shapes.get(i);
        }

        for (int i = 0; i < shapes.size(); i++) {
           ASCLLarr[i] = (int) shapes.get(i).pattern;
        }


        for (int i = 0; i < ASCLLarr.length - 1; i++) {
            for (int j = 0; j < ASCLLarr.length - 1 - i; j++) {
                if(ASCLLarr[j]> ASCLLarr[j+1]){
                    int middleASCLL = ASCLLarr[j];
                    ASCLLarr[j] = ASCLLarr[j+1];
                    ASCLLarr[j+1] = middleASCLL;

                    int middleArea = areaArr[j];
                    areaArr[j] = areaArr[j+1];
                    areaArr[j+1] = middleArea;

                    Shape middleShape = shapeArr[j];
                    shapeArr[j] = shapeArr[j+1];
                    shapeArr[j+1] = middleShape;
                }
            }
        }

        for (int i = 0; i < areaArr.length - 1; i++) {
            for (int j = 0; j < areaArr.length - 1 - i; j++) {
                if(areaArr[j]> areaArr[j+1]){
                    int middleArea = areaArr[j];
                    areaArr[j] = areaArr[j+1];
                    areaArr[j+1] = middleArea;

                    Shape middleShape = shapeArr[j];
                    shapeArr[j] = shapeArr[j+1];
                    shapeArr[j+1] = middleShape;
                }
            }
        }

        for (int i = 0; i < shapeArr.length; i++) {
            shapeListByArea.add(shapeArr[i]);
        }

        return shapeListByArea;
    }


    @Override
    public List<Shape> getShapesByLocation() {
        ArrayList<Shape> shapeListByLocation = new ArrayList<>();

        int[] xArr = new int[shapes.size()];
        int[] yArr = new int[shapes.size()];
        int[] ASCLLarr = new int[shapes.size()];
        Shape[] shapeArr = new Shape[shapes.size()];

        for (int i = 0; i < shapes.size(); i++) {
            xArr[i] = shapes.get(i).location.getX();
            yArr[i] = shapes.get(i).location.getY();
            shapeArr[i] = shapes.get(i);
        }

        for (int i = 0; i < shapes.size(); i++) {
            ASCLLarr[i] = (int) shapes.get(i).pattern;
        }


        for (int i = 0; i < ASCLLarr.length - 1; i++) {
            for (int j = 0; j < ASCLLarr.length - 1 - i; j++) {
                if(ASCLLarr[j]> ASCLLarr[j+1]){
                    int middleASCLL = ASCLLarr[j];
                    ASCLLarr[j] = ASCLLarr[j+1];
                    ASCLLarr[j+1] = middleASCLL;

                    int middleX = xArr[j];
                    xArr[j] = xArr[j+1];
                    xArr[j+1] = middleX;

                    int middleY = yArr[j];
                    yArr[j] = yArr[j+1];
                    yArr[j+1] = middleY;

                    Shape middleShape = shapeArr[j];
                    shapeArr[j] = shapeArr[j+1];
                    shapeArr[j+1] = middleShape;
                }
            }
        }

        for (int i = 0; i < yArr.length - 1; i++) {
            for (int j = 0; j < yArr.length - 1 - i; j++) {
                if(yArr[j]> yArr[j+1]){
                    int middleX = xArr[j];
                    xArr[j] = xArr[j+1];
                    xArr[j+1] = middleX;

                    int middleY = yArr[j];
                    yArr[j] = yArr[j+1];
                    yArr[j+1] = middleY;

                    Shape middleShape = shapeArr[j];
                    shapeArr[j] = shapeArr[j+1];
                    shapeArr[j+1] = middleShape;
                }
            }
        }

        for (int i = 0; i < xArr.length - 1; i++) {
            for (int j = 0; j < xArr.length - 1 - i; j++) {
                if(xArr[j]> xArr[j+1]){
                    int middleX = xArr[j];
                    xArr[j] = xArr[j+1];
                    xArr[j+1] = middleX;

                    Shape middleShape = shapeArr[j];
                    shapeArr[j] = shapeArr[j+1];
                    shapeArr[j+1] = middleShape;
                }
            }
        }

        for (int i = 0; i < shapeArr.length; i++) {
            shapeListByLocation.add(shapeArr[i]);
        }

        return shapeListByLocation;
    }



    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
