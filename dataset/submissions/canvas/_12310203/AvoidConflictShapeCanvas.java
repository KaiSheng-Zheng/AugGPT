import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }
    public int getArea(Shape shape){
        int area=0;
        for (char[] canva : canvas) {
            for (char c : canva) {
                if (c == shape.pattern) {
                    area++;
                }
            }
        }
        return area;
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape shape = null;
        if (params.length == 1) {
            shape = new Circle(new Location(x, y), pattern, params[0]);
            shape.setParams(params);
        } else if (params.length == 3) {
            shape = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.values()[params[2]]);
            shape.setParams(params);
        }
        if (shape != null && canAddShape(shape)) {
            shapes.add(shape);
            return true;
        }
        return false;
    }
    private boolean canAddShape(Shape shape) {
        boolean b = true;
        if(shape.params.length==1){
            int radius = shape.params[0];
            int x = shape.location.getX();
            int y = shape.location.getY();
            if(x<0 || y<0 || x+2*radius>canvas.length||y+2*radius>canvas[0].length){b=false;}
            else {
                for (int i = 1; i < canvas.length; i++) {
                    for (int j = 1; j < canvas[i].length; j++) {
                        if ((i-(x+radius)) * (i-(x+radius)) + (j-(y+radius)) * (j-(y+radius)) < radius * radius) {
                            if ((canvas[i][j]!=' ')
                            ||(canvas[i - 1][j]!=' ')
                            ||(canvas[i][j - 1] !=' ')
                            ||(canvas[i - 1][j - 1] !=' ')) {b=false;}
                        }
                    }
                }
                if(b) {
                    for (int i = 1; i < canvas.length; i++) {
                        for (int j = 1; j < canvas[i].length; j++) {
                            if ((i-(x+radius)) * (i-(x+radius)) + (j-(y+radius)) * (j-(y+radius)) < radius * radius) {
                                if (canvas[i][j] == ' ') canvas[i][j] = shape.pattern;
                                if (canvas[i - 1][j] == ' ') canvas[i - 1][j] = shape.pattern;
                                if (canvas[i][j - 1] == ' ') canvas[i][j - 1] = shape.pattern;
                                if (canvas[i - 1][j - 1] == ' ') canvas[i - 1][j - 1] = shape.pattern;
                            }
                        }
                    }
                    getArea(shape);
                }
            }
        }
        if(shape.params.length==3) {
            int width = shape.params[0];
            int height = shape.params[1];
            int x = shape.location.getX();
            int y = shape.location.getY();
            if (x < 0 || y < 0||x+height>canvas.length||y+width>canvas[0].length) {
                b=false;
            } else {
                switch (shape.params[2]) {
                    case 0:
                        for (int i = y; i < width + y; i++) {
                            if(canvas[x][i]!=' '){b=false;break;}
                        }
                        for (int i = x; i < height + x; i++) {
                            if(canvas[i][y]!=' ') {b=false;break;}
                        }
                        for (int i = x + 1; i < height + x; i++) {
                            for (int j = y + 1; j < width + y; j++) {
                                if ((i - x) < height - (double) (height * (j - y)) / width) {
                                    if ((canvas[i][j] != ' ')
                                    ||(canvas[i - 1][j] != ' ')
                                    || (canvas[i][j - 1] != ' ')
                                    || (canvas[i - 1][j - 1] != ' ')){b=false;}
                                }
                            }
                        }

                        if(b) {
                            for (int i = y; i < width + y; i++) {
                                canvas[x][i] = shape.pattern;
                            }
                            for (int i = x; i < height + x; i++) {
                                canvas[i][y] = shape.pattern;
                            }
                            for (int i = x + 1; i < height + x; i++) {
                                for (int j = y + 1; j < width + y; j++) {
                                    if ((i - x) < height - (double) (height * (j - y)) / width) {
                                        if (canvas[i][j] != shape.pattern) canvas[i][j] = shape.pattern;
                                        if (canvas[i - 1][j] != shape.pattern) canvas[i - 1][j] = shape.pattern;
                                        if (canvas[i][j - 1] != shape.pattern) canvas[i][j - 1] = shape.pattern;
                                        if (canvas[i - 1][j - 1] != shape.pattern) canvas[i - 1][j - 1] = shape.pattern;
                                    }
                                }
                            }
                        }
                        break;
                    case 1:
                        for(int i=x;i<x+height;i++){
                            if (canvas[i][y] != ' ') {b = false;break;}
                        }
                        for(int i=y;i<width+y;i++){
                            if(canvas[x+height-1][i]!=' '){b=false;break;}
                        }
                        for (int i=x+1;i < height+x;i++) {
                            for (int j=y+1; j < width+y;j++) {
                                if (i-x>(double)height*(j-y)/width) {
                                    if ((canvas[i][j] != ' ')
                                            ||(canvas[i - 1][j] != ' ')
                                            || (canvas[i][j - 1] != ' ')
                                            || (canvas[i - 1][j - 1] != ' ')){b=false;break;}
                                }
                            }
                        }

                        if(b) {
                            for (int i = x; i < x + height; i++) {
                                canvas[i][y] = shape.pattern;
                            }
                            for (int i = y; i < width + y; i++) {
                                canvas[x + height - 1][i] = shape.pattern;
                            }
                            for (int i = x + 1; i < height + x; i++) {
                                for (int j = y + 1; j < width + y; j++) {
                                    if (i - x > (double) height * (j - y) / width) {
                                        if (canvas[i][j] != shape.pattern) canvas[i][j] = shape.pattern;
                                        if (canvas[i - 1][j] != shape.pattern) canvas[i - 1][j] = shape.pattern;
                                        if (canvas[i][j - 1] != shape.pattern) canvas[i][j - 1] = shape.pattern;
                                        if (canvas[i - 1][j - 1] != shape.pattern) canvas[i - 1][j - 1] = shape.pattern;
                                    }
                                }
                            }
                        }
                        break;
                    case 2:
                        for(int i=y;i<width+y;i++){
                            if(canvas[x][i]!=' '){b=false;break;}
                        }
                        for(int i=x;i<height+x;i++){
                            if(canvas[i][y+width-1]!=' '){b=false;break;}
                        }
                        for (int i=x+1;i < height+x;i++) {
                            for (int j=1+y; j < width+y;j++) {
                                if (i-x<(double)height*(j-y)/width) {
                                    if ((canvas[i][j] != ' ')
                                            ||(canvas[i - 1][j] != ' ')
                                            || (canvas[i][j - 1] != ' ')
                                            || (canvas[i - 1][j - 1] != ' ')){b=false;break;}
                                }
                            }
                        }
                        if(b) {
                            for (int i = y; i < width + y; i++) {
                                canvas[x][i] = shape.pattern;
                            }
                            for (int i = x; i < height + x; i++) {
                                canvas[i][y + width - 1] = shape.pattern;
                            }
                            for (int i = x + 1; i < height + x; i++) {
                                for (int j = 1 + y; j < width + y; j++) {
                                    if (i - x < (double) height * (j - y) / width) {
                                        if (canvas[i][j] != shape.pattern) canvas[i][j] = shape.pattern;
                                        if (canvas[i - 1][j] != shape.pattern) canvas[i - 1][j] = shape.pattern;
                                        if (canvas[i][j - 1] != shape.pattern) canvas[i][j - 1] = shape.pattern;
                                        if (canvas[i - 1][j - 1] != shape.pattern) canvas[i - 1][j - 1] = shape.pattern;
                                    }
                                }
                            }
                        }
                        break;
                    case 3:
                        for(int i=y;i<width+y;i++){
                            if(canvas[x+height-1][i]!=' '){b=false;break;}
                        }
                        for(int i=x;i<height+x;i++) {
                            if (canvas[i][y + width - 1] != ' ') {b = false;break;}
                        }
                        for (int i=1+x;i < height+x;i++) {
                            for (int j=1+y; j < width+y;j++) {
                                if (i-x>height- (double) (height * (j-y)) /width) {
                                    if ((canvas[i][j] != ' ')
                                            ||(canvas[i - 1][j] != ' ')
                                            || (canvas[i][j - 1] != ' ')
                                            || (canvas[i - 1][j - 1] != ' ')){b=false;break;}
                                }
                            }
                        }
                    if(b) {
                        for (int i = y; i < width + y; i++) {
                            canvas[x + height - 1][i] = shape.pattern;
                        }
                        for (int i = x; i < height + x; i++) {
                            canvas[i][y + width - 1] = shape.pattern;
                        }
                        for (int i = 1 + x; i < height + x; i++) {
                            for (int j = 1 + y; j < width + y; j++) {
                                if (i - x > height - (double) (height * (j - y)) / width) {
                                    if (canvas[i][j] != shape.pattern) canvas[i][j] = shape.pattern;
                                    if (canvas[i - 1][j] != shape.pattern) canvas[i - 1][j] = shape.pattern;
                                    if (canvas[i][j - 1] != shape.pattern) canvas[i][j - 1] = shape.pattern;
                                    if (canvas[i - 1][j - 1] != shape.pattern) canvas[i - 1][j - 1] = shape.pattern;
                                }
                            }
                        }
                    }
                        break;

                }
                if(b){getArea(shape);}
            }
        }
        return b;
    }
/*
    private void drawShape(Shape shape) {
        for (int i = 0; i < shape.getLocation().getX() + shape.getWidth(); i++) {
            for (int j = 0; j < shape.getLocation().getY() + shape.getHeight(); j++) {
                if (i < 0 || i >= canvas.length || j < 0 || j >= canvas[0].length) {
                    continue;
                }
                canvas[i][j] = shape.getPattern();
            }
        }
    }
*/
    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (char[] canva : canvas) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canva[j] == ' ') {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        shapes.sort((s1, s2) -> {
            if (s1.area() != s2.area()) {
                return Integer.compare(s1.area(), s2.area());
            } else {
                return Character.compare(s1.getPattern(), s2.getPattern());
            }
        });
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort((s1, s2) -> {
            if (s1.getLocation().getX() != s2.getLocation().getX()) {
                return Integer.compare(s1.getLocation().getX(), s2.getLocation().getX());
            } else if (s1.getLocation().getY() != s2.getLocation().getY()) {
                return Integer.compare(s1.getLocation().getY(), s2.getLocation().getY());
            } else {
                return Character.compare(s1.getPattern(), s2.getPattern());
            }
        });
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
