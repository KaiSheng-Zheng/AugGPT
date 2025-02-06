

import java.awt.font.GraphicAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        initializeCanvas();

    }
    private void initializeCanvas() {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x, y);
        boolean flag = false;
        if (params.length == 1){
            boolean a = true;
            boolean b = false;
            int radius = params[0];
            for (int n = 1; n <= 2; n++) {
                h1:
                for (int i = 0; i < 2*radius; i++) {
                    for (int j = 0; j < 2*radius; j++) {
                        if (i<radius) {
                            if (j<radius) {
                                if (Math.pow(radius-j-1, 2) + Math.pow(radius-i-1, 2) < Math.pow(radius, 2)) {
                                    if ((x + i) < canvas.length && (y + j) < canvas[0].length){
                                        if (a){
                                            flag = true;
                                            break h1;
                                        }
                                        else if (b){
                                            canvas[x+i][y+j] = pattern;
                                        }
                                    }
                                }
                            } else {
                                if (Math.pow(radius-j, 2) + Math.pow(radius-i-1, 2) < Math.pow(radius, 2)) {
                                    if ((x+i) < canvas.length && (y + j) < canvas[0].length){
                                        if (a){
                                            flag = true;
                                            break h1;
                                        }
                                        else if (b){
                                            canvas[x+i][y+j] = pattern;
                                        }
                                    }
                                }
                            }
                        } else {
                            if (j < radius) {
                                if (Math.pow(radius-j-1, 2) + Math.pow(radius-i, 2) < Math.pow(radius, 2)) {
                                    if ((x + i) < canvas.length && (y + j) < canvas[0].length){
                                        if (a){
                                            flag = true;
                                            break h1;
                                        }
                                        else if (b){
                                            canvas[x+i][y+j] = pattern;
                                        }
                                    }
                                }
                            } else {
                                if (Math.pow(radius-j, 2) + Math.pow(radius-i, 2) < Math.pow(radius, 2)) {
                                    if ((x + i) < canvas.length && (y + j) < canvas[0].length){
                                        if (a){
                                            flag = true;
                                            break h1;
                                        }
                                        else if (b){
                                            canvas[x+i][y+j] = pattern;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                a = false;
                b = true;
            }
            if (flag){
                Circle circle = new Circle(location, pattern, radius);
                shapes.add(circle);
            }
        }
        else {
            boolean a = true;
            boolean b = false;
            int width = params[0];
            int height = params[1];

            for (int n = 1; n <= 2; n++){
                h2:
                for (int i = 0; i < height; i++){
                    for (int j = 0; j < width; j++){
                        switch (params[2]){
                            case 0:
                                if((double)(height-i)*width > (double) j*height){
                                    if ((x + i) < canvas.length && (y + j) < canvas[0].length){
                                        if (a){
                                            flag = true;
                                            break h2;
                                        }
                                        if (b) {
                                            canvas[x+i][y+j] = pattern;
                                        }
                                    }
                                }
                                break ;
                            case 1:
                                if((double)(i+1)*width > (double) j*height){
                                    if ((x + i) < canvas.length && (y + j) < canvas[0].length){
                                        if (a){
                                            flag = true;
                                            break h2;
                                        }
                                        if (b) {
                                            canvas[x+i][y+j] = pattern;
                                        }
                                    }
                                }
                                break ;
                            case 2:
                                if((double)(height - i) * width >  ((double) height *(width - 1 - j) )){
                                    if ((x + i) < canvas.length && (y + j) < canvas[0].length){
                                        if (a){
                                            flag = true;
                                            break h2;
                                        }
                                        if (b) {
                                            canvas[x+i][y+j] = pattern;
                                        }
                                    }
                                }
                                break ;
                            case 3:
                                if(((double) (i + 1) *width ) >  ((double) height *(width - 1 - j) )){
                                    if ((x + i) < canvas.length && (y + j) < canvas[0].length){
                                        if (a){
                                            flag = true;
                                            break h2;
                                        }
                                        if (b) {
                                            canvas[x+i][y+j] = pattern;
                                        }
                                    }
                                }
                                break ;

                        }
                    }
                }
                a = false;
                b = true;
            }
            Direction d = Direction.values()[params[2]];
            if (flag){
                RightTriangle rightTriangle = new RightTriangle(location, pattern,width, height, d);
                shapes.add(rightTriangle);
            }
        }
        return flag;
    }
    @Override
    public int getSpaceGridCount() {
        int num = 0;
        for (char[] row : canvas){
            for (char column : row){
                if (column == ' '){
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
        Arrays.sort(Area, new Comparator<>(){
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
        Arrays.sort(Location, new Comparator<>(){
            @Override
            public int compare(Shape s1, Shape s2) {
                if (s1.location.getX() != s2.location.getX()){
                    return s1.location.getX() - s2.location.getX();
                }
                else if (s1.location.getY() != s2.location.getY()){
                    return s1.location.getY() - s2.location.getY();
                }
                else {
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
