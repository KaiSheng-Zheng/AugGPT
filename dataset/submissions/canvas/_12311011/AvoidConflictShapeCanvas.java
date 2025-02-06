import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    private int area=0;
    private int shapeCount=0;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        shapes = new ArrayList<>();
        canvas = new char[rows][cols];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvas[i][j] =' ';
            }

        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x, y);
        boolean result = true;
        switch(params.length){
            case 1 :
                Circle circle = new Circle(location, pattern, params[0]);
                int radius = params[0];
                if (x+ 2*radius <= canvas.length
                        && y+2*radius<= canvas[0].length){
                    for (int i = y; i < y+2*radius; i++) {//y axis
                        for (int j = x; j < x+2 * radius; j++) {//x axis
                            double d = Math.sqrt(Math.pow((i - 0.5) - (y+radius - 1), 2) + Math.pow((j - 0.5) - (x+radius - 1), 2));
                            if (d - radius < 0.5 * 1.4) {//inside the circle
                                if (canvas[j][i] != ' ') {
                                    return false;
                                }
                            }
                        }
                    }
                    for (int i = y; i < y+2*radius; i++) {//y axis
                        for (int j = x; j < x+2 * radius; j++) {//x axis
                            double d = Math.sqrt(Math.pow((i - 0.5) - (y+radius - 1), 2) + Math.pow((j - 0.5) - (x+radius - 1), 2));
                            if (d - radius < 0.5 * 1.4) {//inside the circle
                                canvas[j][i] = pattern;area++;
                            }
                        }
                    }
                }
                else{result = false;}
                if (result){
                    shapeCount++;shapes.add(circle);
                }
                break;

            case 3 :
                Direction d = switch (params[2]) {
                    case 0 -> Direction.LEFT_UP;
                    case 1 -> Direction.LEFT_DOWN;
                    case 2 -> Direction.RIGHT_UP;
                    case 3 -> Direction.RIGHT_DOWN;
                    default -> null;
                };
                if (x+params[1] > canvas.length || y+params[0]> canvas[0].length) {return false;}
                RightTriangle rightTriangle = new RightTriangle(location, pattern, params[0], params[1], d);
                int width = params[0];int height = params[1];double tan = (double)width/height;
                switch (d) {
                    case RIGHT_UP:
                        for (int i = 1; i <= height; i++) {
                            double a = tan * i;
                            for (int j = 0; j < width; j++) {
                                if (j < a) {
                                    if (canvas[x + height - i][y + width - j - 1] != ' ') {
                                        return false;
                                    }
                                }

                            }
                        }
                        for (int i = 1; i <= height; i++) {
                            double a = tan * i;
                            for (int j = 0; j < width; j++) {
                                if (j < a) {
                                    canvas[x + height - i][y + width - j - 1] = pattern;
                                    area++;
                                }

                            }
                        }
                        break;
                    case RIGHT_DOWN:
                        for (int i = 1; i <= height; i++) {
                            double a = tan * i;
                            for (int j = 0; j < width; j++) {
                                if (j < a) {
                                    if (canvas[x + i - 1][y + width - j - 1] != ' ') {
                                        return false;
                                    }
                                }
                            }
                        }
                        for (int i = 1; i <= height; i++) {
                            double a = tan * i;
                            for (int j = 0; j < width; j++) {
                                if (j < a) {
                                    canvas[x + i - 1][y + width - j - 1] = pattern;
                                    area++;
                                }
                            }
                        }
                        break;
                    case LEFT_UP:
                        for (int i = 1; i <= height; i++) {
                            double a = tan * i;
                            for (int j = 0; j < width; j++) {
                                if (a - j > 0) {
                                    if (canvas[x + height - i][y + j] != ' ') {
                                        return false;
                                    }
                                }
                            }
                        }
                        for (int i = 1; i <= height; i++) {
                            double a = tan * i;
                            for (int j = 0; j < width; j++) {
                                if (a - j > 0) {
                                    canvas[x + height - i][y + j] = pattern;
                                    area++;
                                }
                            }
                        }
                        break;
                    case LEFT_DOWN:
                        for (int i = 1; i <= height; i++) {
                            double a = tan * i;
                            for (int j = 0; j < width; j++) {
                                if (a - j > 0) {
                                    if (canvas[x + i - 1][y + j] != ' ') {
                                        return false;
                                    }
                                }
                            }
                        }
                        for (int i = 1; i <= height; i++) {
                            double a = tan * i;
                            for (int j = 0; j < width; j++) {
                                if (a - j > 0) {
                                    canvas[x + i - 1][y + j] = pattern;
                                    area++;
                                }
                            }
                        }
                        break;
                }
                if (result){
                    shapeCount++;
                    shapes.add(rightTriangle);
                }
        }

        return result;
    }

    @Override
    public int getSpaceGridCount() {
        return canvas.length * canvas[0].length-area;
    }

    @Override
    public int getShapeCount() {
        return shapeCount;
    }

    @Override
    public List<Shape> getShapesByArea() {
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = i+1; j < shapes.size(); j++) {
                if (shapes.get(i).area() > shapes.get(j).area()){
                    Shape temp = shapes.get(i);
                    shapes.set(i,shapes.get(j));
                    shapes.set(j,temp);
                }
                if (shapes.get(i).area() == shapes.get(j).area()){
                if (shapes.get(i).getPattern()>shapes.get(j).getPattern()){
                    Shape temp = shapes.get(i);
                    shapes.set(i,shapes.get(j));
                    shapes.set(j,temp);
                }
                }
            }

        }
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = i+1; j < shapes.size(); j++) {
                if (shapes.get(i).location.getX() > shapes.get(j).location.getX()){
                    Shape temp = shapes.get(i);
                    shapes.set(i,shapes.get(j));
                    shapes.set(j,temp);
                }
                if (shapes.get(i).location.getX() == shapes.get(j).location.getX()){
                    if (shapes.get(i).location.getY() >shapes.get(j).location.getY()){
                        Shape temp = shapes.get(i);
                        shapes.set(i,shapes.get(j));
                        shapes.set(j,temp);
                    }
                    if (shapes.get(i).location.getY() ==shapes.get(j).location.getY()){
                        if (shapes.get(i).getPattern()>shapes.get(j).getPattern()){
                            Shape temp = shapes.get(i);
                            shapes.set(i,shapes.get(j));
                            shapes.set(j,temp);
                        }
                    }

                }
            }

        }
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

}