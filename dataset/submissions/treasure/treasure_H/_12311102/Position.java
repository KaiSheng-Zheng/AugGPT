public class Position {
    private int row;
    private int col;
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public boolean equals(Object position) {
        Position location = new Position(row, col);
        Position p = (Position) position;
        return p.equals(location);
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
}