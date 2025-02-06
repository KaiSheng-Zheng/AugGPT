public class Position {
    private int row, col;

    public Position (int row, int col){
        this.row = row;
        this.col = col;
    }

    int getRow() { return this.row; }
    int getCol() { return this.col; }
    void setRow(int row) { this.row = row; }
    void setCol(int col) { this.col = col; }

    @Override
    public boolean equals(Object position) {
        Position p = (Position) position;
        return this.row == p.getRow() && this.col == p.getCol();
    }
}
