public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;
    private int numberOfFilledGrids;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        numberOfFilledGrids = 0;
        this.fillGrids();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Direction getD() {
        return d;
    }

    public int getNumberOfFilledGrids() {
        return numberOfFilledGrids;
    }

    public int area(){
        return this.numberOfFilledGrids;
    }

    public void fillGrids() {
        if (d.equals(Direction.LEFT_UP)){
            this.fillGridsForLeftUp();
        } else if (d.equals(Direction.RIGHT_UP)) {
            this.fillGridsForRightUp();
        } else if (d.equals(Direction.RIGHT_DOWN)) {
            this.fillGridsForRightDown();
        } else if (d.equals(Direction.LEFT_DOWN)) {
            this.fillGridsForLeftDown();
        }
    }
    public void enlarge(){
        this.height+=1;
        this.width+=1;
        this.numberOfFilledGrids = 0;
        this.fillGrids();
    }
    public void shrink(){
        this.height-=1;
        this.width-=1;
        this.numberOfFilledGrids = 0;
        this.fillGrids();
    }
    public String toString(){
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%S",location.getX(),location.getY(),this.area(),pattern);
    }
    private void fillGridsForLeftUp(){
        grids = new char[height][width];
        this.fillGridsWithBlank();
        double currentWidth= (double) width;
        double changeOfWidthWhenChangingOneRow = (double) width/(double) height;
        for (int indexInHeight = 0; indexInHeight < height; indexInHeight++) {
            for (int indexInWidth = 0; indexInWidth < width; indexInWidth++) {
                if(indexInWidth<currentWidth){
                    grids[indexInHeight][indexInWidth] = pattern;
                    numberOfFilledGrids+=1;
                }else {
                    break;
                }
            }
            currentWidth -= changeOfWidthWhenChangingOneRow;
        }
    }
    private void fillGridsForLeftDown(){
        grids = new char[height][width];
        this.fillGridsWithBlank();
        double currentWidth= 0;
        double changeOfWidthWhenChangingOneRow = (double) width/(double) height;
        for (int indexInHeight = 0; indexInHeight < height; indexInHeight++) {
            currentWidth += changeOfWidthWhenChangingOneRow;
            for (int indexInWidth = 0; indexInWidth < width; indexInWidth++) {
                if(indexInWidth<currentWidth){
                    grids[indexInHeight][indexInWidth] = pattern;
                    numberOfFilledGrids+=1;
                }else {
                    break;
                }
            }
        }
    }
    private void fillGridsForRightUp(){
        grids = new char[height][width];
        this.fillGridsWithBlank();
        double currentRowPosition=0;
        double changeOfWidthWhenChangingOneRow = (double) width/(double) height;
        for (int indexInHeight = 0; indexInHeight < height; indexInHeight++) {
            for (int indexInWidth = 0; indexInWidth < width; indexInWidth++) {
                if(indexInWidth+1>currentRowPosition){
                    grids[indexInHeight][indexInWidth] = pattern;
                    numberOfFilledGrids+=1;
                }
            }
            currentRowPosition += changeOfWidthWhenChangingOneRow;
        }
    }
    private void fillGridsForRightDown(){
        grids = new char[height][width];
        this.fillGridsWithBlank();
        double currentRowPosition=(double) width;
        double changeOfWidthWhenChangingOneRow = (double) width/(double) height;
        for (int indexInHeight = 0; indexInHeight < height; indexInHeight++) {
            currentRowPosition -= changeOfWidthWhenChangingOneRow;
            for (int indexInWidth = 0; indexInWidth < width; indexInWidth++) {
                if(indexInWidth+1>currentRowPosition){
                    grids[indexInHeight][indexInWidth] = pattern;
                    numberOfFilledGrids+=1;
                }
            }
        }
    }
}
