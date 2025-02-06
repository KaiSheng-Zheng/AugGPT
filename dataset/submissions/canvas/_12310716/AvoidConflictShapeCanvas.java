import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


    public class AvoidConflictShapeCanvas implements ShapeCanvas {
        private List<Shape> shapes;
        private char[][] canvas;
        public int spaceGridCount=0;
        public int shapeCount=0;

        public AvoidConflictShapeCanvas(int rows, int cols) {
            this.shapes = new ArrayList<>();
            this.canvas = new char[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    canvas[i][j]=' ';
                }
            }
        }

        @Override
        public boolean addShape(int x, int y, char pattern, int... params) {
            if(params.length!=1){
            if (x < 0 || y < 0 || x + params[1] > canvas.length || y + params[0] > canvas[0].length) {
                return false;
            }
            for (int i = y; i < y + params[0]; i++) {
                for (int j = x; j < x + params[1]; j++) {
                    if (canvas[j][i] != ' ') {
                        return false;
                    }
                }
            }
            for (int i = y; i < y + params[0]; i++) {
                for (int j = x; j < x + params[1]; j++) {
                    canvas[j][i] = pattern;
                    spaceGridCount++;
                }
            }
            }
            else{
                if (x < 0 || y < 0 || x + params[0]*2 > canvas.length||y+params[0]*2>canvas[0].length ) {
                    return false;
                }
                for (int i = y; i < y + params[0]*2; i++) {
                    for (int j = x; j < x + params[0]*2; j++) {
                        if (canvas[j][i] != ' ') {
                            return false;
                        }
                    }
                }
                for (int i = y; i < y + params[0]*2; i++) {
                    for (int j = x; j < x + params[0]*2; j++) {
                            canvas[j][i]=pattern;
                            spaceGridCount++;
                    }
                }
            }
            shapeCount++;
            return true;
        }

        @Override
        public int getSpaceGridCount() {
            return spaceGridCount;
        }

        @Override
        public int getShapeCount() {
            return shapeCount;
        }

        @Override
        public List<Shape> getShapesByArea() {
        shapes.sort(Comparator.comparingInt(Shape::area));
        shapes.sort(Comparator.comparing(Shape::getPattern));
            return shapes;
        }

        @Override
        public List<Shape> getShapesByLocation() {
            shapes.sort(Comparator.comparingInt(Location::getX));
            shapes.sort(Comparator.comparingInt(Location::getY));
            return shapes;
        }

        @Override
        public char[][] getCanvas() {
            return canvas;
        }


    }

