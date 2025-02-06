public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
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

    public boolean equals(Object position) {
        if (((Position) position).getRow() == this.row && ((Position) position).getCol() == this.col) {
            return true;
        } else {
            return false;
        }
    }
}
