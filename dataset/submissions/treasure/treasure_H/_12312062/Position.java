public class Position {
    private int row=0;
    private int col=0;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean equals(Object pos) {
        Position p = (Position) pos;
        return this.row == p.row && this.col == p.col;
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

    @Override
    public String toString() {
        return "(" +
                 row +
                ", " + col +
                ")";
    }
}

