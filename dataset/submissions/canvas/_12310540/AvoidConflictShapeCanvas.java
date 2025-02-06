import java.util.*;

public class AvoidConflictShapeCanvas  implements ShapeCanvas {
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.canvas = new char[rows][cols];
        initializeCanvas();
    }

    private void initializeCanvas() {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvas[i][j] = ' ';
            }
        }
    }


    @Override

    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x, y);

        if (params.length == 1){
            boolean a = true;
            boolean b = false;
            int radius = params[0];

            if ((x+2*radius) > canvas.length || (y+2*radius) > canvas[0].length){
                return false;
            }

            for (int n = 1; n <= 2; n++) {
                for (int i = 0; i < 2*radius; i++) {
                    for (int j = 0; j < 2*radius; j++) {
                        if (i<radius) {
                            if (j<radius) {
                                if (Math.pow(radius-j-1, 2) + Math.pow(radius-i-1, 2) < Math.pow(radius, 2)) {
                                    if(a && canvas[x+i][y+j] != ' ') {
                                        return false;
                                    }
                                    if(b) {
                                        canvas[x+i][y+j] = pattern;
                                    }
                                }
                            } else {
                                if (Math.pow(radius-j, 2) + Math.pow(radius-i-1, 2) < Math.pow(radius, 2)) {
                                    if(a && canvas[x+i][y+j] != ' ') {
                                        return false;
                                    }
                                    if(b) {
                                        canvas[x+i][y+j] = pattern;
                                    }
                                }
                            }
                        } else {
                            if (j<radius) {
                                if (Math.pow(radius-j-1, 2) + Math.pow(radius-i, 2) < Math.pow(radius, 2)) {
                                    if(a && canvas[x+i][y+j] != ' ') {
                                        return false;
                                    }
                                    if(b) {
                                        canvas[x+i][y+j] = pattern;
                                    }
                                }

                            } else {
                                if (Math.pow(radius-j, 2) + Math.pow(radius-i, 2) < Math.pow(radius, 2)) {
                                    if (a && canvas[x+i][y+j] != ' ') {
                                        return false;
                                    }
                                    if (b) {
                                        canvas[x+i][y+j] = pattern;
                                    }
                                }
                            }
                        }
                    }
                }
                a = false;
                b = true;
            }
            Circle circle = new Circle(location, pattern,radius);
            shapes.add(circle);
        }
        else {
            int width = params[0];
            int height = params[1];
            if (((y + width) > canvas[0].length) || ((x + params[1]) > canvas.length)){
                return false;
            }
            boolean a = true;
            boolean b = false;
            for (int n = 1; n <= 2; n++){
                for (int i = 0; i < height; i++){
                    for (int j = 0; j < width; j++){
                        switch (params[2]){
                            case 0:
                                if((double)(height-i)*width > (double) j*height){
                                    if (a && canvas[x + i][y + j] != ' '){
                                        return false;
                                    }
                                    if (b) {
                                        canvas[x + i][y + j] = pattern;
                                    }
                                }
                                break;
                            case 1:
                                if ((double)(i+1)*width > (double) j*height){
                                    if (a && canvas[x + i][y + j] != ' '){
                                        return false;
                                    }
                                    if (b) {
                                        canvas[x + i][y + j] = pattern;
                                    }
                                }
                                break;
                            case 2:
                                if ((double)(height - i) * width >  ((double) height *(width - 1 - j) )){
                                    if (a && canvas[x + i][y + j] != ' '){
                                        return false;
                                    }
                                    if (b) {
                                        canvas[x + i][y + j] = pattern;
                                    }
                                }
                                break;
                            case 3:
                                if (((double) (i + 1) *width ) >  ((double) height *(width - 1 - j) )){
                                    if (a && canvas[x + i][y + j] != ' '){
                                        return false;
                                    }
                                    if (b) {
                                        canvas[x + i][y + j] = pattern;
                                    }
                                }
                                break;
                        }
                    }
                }
                a = false;
                b = true;
            }
            Direction d = Direction.values()[params[2]];
            RightTriangle rightTriangle = new RightTriangle(location, pattern, width, height, d);
            shapes.add(rightTriangle);
        }
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int num = 0;
        for (char[] row : canvas) {
            for (char column : row) {
                if (column == ' ') {
                    num++;
                }
            }
        }
        return num;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        Shape[] Area = new Shape[shapes.size()];
        shapes.toArray(Area);
        Arrays.sort(Area, new Comparator<>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                if (s1.area() != s2.area()) {
                    return s1.area() - s2.area();
                } else {
                    return s1.pattern - s2.pattern;
                }
            }
        });
        return Arrays.asList(Area);
    }


    @Override
    public List<Shape> getShapesByLocation() {
        Shape[] Location = new Shape[shapes.size()];
        shapes.toArray(Location);
        Arrays.sort(Location, new Comparator<>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                if (s1.location.getX() != s2.location.getX()) {
                    return s1.location.getX() - s2.location.getX();
                } else if (s1.location.getY() != s2.location.getY()) {
                    return s1.location.getY() - s2.location.getY();
                } else {
                    return s1.pattern - s2.pattern;
                }
            }
        });
        return Arrays.asList(Location);
    }


    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}



