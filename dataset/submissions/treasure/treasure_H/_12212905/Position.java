public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean equals(Object position) {
        if (this == position) {
            return true;
        }
        if (position == null || getClass() != position.getClass()) {
            return false;
        }
        Position other = (Position) position;
        return this.row == other.row && this.col == other.col;
    }

    public int getRow() {
        return row;
    }


    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
    public void setRow(int row) {
        this.row = row;
    }

}