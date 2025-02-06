public class Position {
    private int row;
    private int col;
    public Position(int row, int col){
        this.row=row;
        this.col=col;
    }
    public boolean equals(Object po) {
        if (this == po) return true;
        if (po == null || getClass() != po.getClass())
            return false;
        Position position = (Position) po;
        return row == position.row && col == position.col;
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
