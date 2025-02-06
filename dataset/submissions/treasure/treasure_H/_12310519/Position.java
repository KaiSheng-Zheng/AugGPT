public class Position {
    private int row;
    private int col;

    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }
    public boolean equals(Object position){
        boolean result = false;
        Position targetposition1 = (Position) position;
        if((this.col == targetposition1.col) && (this.row == targetposition1.row)){
            result = true;
            return result;
        }
        return result;
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
