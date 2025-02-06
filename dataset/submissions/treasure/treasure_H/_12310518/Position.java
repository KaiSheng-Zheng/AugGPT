public class Position {
    private int row;
    private int col;

    public Position(int row,int col){
        this.row=row;
        this.col=col;
    }
    public boolean equals(Object position){
        if (position instanceof Position) {
            Position position1 = (Position) position;
            if (this.row == position1.row && this.col == position1.col) {
                return true;
            } else return false;
        }else return false;
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