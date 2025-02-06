public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean equals(Object position) {
        return position instanceof Position && getRow() == ((Position) position).getRow() && getCol() == ((Position) position).getCol();
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }


    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

}
