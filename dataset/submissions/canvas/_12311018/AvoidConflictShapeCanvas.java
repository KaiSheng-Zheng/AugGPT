import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    private int[][] filledStateRecorder;
    int rowNumber;
    int columnNumber;

    public AvoidConflictShapeCanvas(int rows,int cols) {
        shapes = new ArrayList<>();
        this.rowNumber = rows;
        this.columnNumber = cols;
        canvas = new char[rows][cols];
        this.fillCanvasWithBlank();
        this.SetUpTheStateRecorder(rows, cols);
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
            if (this.ExamineOutOfBoundsForCircle(copyOfCircle) && this.ExamineWhetherSpareSpaceForCircle(copyOfCircle)) {
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
            if (this.ExamineOutOfBoundsForTriangle(copyOfTriangle) && this.ExamineWhetherSpareSpaceForTriangle(copyOfTriangle)) {
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
                if (areaOfShapeOne < areaOfShapeTwo) {
                    return -1;
                } else if (areaOfShapeOne > areaOfShapeTwo) {
                    return 1;
                } else {
                    if (patternOfShapeOne < patternOfShapeTwo) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        };
        Collections.sort(shapes, comparator);
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
                if (xOfShapeOne < xOfShapeTwo) {
                    return -1;
                } else if (xOfShapeOne > xOfShapeTwo) {
                    return 1;
                } else {
                    if (yOfShapeOne < yOfShapeTwo) {
                        return -1;
                    } else if (yOfShapeOne > yOfShapeTwo) {
                        return 1;
                    } else {
                        if (patternOfShapeOne < patternOfShapeTwo) {
                            return -1;
                        } else {
                            return 1;
                        }
                    }
                }
            }
        };
        Collections.sort(shapes, comparator);
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

    public void fillCanvasWithBlank() {
        for (int indexInHeight = 0; indexInHeight < canvas.length; indexInHeight++) {
            for (int indexInWidth = 0; indexInWidth < canvas[indexInHeight].length; indexInWidth++)
                canvas[indexInHeight][indexInWidth] = ' ';
        }
    }

    private void SetUpTheStateRecorder(int rows, int cols) {
        filledStateRecorder = new int[rows][cols];
        for (int indexInRow = 0; indexInRow < rows; indexInRow++) {
            for (int indexInColumn = 0; indexInColumn < cols; indexInColumn++) {
                filledStateRecorder[indexInRow][indexInColumn] = 0;
            }
        }
    }

    private boolean ExamineOutOfBoundsForCircle(Circle circle) {
        boolean whetherValid = true;
        if (circle.location.getX() < 0) {
            whetherValid = false;
            return whetherValid;
        } else if (circle.location.getX() + 2 * circle.getRadius() > rowNumber) {
            whetherValid = false;
            return whetherValid;
        } else if (circle.location.getY() < 0) {
            whetherValid = false;
            return whetherValid;
        } else if (circle.location.getY() + 2 * circle.getRadius() > columnNumber) {
            whetherValid = false;
            return whetherValid;
        }
        return whetherValid;
    }

    public boolean ExamineWhetherSpareSpaceForCircle(Circle circle) {
        boolean whetherValid = true;
        char[][] copyOfCirclePartOfCanvas = circle.getGrids();
        for (int indexInRows = 0; indexInRows < copyOfCirclePartOfCanvas.length; indexInRows++) {
            for (int indexInColumn = 0; indexInColumn < copyOfCirclePartOfCanvas[0].length; indexInColumn++) {
                if ((copyOfCirclePartOfCanvas[indexInRows][indexInColumn] != ' ') && (filledStateRecorder[circle.location.getX() + indexInRows][circle.location.getY() + indexInColumn] == 1)) {
                    whetherValid = false;
                    return whetherValid;
                }
            }
        }
        return whetherValid;
    }

    public void AddCircle(Circle circle) {
        char pattern = circle.pattern;
        char[][] copyOfCirclePartOfCanvas = circle.getGrids();
        for (int indexInRows = 0; indexInRows < copyOfCirclePartOfCanvas.length; indexInRows++) {
            for (int indexInColumn = 0; indexInColumn < copyOfCirclePartOfCanvas[0].length; indexInColumn++) {
                if (copyOfCirclePartOfCanvas[indexInRows][indexInColumn] != ' ') {
                    canvas[circle.location.getX() + indexInRows][circle.location.getY() + indexInColumn] = pattern;
                    filledStateRecorder[circle.location.getX() + indexInRows][circle.location.getY() + indexInColumn] = 1;
                }
            }
        }
    }

    public boolean ExamineOutOfBoundsForTriangle(RightTriangle triangle) {
        boolean whetherValid = true;
        if (triangle.location.getX() < 0) {
            whetherValid = false;
            return whetherValid;
        } else if (triangle.location.getY() < 0) {
            whetherValid = false;
            return whetherValid;
        } else if (triangle.location.getY() + triangle.getWidth() - 1 > columnNumber - 1) {
            whetherValid = false;
            return whetherValid;
        } else if (triangle.location.getX() + triangle.getHeight() - 1 > rowNumber - 1) {
            whetherValid = false;
            return whetherValid;
        }
        return whetherValid;
    }

    public boolean ExamineWhetherSpareSpaceForTriangle(RightTriangle triangle) {
        boolean whetherValid = true;
        char[][] copyOfTrianglePartOfCanvas = triangle.getGrids();
        for (int indexInRows = 0; indexInRows < copyOfTrianglePartOfCanvas.length; indexInRows++) {
            for (int indexInColumn = 0; indexInColumn < copyOfTrianglePartOfCanvas[0].length; indexInColumn++) {
                if ((copyOfTrianglePartOfCanvas[indexInRows][indexInColumn] != ' ') && (filledStateRecorder[triangle.location.getX() + indexInRows][triangle.location.getY() + indexInColumn] == 1)) {
                    whetherValid = false;
                    return whetherValid;
                }
            }
        }
        return whetherValid;
    }

    public void AddTriangle(RightTriangle triangle) {
        char pattern = triangle.pattern;
        char[][] copyOfCirclePartOfCanvas = triangle.getGrids();
        for (int indexInRows = 0; indexInRows < copyOfCirclePartOfCanvas.length; indexInRows++) {
            for (int indexInColumn = 0; indexInColumn < copyOfCirclePartOfCanvas[0].length; indexInColumn++) {
                if (copyOfCirclePartOfCanvas[indexInRows][indexInColumn] != ' ') {
                    canvas[triangle.location.getX() + indexInRows][triangle.location.getY() + indexInColumn] = pattern;
                    filledStateRecorder[triangle.location.getX() + indexInRows][triangle.location.getY() + indexInColumn] = 1;
                }
            }
        }
    }
}