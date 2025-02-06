import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes = new ArrayList<Shape>();
    private char[][] canvas;
    private int shapeCount = 0;

    public OverLapShapeCanvas(int rows, int cols) {
        this.canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int radius) {
        int validcount=0;
        //leftup
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if (Math.pow(i + 1 - radius, 2) + Math.pow(j + 1 - radius, 2) < Math.pow(radius, 2)) {
                    if (x+i>=0 && x+i< canvas.length && y+j>=0 && y+j< canvas[0].length) {
                        canvas[x + i][y + j] = pattern;
                        validcount++;
                    }
                }
            }
        }
        //rightup
        for (int i = 0; i < radius; i++) {
            for (int j = radius; j < radius * 2; j++) {
                if (Math.pow(i + 1 - radius, 2) + Math.pow(j - radius, 2) < Math.pow(radius, 2)) {
                    if (x+i>=0 && x+i< canvas.length && y+j>=0 && y+j< canvas[0].length) {
                        canvas[x + i][y + j] = pattern;
                        validcount++;
                    }
                }
            }
        }
        //leftdown
        for (int i = radius; i < radius * 2; i++) {
            for (int j = 0; j < radius; j++) {
                if (Math.pow(i - radius, 2) + Math.pow(j + 1 - radius, 2) < Math.pow(radius, 2)) {
                    if (x+i>=0 && x+i< canvas.length && y+j>=0 && y+j< canvas[0].length) {
                        canvas[x + i][y + j] = pattern;
                        validcount++;
                    }
                }
            }
        }
        //rightdown
        for (int i = radius; i < radius * 2; i++) {
            for (int j = radius; j < radius * 2; j++) {
                if (Math.pow(i - radius, 2) + Math.pow(j - radius, 2) < Math.pow(radius, 2)) {
                    if (x+i>=0 && x+i< canvas.length && y+j>=0 && y+j< canvas[0].length) {
                        canvas[x + i][y + j] = pattern;
                        validcount++;
                    }
                }
            }
        }
        if (validcount==0){
            return false;
        }
        Shape circle = new Circle(new Location(x, y), pattern, radius);
        shapes.add(circle);
        shapeCount++;
        return true;
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int width, int height, int d){
        int validcount=0;
        double slope=(double)height/width;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (d==1) {
                    if (j==0){
                        if (x+i>=0 && x+i< canvas.length && y+j>=0 && y+j< canvas[0].length) {
                            canvas[x + i][y + j] = pattern;
                            validcount++;
                        }
                    }
                    else {
                        double a=(double)(i+1)/j;
                        if (a>slope){
                            if (x+i>=0 && x+i< canvas.length && y+j>=0 && y+j< canvas[0].length) {
                                canvas[x + i][y + j] = pattern;
                                validcount++;
                            }
                        }
                    }
                }
                else if (d==0) {
                    if (j==0){
                        if (x+i>=0 && x+i< canvas.length && y+j>=0 && y+j< canvas[0].length) {
                            canvas[x + i][y + j] = pattern;
                            validcount++;
                        }
                    }
                    else{
                        double a=(double)(height-i)/j;
                        if (a>slope){
                            if (x+i>=0 && x+i< canvas.length && y+j>=0 && y+j< canvas[0].length) {
                                canvas[x + i][y + j] = pattern;
                                validcount++;
                            }
                        }
                    }
                }
                else if (d==3) {
                    if ((width-j-1)==0){
                        if (x+i>=0 && x+i< canvas.length && y+j>=0 && y+j< canvas[0].length) {
                            canvas[x + i][y + j] = pattern;
                            validcount++;
                        }
                    }else{
                        double a=(double) (i+1)/(width-j-1);
                        if (a>slope){
                            if (x+i>=0 && x+i< canvas.length && y+j>=0 && y+j< canvas[0].length) {
                                canvas[x + i][y + j] = pattern;
                                validcount++;
                            }
                        }
                    }
                }
                else if (d==2) {
                    if ((width-j-1)==0){
                        if (x+i>=0 && x+i< canvas.length && y+j>=0 && y+j< canvas[0].length) {
                            canvas[x + i][y + j] = pattern;
                            validcount++;
                        }
                    }else{
                        double a=(double)(height-i)/(width-j-1);
                        if (a>slope){
                            if (x+i>=0 && x+i< canvas.length && y+j>=0 && y+j< canvas[0].length) {
                                canvas[x + i][y + j] = pattern;
                                validcount++;
                            }
                        }
                    }
                }
            }
        }
        if (validcount==0){
            return false;
        }
        shapeCount++;
        Direction direction = null;
        if (d==0){
            direction= Direction.LEFT_UP;
        }
        else if (d==1){
            direction= Direction.LEFT_DOWN;
        }
        else if (d==2){
            direction= Direction.RIGHT_UP;
        }
        else if (d==3){
            direction= Direction.RIGHT_DOWN;
        }
        Shape rightTriangle = new RightTriangle(new Location(x, y), pattern, width,height, direction);
        shapes.add(rightTriangle);
        return true;
    }

    @Override
    public int getSpaceGridCount(){
        int spaceGridCount=0;
        for (int i=0;i<canvas.length;i++){
            for (int j=0;j<canvas[0].length;j++){
                if (canvas[i][j]==' '){
                    spaceGridCount++;
                }
            }
        }
        return spaceGridCount;
    }

    @Override
    public int getShapeCount(){
        return shapeCount;
    }

    @Override
    public List<Shape> getShapesByArea(){
        List<Shape> list = new ArrayList<Shape>();
        for (Shape shape : shapes) {
            shape.setMode("area");
            list.add(shape);
        }

        Collections.sort(list, list.get(0));

        return list;
    }

    @Override
    public List<Shape> getShapesByLocation(){
        List<Shape> list = new ArrayList<Shape>();
        for (Shape shape : shapes) {
            shape.setMode("location");
            list.add(shape);
        }

        Collections.sort(list, list.get(0));

        return list;
    }

    @Override
    public char[][] getCanvas(){
        return canvas;
    }

}
