import java.util.*;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    int rowNumber;
    int columnNumber;
    public OverLapShapeCanvas(int rows, int cols){
         canvas = new char[rows][cols];
         this.fillCanvasWithBlank();
         shapes = new ArrayList<>();
        this.rowNumber = rows;
        this.columnNumber = cols;
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        boolean whetherSuccessful = true;
        int radiusOfCircle = 0;
        int widthOfTriangle = 0;
        int heightOfTriangle = 0;
        int directionOfTriangle = 0;
        if (params.length == 1) {
            radiusOfCircle = params[0];
        } else {
            widthOfTriangle = params[0];
            heightOfTriangle = params[1];
            directionOfTriangle = params[2];
        }
        if (params.length == 1) {
            Location location = new Location(x, y);
            Shape circle = new Circle(location, pattern, radiusOfCircle);
            Circle copyOfCircle = (Circle) circle;
            if (this.ExamineFullyOutOfBoundsForCircle(copyOfCircle)) {
                this.AddCircle(copyOfCircle);
                shapes.add(circle);
            } else {
                whetherSuccessful = false;
                return whetherSuccessful;
            }
        } else {
            Location location = new Location(x, y);
            Shape triangle = new RightTriangle(location, pattern, widthOfTriangle, heightOfTriangle, Direction.GetCorrespondingDirection(directionOfTriangle));
            RightTriangle copyOfTriangle = (RightTriangle) triangle;
            if (this.ExamineFullyOutOfBoundsForTriangle(copyOfTriangle) ) {
                this.AddTriangle(copyOfTriangle);
                shapes.add(triangle);
            } else {
                whetherSuccessful = false;
                return whetherSuccessful;
            }
        }
        return whetherSuccessful;
    }

    @Override
    public int getSpaceGridCount() {
        int totalNumber=0;
        for (int indexInRowOfCanvas = 0; indexInRowOfCanvas < canvas.length; indexInRowOfCanvas++) {
            for (int indexInColumnOFCanvas = 0; indexInColumnOFCanvas < canvas[0].length; indexInColumnOFCanvas++) {
                if (canvas[indexInRowOfCanvas][indexInColumnOFCanvas]!=' '){
                    totalNumber+=1;
                }
            }
        }
        return canvas.length*canvas[0].length- totalNumber;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        Comparator<Shape> comparator = new Comparator<Shape>() {
            @Override
            public int compare(Shape shapeOne, Shape shapeTwo) {
                int areaOfShapeOne = shapeOne.area();
                int areaOfShapeTwo = shapeTwo.area();
                char patternOfShapeOne = shapeOne.pattern;
                char patternOfShapeTwo = shapeTwo.pattern;
                if (areaOfShapeOne<areaOfShapeTwo){
                    return -1;
                } else if (areaOfShapeOne > areaOfShapeTwo) {
                    return 1;
                } else {
                    if (patternOfShapeOne<patternOfShapeTwo){
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        };
        Collections.sort(shapes,comparator);
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Comparator<Shape> comparator = new Comparator<Shape>() {
            @Override
            public int compare(Shape shapeOne, Shape shapeTwo) {
                int xOfShapeOne = shapeOne.location.getX();
                int yOfShapeOne = shapeOne.location.getY();
                int xOfShapeTwo = shapeTwo.location.getX();
                int yOfShapeTwo = shapeTwo.location.getY();
                char patternOfShapeOne = shapeOne.pattern;
                char patternOfShapeTwo = shapeTwo.pattern;
                if (xOfShapeOne<xOfShapeTwo){
                    return -1;
                } else if (xOfShapeOne>xOfShapeTwo) {
                    return 1;
                } else {
                    if (yOfShapeOne<yOfShapeTwo){
                        return -1;
                    } else if (yOfShapeOne>yOfShapeTwo){
                        return 1;
                    } else {
                        if (patternOfShapeOne<patternOfShapeTwo){
                            return -1;
                        } else {
                            return 1;
                        }
                    }
                }
            }
        };
        Collections.sort(shapes,comparator);
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
    public void fillCanvasWithBlank(){
        for (int indexInHeight = 0; indexInHeight < canvas.length; indexInHeight++) {
            for (int indexInWidth = 0; indexInWidth < canvas[indexInHeight].length; indexInWidth++)
                canvas[indexInHeight][indexInWidth] = ' ';
        }
    }
    public void AddTriangle(RightTriangle triangle) {
        char pattern = triangle.pattern;
        char[][] copyOfCirclePartOfCanvas = triangle.getGrids();
        for (int indexInRows = 0; indexInRows < copyOfCirclePartOfCanvas.length; indexInRows++) {
            for (int indexInColumn = 0; indexInColumn < copyOfCirclePartOfCanvas[0].length; indexInColumn++) {
                if (copyOfCirclePartOfCanvas[indexInRows][indexInColumn] != ' '&&whetherPointInCanvas(triangle.location.getX()+indexInRows,triangle.location.getY()+indexInColumn)) {
                    canvas[triangle.location.getX() + indexInRows][triangle.location.getY() + indexInColumn] = pattern;
                }
            }
        }
    }
    public void AddCircle(Circle circle) {
        char pattern = circle.pattern;
        char[][] copyOfCirclePartOfCanvas = circle.getGrids();
        for (int indexInRows = 0; indexInRows < copyOfCirclePartOfCanvas.length; indexInRows++) {
            for (int indexInColumn = 0; indexInColumn < copyOfCirclePartOfCanvas[0].length; indexInColumn++) {
                if (copyOfCirclePartOfCanvas[indexInRows][indexInColumn] != ' '&&whetherPointInCanvas(circle.location.getX()+indexInRows,circle.location.getY()+indexInColumn)) {
                    canvas[circle.location.getX() + indexInRows][circle.location.getY() + indexInColumn] = pattern;
                }
            }
        }
    }
    public boolean ExamineFullyOutOfBoundsForCircle(Circle circle) {
        boolean whetherValid = false;
        char[][] copyOfCirclePartOfCanvas = circle.getGrids();
        for (int indexInRows = 0; indexInRows < copyOfCirclePartOfCanvas.length; indexInRows++) {
            for (int indexInColumn = 0; indexInColumn < copyOfCirclePartOfCanvas[0].length; indexInColumn++) {
                if ((copyOfCirclePartOfCanvas[indexInRows][indexInColumn] != ' ') && (circle.location.getX()+indexInRows<rowNumber)&&(-1<circle.location.getX()+indexInRows)&&(circle.location.getY()+indexInColumn>-1)&&(circle.location.getY()+indexInColumn<columnNumber)) {
                    whetherValid = true;
                    return whetherValid;
                }
            }
        }
        return whetherValid;
    }
    public boolean ExamineFullyOutOfBoundsForTriangle(RightTriangle triangle) {
        boolean whetherValid = false;
        char[][] copyOfCirclePartOfCanvas = triangle.getGrids();
        for (int indexInRows = 0; indexInRows < copyOfCirclePartOfCanvas.length; indexInRows++) {
            for (int indexInColumn = 0; indexInColumn < copyOfCirclePartOfCanvas[0].length; indexInColumn++) {
                if ((copyOfCirclePartOfCanvas[indexInRows][indexInColumn] != ' ') && (triangle.location.getX()+indexInRows<rowNumber)&&(-1<triangle.location.getX()+indexInRows)&&(triangle.location.getY()+indexInColumn>-1)&&(triangle.location.getY()+indexInColumn<columnNumber)) {
                    whetherValid = true;
                    return whetherValid;
                }
            }
        }
        return whetherValid;
    }
    private boolean whetherPointInCanvas(int rowIndex, int columnIndex){
        boolean whetherInCanvas = true;
        if (rowIndex<0){
            whetherInCanvas = false;
            return whetherInCanvas;
        } else if (rowIndex > rowNumber-1){
            whetherInCanvas = false;
            return  whetherInCanvas;
        } else if(columnIndex<0){
            whetherInCanvas = false;
            return whetherInCanvas;
        } else if (columnIndex>columnNumber-1){
            whetherInCanvas = false;
            return whetherInCanvas;
        }
        return whetherInCanvas;
    }

}
