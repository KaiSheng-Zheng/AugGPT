public class Position {
    private int row;
    private int col;
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean equals(Object position) {
        if (position instanceof Position) {
            Position paraPosition = (Position) position;
            return this.row == paraPosition.row && this.col == paraPosition.col;
        }
        return false;
    }
    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

}

