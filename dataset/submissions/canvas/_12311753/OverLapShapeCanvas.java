
import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes = new ArrayList<>();
    private ArrayList<Integer> areas = new ArrayList<Integer>();
    private char[][] canvas;
    private int width,height,indexOfDirection,radius;
    private char[][] grids;
    private Direction [] directions = Direction.values();
    public OverLapShapeCanvas(int rows, int cols){
        this.canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.canvas[i][j] = ' ';
            }

        }
    }
    public boolean addShape(int x, int y, char pattern, int... params){
        int cmd = 0;
        if (params.length==3){
            width = params[0];
            height = params[1];
            indexOfDirection = params[2];

            RightTriangle triangle = new RightTriangle(new Location(x,y),pattern,width,height,this.directions[indexOfDirection]);
            grids = triangle.getGrids();
            for (int i = 0; i < this.grids.length; i++) {
                for (int j = 0; j < this.grids[i].length; j++) {
                    if(grids[i][j]==pattern){
                        if((x+i<this.canvas.length)&(y+j<this.canvas[0].length)&(x+i>=0)&(y+j>=0)){
                            this.canvas[x+i][y+j]= pattern;
                            cmd++;
                        }

                    }
                }
            }
            if(cmd>0){
                shapes.add(triangle);
                areas.add(triangle.area());
                return true;
            }else{
                return false;
            }

        }else {
            radius = params[0];
            Circle circle = new Circle(new Location(x, y), pattern, radius);
            grids = circle.getGrids();
            for (int i = 0; i < this.grids.length; i++) {
                for (int j = 0; j < this.grids[i].length; j++) {
                    if (grids[i][j] == pattern) {
                        if ((x + i < this.canvas.length) & (y + j < this.canvas[0].length) & (x + i >= 0) & (y + j >= 0)) {
                            this.canvas[x+i][y+j]= pattern;
                            cmd++;
                        }
                    }
                }
            }
            if(cmd>0){
                shapes.add(circle);
                areas.add(circle.area());
                return true;
            }else{
                return false;
            }
        }
    }

    @Override
    public int getSpaceGridCount() {
        int count = this.canvas.length*this.canvas[0].length;
        for (int i = 0; i < this.canvas.length; i++) {
            for (int j = 0; j < this.canvas[0].length; j++) {
                if(this.canvas[i][j]!=' '){
                    count--;
                }
            }

        }
        return count;
    }

    @Override
    public int getShapeCount() {
        return this.shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        List<Shape> orderedShape= new ArrayList<>();
        Integer cup;
        Shape littleCup ;

        for (int i = 0; i < this.areas.size(); i++) {
            for (int j = i+1; j < this.areas.size(); j++) {
                if (areas.get(i)>areas.get(j)||(areas.get(i).equals(areas.get(j))&&shapes.get(i).getPattern()>shapes.get(j).getPattern())){
                    cup = areas.get(i);
                    areas.set(i,areas.get(j));
                    areas.set(j,cup);
                    littleCup = shapes.get(i);
                    shapes.set(i, shapes.get(j));
                    shapes.set(j,littleCup);
                }
            }

        }
        for (int i = 0; i < this.shapes.size(); i++) {
            orderedShape.add(shapes.get(i));
        }
        return orderedShape;
    }
    public boolean needChange(Shape shape1,Shape shape2){
        if(shape1.getLocation().getX()>shape2.getLocation().getX()){
            return true;
        } else if (shape1.getLocation().getX()==shape2.getLocation().getX()) {
            if(shape1.getLocation().getY()>shape2.getLocation().getY()){
                return true;
            } else if (shape1.getLocation().getY()==shape2.getLocation().getY()) {
                if(shape1.getPattern()>shape2.getPattern()){
                    return true;
                }
            }

        }
        return false;
    }
    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> orderedShape= new ArrayList<>();
        Shape littleCup ;
        for (int i = 0; i < this.shapes.size(); i++) {
            for (int j = i+1; j < this.shapes.size(); j++) {
                if (needChange(shapes.get(i),shapes.get(j))){
                    littleCup = shapes.get(i);
                    shapes.set(i, shapes.get(j));
                    shapes.set(j,littleCup);
                }
            }

        }
        for (int i = 0; i < this.shapes.size(); i++) {
            orderedShape.add(shapes.get(i));
        }
        return orderedShape;
    }

    @Override
    public char[][] getCanvas() {
        return this.canvas;
    }
    public static void main(String[] args) {
        ShapeCanvas canvas1 = new OverLapShapeCanvas(15, 15);
        canvas1.addShape(0, 0, 'A', 6);
        canvas1.addShape(1, 1, 'B', 5);
        canvas1.addShape(2, 2, 'C', 4);
        canvas1.addShape(3, 3, 'D', 3);
        canvas1.addShape(10, 5, 'E', 4, 6, 2);
        canvas1.addShape(14, 14, 'F', 4, 6, 3);
        canvas1.addShape(10, 5, '0', 3, 2, 1);
        canvas1.addShape(10, 5, '1', 1, 1, 2);
        for (char[] line : canvas1.getCanvas()) {
            System.out.println(line);
        }
        System.out.println(canvas1.getShapeCount());
        System.out.println(canvas1.getSpaceGridCount());
        canvas1.getShapesByArea().forEach(System.out::println);
        canvas1.getShapesByLocation().forEach(System.out::println);
    }
}
