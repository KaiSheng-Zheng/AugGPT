import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
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
        boolean b = false;
        if(shape.params.length==1){
            int radius = shape.params[0];
            int x = shape.location.getX();
            int y = shape.location.getY();
                    for (int i = 1; i <= canvas.length; i++) {
                        for (int j = 1; j <= canvas[0].length; j++) {
                            if ((i-(x+radius)) * (i-(x+radius)) + (j-(y+radius)) * (j-(y+radius)) < radius * radius) {
                                if (i>=0&&i<canvas.length&&j>=0&&j<canvas[0].length) canvas[i][j] = shape.pattern;
                                if (i>=1&&i<canvas.length+1&&j>=0&&j<canvas[0].length) canvas[i - 1][j] = shape.pattern;
                                if (i>=0&&i<canvas.length&&j>=1&&j<canvas[0].length+1) canvas[i][j - 1] = shape.pattern;
                                if (i>=1&&i<canvas.length+1&&j>=1&&j<canvas[0].length+1)
                                    canvas[i - 1][j - 1] = shape.pattern;
                            }
                        }
                    }
                    getArea(shape);
                    if(getArea(shape)>0){b=true;}
        }
        if(shape.params.length==3) {
            int width = shape.params[0];
            int height = shape.params[1];
            int x = shape.location.getX();
            int y = shape.location.getY();
            if(y>=canvas[0].length||x>=canvas.length||x+height<=0||y+width<=0){b=false;}
            else {
                switch (shape.params[2]) {
                    case 0:
                            for (int i = y; i < width + y; i++) {
                                if(x>=0&&i>=0&&i<canvas[0].length)
                                {canvas[x][i] = shape.pattern;}
                            }
                            for (int i = x; i < height + x; i++) {
                                if(i>=0&&i<canvas.length&&y>=0&&y<canvas[0].length)
                                {canvas[i][y] = shape.pattern;}
                            }
                            for (int i = x + 1; i < height + x; i++) {
                                for (int j = y + 1; j < width + y; j++) {
                                    if ((i - x) < height - (double) (height * (j - y)) / width) {
                                        if (i>=0&&i<canvas.length&&j>=0&&j<canvas[0].length)
                                            canvas[i][j] = shape.pattern;
                                        if (i>=1&&i<canvas.length+1&&j>=0&&j<canvas[0].length)
                                            canvas[i - 1][j] = shape.pattern;
                                        if (i>=0&&i<canvas.length&&j>=1&&j<canvas[0].length+1)
                                            canvas[i][j - 1] = shape.pattern;
                                        if (i>=1&&i<canvas.length+1&&j>=1&&j<canvas[0].length+1)
                                            canvas[i - 1][j - 1] = shape.pattern;
                                    }
                                }
                            }
                        break;
                    case 1:
                            for (int i = x; i < x + height; i++) {
                                if(i>=0&&i<canvas.length&&y>=0&&y<canvas[0].length)
                                {canvas[i][y] = shape.pattern;}
                            }
                            for (int i = y; i < width + y; i++) {
                                if(x+height-1>=0&&i>=0&&i+height-1<canvas[0].length&&i<canvas[0].length)
                                {canvas[x + height - 1][i] = shape.pattern;}
                            }
                            for (int i = x + 1; i < height + x; i++) {
                                for (int j = y + 1; j < width + y; j++) {
                                    if (i - x > (double) height * (j - y) / width) {
                                        if (i>=0&&i<canvas.length&&j>=0&&j<canvas[0].length)
                                            canvas[i][j] = shape.pattern;
                                        if (i>=1&&i<canvas.length+1&&j>=0&&j<canvas[0].length)
                                            canvas[i - 1][j] = shape.pattern;
                                        if (i>=0&&i<canvas.length&&j>=1&&j<canvas[0].length+1)
                                            canvas[i][j - 1] = shape.pattern;
                                        if (i>=1&&i<canvas.length+1&&j>=1&&j<canvas[0].length+1)
                                            canvas[i - 1][j - 1] = shape.pattern;
                                    }
                                }
                            }
                        break;
                    case 2:
                            for (int i = y; i < width + y; i++) {
                                if(x>=0&&i>=0&&i<canvas[0].length)
                                {canvas[x][i] = shape.pattern;}
                            }
                            for (int i = x; i < height + x; i++) {
                                if(y+width-1>=0&&i>=0&&i<canvas.length&&y+width-1<canvas[0].length)
                                {canvas[i][y + width - 1] = shape.pattern;}
                            }
                            for (int i = x + 1; i < height + x; i++) {
                                for (int j = 1 + y; j < width + y; j++) {
                                    if (i - x < (double) height * (j - y) / width) {
                                        if (i>=0&&i<canvas.length&&j>=0&&j<canvas[0].length)
                                            canvas[i][j] = shape.pattern;
                                        if (i>=1&&i<canvas.length+1&&j>=0&&j<canvas[0].length)
                                            canvas[i - 1][j] = shape.pattern;
                                        if (i>=0&&i<canvas.length&&j>=1&&j<canvas[0].length+1)
                                            canvas[i][j - 1] = shape.pattern;
                                        if (i>=1&&i<canvas.length+1&&j>=1&&j<canvas[0].length+1)
                                            canvas[i - 1][j - 1] = shape.pattern;
                                    }
                                }
                            }
                        break;
                    case 3:
                            for (int i = y; i < width + y; i++) {
                                if(x + height - 1>=0&&x + height - 1<canvas.length&&i>=0&&i<canvas[0].length)
                                {canvas[x + height - 1][i] = shape.pattern;}
                            }

                            for (int i = x; i < height + x; i++) {
                                if(i>=0&&y+width-1>=0&&y+width-1<canvas[0].length&&i<canvas.length)
                                {canvas[i][y + width - 1] = shape.pattern;}
                            }
                            for (int i = 1 + x; i < height + x; i++) {
                                for (int j = 1 + y; j < width + y; j++) {
                                    if (i - x > height - (double) (height * (j - y)) / width) {
                                        if (i>=0&&i<canvas.length&&j>=0&&j<canvas[0].length)
                                            canvas[i][j] = shape.pattern;
                                        if (i>=1&&i<canvas.length+1&&j>=0&&j<canvas[0].length)
                                            canvas[i - 1][j] = shape.pattern;
                                        if (i>=0&&i<canvas.length&&j>=1&&j<canvas[0].length+1)
                                            canvas[i][j - 1] = shape.pattern;
                                        if (i>=1&&i<canvas.length+1&&j>=1&&j<canvas[0].length+1)
                                            canvas[i - 1][j - 1] = shape.pattern;
                                    }
                                }
                            }
                        break;
                }
                getArea(shape);
                if(getArea(shape)>0){b=true;}
            }
        }
        return b;
    }
    
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
    public List<Shape> getShapesByLocation()  {
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

