public class Circle extends Shape {
    private int radius;
    private int numberOfFilledGrids;
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius = radius;
        numberOfFilledGrids = 0;
        this.fillGrids();
    }

    public int getRadius() {
        return radius;
    }

    public int getNumberOfFilledGrids() {
        return numberOfFilledGrids;
    }

    public void fillGrids(){
        //clear the counter before counting
        grids = new char[radius*2][radius*2];
        this.fillGridsWithBlank();
        for (int indexInTheOutLayer = 0; indexInTheOutLayer < radius*2; indexInTheOutLayer++) {
            for (int indexInTheInerLayer = 0; indexInTheInerLayer < radius*2; indexInTheInerLayer++) {
                int distanceSquareOne = (radius-indexInTheOutLayer)*(radius-indexInTheOutLayer)+(radius-indexInTheInerLayer)*(radius-indexInTheInerLayer);
                int distanceSquareTwo = (radius-indexInTheOutLayer)*(radius-indexInTheOutLayer)+(radius-indexInTheInerLayer-1)*(radius-indexInTheInerLayer-1);
                int distanceSquareThree = (radius-indexInTheOutLayer-1)*(radius-indexInTheOutLayer-1)+(radius-indexInTheInerLayer)*(radius-indexInTheInerLayer);
                int distanceSquareFour = (radius-indexInTheOutLayer-1)*(radius-indexInTheOutLayer-1)+(radius-indexInTheInerLayer-1)*(radius-indexInTheInerLayer-1);
                if (distanceSquareOne<radius*radius||distanceSquareTwo<radius*radius||distanceSquareThree<radius*radius||distanceSquareFour<radius*radius){
                    grids[indexInTheOutLayer][indexInTheInerLayer]=pattern;
                    numberOfFilledGrids+=1;
                }
            }
        }
    }
    public void enlarge(){
        this.radius+=1;
        this.numberOfFilledGrids = 0;
        this.fillGrids();
    }
    public void shrink(){
        this.radius-=1;
        this.numberOfFilledGrids = 0;
        this.fillGrids();
    }
    public int area(){
        return this.numberOfFilledGrids;
    }
    public String toString(){
        return String.format("Circle: (%d,%d) area=%d pattern=%S",location.getX(),location.getY(),this.area(),pattern);
    }
}