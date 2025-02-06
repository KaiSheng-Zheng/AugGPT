public class Position {
    private int row;
    private int col;
    public Position(int row, int col){
        setCol(col);
        setRow(row);
    }
    public boolean equals(Object pos) {
        Position other = (Position) pos;
        if (this == pos) {
            return true;
        }
        else {
            return false;
        }
    }
    public void setCol(int col) {
        this.col = col;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public int getRow() {
        return row;
    }
}