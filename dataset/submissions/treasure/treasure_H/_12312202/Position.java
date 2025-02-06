public class Position {
    private int row;
    private int col;

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

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean equals(Object position) {
        Position tmp = (Position) position;
        if (tmp.getCol() == this.col && tmp.getRow() == this.row) return true;
        return false;
    }
}
