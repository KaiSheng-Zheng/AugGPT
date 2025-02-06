public class Position {
    private int row;
    private int col;
    public Position(int row, int col)
    {
        this.row=row;
        this.col=col;
    }
    public boolean equals(Object position)
    {
        return this.row == ((Position) position).row &&
                this.col == ((Position) position).col;
    }
    public int getCol() {
        return col;
    }
    public int getRow() {
        return row;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public void setRow(int row) {
        this.row = row;
    }
}