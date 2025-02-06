public class Position {
    private int row;
    private int col;
    public Position(int row, int col){
        setRow(row);
        setCol(col);
    }
    public boolean equals(Object position) {
        Position p = (Position) position;
        return p.row == this.row && p.col == this.col;
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
