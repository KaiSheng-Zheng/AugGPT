

public abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;
    public abstract int getX();
    public abstract int getY();
    public Shape(Location location, char pattern){
        this.location = location;
        this.pattern = pattern;
    }
    public char getPattern (){
        return pattern;
    }
    public char[][] getGrids(){
        return  grids;
    }
    public abstract void setGrids();
    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
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
