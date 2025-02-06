//add score for player
// set the position for Position
public class Position {
    private int row;
    private int col;
    public Position(int row,int col){
        this.col = col;
        this.row = row;
    }

    @Override
    public boolean equals(Object position) {
        // Check if the object is compared with itself
        if (this == position) {
            return true;
        }

        // Check if the object is an instance of Position
        if (!(position instanceof Position)) {
            return false;
        }

        // Typecast position to Position so that we can compare data members
        Position p = (Position) position;

        // Compare the data members and return accordingly
        return this.row == p.row && this.col == p.col;
    }

    public int getCol(){
        return col;
    }
    public int getRow(){
        return row;
    }
    public void setRow(int Row){
        this.row= Row;
    }
    public void setCol(int Col){
        this.row= Col;
    }

    public boolean isOutsideMap(Map map) {
        return col < 0 || row < 0 || col >=map.getColumns()|| row >= map.getRows();
    }
    public Position moveToBoundary(Direction direction, Map map) {
        Position newPosition = new Position(this.row, this.col);
        switch (direction) {
            case UP:
                newPosition.row = 0;
                break;
            case DOWN:
                newPosition.row = map.getRows() - 1;
                break;
            case RIGHT:
                newPosition.col = map.getColumns() - 1;
                break;
            case LEFT:
                newPosition.col = 0;
                break;
        }
        return newPosition;
    }
    public int stepsFrom(Position other) {
        return Math.abs(this.row - other.row) + Math.abs(this.col - other.col);
    }


    public Position calculateNewPosition(Direction direction, int steps) {
        Position newPosition = new Position(this.row, this.col);
        switch (direction) {
            case UP:
                newPosition.row -= steps;
                break;
            case DOWN:
                newPosition.row += steps;
                break;
            case RIGHT:
                newPosition.col += steps;
                break;
            case LEFT:
                newPosition.col -= steps;
                break;
        }
        return newPosition;
    }

}
