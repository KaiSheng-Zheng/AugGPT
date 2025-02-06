import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes = new ArrayList<>();
    private ArrayList <Integer> areas = new ArrayList<Integer>();
    private char[][] canvas;
    private char[][] grids;
    private int width,height,indexOfDirection,radius;
    private Direction [] directions = Direction.values();
    public AvoidConflictShapeCanvas(int rows, int cols){
        this.canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.canvas[i][j] = ' ';
            }

        }
    }
    public boolean addShape(int x, int y, char pattern, int... params){
        if (params.length==3){
            width = params[0];
            height = params[1];
            indexOfDirection = params[2];

            RightTriangle triangle = new RightTriangle(new Location(x,y),pattern,width,height,this.directions[indexOfDirection]);
            grids = triangle.getGrids();
            for (int i = 0; i < this.grids.length; i++) {
                for (int j = 0; j < this.grids[i].length; j++) {
                    if(grids[i][j]==pattern){
                        if((x+i>=this.canvas.length)||(y+j>=this.canvas[0].length)||(x+i<0)||(y+j<0)){
                            return false;
                        }else if(this.canvas[x+i][y+j]!=' '){
                            return false;
                        }
                    }
                }
            }
            for (int i = 0; i < this.grids.length; i++) {
                for (int j = 0; j < this.grids[i].length; j++) {
                    if(grids[i][j]==pattern){
                        this.canvas[x+i][y+j]= pattern;
                    }

                }

            }
            shapes.add(triangle);
            areas.add(triangle.area());
            return true;
        }else {
            radius = params[0];
            Circle circle = new Circle(new Location(x, y), pattern, radius);
            grids = circle.getGrids();
            for (int i = 0; i < this.grids.length; i++) {
                for (int j = 0; j < this.grids[i].length; j++) {
                    if (grids[i][j] == pattern) {
                        if ((x + i >= this.canvas.length) || (y + j >= this.canvas[0].length) || (x + i < 0) || (y + j < 0)) {
                            return false;
                        } else if (this.canvas[x + i][y + j] != ' ') {
                            return false;
                        }
                    }
                }
            }
            for (int i = 0; i < this.grids.length; i++) {
                for (int j = 0; j < this.grids[i].length; j++) {
                    if (grids[i][j] == pattern) {
                        this.canvas[x + i][y + j] = pattern;
                    }

                }

            }
            shapes.add(circle);
            areas.add(circle.area());
            return true;
        }
    }

    @Override
    public int getSpaceGridCount() {
        // incomplete implementation
        return 0;
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
        ShapeCanvas shapeCanvas = new AvoidConflictShapeCanvas(20, 20);
        System.out.println(shapeCanvas.addShape(0, 2, 'A', 5, 3, 1));
        System.out.println(shapeCanvas.addShape(6, 8, 'B', 5, 7, 2));
        System.out.println(shapeCanvas.addShape(8, 12, 'C', 5));
        System.out.println(shapeCanvas.addShape(6,6,'D',5,7,1));
        System.out.println(shapeCanvas.addShape(0,8,'E',3));

        shapeCanvas.getShapesByArea().forEach(System.out::println);
        shapeCanvas.getShapesByLocation().forEach(System.out::println);

        for (char[] line:shapeCanvas.getCanvas()) {
            System.out.println(line);
        }
    }

}
