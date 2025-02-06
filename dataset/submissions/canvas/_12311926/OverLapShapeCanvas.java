import java.util.ArrayList;
import java.util.Comparator;

public class OverLapShapeCanvas implements ShapeCanvas {
    private ArrayList<Shape> shapes;
    private char[][] canvas;
    private int count;
    private ArrayList<Shape> list = new ArrayList<>();

    public OverLapShapeCanvas(int rows, int cols) {
        count = 0;
        this.canvas = new char[rows][cols];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                canvas[i][j] = '\u0020';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length == 1) {
            Location location = new Location(x, y);
            Circle circle = new Circle(location, pattern, params[0]);
            if (x + params[0] * 2 - 1 > canvas.length - 1 && y + params[0] * 2 - 1 > canvas[0].length - 1) {
                for (int i = 0; i < canvas.length - x; i++) {
                    for (int j = 0; j < canvas[i].length - y; j++) {
                        if (circle.grids[i][j] != ' ') {
                            for (int i1 = 0; i1 < canvas.length - x; i1++) {
                                for (int j1 = 0; j1 < canvas[i1].length - y; j1++) {
                                    if (circle.grids[i1][j1] != ' ') {
                                        canvas[x + i1][y + j1] = circle.grids[i1][j1];
                                    }

                                }
                            }
                            count++;
                            list.add(circle);
                            return true;
                        }
                    }
                }
                return false;
            }
            if (x + params[0] * 2 - 1 > canvas.length - 1 && y + params[0] * 2 - 1 <= canvas[0].length - 1) {
                for (int i = 0; i < canvas.length - x; i++) {
                    for (int j = 0; j < circle.grids[i].length; j++) {
                        if (circle.grids[i][j] != ' ') {
                            for (int i1 = 0; i1 < canvas.length - x; i1++) {
                                for (int j1 = 0; j1 < circle.grids[i1].length ; j1++) {
                                    if (circle.grids[i1][j1] != ' ') {
                                        canvas[x + i1][y + j1] = circle.grids[i1][j1];
                                    }

                                }
                            }
                            count++;
                            list.add(circle);
                            return true;
                        }
                    }
                }
                return false;
            }
            if (x + params[0] * 2 - 1 <= canvas.length - 1 && y + params[0] * 2 - 1 > canvas[0].length - 1) {
                for (int i = 0; i < circle.grids.length; i++) {
                    for (int j = 0; j < canvas[i].length-y; j++) {
                        if (circle.grids[i][j] != ' ') {
                            for (int i1 = 0; i1 < circle.grids.length; i1++) {
                                for (int j1 = 0; j1 < canvas[i1].length-y; j1++) {
                                    if (circle.grids[i1][j1] != ' ') {
                                        canvas[x + i1][y + j1] = circle.grids[i1][j1];
                                    }

                                }
                            }
                            count++;
                            list.add(circle);
                            return true;
                        }
                    }
                }
                return false;
            }

            if (x + params[0] * 2 - 1 <= canvas.length - 1 && y + params[0] * 2 - 1 <= canvas[0].length - 1) {
                for (int i = 0; i < circle.grids.length; i++) {
                    for (int j = 0; j < circle.grids[i].length; j++) {
                        if (circle.grids[i][j] != ' ') {
                            canvas[x + i][y + j] = circle.grids[i][j];
                        }
                    }
                }
                count++;
                list.add(circle);

            }
            return true;
        }


        if (params.length == 3) {
            Location location = new Location(x, y);
            ArrayList<Direction> arrayList = new ArrayList<>();
            arrayList.add(Direction.LEFT_UP);
            arrayList.add(Direction.LEFT_DOWN);
            arrayList.add(Direction.RIGHT_UP);
            arrayList.add(Direction.RIGHT_DOWN);
            RightTriangle rightTriangle = new RightTriangle(location, pattern, params[0], params[1], arrayList.get(params[2]));
            if (x + params[1] - 1 > canvas.length - 1 && y + params[0] - 1 > canvas[0].length - 1) {
                for (int i = 0; i < canvas.length - x; i++) {
                    for (int j = 0; j < canvas[i].length - y; j++) {
                        if (rightTriangle.grids[i][j] != ' ') {
                            for (int i1 = 0; i1 <= canvas.length - x - 1; i1++) {
                                for (int j1 = 0; j1 <= canvas[i1].length - y - 1; j1++) {
                                    if (rightTriangle.grids[i1][j1] != ' ') {
                                        canvas[x + i1][y + j1] = rightTriangle.grids[i1][j1];
                                    }

                                }
                            }
                            count++;
                            list.add(rightTriangle);
                            return true;
                        }

                    }
                }
                return false;
            }
            if (x + params[1] - 1 > canvas.length - 1 && y + params[0] - 1 <= canvas[0].length - 1) {
                for (int i = 0; i < canvas.length - x; i++) {
                    for (int j = 0; j < rightTriangle.grids[i].length; j++) {
                        if (rightTriangle.grids[i][j] != ' ') {
                            for (int i1 = 0; i1 <= canvas.length - x - 1; i1++) {
                                for (int j1 = 0; j1 < rightTriangle.grids[i1].length; j1++) {
                                    if (rightTriangle.grids[i1][j1] != ' ') {
                                        canvas[x + i1][y + j1] = rightTriangle.grids[i1][j1];
                                    }

                                }
                            }
                            count++;
                            list.add(rightTriangle);
                            return true;
                        }

                    }
                }
                return false;
            }
            if (x + params[1] - 1 <= canvas.length - 1 && y + params[0] - 1 > canvas[0].length - 1) {
                for (int i = 0; i < rightTriangle.grids.length ; i++) {
                    for (int j = 0; j < canvas[i].length-y; j++) {
                        if (rightTriangle.grids[i][j] != ' ') {
                            for (int i1 = 0; i1 <rightTriangle.grids.length; i1++) {
                                for (int j1 = 0; j1 <= canvas[0].length - y - 1; j1++) {
                                    if (rightTriangle.grids[i1][j1] != ' ') {
                                        canvas[x + i1][y + j1] = rightTriangle.grids[i1][j1];
                                    }

                                }
                            }
                            count++;
                            list.add(rightTriangle);
                            return true;
                        }

                    }
                }
                return false;
            }
            if (x + params[1] - 1 <= canvas.length - 1 && y + params[0] - 1 <= canvas[0].length - 1) {
                for (int i = 0; i < rightTriangle.grids.length; i++) {
                    for (int j = 0; j < rightTriangle.grids[i].length; j++) {
                        if (rightTriangle.grids[i][j] != ' ') {
                            canvas[x + i][y + j] = rightTriangle.grids[i][j];
                        }
                    }
                }
                count++;
                list.add(rightTriangle);
                return true;
            }

        }
        return false;
    }

    @Override
    public int getSpaceGridCount() {
        int sum = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int i1 = 0; i1 < canvas[i].length; i1++) {
                if (canvas[i][i1] == '\u0020') {
                    sum++;
                }
            }
        }
        return sum;
    }

    @Override
    public int getShapeCount() {
        return count;
    }

    @Override
    public ArrayList<Shape> getShapesByArea() {
        ArrayList<Shape> sortedShapes = list;
        sortedShapes.sort(Comparator.comparingInt(Shape::area).thenComparing(Shape::getPattern));
        return sortedShapes;
    }

    @Override
    public ArrayList<Shape> getShapesByLocation() {
        ArrayList<Shape> sortedShapes = list;
        sortedShapes.sort(Comparator.comparing(Shape::getX).thenComparing(Shape::getY).thenComparing(Shape::getPattern));
        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }


}
