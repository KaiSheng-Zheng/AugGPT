public class Position {
    private int row;

    public void setRow(int row) {
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    private int col;

    public void setCol(int col) {
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public Position(int row, int col){
        this.col=col;
        this.row=row;
    }
    public boolean equals(Object position){
        Position p = (Position) position;
        return this.getCol() == p.getCol() && this.getRow() == p.getRow();
    }
}