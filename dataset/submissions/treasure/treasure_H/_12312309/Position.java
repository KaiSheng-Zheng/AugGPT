public class Position {

    private int row;

    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
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
    public boolean equals(Object position) {
        if(position instanceof Position position1){
            return this.row == position1.row && this.col == position1.col;
        } else {
            return false;
        }
    }
}
