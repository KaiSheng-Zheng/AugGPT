public class Position {
    private int row;
    private int col;

    public Position(int row, int col){ //constructor method;
        this.row = row;
        this.col = col;
    }

    public boolean equals(Object position){ //equals method;
        Position targetPosition = (Position) position;
        return (this.row == targetPosition.row && this.col == targetPosition.col);
    }

    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }

}
